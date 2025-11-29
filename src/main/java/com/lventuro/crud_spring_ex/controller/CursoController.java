package com.lventuro.crud_spring_ex.controller;

import com.lventuro.crud_spring_ex.dto.CursoDto;
import com.lventuro.crud_spring_ex.service.CursoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/curso")
@Tag(name = "Curso", description = "Endpoints para gestión de cursos")
public class CursoController {
    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }
    @Operation(
            summary = "Crear un curso",
            description = "Crea un nuevo curso en el sistema"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Curso creado correctamente",
            content = @Content(schema = @Schema(implementation = CursoDto.class))
    )
    @PostMapping("/save")
    public ResponseEntity<CursoDto> saveCurso(@RequestBody CursoDto cursoDto) {
        var dto = cursoService.creatCurso(cursoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @Operation(
            summary = "Obtener un curso por ID",
            description = "Retorna la información de un curso según su ID"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Curso encontrado",
            content = @Content(schema = @Schema(implementation = CursoDto.class))
    )
    @GetMapping("/{id}")
    public ResponseEntity<CursoDto> getCursoById(@PathVariable Integer id) {
        return ResponseEntity.ok(cursoService.findCursoById(id));
    }

    @Operation(
            summary = "Listar todos los cursos",
            description = "Retorna la lista completa de cursos registrados"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Listado de cursos",
            content = @Content
    )
    @GetMapping()
    public List<CursoDto> getAllCurso() {
        return cursoService.findAllCurso();
    }
}
