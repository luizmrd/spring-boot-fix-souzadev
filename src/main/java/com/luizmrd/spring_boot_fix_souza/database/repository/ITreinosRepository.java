package com.luizmrd.spring_boot_fix_souza.database.repository;

import com.luizmrd.spring_boot_fix_souza.database.model.AlunosEntity;
import com.luizmrd.spring_boot_fix_souza.database.model.TreinosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ITreinosRepository extends JpaRepository<TreinosEntity, Integer> {

    Optional<TreinosEntity> findByNomeAndAlunoId(String nome, Integer alunoId);
}
