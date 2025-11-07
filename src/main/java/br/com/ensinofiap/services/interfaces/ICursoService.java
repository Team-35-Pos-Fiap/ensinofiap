package br.com.ensinofiap.services.interfaces;

import java.util.List;
import java.util.UUID;

import br.com.ensinofiap.entities.dto.CursoDto;

public interface ICursoService {
	CursoDto buscarPorId(UUID id);
	List<CursoDto> buscarTodos();
}