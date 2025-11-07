package br.com.ensinofiap.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.ensinofiap.entities.db.CursoDb;
import br.com.ensinofiap.entities.dto.CursoDto;
import br.com.ensinofiap.mappers.CursoMapper;
import br.com.ensinofiap.repositories.interfaces.ICursoRepository;
import br.com.ensinofiap.services.interfaces.ICursoService;

@Service
public class CursoService implements ICursoService {

	private ICursoRepository cursoRepository;
	
	public CursoService(ICursoRepository cursoRepository) { 
		this.cursoRepository = cursoRepository;
	}
	
	@Override
	public CursoDto buscarPorId(UUID id) {
		CursoDb curso = cursoRepository.buscarPorId(id);
		
		return CursoMapper.toCursoDto(curso);
	}

	@Override
	public List<CursoDto> buscarTodos() {
		List<CursoDb> cursos = cursoRepository.buscarTodos();
		
		return CursoMapper.toListCursoDto(cursos);	
	}
}