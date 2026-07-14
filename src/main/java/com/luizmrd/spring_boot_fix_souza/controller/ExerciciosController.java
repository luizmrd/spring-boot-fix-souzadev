package com.luizmrd.spring_boot_fix_souza.controller;

import com.luizmrd.spring_boot_fix_souza.database.model.ExerciciosEntity;
import com.luizmrd.spring_boot_fix_souza.dto.ExerciciosDto;
import com.luizmrd.spring_boot_fix_souza.service.ExerciciosService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/exercicios")
@RequiredArgsConstructor
public class ExerciciosController {

    private final ExerciciosService exerciciosService;

    @GetMapping
    public List<ExerciciosEntity> findAll(){
        return exerciciosService.findAll();
    }


    @PostMapping
    public void saveExercicios(@RequestBody ExerciciosDto exerciciosDto){
        exerciciosService.save(exerciciosDto);

    }
    @GetMapping("/grupo/{grupoMuscular}")
    public List<ExerciciosEntity> getExerciciosByGrupoMuscular(@PathVariable String grupoMuscular){
        return  exerciciosService.filtroExerciciosGrupoMuscular(grupoMuscular);
    }
}
