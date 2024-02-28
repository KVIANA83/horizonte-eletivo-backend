package com.desafio.horizonteEletivo.repository;

import com.desafio.horizonteEletivo.model.Aluno;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
        Optional<Aluno> findByEmail(@Param("matricula") long matricula);
        Optional<Aluno> findByEmail(@Param("dataNascimento") int dataNascimento);
        
}