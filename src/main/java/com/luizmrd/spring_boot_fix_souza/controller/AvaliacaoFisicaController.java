package com.luizmrd.spring_boot_fix_souza.controller;

import com.luizmrd.spring_boot_fix_souza.database.model.ExerciciosEntity;
import com.luizmrd.spring_boot_fix_souza.dto.AvaliacaoFisicaDto;
import com.luizmrd.spring_boot_fix_souza.dto.ExerciciosDto;
import com.luizmrd.spring_boot_fix_souza.exception.BadRequestException;
import com.luizmrd.spring_boot_fix_souza.exception.NotFoundException;
import com.luizmrd.spring_boot_fix_souza.service.AvaliacaoService;
import com.luizmrd.spring_boot_fix_souza.service.ExerciciosService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/avaliacoes")
@RequiredArgsConstructor
public class AvaliacaoFisicaController {

    private final AvaliacaoService avaliacaoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAvaliacaoFisica(@Valid @RequestBody AvaliacaoFisicaDto avaliacaoFisicaDto) throws NotFoundException, BadRequestException {
        avaliacaoService.criarAvaliacao(avaliacaoFisicaDto);
    }
}
