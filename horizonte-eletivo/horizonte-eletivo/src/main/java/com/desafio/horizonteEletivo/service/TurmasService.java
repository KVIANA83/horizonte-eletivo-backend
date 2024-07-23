package com.desafio.horizonteEletivo.service;

import com.desafio.horizonteEletivo.dto.TurmasDTO;
import com.desafio.horizonteEletivo.model.Turmas;
import com.desafio.horizonteEletivo.repository.TurmasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TurmasService {

    private final TurmasRepository turmasRepository;

    @Autowired
    public TurmasService(TurmasRepository turmasRepository) {
        this.turmasRepository = turmasRepository;
    }

    public List<TurmasDTO> listarTodas() {
        List<Turmas> turmas = turmasRepository.findAll();
        return turmas.stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    public TurmasDTO pegarTurmaPeloId(long id) {
        Optional<Turmas> turmaOptional = turmasRepository.findById(id);
        return turmaOptional.map(this::converterParaDTO).orElse(null);
    }

    public TurmasDTO atualizarTurma(long id, TurmasDTO turmaDTO) {
        Optional<Turmas> turmaOptional = turmasRepository.findById(id);
        if (turmaOptional.isPresent()) {
            Turmas turma = turmaOptional.get();
            turma.setNomeTurma(turmaDTO.getNomeTurma());
            turma.setCurso(turmaDTO.getCurso());
            turma.setModalidade(turmaDTO.getModalidade());
            turma.setQuantVagas(turmaDTO.getQuantVagas());
            turmasRepository.save(turma);
            return converterParaDTO(turma);
        }
        throw new RuntimeException("Turma não encontrada.");
    }

    private TurmasDTO converterParaDTO(Turmas turma) {
        return TurmasDTO.builder()
                .idTurmas(turma.getIdTurmas())
                .nomeTurma(turma.getNomeTurma())
                .curso(turma.getCurso())
                .modalidade(turma.getModalidade())
                .quantVagas(turma.getQuantVagas())
                .build();
    }
}
