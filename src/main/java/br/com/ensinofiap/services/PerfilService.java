package br.com.ensinofiap.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ensinofiap.entities.db.PerfilDb;
import br.com.ensinofiap.entities.dto.PerfilDtoResponse;
import br.com.ensinofiap.mappers.PerfilMapper;
import br.com.ensinofiap.repositories.interfaces.IPerfilRepository;
import br.com.ensinofiap.services.interfaces.IPerfilService;

@Service
public class PerfilService implements IPerfilService {

    private final IPerfilRepository perfilRepository;

    public PerfilService(IPerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }

    @Override
    public PerfilDb buscarPorId(Integer id) {
        return perfilRepository.buscarPorId(id);
    }

    @Override
    public List<PerfilDtoResponse> buscarTodos() {
        return PerfilMapper.toPerfilRecord(perfilRepository.buscarTodos());
    }
}