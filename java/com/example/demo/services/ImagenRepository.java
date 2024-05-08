package com.example.demo.services;



import com.example.demo.model.entities.imagen;
import com.example.demo.repositories.RegistrarUsuariosRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ImagenRepository {

    @Autowired
    private RegistrarUsuariosRepository registrarUsuariosRepository;


    @Transactional
    public void guardarImagen(imagen registrarUsuario) {
        registrarUsuariosRepository.save(registrarUsuario);
    }

    public List<imagen> obtenerTodasLasImagenes() {
        return registrarUsuariosRepository.findAll();
    }

    public imagen obtenerImagenPorId(Long id) {
        return registrarUsuariosRepository.findById(id).orElse(null);
    }
    @Transactional
    public void eliminarImagen(Long id) {
        registrarUsuariosRepository.deleteById(id);
    }
}