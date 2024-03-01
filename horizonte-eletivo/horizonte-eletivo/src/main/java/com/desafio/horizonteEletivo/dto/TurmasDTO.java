package com.desafio.horizonteEletivo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TurmasDTO {
    
    private String nomeTurma;
    private String curso;
    private String modalidade;
    private int quantVagas;
    private EletivaDTO eletiva;
}