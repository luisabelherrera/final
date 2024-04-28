package com.example.demo.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Table(name = "horario")
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "horario_seq")
    @SequenceGenerator(name = "horario_seq", sequenceName = "horario_seq", allocationSize = 1)

    private int id_horario;
    private String dia_semana;
    private LocalDateTime hora_inicio;
    private LocalDateTime hora_fin;
    private int id_curso;
    private int id_asignatura;
    private int id_professor;

}
