package com.example.demo.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.tomcat.util.codec.binary.Base64;

import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "estudiantes")
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estudianteSeq")
    private Long id;

    private String nombreCompleto;
    private String fechaNacimiento;
    private String dirección;
    private String teléfono;
    private String correoElectrónico;
    private String género;
    private String nacionalidad;


   // AQUI COMIENZA LA FOTO PARA EL ESTUDIANTE
    private String nombre;

    @Lob
    private byte[] datos;

    private String formato;

    // hasta aca



    @OneToMany(mappedBy = "estudiante")
    private List<Matricula> matriculas;


    @Lob
    @Column
    private byte[] imageData;

    public String generateBase64Image() {
        return Base64.encodeBase64String(this.imageData);
    }
}
