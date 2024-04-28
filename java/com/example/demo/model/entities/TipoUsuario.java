package com.example.demo.model.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tipoUsuario")
public class TipoUsuario {



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipoUsuario_seq")
    @SequenceGenerator(name = "tipoUsuario_seq", sequenceName = "tipoUsuario_seq", allocationSize = 1)



    private int idTipoUsuario;
    private String descripcion;



}
