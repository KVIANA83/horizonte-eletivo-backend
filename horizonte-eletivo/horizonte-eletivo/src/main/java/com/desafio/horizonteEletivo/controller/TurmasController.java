package com.desafio.horizonteEletivo.controller;

import com.desafio.horizonteEletivo.dto.TurmasDTO;
import com.desafio.horizonteEletivo.model.Turmas;
import com.desafio.horizonteEletivo.service.TurmasService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/turmas")
public class TurmasController {

    // Injeta a dependência do serviço TurmasService
    private final TurmasService turmasService;
    
    // Endpoint para listar todas as turmas
    @GetMapping("/listar")
    public ResponseEntity<List<TurmasDTO>> listarTurmas() {
        // Chama o método do serviço para listar todas as turmas e retorna a lista com status 200 (OK)
        return ResponseEntity.ok(turmasService.listarTodos());
    }

    // Endpoint para buscar uma turma pelo ID
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Turmas> getTurmas(@PathVariable long id) {
        // Chama o método do serviço para obter uma turma pelo ID e retorna a turma com status 200 (OK)
        return ResponseEntity.ok(turmasService.pegarTurmasPeloId(id));
    }

    // Endpoint para atualizar uma turma
    @PostMapping("/atualizar/{id}")
    public ResponseEntity<Void> atualizarTurmas(@PathVariable long id,
                                                @Valid @RequestBody TurmasDTO turmasAtualizar) {
        // Chama o método do serviço para atualizar a turma com os dados fornecidos e o ID
        turmasService.atualizarTurmas(turmasAtualizar, id);
        // Retorna um status 204 (No Content) indicando que a operação foi bem-sucedida mas não há conteúdo para retornar
        return ResponseEntity.noContent().build();
    }

    // Sugestão de endpoint para deletar uma turma pelo ID
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarTurmas(@PathVariable long id) {
        // Chama o método do serviço para deletar a turma pelo ID
        turmasService.deletarTurmas(id);
        // Retorna um status 204 (No Content) indicando que a operação foi bem-sucedida mas não há conteúdo para retornar
        return ResponseEntity.noContent().build();
    }
}
