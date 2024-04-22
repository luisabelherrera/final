package com.example.demo.services.impl;

import com.example.demo.model.entities.Profesor;
import com.example.demo.repositories.EstudianteRepository;
import com.example.demo.repositories.ProfesorRepository;
import com.example.demo.services.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProfesorServiceImpl implements ProfesorService {

    @Autowired
    private ProfesorRepository profesorRepository;

    @Override
    public void registrar(Profesor profesor) {
        profesorRepository.save(profesor);
    }


    @Override
    public Iterable<Profesor> listar()  {
        return profesorRepository.findAll();
    }
    }

