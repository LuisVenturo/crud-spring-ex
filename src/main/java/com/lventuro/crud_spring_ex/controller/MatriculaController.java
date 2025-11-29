package com.lventuro.crud_spring_ex.controller;

import com.lventuro.crud_spring_ex.dto.MatriculaDto;
import com.lventuro.crud_spring_ex.dto.request.MatriculaRequest;
import com.lventuro.crud_spring_ex.service.MatriculaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/matricula")
public class MatriculaController {

    private final MatriculaService matriculaService;

    public MatriculaController(MatriculaService matriculaService) {
        this.matriculaService = matriculaService;
    }

    @PostMapping()
    public ResponseEntity<MatriculaDto> createMatricula(@RequestBody MatriculaRequest matriculaRequest) {
        MatriculaDto dto = matriculaService.creaMatriculaDto(matriculaRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

}
