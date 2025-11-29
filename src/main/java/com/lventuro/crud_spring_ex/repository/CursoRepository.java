package com.lventuro.crud_spring_ex.repository;

import com.lventuro.crud_spring_ex.entity.CursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<CursoEntity, Integer> {
}
