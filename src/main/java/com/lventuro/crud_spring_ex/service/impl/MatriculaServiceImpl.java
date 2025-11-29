package com.lventuro.crud_spring_ex.service.impl;

import com.lventuro.crud_spring_ex.dto.MatriculaDto;
import com.lventuro.crud_spring_ex.dto.request.MatriculaRequest;
import com.lventuro.crud_spring_ex.entity.CursoEntity;
import com.lventuro.crud_spring_ex.entity.EstudianteEntity;
import com.lventuro.crud_spring_ex.entity.MatriculaEntity;
import com.lventuro.crud_spring_ex.repository.CursoRepository;
import com.lventuro.crud_spring_ex.repository.EstudianteRespository;
import com.lventuro.crud_spring_ex.repository.MatriculaRepository;
import com.lventuro.crud_spring_ex.service.MatriculaService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class MatriculaServiceImpl implements MatriculaService {

    private final MatriculaRepository matriculaRepository;
    private final EstudianteRespository estudianteRepository;
    private final CursoRepository cursoRepository;
    private final ModelMapper modelMapper;

    public MatriculaServiceImpl(MatriculaRepository matriculaRepository,
                                EstudianteRespository estudianteRepository,
                                CursoRepository cursoRepository,
                                ModelMapper modelMapper) {
        this.matriculaRepository = matriculaRepository;
        this.estudianteRepository = estudianteRepository;
        this.cursoRepository = cursoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public MatriculaDto creaMatriculaDto(MatriculaRequest req) {

        EstudianteEntity estudiante = estudianteRepository.findByDni(req.getDni());

        CursoEntity curso = cursoRepository.findById(req.getCursoId())
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        MatriculaEntity matriculaEntity = new MatriculaEntity();
        matriculaEntity.setEstudiante(estudiante);
        matriculaEntity.setCurso(curso);
        matriculaEntity.setNota(10.1);

        matriculaRepository.save(matriculaEntity);

        MatriculaDto dto = modelMapper.map(matriculaEntity, MatriculaDto.class);
        dto.setEstudiante(estudiante.getNombre() + " " + estudiante.getApellido());
        dto.setCurso(curso.getNombre());

        return dto;
    }
}
