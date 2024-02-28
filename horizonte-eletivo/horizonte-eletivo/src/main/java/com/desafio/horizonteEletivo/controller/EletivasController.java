package com.desafio.horizonteEletivo.controller;

import com.desafio.horizonteEletivo.dto.EletivasDTO;
import com.desafio.horizonteEletivo.service.EletivasService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController;
@AllArgsConstructor;
@RequestMapping("/eletivas")
public class EletivasController {
    
    private EletivasService eletivasService;
    
    @GetMapping("/listar")
    public ResponseEntity<List<EletivasDTO>> listarEletivas() {

        return ResponseEntity.ok(eletivasService.listarTodos());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Eletivas> getEletivas(@PathVariable long id) {

        return ResponseEntity.ok(eletivasService.pegarEletivasPeloId(id));
    }

    @PostMapping("/atualizar/{id}")
    public ResponseEntity<Void> atualizarEletivas(@PathVariable long id,
            @Valid @RequestBody CreateUsuarioDTO eletivasAtualizar) {

        alunoService.atualizarEletivas(eletivasAtualizar, id);

        return ResponseEntity.noContent().build();
    }    
}