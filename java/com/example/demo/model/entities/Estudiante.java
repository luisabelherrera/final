package com.example.demo.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Setter
@Getter
@Table(name = "estudiante")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estudiante_seq")
    @SequenceGenerator(name = "estudiante_seq", sequenceName = "estudiante_seq", allocationSize = 1, initialValue = 1)
    private Long id;

    private int codigo;
    private String nombre;
    private String apellido;
    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    private String genero;
    private String dirrecion;
    private String telefono;
    private String email;
    private int edad;
    private String acudiente;



}
