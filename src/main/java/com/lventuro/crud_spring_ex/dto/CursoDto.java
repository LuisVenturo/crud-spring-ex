package com.lventuro.crud_spring_ex.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(name = "Curso", description = "DTO que representa un curso")
public class CursoDto {
    @Schema(description = "ID del curso", example = "1")
    private Integer id;
    @Schema(description = "Código único del curso", example = "MAT101")
    private String codigo;
    @Schema(description = "Nombre del curso", example = "Matemáticas I")
    private String nombre;
    @Schema(description = "Nombre del profesor", example = "Juan Pérez")
    private String profesor;
    @Schema(description = "Número de créditos", example = "4")
    private int creditos;
}
