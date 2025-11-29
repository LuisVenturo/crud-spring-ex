package com.lventuro.crud_spring_ex.repository;

import com.lventuro.crud_spring_ex.entity.MatriculaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatriculaRepository extends JpaRepository<MatriculaEntity, Integer> {
}
