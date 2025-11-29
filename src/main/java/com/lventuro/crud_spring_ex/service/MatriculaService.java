package com.lventuro.crud_spring_ex.service;

import com.lventuro.crud_spring_ex.dto.MatriculaDto;
import com.lventuro.crud_spring_ex.dto.request.MatriculaRequest;

public interface MatriculaService {
    MatriculaDto creaMatriculaDto(MatriculaRequest req);
}
