package br.com.ensinofiap.services.interfaces;

import java.util.List;
import java.util.UUID;

import br.com.ensinofiap.entities.dto.AvaliacaoDto;

public interface IAvaliacaoService {
	AvaliacaoDto buscarPorId(UUID id);
	List<AvaliacaoDto> buscarTodos();
}