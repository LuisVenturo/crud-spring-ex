package com.lventuro.crud_spring_ex.repository;

import com.lventuro.crud_spring_ex.entity.EstudianteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRespository extends JpaRepository<EstudianteEntity,Integer> {
    EstudianteEntity findByDni(String dni);

    String dni(String dni);
}
