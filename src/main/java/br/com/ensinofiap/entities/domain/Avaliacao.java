package br.com.ensinofiap.entities.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Avaliacao {
	private UUID id;
	private String descricao;
	private UUID idCurso;
	private UUID idAluno;
	private LocalDateTime dataCriacao;
	private Boolean isUrgente;
	private Integer nota;
}