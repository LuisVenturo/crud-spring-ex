package com.lventuro.crud_spring_ex.service;

import com.lventuro.crud_spring_ex.dto.CursoDto;

import java.util.List;

public interface CursoService {
    CursoDto creatCurso(CursoDto cursoDto);
    CursoDto findCursoById(int id);
    List<CursoDto> findAllCurso();
}
