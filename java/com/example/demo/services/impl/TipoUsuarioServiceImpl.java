package com.example.demo.services.impl;


import com.example.demo.model.entities.TipoUsuario;
import com.example.demo.repositories.TipoUsuarioRepository;
import com.example.demo.services.TipoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoUsuarioServiceImpl implements TipoUsuarioService {

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    @Override
    public void registrar(TipoUsuario tipoUsuario) {
        tipoUsuarioRepository.save(tipoUsuario);
    }

    @Override
    public Iterable<TipoUsuario> listar() {
        return tipoUsuarioRepository.findAll();
    }


}
