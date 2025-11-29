package com.lventuro.crud_spring_ex.service.impl;

import com.lventuro.crud_spring_ex.dto.CursoDto;
import com.lventuro.crud_spring_ex.dto.EstudianteDto;
import com.lventuro.crud_spring_ex.entity.EstudianteEntity;
import com.lventuro.crud_spring_ex.repository.EstudianteRespository;
import com.lventuro.crud_spring_ex.service.EstudianteService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudianteServiceImpl implements EstudianteService {
    private final EstudianteRespository estudianteRespository;
    private final ModelMapper modelMapper;

    public EstudianteServiceImpl(EstudianteRespository estudianteRespository, ModelMapper modelMapper) {
        this.estudianteRespository = estudianteRespository;
        this.modelMapper = modelMapper;
    }

    @Override
    public EstudianteDto create(EstudianteDto estudianteDto) {
        EstudianteEntity estudianteEntity = modelMapper.map(estudianteDto, EstudianteEntity.class);
        estudianteRespository.save(estudianteEntity);
        return modelMapper.map(estudianteEntity, EstudianteDto.class);
    }

    @Override
    public EstudianteDto findByDni(String dni) {
        EstudianteEntity estudiante = estudianteRespository.findByDni(dni);
        EstudianteDto dto = modelMapper.map(estudiante, EstudianteDto.class);
        List<CursoDto> cursos = estudiante.getMatriculas()
                .stream()
                .map(m -> modelMapper.map(m.getCurso(), CursoDto.class))
                .toList();
        dto.setCursosMatriculados(cursos);
        return dto;
    }
}
