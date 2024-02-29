package com.desafio.horizonteEletivo.controller;

import com.desafio.horizonteEletivo.dto.EletivaDTO;
import com.desafio.horizonteEletivo.service.EletivaService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController;
@AllArgsConstructor;
@RequestMapping("/eletiva")
public class EletivaController {
    
    private EletivaService eletivaService;
    
    @GetMapping("/listar")
    public ResponseEntity<List<EletivaDTO>> listarEletiva() {

        return ResponseEntity.ok(eletivaService.listarTodos());
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Eletiva> getEletiva(@PathVariable long id) {

        return ResponseEntity.ok(eletivaService.pegarEletivaPeloId(id));
    }

    @PostMapping("/atualizar/{id}")
    public ResponseEntity<Void> atualizarEletiva(@PathVariable long id,
            @Valid @RequestBody AlunoDTO eletivaAtualizar) {

        alunoService.atualizarEletiva(eletivaAtualizar, id);

        return ResponseEntity.noContent().build();
    }    
}