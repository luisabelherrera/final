package com.example.demo.model.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "recursosEducativos")
public class RecursosEducativos {



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recursosEducativos_seq")
    @SequenceGenerator(name = "recursosEducativos_seq", sequenceName = "recursosEducativos_seq", allocationSize = 1)

    private long id;
    private int idRecurso;
    private String nombreRecurso;
    private String tipoRecurso;
    private String descripcionRecurso;
    private String autorRecurso;
    private String enlaceRecurso;
    private byte[] archivoRecurso;




    }


