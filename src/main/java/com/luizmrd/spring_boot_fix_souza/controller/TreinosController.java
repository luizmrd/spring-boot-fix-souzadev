package com.luizmrd.spring_boot_fix_souza.controller;

import com.luizmrd.spring_boot_fix_souza.dto.TreinoDto;
import com.luizmrd.spring_boot_fix_souza.service.TreinoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/treinos")
@RequiredArgsConstructor
@Validated
public class TreinosController {

    private final TreinoService treinoService;


    @PostMapping
    public void criarTreino(@Valid @RequestBody TreinoDto treinoDto){
        treinoService.criarTreino(treinoDto);
    }
}
