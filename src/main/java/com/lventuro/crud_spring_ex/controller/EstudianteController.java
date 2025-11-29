package com.lventuro.crud_spring_ex.controller;

import com.lventuro.crud_spring_ex.dto.EstudianteDto;
import com.lventuro.crud_spring_ex.service.EstudianteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/estudiante")
public class EstudianteController {
    private final EstudianteService estudianteService;

    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @PostMapping("/save")
    public ResponseEntity<EstudianteDto> createEstudiante(@RequestBody EstudianteDto estudianteDto) {
        EstudianteDto dto = estudianteService.create(estudianteDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @GetMapping("/{dni}")
    public ResponseEntity<EstudianteDto> findByDni(@PathVariable String dni){
        EstudianteDto dto = estudianteService.findByDni(dni);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
}
