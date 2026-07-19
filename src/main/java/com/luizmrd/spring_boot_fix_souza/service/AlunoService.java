package com.luizmrd.spring_boot_fix_souza.service;

import com.luizmrd.spring_boot_fix_souza.database.model.AlunosEntity;
import com.luizmrd.spring_boot_fix_souza.database.model.AvaliacaoFisicaEntity;
import com.luizmrd.spring_boot_fix_souza.database.repository.IAlunosRepository;
import com.luizmrd.spring_boot_fix_souza.dto.AlunoDto;
import com.luizmrd.spring_boot_fix_souza.exception.BadRequestException;
import com.luizmrd.spring_boot_fix_souza.exception.NotFoundException;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final IAlunosRepository alunosRepository;


    public void criarAluno(AlunoDto alunoDto) throws BadRequestException{
        AlunosEntity aluno = alunosRepository.findByEmail(alunoDto.getEmail())
                .orElse(null);
        if(aluno != null){
            throw new BadRequestException("Aluno cadrastrado com esse email");
        }

        alunosRepository.save(AlunosEntity.builder()
                .nome(alunoDto.getNome())
                .email(alunoDto.getEmail())
                .build());
    }

    public AvaliacaoFisicaEntity getAlunoAvaliacoes(Integer alunoId){
        AlunosEntity aluno = alunosRepository.findById(alunoId)
                .orElseThrow(() -> new NotFoundException("Alunon não encontrado!"));

        AvaliacaoFisicaEntity avaliacaoFisica = aluno.getAvaliacaoFisica();
        if(avaliacaoFisica == null){
                throw new NotFoundException("Avaliação f[isica não encontrada para esse aluno!");
        }
        return avaliacaoFisica;
    }

}
