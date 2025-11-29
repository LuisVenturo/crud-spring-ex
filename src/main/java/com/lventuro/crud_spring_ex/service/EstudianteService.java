package com.lventuro.crud_spring_ex.service;

import com.lventuro.crud_spring_ex.dto.EstudianteDto;

public interface EstudianteService {
 EstudianteDto create(EstudianteDto estudianteDto);
 EstudianteDto findByDni(String dni);

}
