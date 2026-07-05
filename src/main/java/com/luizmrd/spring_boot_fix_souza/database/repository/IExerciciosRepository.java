package com.luizmrd.spring_boot_fix_souza.database.repository;

import com.luizmrd.spring_boot_fix_souza.database.model.ExeciciosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IExerciciosRepository extends JpaRepository<ExeciciosEntity, Integer> {
}
