package com.luizmrd.spring_boot_fix_souza.database.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "avaliacoes_fisicas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AvaliacaoFisicaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private BigDecimal peso;
    @Column(nullable = false)
    private BigDecimal altura;
    @Column(name = "porcentagem_gordura_corporal", nullable = false)
    private BigDecimal porcentagemGorduraCorporal;



}
