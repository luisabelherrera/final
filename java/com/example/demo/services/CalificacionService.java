package com.example.demo.services;

import com.example.demo.model.entities.Calificacion;


public interface CalificacionService {



    void registrar(Calificacion calificacion);

    Iterable<Calificacion> listar();


}
