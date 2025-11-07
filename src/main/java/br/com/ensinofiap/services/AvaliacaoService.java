package br.com.ensinofiap.services;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.ensinofiap.entities.db.AvaliacaoDb;
import br.com.ensinofiap.entities.dto.AvaliacaoDto;
import br.com.ensinofiap.entities.dto.CursoDto;
import br.com.ensinofiap.entities.dto.UsuarioDtoResponse;
import br.com.ensinofiap.mappers.AvaliacaoMapper;
import br.com.ensinofiap.repositories.interfaces.IAvaliacaoRepository;
import br.com.ensinofiap.services.interfaces.IAvaliacaoService;
import br.com.ensinofiap.services.interfaces.ICursoService;
import br.com.ensinofiap.services.interfaces.IUsuarioService;

@Service
public class AvaliacaoService implements IAvaliacaoService {

	private IAvaliacaoRepository avaliacaoRepository;
	private ICursoService cursoService;
	private IUsuarioService usuarioService;	
	
	public AvaliacaoService(IAvaliacaoRepository avaliacaoRepository, ICursoService cursoService, IUsuarioService usuarioService) { 
		this.avaliacaoRepository = avaliacaoRepository;
		this.cursoService = cursoService;
		this.usuarioService = usuarioService;
	}
	
	@Override
	public AvaliacaoDto buscarPorId(UUID idAvaliacao) {
		return toAvaliacaoDto(buscarAvaliacao(idAvaliacao));
	}

	@Override
	public List<AvaliacaoDto> buscarTodos() {
		return toListAvaliacaoDto(buscarAvaliacoes());	
	}
	
	private AvaliacaoDb buscarAvaliacao(UUID idAvaliacao) {
		return avaliacaoRepository.buscarPorId(idAvaliacao);
	}
	
	private List<AvaliacaoDb> buscarAvaliacoes() {
		return avaliacaoRepository.buscarTodos();
	}
	
	private AvaliacaoDto toAvaliacaoDto(AvaliacaoDb avaliacao) {
		return AvaliacaoMapper.toAvaliacaoDto(avaliacao, buscarCurso(avaliacao.getIdCurso()), buscarAluno(avaliacao.getIdAluno()));
	}
	
	private CursoDto buscarCurso(UUID idCurso) {
		return cursoService.buscarPorId(idCurso);
	}

	private UsuarioDtoResponse buscarAluno(UUID idAluno) {
		return usuarioService.buscarPorId(idAluno);
	}
	
	private List<AvaliacaoDto> toListAvaliacaoDto(List<AvaliacaoDb> avaliacoes) {
		return avaliacoes.stream().map(a -> toAvaliacaoDto(a)).collect(Collectors.toList()); 
	}
}