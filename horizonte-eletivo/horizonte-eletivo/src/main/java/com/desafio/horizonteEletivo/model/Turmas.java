package com.desafio.horizonteEletivo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "turmas")
public class Turmas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turmas")
    private long idTurmas;

    @Column(name = "nome_turma")
    private String nomeTurma;

    @Column
    private String curso;

    @Column
    private String modalidade;

    @Column(name = "quant_vagas")
    private int quantVagas;

}
