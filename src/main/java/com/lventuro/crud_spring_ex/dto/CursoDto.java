package com.lventuro.crud_spring_ex.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CursoDto {
    private Integer id;
    private String codigo;
    private String nombre;
    private String profesor;
    private int creditos;
}
