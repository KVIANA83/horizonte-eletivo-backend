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
@Table(name = "eletiva")
public class Eletiva {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @column(name ="id_eletiva")
    private long idEletiva;

    @column(name ="nome_professor")
    private String nomeProfessor;

    @column(name ="quant_vagas")
    private int quantVagas;

    @column(name="nome_eletiva")
    private String nomeEletiva
        
    }
    
//Construtor vazio
    public Eletiva() {
    }
    
//Construtor com argumentos
    public Eletiva(long idEletiva, String nomeProfessor, int quantVagas, String nomeEletiva) {
        this.idEletiva = idEletiva;
        this.nomeProfessor = nomeProfessor;
        this.quantVagas = quantVagas;
        this.nomeEletiva = nomeEletiva;
    }
}