package br.com.ensinofiap.repositories.interfaces;

import java.util.List;
import java.util.UUID;

import br.com.ensinofiap.entities.db.CursoDb;

public interface ICursoRepository {
	List<CursoDb> buscarTodos();
	CursoDb buscarPorId(UUID id);
}