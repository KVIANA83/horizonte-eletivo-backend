package com.desafio.horizonteEletivo.controller;

import com.desafio.horizonteEletivo.dto.LoginDTO;
import com.desafio.horizonteEletivo.service.AlunoService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/login")
public class LoginController {
    
    private final AlunoService alunoService;
    
    @PostMapping
    public ResponseEntity<String> login(@Valid @RequestBody LoginDTO loginDTO) {
        // Verifica se a matrícula existe no banco de dados
        if (alunoService.preLoginAluno(loginDTO.getMatricula())) {
            // Tenta logar o aluno com a matrícula e data de nascimento fornecidos
            boolean isLoggedIn = alunoService.logarAluno(loginDTO);
            if (isLoggedIn) {
                // Se o login for bem-sucedido, retorna uma mensagem de sucesso
                return ResponseEntity.ok("Login realizado com sucesso!");
            } else {
                // Se a data de nascimento não corresponder à matrícula, retorna uma mensagem de erro
                return ResponseEntity.status(401).body("Data de nascimento incorreta.");
            }
        } else {
            // Se a matrícula não for encontrada, retorna uma mensagem de erro
            return ResponseEntity.status(404).body("Credenciais não encontradas. Entre em contato com a secretaria!");
        }
    }
}
