package br.com.ensinofiap.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ensinofiap.entities.dto.CursoDto;
import br.com.ensinofiap.services.interfaces.ICursoService;

@RestController
@RequestMapping("/cursos")
public class CursoController {

	private ICursoService cursosService;
	
	public CursoController(ICursoService cursosService) {
		this.cursosService = cursosService;
	}
	
	@GetMapping
	public ResponseEntity<List<CursoDto>> buscarTodos() {
		return ResponseEntity.ok(cursosService.buscarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<CursoDto> buscarPorId(@PathVariable UUID id) {
		return ResponseEntity.ok(cursosService.buscarPorId(id));
	}
}