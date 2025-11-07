package br.com.ensinofiap.repositories.interfaces;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ensinofiap.entities.db.AvaliacaoDb;

public interface IAvaliacaoJpaRepository extends JpaRepository<AvaliacaoDb, UUID> {
}