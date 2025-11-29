package com.lventuro.crud_spring_ex.service.impl;

import com.lventuro.crud_spring_ex.dto.CursoDto;
import com.lventuro.crud_spring_ex.entity.CursoEntity;
import com.lventuro.crud_spring_ex.repository.CursoRepository;
import com.lventuro.crud_spring_ex.service.CursoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CursoServiceImpl implements CursoService {
    private final CursoRepository cursoRepository;
    private final ModelMapper mapper;

    public CursoServiceImpl(CursoRepository cursoRepository, ModelMapper mapper) {
        this.cursoRepository = cursoRepository;
        this.mapper = mapper;
    }

    @Override
    public CursoDto creatCurso(CursoDto cursoDto) {
        CursoEntity cursoEntity = mapper.map(cursoDto, CursoEntity.class);
        cursoEntity = cursoRepository.save(cursoEntity);
        return mapper.map(cursoEntity, CursoDto.class);
    }

    @Override
    public CursoDto findCursoById(int id) {
        Optional<CursoEntity> cursoEntity = cursoRepository.findById(id);
        return mapper.map(cursoEntity, CursoDto.class);
    }

    @Override
    public List<CursoDto> findAllCurso() {
        List<CursoDto> cursoEntities = cursoRepository.findAll()
                .stream().map(e -> mapper.map(e, CursoDto.class))
                .toList();
        return cursoEntities;
    }
}
