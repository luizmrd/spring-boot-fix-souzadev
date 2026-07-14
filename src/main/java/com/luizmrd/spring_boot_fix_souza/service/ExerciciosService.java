package com.luizmrd.spring_boot_fix_souza.service;

import com.luizmrd.spring_boot_fix_souza.database.model.ExerciciosEntity;
import com.luizmrd.spring_boot_fix_souza.database.repository.IExerciciosRepository;
import com.luizmrd.spring_boot_fix_souza.dto.ExerciciosDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciciosService {


    private final IExerciciosRepository exerciciosRepository;

    public List<ExerciciosEntity> findAll(){
        return exerciciosRepository.findAll();
    }

    public void save(ExerciciosDto exerciciosDto){
        ExerciciosEntity ex = exerciciosRepository.save(ExerciciosEntity.builder()
                .nome(exerciciosDto.getNome())
                .grupoMuscular(exerciciosDto.getGrupoMuscular())
                .build()


        );
    exerciciosRepository.save(ex);

    }

    public List<ExerciciosEntity> filtroExerciciosGrupoMuscular(String grupoMuscular){
        return exerciciosRepository.findAllByGrupoMuscular(grupoMuscular);
    }


}
