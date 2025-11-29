package com.lventuro.crud_spring_ex.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MatriculaDto {
    private Integer id;
    private String estudiante;
    private String curso;
    private Date fechaInscripcion;
    private double nota;
}
