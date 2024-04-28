package com.example.demo.model.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "asignatura")
public class Asignatura {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "asignatura_seq")
    @SequenceGenerator(name = "asignatura_seq", sequenceName = "asignatura_seq", allocationSize = 1, initialValue = 1)

    private long id;
    private String codigo;
    private String nombre;
    private String grado_curso;
    private int profesor;
    private String descripcion;
}
