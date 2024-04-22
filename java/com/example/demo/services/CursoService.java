package com.example.demo.services;

import com.example.demo.model.entities.Curso;


public interface CursoService {


    void registrar(Curso curso);
    Iterable<Curso> listar();

}
