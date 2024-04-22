package com.example.demo.services.impl;

import com.example.demo.model.entities.Calificacion;
import com.example.demo.repositories.CalificacionRepository;
import com.example.demo.services.CalificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CalificacionServiceImpl implements CalificacionService {


    @Autowired
    private CalificacionRepository calificacionRepository;

    @Override
    public void registrar(Calificacion calificacion) {
        calificacionRepository.save(calificacion);
    }

    @Override
    public Iterable<Calificacion> listar() {
        return calificacionRepository.findAll();
    }


}
