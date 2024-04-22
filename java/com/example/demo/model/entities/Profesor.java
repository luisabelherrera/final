package com.example.demo.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "profesor")
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "profesor_seq")
    @SequenceGenerator(name = "profesor_seq", sequenceName = "profesor_seq", allocationSize = 1)
    private Long id;
    private int codigo;
    private String nombre;
    private String apellido;
    private String telefono;
    private String celular;
    private String dirrecion;
    private String genero;
    private String email;
}
