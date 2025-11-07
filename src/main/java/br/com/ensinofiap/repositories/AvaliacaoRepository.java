package br.com.ensinofiap.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import br.com.ensinofiap.entities.db.AvaliacaoDb;
import br.com.ensinofiap.exceptions.CursoNaoEncontradoException;
import br.com.ensinofiap.repositories.interfaces.IAvaliacaoJpaRepository;
import br.com.ensinofiap.repositories.interfaces.IAvaliacaoRepository;

@Repository
public class AvaliacaoRepository implements IAvaliacaoRepository{

	private IAvaliacaoJpaRepository avaliacaoJpaRepository;
	
	public AvaliacaoRepository(IAvaliacaoJpaRepository avaliacaoJpaRepository) {
		this.avaliacaoJpaRepository = avaliacaoJpaRepository; 
	}
	
	@Override
	public List<AvaliacaoDb> buscarTodos() {
		return avaliacaoJpaRepository.findAll();
	}

	@Override
	public AvaliacaoDb buscarPorId(UUID id) {
		return getCurso(avaliacaoJpaRepository.findById(id));
	}

	private AvaliacaoDb getCurso(Optional<AvaliacaoDb> avaliacao) {
		if(avaliacao.isPresent()) {
			return avaliacao.get();
		} else {
			throw new CursoNaoEncontradoException("Não foi encontrado nenhum curso com o id informado.");
		}
	}
}