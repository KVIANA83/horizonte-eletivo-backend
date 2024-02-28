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
    
    private AlunoService alunoService;
    
    @PostMapping
        public ResponseEntity<String> login(@Valid @RequestBody LoginDTO loginDTO) {    public ResponseEntity<Long> login(@Valid @RequestBody LoginDTO loginDTO) {
            long return =""
            
                    if (alunoService.preLoginAluno(loginDTO.getMatricula())) {
            retorno = alunoService.logarAluno(loginDTO).toLong();

        } else {
            retorno = "Credenciais não encontradas. Entre em contato com a secretaria!";
        }

        return ResponseEntity.ok(retorno);
        }
}