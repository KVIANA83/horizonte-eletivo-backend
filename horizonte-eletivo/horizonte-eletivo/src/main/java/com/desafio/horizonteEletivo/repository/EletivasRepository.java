package com.desafio.horizonteEletivo.repository;

import com.desafio.horizonteEletivo.model.Eletiva;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EletivaRepository extendes JpaRepository<Eletiva, Long> {
    
    Optional<List<Eletiva>> findAllByNome(String nomeEletiva);
}