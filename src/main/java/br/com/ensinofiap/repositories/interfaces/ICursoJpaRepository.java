package br.com.ensinofiap.repositories.interfaces;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ensinofiap.entities.db.CursoDb;

public interface ICursoJpaRepository extends JpaRepository<CursoDb, UUID> {
}