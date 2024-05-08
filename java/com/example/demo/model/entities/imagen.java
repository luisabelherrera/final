package com.example.demo.model.entities;

import jakarta.persistence.*;
import lombok.*;


@Setter
@Getter
@Entity
@Table(name = "registrarUsuario")
public class imagen {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Lob
    private byte[] datos;

    private String formato;



    }
