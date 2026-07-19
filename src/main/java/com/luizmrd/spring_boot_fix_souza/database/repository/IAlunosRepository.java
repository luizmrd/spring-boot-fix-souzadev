package com.luizmrd.spring_boot_fix_souza.database.repository;

import com.luizmrd.spring_boot_fix_souza.database.model.AlunosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAlunosRepository extends JpaRepository<AlunosEntity, Integer> {

    Optional<AlunosEntity> findByEmail(String email);
}
