package com.luizmrd.spring_boot_fix_souza.controller;

import com.luizmrd.spring_boot_fix_souza.database.model.ExerciciosEntity;
import com.luizmrd.spring_boot_fix_souza.database.repository.IAlunosRepository;
import com.luizmrd.spring_boot_fix_souza.dto.AlunoDto;
import com.luizmrd.spring_boot_fix_souza.dto.ExerciciosDto;
import com.luizmrd.spring_boot_fix_souza.exception.BadRequestException;
import com.luizmrd.spring_boot_fix_souza.service.AlunoService;
import com.luizmrd.spring_boot_fix_souza.service.ExerciciosService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/alunos")
@RequiredArgsConstructor
public class AlunoController {

    private final AlunoService alunoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAluno(@Valid @RequestBody AlunoDto alunoDto) throws BadRequestException {
        alunoService.criarAluno(alunoDto);
    }

}

