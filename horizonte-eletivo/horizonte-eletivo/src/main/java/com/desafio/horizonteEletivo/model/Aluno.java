package com.desafio.horizonteEletivo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Aluno")
public class Aluno {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name ="id_aluno")
    private long idAluno;

    @Column
    private long matricula;

    @Column(name ="nome_aluno")
    private String nomeAluno;

    @Column(name ="data_nascimento")
    private LocalDate dataNascimento;

    @Column
    private String sexo;

    @Column(name ="n_classe")
    private int nClasse;

    @Column
    private String turma;

    @Column(name ="cor_raca")
    private String corRaca;

    @Column
    private String curso;
        
    @ManyToOne
    @JoinColumn(name = "id_eletiva")
    private Eletiva eletiva;
}