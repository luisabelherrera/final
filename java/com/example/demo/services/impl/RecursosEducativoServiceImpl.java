package com.example.demo.services.impl;


import com.example.demo.model.entities.RecursosEducativos;

import com.example.demo.repositories.RecursosEducativosRepository;
import com.example.demo.services.RecursosEducativoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RecursosEducativoServiceImpl implements RecursosEducativoService {


    @Autowired
    private RecursosEducativosRepository recursosEducativosRepository;

    @Override
    public void registrar(RecursosEducativos recursosEducativos) {
        recursosEducativosRepository.save(recursosEducativos);
    }

    @Override
    public Iterable<RecursosEducativos> listar() {
        return recursosEducativosRepository.findAll();
    }






}
