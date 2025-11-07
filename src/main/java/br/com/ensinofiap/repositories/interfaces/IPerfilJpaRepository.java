package br.com.ensinofiap.repositories.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ensinofiap.entities.db.PerfilDb;

public interface IPerfilJpaRepository extends JpaRepository<PerfilDb, Integer> { }
