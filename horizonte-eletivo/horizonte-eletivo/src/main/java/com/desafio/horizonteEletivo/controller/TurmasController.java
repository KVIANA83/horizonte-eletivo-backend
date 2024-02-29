package com.desafio.horizonteEletivo.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController;
@AllArgsConstructor;
@RequestMapping("/turmas")
public class TurmasController {

    private TurmasService turmasService;
    
    @GetMapping("/listar")
    public ResponseEntity<List<TurmasDTO>> listarTurmas() {

        return ResponseEntity.ok(turmasService.listarTodos());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Turmas> getTurmas(@PathVariable long id) {

        return ResponseEntity.ok(turmasService.pegarTurmasPeloId(id));
    }

    @PostMapping("/atualizar/{id}")
    public ResponseEntity<Void> atualizarTurmas(@PathVariable long id,
            @Valid @RequestBody AlunoDTO turmasAtualizar) {

        alunoService.atualizarTurmas(turmasAtualizar, id);

        return ResponseEntity.noContent().build();
    } 
}