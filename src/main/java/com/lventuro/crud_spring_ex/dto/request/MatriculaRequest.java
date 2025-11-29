package com.lventuro.crud_spring_ex.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MatriculaRequest {
    private String dni;
    private int cursoId;
}
