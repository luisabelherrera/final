package com.example.demo.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "curso")
public class Curso {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "curso_seq")
    @SequenceGenerator(name = "curso_seq", sequenceName = "curso_seq", allocationSize = 1, initialValue = 1)

    private int id;
    private int nivel;
    private String seccion;
    private int cupos;
    private String añolectivo;
    private String director;
    private String grado;
    private String sede;


}
