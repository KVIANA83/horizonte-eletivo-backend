package com.desafio.horizonteEletivo.service;

import com.desafio.horizonteEletivo.dto.AlunoDTO;
import com.desafio.horizonteEletivo.dto.TrocaEletivaDTO;
import com.desafio.horizonteEletivo.model.Aluno;
import com.desafio.horizonteEletivo.repository.AlunoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AlunoService {
    
    private final AlunoRepository alunoRepository;
    private final EletivasService eletivasService;

    public List<AlunoDTO> listarTodos() {
        List<Aluno> alunos = alunoRepository.findAll();
        return alunos.stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    public AlunoDTO pegarAlunoPeloId(long id) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(id);
        return alunoOptional.map(this::converterParaDTO).orElse(null);
    }

    public void atualizarAluno(AlunoDTO alunoAtualizar, long id) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(id);
        if (alunoOptional.isPresent()) {
            Aluno aluno = alunoOptional.get();
            aluno.setNomeAluno(alunoAtualizar.getNomeCompleto());
            aluno.setTurma(alunoAtualizar.getTurma());
            aluno.setCurso(alunoAtualizar.getCurso());
            alunoRepository.save(aluno);
        }
    }

    public void escolherEletiva(long alunoId, long eletivaId) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(alunoId);
        if (alunoOptional.isPresent()) {
            Aluno aluno = alunoOptional.get();
            if (eletivasService.verificarVagas(eletivaId)) {
                aluno.setEletivaId(eletivaId);
                alunoRepository.save(aluno);
                eletivasService.atualizarVagas(eletivaId, 1); // Atualiza a vaga na eletiva
            } else {
                throw new RuntimeException("Não há vagas disponíveis para a eletiva.");
            }
        } else {
            throw new RuntimeException("Aluno não encontrado.");
        }
    }

    public void trocarEletiva(long alunoId, long eletivaAtualId, long novaEletivaId) {
        escolherEletiva(alunoId, novaEletivaId); // Reutiliza o método de escolherEletiva
        eletivasService.atualizarVagas(eletivaAtualId, -1); // Libera vaga na eletiva antiga
    }

    private AlunoDTO converterParaDTO(Aluno aluno) {
        return AlunoDTO.builder()
                .matricula(aluno.getMatricula())
                .nomeCompleto(aluno.getNomeAluno())
                .dataNascimento(aluno.getDataNascimento())
                .turma(aluno.getTurma())
                .curso(aluno.getCurso())
                .build();
    }
}
