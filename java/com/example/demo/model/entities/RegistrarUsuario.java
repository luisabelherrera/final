package com.example.demo.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;



@Getter
@Setter
@Entity
@Table(name = "registrarUsuario")
public class RegistrarUsuario {



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "registrarUsuario_seq")
    @SequenceGenerator(name = "registrarUsuario_seq", sequenceName = "registrarUsuario_seq", allocationSize = 1)


    private int id;
private int codigo;
private int tipo;
private String usuario;
private String password;
private LocalDateTime fecha;
}
