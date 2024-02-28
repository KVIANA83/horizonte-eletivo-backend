package com.desafio.horizonteEletivo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {
    
    @NotBlanck(message="Matrícula é um campo obrigatório!")
    private long matricula;
    
    @NotBlank(message="Data de nascimento é um campo obrigatório!")
    private int dataNascimento;
    
}