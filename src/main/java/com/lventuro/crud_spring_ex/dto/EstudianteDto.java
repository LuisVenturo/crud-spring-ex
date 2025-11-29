package com.lventuro.crud_spring_ex.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class EstudianteDto {
    private String dni;
    private String nombre;
    private String apellido;
    private String email;
    private Date fechaNacimiento;
    private List<CursoDto> cursosMatriculados;
}
