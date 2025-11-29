package com.lventuro.crud_spring_ex.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "matricula")
public class MatriculaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "estudiante_dni")
    private EstudianteEntity  estudiante;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private CursoEntity curso;

    @Temporal(TemporalType.DATE)
    @Column(name = "fechainscripcion")
    private Date fechaInscripcion = new Date();
    private double nota;

}
