package br.com.ensinofiap.entities.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record AvaliacaoDto(UUID id, String descricao, CursoDto curso, UsuarioDtoResponse aluno, LocalDateTime dataCriacao, Boolean isUrgente, Integer nota) {

}