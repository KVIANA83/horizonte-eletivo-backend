package com.desafio.horizonteEletivo.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlunoDTO {
    
    private long matricula;
    private String nomeCompleto;
    private int dataNascimento;
    private String turma;
    private String curso;
}