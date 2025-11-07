package br.com.ensinofiap.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import br.com.ensinofiap.entities.db.UsuarioDb;
import br.com.ensinofiap.entities.domain.Usuario;
import br.com.ensinofiap.entities.dto.PerfilDtoResponse;
import br.com.ensinofiap.entities.dto.UsuarioDtoRequest;
import br.com.ensinofiap.entities.dto.UsuarioDtoResponse;
import br.com.ensinofiap.exceptions.EmailDuplicadoException;
import br.com.ensinofiap.mappers.UsuarioMapper;
import br.com.ensinofiap.repositories.interfaces.IUsuarioRepository;
import br.com.ensinofiap.services.interfaces.IPerfilService;
import br.com.ensinofiap.services.interfaces.IUsuarioService;
import br.com.ensinofiap.utils.MensagensUtil;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UsuarioService implements IUsuarioService, ApplicationRunner {

	private final IUsuarioRepository usuarioRepository;
	private final IPerfilService perfilService;
	
	//private final CacheManager cacheManager;
	
	private final String CACHE_USUARIOS_POR_PERFIL = "usuarios_por_perfil";
	private final String CACHE_USUARIO = "usuario";

	public UsuarioService(IUsuarioRepository usuarioRepository, IPerfilService perfilService) {
		this.usuarioRepository = usuarioRepository;
		this.perfilService = perfilService;
	}

	@Override
	//@CircuitBreaker(name = "usuarios", fallbackMethod = "recuperarUsuarioNoCache")
	//@Retry(name = "usuarios", fallbackMethod = "recuperarUsuarioNoCache")	
	public UsuarioDtoResponse buscarPorId(UUID id) {
		log.info("busca por id {}", id);
		
		return toUsuarioDto(toUsuario(buscarUsuarioPorId(id)));
	}

	@Override
	//@CircuitBreaker(name = "usuarios", fallbackMethod = "recuperarUsuariosNoCache")
	//@Retry(name = "usuarios", fallbackMethod = "recuperarUsuariosNoCache")
	public List<UsuarioDtoResponse> buscarUsuariosPorPerfil(Integer idPerfil) {
		return toListUsuarioDtoResponse(buscarUsuarios(idPerfil));
	}
	
	@Override
	public void cadastrar(UsuarioDtoRequest usuario) {
		verificaEmailCadastrado(usuario.email());

		salvar(toUsuario(usuario));
	}

	@Override
	public void atualizarStatus(UUID id, boolean isAtivo) {
		UsuarioDb usuario = buscarUsuarioPorId(id);
		
		if(isAtivo) { 
			usuario.reativar();
		} else {
			usuario.inativar();
		}

		salvar(usuario);
	}

	@Override
	public void atualizarNome(UUID id, String nome) {
		UsuarioDb usuario = buscarUsuarioPorId(id);

		usuario.atualizarNome(nome);
			
		salvar(usuario);
	}

	@Override
	public void atualizarEmail(UUID id, String email) {
		UsuarioDb usuario = buscarUsuarioPorId(id);
		
		verificaEmailCadastrado(email);
		
		usuario.atualizarEmail(email);
		
		salvar(usuario);
	}
	
	@Override
	public void atualizarSenha(UUID id, String senha) {
		UsuarioDb usuario = buscarUsuarioPorId(id);
		
		usuario.atualizarSenha(senha);
		
		salvar(usuario);
	}
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		List<PerfilDtoResponse> perfis = carregarPerfis();
		
		perfis.stream().forEach(p -> buscarUsuarios(p.id()));
	}
	
	private UsuarioDb buscarUsuarioPorId(UUID id) {
		return usuarioRepository.recuperaDadosUsuarioPorId(id);
	}
	
	private List<UsuarioDtoResponse> toListUsuarioDtoResponse(List<UsuarioDb> usuarios) {
		return UsuarioMapper.toListUsuarioDtoResponse(usuarios);
	}

	/*private List<UsuarioDtoResponse> recuperarUsuariosNoCache(Integer idPerfil, Throwable t) {
		log.info("Método de fallback da busca de usuários no perfil {}.", idPerfil);

		return toListUsuarioDtoResponse(recuperarUsuariosNoCache(idPerfil));
	}
	
	private UsuarioDtoResponse recuperarUsuarioNoCache(UUID id, Throwable t) {
		log.info("Método de fallback da busca de usuário pelo id {}.", id);
		
		return toUsuarioDto(toUsuario(recuperarUsuarioNoCache(id)));
	}
	
	private UsuarioDb recuperarUsuarioNoCache(UUID id) {
		return cacheManager.getCache(CACHE_USUARIO).get(id, UsuarioDb.class);
	}
	
	private List<UsuarioDb> recuperarUsuariosNoCache(Integer idPerfil) {
		return cacheManager.getCache(CACHE_USUARIOS_POR_PERFIL).get(idPerfil, ArrayList.class);
	}*/
	
	private void verificaEmailCadastrado(String email) {
		boolean possuiEmailCadastrado = usuarioRepository.emailJaCadastrado(email);
		
		if(possuiEmailCadastrado){
			throw new EmailDuplicadoException(MensagensUtil.recuperarMensagem(MensagensUtil.ERRO_EMAIL_DUPLICADO));
		}
	}
	
	private List<UsuarioDb> buscarUsuarios(Integer idPerfil) {
		return usuarioRepository.buscarUsuariosPorPerfil(idPerfil);
	}

	private void salvar(Usuario usuario) {
		usuarioRepository.salvar(toUsuarioDb(usuario));
	}

	private void salvar(UsuarioDb usuario) {
		usuarioRepository.salvar(usuario);
	}
	
	private List<PerfilDtoResponse> carregarPerfis() {
		return perfilService.buscarTodos();
	}
	
	private Usuario toUsuario(UsuarioDb usuario) {
		return UsuarioMapper.toUsuario(usuario);
	}
	
	private UsuarioDb toUsuarioDb(Usuario usuario) {
		return UsuarioMapper.toUsuarioDb(usuario);
	}

	private UsuarioDtoResponse toUsuarioDto(Usuario usuario) {
		return UsuarioMapper.toUsuarioDtoResponse(usuario);
	}
	
	private Usuario toUsuario(UsuarioDtoRequest usuario) {
		return UsuarioMapper.toUsuario(usuario);
	}
}