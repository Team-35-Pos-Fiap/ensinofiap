package br.com.ensinofiap.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ensinofiap.entities.dto.PerfilDtoResponse;
import br.com.ensinofiap.services.interfaces.IPerfilService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/perfis")
@Slf4j
public class PerfilController {

    private final IPerfilService perfilService;

    public PerfilController(IPerfilService perfilService) {
        this.perfilService = perfilService;
    }

    @GetMapping
    public ResponseEntity<List<PerfilDtoResponse>> buscarTodos(){
        log.info("buscarTodos()");

        return ResponseEntity.ok(perfilService.buscarTodos());
    }
}
