package com.example.demo.services;


import com.example.demo.model.entities.TipoUsuario;

public interface TipoUsuarioService {


    void registrar(TipoUsuario tipoUsuario);
    Iterable<TipoUsuario> listar();


}
