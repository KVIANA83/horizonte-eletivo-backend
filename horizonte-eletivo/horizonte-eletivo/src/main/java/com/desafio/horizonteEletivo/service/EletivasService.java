package com.desafio.horizonteEletivo.service;

import com.desafio.horizonteEletivo.dto.EletivaDTO;
import com.desafio.horizonteEletivo.dto.AlunoDTO;
import com.desafio.horizonteEletivo.model.Aluno;
import com.desafio.horizonteEletivo.model.Eletiva;
import com.desafio.horizonteEletivo.repository.AlunoRepository;
import com.desafio.horizonteEletivo.repository.EletivaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EletivasService {
    
    private final EletivaRepository eletivaRepository;
    private final AlunoRepository alunoRepository;
    
    public List<EletivaDTO> listarTodas() {
        List<Eletiva> eletivas = eletivaRepository.findAll();
        return eletivas.stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }
    
    public EletivaDTO pegarEletivaPeloId(long id) {
        Optional<Eletiva> eletivaOptional = eletivaRepository.findById(id);
        return eletivaOptional.map(this::converterParaDTO).orElse(null);
    }
    
    public void escolherEletiva(long alunoId, long eletivaId) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(alunoId);
        Optional<Eletiva> eletivaOptional = eletivaRepository.findById(eletivaId);
        
        if (alunoOptional.isPresent() && eletivaOptional.isPresent()) {
            Aluno aluno = alunoOptional.get();
            Eletiva eletiva = eletivaOptional.get();
            
            if (eletiva.getQuantVagas() > 0) {
                aluno.setEletiva(eletiva);
                alunoRepository.save(aluno);
                
                eletiva.setQuantVagas(eletiva.getQuantVagas() - 1);
                eletivaRepository.save(eletiva);
            } else {
                throw new RuntimeException("Não há vagas disponíveis para a eletiva escolhida.");
            }
        } else {
            throw new RuntimeException("Aluno ou Eletiva não encontrados.");
        }
    }

    public void trocarEletiva(long alunoId, long eletivaAtualId, long novaEletivaId) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(alunoId);
        Optional<Eletiva> eletivaAtualOptional = eletivaRepository.findById(eletivaAtualId);
        Optional<Eletiva> novaEletivaOptional = eletivaRepository.findById(novaEletivaId);
        
        if (alunoOptional.isPresent() && eletivaAtualOptional.isPresent() && novaEletivaOptional.isPresent()) {
            Aluno aluno = alunoOptional.get();
            Eletiva eletivaAtual = eletivaAtualOptional.get();
            Eletiva novaEletiva = novaEletivaOptional.get();
            
            if (novaEletiva.getQuantVagas() > 0) {
                // Reverter vaga da eletiva atual
                eletivaAtual.setQuantVagas(eletivaAtual.getQuantVagas() + 1);
                eletivaRepository.save(eletivaAtual);
                
                // Atualizar escolha do aluno
                aluno.setEletiva(novaEletiva);
                alunoRepository.save(aluno);
                
                // Atualizar vaga da nova eletiva
                novaEletiva.setQuantVagas(novaEletiva.getQuantVagas() - 1);
                eletivaRepository.save(novaEletiva);
            } else {
                throw new RuntimeException("Não há vagas disponíveis para a nova eletiva escolhida.");
            }
        } else {
            throw new RuntimeException("Aluno ou Eletiva(s) não encontrados.");
        }
    }
    
    public boolean verificarVagas(long eletivaId) {
        
        Optional<Eletiva> eletivaOptional = eletivaRepository.findById(eletivaId);
        return eletivaOptional.map(eletiva -> eletiva.getQuantVagas() > 0).orElse(false);
    }

    
    private EletivaDTO converterParaDTO(Eletiva eletiva) {
        return EletivaDTO.builder()
                .idEletiva(eletiva.getIdEletiva())
                .nomeProfessor(eletiva.getNomeProfessor())
                .quantVagas(eletiva.getQuantVagas())
                .nomeEletiva(eletiva.getNomeEletiva())
                .build();
    }
}
