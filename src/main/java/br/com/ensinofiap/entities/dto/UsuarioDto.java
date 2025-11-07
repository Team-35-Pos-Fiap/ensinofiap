package br.com.ensinofiap.entities.dto;

import java.util.UUID;

public record UsuarioDto(UUID id, String nome, String email) { }