    package com.luizmrd.spring_boot_fix_souza.database.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

    @Entity
    @Table(name = "treinos")
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public class TreinosEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        @Column(nullable = false)
        private String nome;

        @ManyToOne
        @JoinColumn(name = "avaliacao_fisica_id")
        private AvaliacaoFisicaEntity avaliacaoFisica;

        @ManyToOne
        @JoinColumn(name = "aluno_id")
        private AlunosEntity aluno;

        @ManyToMany
        @JoinTable(
                name = "treinos_execicios",
                joinColumns = @JoinColumn(name = "treino_id"),
                inverseJoinColumns = @JoinColumn(name = "exercicio_id")
        )
        private Set<ExerciciosEntity> exercicios = new HashSet<>();
    }
