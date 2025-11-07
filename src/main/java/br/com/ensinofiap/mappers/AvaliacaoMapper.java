package br.com.ensinofiap.mappers;

import br.com.ensinofiap.entities.db.AvaliacaoDb;
import br.com.ensinofiap.entities.dto.AvaliacaoDto;
import br.com.ensinofiap.entities.dto.CursoDto;
import br.com.ensinofiap.entities.dto.UsuarioDtoResponse;

public class AvaliacaoMapper {

	public static AvaliacaoDto toAvaliacaoDto(AvaliacaoDb avaliacao, CursoDto curso, UsuarioDtoResponse aluno) {
		return new AvaliacaoDto(avaliacao.getId(), avaliacao.getDescricao(), curso, aluno, avaliacao.getDataCriacao(), avaliacao.getIsUrgente(), avaliacao.getNota());
	}
}