package com.desafio.horizonteEletivo.controller;

import com.desafio.horizonteEletivo.dto.EletivaDTO;
import com.desafio.horizonteEletivo.model.Eletiva;
import com.desafio.horizonteEletivo.service.EletivaService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/eletivas")
public class EletivasController {

    // Injeta a dependência do serviço EletivaService
    private final EletivaService eletivaService;
    
    // Endpoint para listar todas as eletivas
    @GetMapping("/listar")
    public ResponseEntity<List<EletivaDTO>> listarEletivas() {
        // Chama o método do serviço para listar todas as eletivas e retorna a lista com status 200 (OK)
        return ResponseEntity.ok(eletivaService.listarTodos());
    }

    // Endpoint para buscar uma eletiva pelo ID
    @GetMapping("/buscar/{id}")
    public ResponseEntity<Eletiva> getEletiva(@PathVariable long id) {
        // Chama o método do serviço para obter uma eletiva pelo ID e retorna a eletiva com status 200 (OK)
        return ResponseEntity.ok(eletivaService.pegarEletivaPeloId(id));
    }

    // Endpoint para atualizar uma eletiva
    @PostMapping("/atualizar/{id}")
    public ResponseEntity<Void> atualizarEletiva(@PathVariable long id,
                                                 @Valid @RequestBody EletivaDTO eletivaAtualizar) {
        // Chama o método do serviço para atualizar a eletiva com os dados fornecidos e o ID
        eletivaService.atualizarEletiva(eletivaAtualizar, id);
        // Retorna um status 204 (No Content) indicando que a operação foi bem-sucedida mas não há conteúdo para retornar
        return ResponseEntity.noContent().build();
    }

    // Sugestão de endpoint para deletar uma eletiva pelo ID
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarEletiva(@PathVariable long id) {
        // Chama o método do serviço para deletar a eletiva pelo ID
        eletivaService.deletarEletiva(id);
        // Retorna um status 204 (No Content) indicando que a operação foi bem-sucedida mas não há conteúdo para retornar
        return ResponseEntity.noContent().build();
    }
}
