package com.example.demo.model.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "calificacion")
public class Calificacion {



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "calificacion_seq")
    @SequenceGenerator(name = "calificacion_seq", sequenceName = "calificacion_seq", allocationSize = 1, initialValue = 1)

    private int id;
    private int calificacionPeriodo1;
    private double calificacionPeriodo2;
    private double calificacionPeriodo3;
    private double notaFinal;
    private String descripcion;
}
