package com.luizmrd.spring_boot_fix_souza.database.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "alunos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlunosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false, unique = true)
    private String email;


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "avaliacao_fisica_id")
    private AvaliacaoFisicaEntity avaliacaoFisica;

    @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY)
    private Set<TreinosEntity> treinos = new HashSet<>();



}
