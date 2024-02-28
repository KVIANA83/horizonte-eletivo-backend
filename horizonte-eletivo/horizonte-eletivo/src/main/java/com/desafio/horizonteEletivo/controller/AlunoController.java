package com.desafio.horizonteEletivo.controller;

import com.desafio.horizonteEletivo.dto.AlunoDTO;
import com.desafio.horizonteEletivo.model.Aluno;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/alunos")
public class AlunoController {
    
    private AlunoService alunoService;
    
    @GetMapping("/listar")
    public ResponseEntity<List<AlunoDTO>> listarAlunos() {

        return ResponseEntity.ok(alunoService.listarTodos());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Aluno> getAluno(@PathVariable long id) {

        return ResponseEntity.ok(alunoService.pegarAlunoPeloId(id));
    }

    @PostMapping("/atualizar/{id}")
    public ResponseEntity<Void> atualizarAluno(@PathVariable long id,
            @Valid @RequestBody CreateUsuarioDTO alunoAtualizar) {

        alunoService.atualizarAluno(alunoAtualizar, id);

        return ResponseEntity.noContent().build();
    }
}