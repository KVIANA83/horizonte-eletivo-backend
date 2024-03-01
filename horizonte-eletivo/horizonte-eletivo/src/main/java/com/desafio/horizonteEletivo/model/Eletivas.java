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
    @Column(name ="id_eletiva")
    private long idEletiva;

    @Column(name ="nome_professor")
    private String nomeProfessor;

    @Column(name ="quant_vagas")
    private int quantVagas;

    @Column(name="nome_eletiva")
    private String nomeEletiva;
    
    // Construtor vazio
    public Eletiva() {
    }
    
    // Construtor com argumentos
    public Eletiva(long idEletiva, String nomeProfessor, int quantVagas, String nomeEletiva) {
        this.idEletiva = idEletiva;
        this.nomeProfessor = nomeProfessor;
        this.quantVagas = quantVagas;
        this.nomeEletiva = nomeEletiva;
    }
}
