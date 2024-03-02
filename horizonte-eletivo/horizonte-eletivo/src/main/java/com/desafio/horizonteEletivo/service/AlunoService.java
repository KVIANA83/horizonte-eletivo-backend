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
    
    @Autowired
    private AlunoRepository alunoRepository;
    
    public alunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }
    
    public List<AlunoDTO> listarTodos() {
        
        return null;
    }
    
    public AlunoDTO pegarAlunoPeloId(long id) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(id);
        if (alunoOptional.isPresent()) {
            Aluno aluno = alunoOptional.get();
            // Converter Aluno para AlunoDTO
            return null;
        }
        return null;
    }

    public void atualizarAluno(CreateAlunoDTO alunoAtualizar, long id) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(id);
        if (alunoOptional.isPresent()) {
            Aluno aluno = alunoOptional.get();
            //Atualizar as informações do aluno
        }
    }

    public void escolherEletiva(long alunoId, long eletivaId) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(alunoId);
        if (alunoOptional.isPresent()) {
            Aluno aluno = alunoOptional.get();
            //Permitir o aluno escolher uma eletiva
        }
    }

    public void trocarEletiva(long alunoId, long eletivaAtualId, long novaEletivaId) {
        Optional<Aluno> alunoOptional = alunoRepository.findById(alunoId);
        if (alunoOptional.isPresent()) {
            Aluno aluno = alunoOptional.get();
            //Permitir o aluno trocar de eletiva
        }
    }
    
    
    
}