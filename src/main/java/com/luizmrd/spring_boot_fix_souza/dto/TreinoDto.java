package com.luizmrd.spring_boot_fix_souza.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class TreinoDto {
    @NotBlank
    private Integer alunoId;
    @NotBlank
    private String nome;
    @NotEmpty
    private List<Integer> exerciciosIds;
}
