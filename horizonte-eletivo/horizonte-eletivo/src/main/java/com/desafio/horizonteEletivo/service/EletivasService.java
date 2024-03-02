package com.desafio.horizonteEletivo.service;

import com.desafio.horizonteEletivo.dto.EletivaDTO;
import com.desafio.horizonteEletivo.model.Eletiva;
import com.desafio.horizonteEletivo.repository.EletivaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EletivaService {
    
    @Autowired
    private EletivaRepository eletivaRepository;
    
    public EletivaService(EletivaRepository eletivaRepository) {
        this.eletivaRepository = eletivaRepository;
    }

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
    
    private EletivaDTO converterParaDTO(Eletiva eletiva) {
        return EletivaDTO.builder()
                .idEletiva(eletiva.getIdEletiva())
                .nomeProfessor(eletiva.getNomeProfessor())
                .quantVagas(eletiva.getQuantVagas())
                .nomeEletiva(eletiva.getNomeEletiva())
                .build();
    }
    
}