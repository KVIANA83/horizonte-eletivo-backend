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
@Table(name="turmas")
public class Turmas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @column(name = "id_turmas")
    private long idTurmas;

    @column(name = "nome_turma")
    private String nomeTurma;

    @column
    private curso;

    @column
    private String modalidade;

    @column(name = "quant_vagas")
    private int quantVagas;

//Construtor vazio
    public class Turmas() {
    }

//Construtor com argumentos 
    public class Turmas(long idTurmas, String nomeTurma, String curso, String modalidade, int quantVagas) {
        this.idTurma = idTurma;
        this.nomeTurma = nomeTurma;
        this.curso = curso;
        this.modalidade = modalidade;
        this.quantVagas = quantVagas;
    }
}