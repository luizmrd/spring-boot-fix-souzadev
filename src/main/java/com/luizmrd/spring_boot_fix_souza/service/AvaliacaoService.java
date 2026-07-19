package com.luizmrd.spring_boot_fix_souza.service;

import com.luizmrd.spring_boot_fix_souza.database.model.AlunosEntity;
import com.luizmrd.spring_boot_fix_souza.database.model.AvaliacaoFisicaEntity;
import com.luizmrd.spring_boot_fix_souza.database.repository.IAlunosRepository;
import com.luizmrd.spring_boot_fix_souza.database.repository.IAvaliacaoFisicaRepository;
import com.luizmrd.spring_boot_fix_souza.dto.AvaliacaoFisicaDto;
import com.luizmrd.spring_boot_fix_souza.exception.BadRequestException;
import com.luizmrd.spring_boot_fix_souza.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
public class AvaliacaoService {

    private final IAlunosRepository alunosRepository;
    private final IAvaliacaoFisicaRepository avaliacaoFisicaRepository;

    public void criarAvaliacao(AvaliacaoFisicaDto avaliacaoFisicaDto){
        AlunosEntity aluno = alunosRepository.findById(avaliacaoFisicaDto.getAlunoId())
                .orElseThrow(() -> new NotFoundException("Aluno não encontrado"));

        AvaliacaoFisicaEntity avaliacaoFisica = aluno.getAvaliacaoFisica();
        if(avaliacaoFisica != null){
            throw new BadRequestException("Avaliação física já cadrastrada para esse aluno!");
        }

        avaliacaoFisica = AvaliacaoFisicaEntity.builder()
                .peso(avaliacaoFisicaDto.getPeso())
                .altura(avaliacaoFisicaDto.getAltura())
                .porcentagemGorduraCorporal(avaliacaoFisicaDto.getPercentualGorduraCorporal())
                .build();

        aluno.setAvaliacaoFisica(avaliacaoFisica);
        alunosRepository.save(aluno);

    }
}
