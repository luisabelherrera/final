package com.example.demo.services;


import com.example.demo.model.entities.Horario;

public interface HorarioService {


    void registrar(Horario horario);
    Iterable<Horario> listar();

}
