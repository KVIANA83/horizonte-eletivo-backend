package com.desafio.horizonteEletivo.service;

import com.desafio.horizonteEletivo.dto.LoginDTO;
import com.desafio.horizonteEletivo.dto.AlunoDTO;
import com.desafio.horizonteEletivo.model.Aluno;
import com.desafio.horizonteEletivo.repository.AlunoRepository;
import jakarta.validation.ValidationException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AlunoService {
    
    private AlunoRepository alunoRepository;
    
    public List<AlunoDTO>listarTodos() {
        
        var listarAlunos = alunoRepository.findAll();
        
        var alunosDTO = new ArrayList<AlunoDTO>();
        
        for(Aluno aluno : listaAlunos) {
            
                     /*   var AlunoDTO = AlunoDTO.builder()
                    .telefone(usuario.getTelefone())
                    .nomeSocial(usuario.getNomeSocial())
                    .nomeCompleto(usuario.getNomeCompleto())
                    .endereco(usuario.getEndereco())
                    .email(usuario.getEmail())
                    .build();

            alunoDTOS.add(alunoDTO); */
        }
    }
}