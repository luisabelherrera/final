package com.example.demo.services;

import com.example.demo.model.entities.Estudiante;


public interface EstudianteService {
    void registrar(Estudiante estudiante);
    Iterable<Estudiante> listar();


    void eliminarPorId(long id);


}