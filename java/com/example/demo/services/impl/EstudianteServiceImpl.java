package com.example.demo.services.impl;

import com.example.demo.model.entities.Estudiante;
import com.example.demo.repositories.EstudianteRepository;
import com.example.demo.services.EstudianteService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EstudianteServiceImpl  implements EstudianteService {


    @Autowired
    private EstudianteRepository estudianteRepository;

    @Override
    public void registrar(Estudiante estudiante) {
        estudianteRepository.save(estudiante);
    }

    @Override
    public Iterable<Estudiante> listar() {
        return estudianteRepository.findAll();
    }

    @Override
    public void eliminarPorId(long id) {
        boolean exists = estudianteRepository.existsById(id);
        if (exists) {
            estudianteRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Estudiante con ID " + id + " no encontrado");
        }
    }
}

