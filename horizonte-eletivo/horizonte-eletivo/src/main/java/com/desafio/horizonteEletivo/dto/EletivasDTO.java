package com.desafio.horizonteEletivo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EletivaDTO {
    
    private String nomeProfessor;
    private String nomeEletiva;
    private int quantVagas;
    private AlunoDTO aluno;
}