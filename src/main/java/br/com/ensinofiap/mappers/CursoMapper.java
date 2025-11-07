package br.com.ensinofiap.mappers;

import java.util.List;
import java.util.stream.Collectors;

import br.com.ensinofiap.entities.db.CursoDb;
import br.com.ensinofiap.entities.dto.CursoDto;

public class CursoMapper {

	public static CursoDto toCursoDto(CursoDb curso) {
		return new CursoDto(curso.getId(), curso.getNome());
	}

	public static List<CursoDto> toListCursoDto(List<CursoDb> cursos) {
		return cursos.stream().map(c -> CursoMapper.toCursoDto(c)).collect(Collectors.toList());
	}
}
