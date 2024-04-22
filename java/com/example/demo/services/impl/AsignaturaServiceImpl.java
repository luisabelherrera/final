package com.example.demo.services.impl;

import com.example.demo.model.entities.Asignatura;
import com.example.demo.model.entities.Calificacion;
import com.example.demo.repositories.AsignaturaRepository;
import com.example.demo.repositories.CalificacionRepository;
import com.example.demo.services.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AsignaturaServiceImpl implements AsignaturaService {

    @Autowired
    private AsignaturaRepository asignaturaRepository;

    @Override
    public void registrar(Asignatura asignatura) {
        asignaturaRepository.save(asignatura);
    }

    @Override
    public Iterable<Asignatura> listar() {
        return asignaturaRepository.findAll();
    }

}
