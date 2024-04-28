package com.example.demo.services;


import com.example.demo.model.entities.RegistrarUsuario;

public interface RegistrarUsuariosService {

    void registrar(RegistrarUsuario registrarUsuario);
    Iterable<RegistrarUsuario> listar();


}
