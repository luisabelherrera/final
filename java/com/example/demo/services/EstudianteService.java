package com.example.demo.services;

import com.example.demo.model.entities.Estudiante;
import com.example.demo.repositories.EstudianteRepository;


public interface EstudianteService {
    void registrar(Estudiante estudiante);
    Iterable<Estudiante> listar();


    void eliminarPorId(long id);


}