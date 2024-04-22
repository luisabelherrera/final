package com.example.demo.services;

import com.example.demo.model.entities.Asignatura;

public interface AsignaturaService {


    void registrar(Asignatura asignatura);

    Iterable<Asignatura> listar();


}
