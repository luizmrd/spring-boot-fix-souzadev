package com.luizmrd.spring_boot_fix_souza.service;

import com.luizmrd.spring_boot_fix_souza.database.model.AlunosEntity;
import com.luizmrd.spring_boot_fix_souza.database.model.ExerciciosEntity;
import com.luizmrd.spring_boot_fix_souza.database.model.TreinosEntity;
import com.luizmrd.spring_boot_fix_souza.database.repository.IAlunosRepository;
import com.luizmrd.spring_boot_fix_souza.database.repository.IAvaliacaoFisicaRepository;
import com.luizmrd.spring_boot_fix_souza.database.repository.IExerciciosRepository;
import com.luizmrd.spring_boot_fix_souza.database.repository.ITreinosRepository;
import com.luizmrd.spring_boot_fix_souza.dto.TreinoDto;
import com.luizmrd.spring_boot_fix_souza.exception.BadRequestException;
import com.luizmrd.spring_boot_fix_souza.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class TreinoService {

    private final IAlunosRepository alunosRepository;
    private final IExerciciosRepository exerciciosRepository;
    private final ITreinosRepository treinosRepository;


    public void criarTreino(TreinoDto treinoDto) throws NotFoundException{

        Set<ExerciciosEntity> exerciciosEntitySet = new HashSet<>();

        AlunosEntity aluno = alunosRepository.findById(treinoDto.getAlunoId())
                .orElseThrow(() -> new NotFoundException("Aluno não encontrado!"));

        TreinosEntity treino = treinosRepository.findByNomeAndAlunoId(treinoDto.getNome(),treinoDto.getAlunoId())
                .orElse(null);

        if(treino != null){
            throw new BadRequestException("Já existe um treino com esse nome para esse aluno!");
        }

        for(Integer exerciciosId : treinoDto.getExerciciosIds()){
            ExerciciosEntity ex = exerciciosRepository.findById(exerciciosId)
                    .orElseThrow(() -> new NotFoundException("Exercicios não encontrado"));

            exerciciosEntitySet.add(ex);

        }

         TreinosEntity treinos = TreinosEntity.builder()
                 .nome(treinoDto.getNome())
                 .aluno(aluno)
                 .exercicios(exerciciosEntitySet)
                 .build();

        treinosRepository.save(treinos);


    }

}
