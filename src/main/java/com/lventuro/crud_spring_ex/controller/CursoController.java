package com.lventuro.crud_spring_ex.controller;

import com.lventuro.crud_spring_ex.dto.CursoDto;
import com.lventuro.crud_spring_ex.service.CursoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/curso")
public class CursoController {
    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @PostMapping("/save")
    public ResponseEntity<CursoDto> saveCurso(@RequestBody CursoDto cursoDto) {
        var dto = cursoService.creatCurso(cursoDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoDto> getCursoById(@PathVariable Integer id) {
        return ResponseEntity.ok(cursoService.findCursoById(id));
    }

    @GetMapping()
    public List<CursoDto> getAllCurso() {
        return cursoService.findAllCurso();
    }
}
