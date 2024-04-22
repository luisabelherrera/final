package com.example.demo.services.impl;

import com.example.demo.model.entities.Curso;
import com.example.demo.repositories.CursoRepository;
import com.example.demo.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoServiceImpl implements CursoService {


    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public void registrar(Curso curso) {
        cursoRepository.save(curso);
    }

    @Override
    public Iterable<Curso> listar() {
        return cursoRepository.findAll();
    }

}
