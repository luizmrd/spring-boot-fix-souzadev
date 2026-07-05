    package com.luizmrd.spring_boot_fix_souza.database.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "alunos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExeciciosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String nome;
    @Column(name = "grupo_muscular",nullable = false)
    private String grupoMuscular;

}
