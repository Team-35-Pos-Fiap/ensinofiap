package br.com.ensinofiap.services.interfaces;

import java.util.List;

import br.com.ensinofiap.entities.db.PerfilDb;
import br.com.ensinofiap.entities.dto.PerfilDtoResponse;

public interface IPerfilService {

    PerfilDb buscarPorId(Integer id);
    List<PerfilDtoResponse> buscarTodos();
}
