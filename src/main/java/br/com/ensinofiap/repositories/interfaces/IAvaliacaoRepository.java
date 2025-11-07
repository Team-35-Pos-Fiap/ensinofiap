package br.com.ensinofiap.repositories.interfaces;

import java.util.List;
import java.util.UUID;

import br.com.ensinofiap.entities.db.AvaliacaoDb;

public interface IAvaliacaoRepository {
	List<AvaliacaoDb> buscarTodos();
	AvaliacaoDb buscarPorId(UUID id);
}