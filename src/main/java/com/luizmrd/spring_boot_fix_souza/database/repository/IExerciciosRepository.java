package com.luizmrd.spring_boot_fix_souza.database.repository;

import com.luizmrd.spring_boot_fix_souza.database.model.ExerciciosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IExerciciosRepository extends JpaRepository<ExerciciosEntity, Integer> {


    List<ExerciciosEntity> findAllByGrupoMuscular(String grupoMuscular);
}
