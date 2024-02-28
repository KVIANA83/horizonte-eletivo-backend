package com.desafio.horizonteEletivo.repository;

import com.desafio.horizonteEletivo.model.Eletivas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EletivasRepository extendes JpaRepository<Eletivas, Long> {
    
    Optional<List<Eletivas>> findAllByNome(String nomeEletiva);
}