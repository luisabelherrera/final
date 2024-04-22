package com.example.demo.services;

import com.example.demo.model.entities.Estudiante;
import com.example.demo.model.entities.Profesor;

public interface ProfesorService {
    void registrar(Profesor profesor);
    Iterable<Profesor> listar();

}