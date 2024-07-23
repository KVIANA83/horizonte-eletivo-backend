package com.desafio.horizonteEletivo.controller;

import com.desafio.horizonteEletivo.dto.AlunoDTO;
import com.desafio.horizonteEletivo.model.Aluno;
import com.desafio.horizonteEletivo.service.AlunoService;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/alunos")
public class AlunoController {
    
    // Injeta a dependência do serviço AlunoService
    private final AlunoService alunoService;
    
    // Endpoint para listar todos os alunos
    @GetMapping("/listar")
    public ResponseEntity<List<AlunoDTO>> listarAlunos() {
        // Chama o método do serviço para listar todos os alunos e retorna a lista com status 200 (OK)
        return ResponseEntity.ok(alunoService.listarTodos());
    }

    // Endpoint para buscar um aluno pelo ID
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Aluno> getAluno(@PathVariable long id) {
        // Chama o método do serviço para obter um aluno pelo ID e retorna o aluno com status 200 (OK)
        return ResponseEntity.ok(alunoService.pegarAlunoPeloId(id));
    }

    // Endpoint para atualizar um aluno
    @PostMapping("/atualizar/{id}")
    public ResponseEntity<Void> atualizarAluno(@PathVariable long id,
                                               @Valid @RequestBody AlunoDTO alunoAtualizar) {
        // Chama o método do serviço para atualizar o aluno com os dados fornecidos e o ID
        alunoService.atualizarAluno(alunoAtualizar, id);
        // Retorna um status 204 (No Content) indicando que a operação foi bem-sucedida mas não há conteúdo para retornar
        return ResponseEntity.noContent().build();
    }

    // Sugestão de endpoint para deletar um aluno pelo ID
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarAluno(@PathVariable long id) {
        // Chama o método do serviço para deletar o aluno pelo ID
        alunoService.deletarAluno(id);
        // Retorna um status 204 (No Content) indicando que a operação foi bem-sucedida mas não há conteúdo para retornar
        return ResponseEntity.noContent().build();
    }

    // Endpoint escolher eletiva
    @PostMapping("/escolherEletiva")
    public ResponseEntity<Void> escolherEletiva(@RequestParam long alunoId, @RequestParam long eletivaId) {
        try {
            alunoService.escolherEletiva(alunoId, eletivaId);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Endpoint trocar eletiva
    @PostMapping("/trocarEletiva")
    public ResponseEntity<Void> trocarEletiva(@RequestParam long alunoId, @RequestParam long eletivaAtualId, @RequestParam long novaEletivaId) {
        try {
            alunoService.trocarEletiva(alunoId, eletivaAtualId, novaEletivaId);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
