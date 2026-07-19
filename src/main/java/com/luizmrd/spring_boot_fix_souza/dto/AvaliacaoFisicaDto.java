package com.luizmrd.spring_boot_fix_souza.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AvaliacaoFisicaDto {

    private Integer alunoId;
    private BigDecimal peso;
    private BigDecimal altura;
    private BigDecimal porcentagemGorduraCorporal;

}
