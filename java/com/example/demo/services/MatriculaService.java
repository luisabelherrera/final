package com.example.demo.services;

import com.example.demo.model.entities.Matricula;

public interface MatriculaService {


    void registrar(Matricula matricula);
    Iterable<Matricula> listar();


}
