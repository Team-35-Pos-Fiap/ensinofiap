package br.com.ensinofiap.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ensinofiap.entities.dto.AvaliacaoDto;
import br.com.ensinofiap.services.interfaces.IAvaliacaoService;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

	private IAvaliacaoService avaliacaoService;
	
	public AvaliacaoController(IAvaliacaoService avaliacaoService) {
		this.avaliacaoService = avaliacaoService;
	}
	
	@GetMapping
	public ResponseEntity<List<AvaliacaoDto>> buscarTodos() {
		return ResponseEntity.ok(avaliacaoService.buscarTodos());
	}

	@GetMapping(path = "/cursos/{id-curso}")
	public ResponseEntity<List<AvaliacaoDto>> buscarTodosPorCurso(@PathVariable UUID idCurso) {
		return ResponseEntity.ok(avaliacaoService.buscarTodos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AvaliacaoDto> buscarPorId(@PathVariable UUID id) {
		return ResponseEntity.ok(avaliacaoService.buscarPorId(id));
	}
}