package br.com.ensinofiap.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.com.ensinofiap.entities.db.CursoDb;
import br.com.ensinofiap.exceptions.CursoNaoEncontradoException;
import br.com.ensinofiap.repositories.interfaces.ICursoJpaRepository;
import br.com.ensinofiap.repositories.interfaces.ICursoRepository;

@Repository
public class CursoRepository implements ICursoRepository{

	private ICursoJpaRepository cursoJpaRepository;
	
	public CursoRepository(ICursoJpaRepository cursoJpaRepository) {
		this.cursoJpaRepository = cursoJpaRepository; 
	}
	
	@Override
	public List<CursoDb> buscarTodos() {
		return cursoJpaRepository.findAll();
	}

	@Override
	public CursoDb buscarPorId(UUID id) {
		return getCurso(cursoJpaRepository.findById(id));
	}

	private CursoDb getCurso(Optional<CursoDb> curso) {
		if(curso.isPresent()) {
			return curso.get();
		} else {
			throw new CursoNaoEncontradoException("Não foi encontrado nenhum curso com o id informado.");
		}
	}
}