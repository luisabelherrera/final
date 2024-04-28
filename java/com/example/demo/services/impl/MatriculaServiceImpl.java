package com.example.demo.services.impl;


import com.example.demo.model.entities.Matricula;
import com.example.demo.repositories.MatriculaRepository;
import com.example.demo.services.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MatriculaServiceImpl implements MatriculaService {



    @Autowired
    private MatriculaRepository matriculaRepository;

    @Override
    public void registrar(Matricula matricula) {
        matriculaRepository.save(matricula);
    }

    @Override
    public Iterable<Matricula> listar() {
        return matriculaRepository.findAll();
    }

}
