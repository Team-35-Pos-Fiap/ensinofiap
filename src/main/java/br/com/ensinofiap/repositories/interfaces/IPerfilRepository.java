package br.com.ensinofiap.repositories.interfaces;

import java.util.List;

import br.com.ensinofiap.entities.db.PerfilDb;

public interface IPerfilRepository {
    PerfilDb buscarPorId(Integer id);
    List<PerfilDb> buscarTodos();
}
