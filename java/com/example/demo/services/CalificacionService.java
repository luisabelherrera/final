package com.example.demo.services;

import com.example.demo.model.entities.Calificacion;
import com.example.demo.model.entities.Curso;

public interface CalificacionService {



    void registrar(Calificacion calificacion);

    Iterable<Calificacion> listar();


}
