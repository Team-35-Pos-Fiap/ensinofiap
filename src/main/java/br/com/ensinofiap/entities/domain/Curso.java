package br.com.ensinofiap.entities.domain;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Curso {
	private UUID id;
	private String nome;
}