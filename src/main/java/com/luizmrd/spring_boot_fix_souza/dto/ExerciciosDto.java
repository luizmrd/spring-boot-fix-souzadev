package com.luizmrd.spring_boot_fix_souza.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ExerciciosDto {

        @NotBlank
        private String nome;
        private String grupoMuscular;
}
