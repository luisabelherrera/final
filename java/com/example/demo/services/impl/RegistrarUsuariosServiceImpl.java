package com.example.demo.services.impl;


import com.example.demo.model.entities.RegistrarUsuario;
import com.example.demo.repositories.RegistrarUsuariosRepository;
import com.example.demo.services.RegistrarUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RegistrarUsuariosServiceImpl implements RegistrarUsuariosService {

    @Autowired
    private RegistrarUsuariosRepository registrarUsuariosRepository;

    @Override
    public void registrar(RegistrarUsuario registrarUsuario) {
        registrarUsuariosRepository.save(registrarUsuario);
    }

    @Override
    public Iterable<RegistrarUsuario> listar() {
        return registrarUsuariosRepository.findAll();
    }


}
