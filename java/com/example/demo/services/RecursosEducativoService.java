    package com.example.demo.services;


    import com.example.demo.model.entities.RecursosEducativos;

    public interface RecursosEducativoService {
        void registrar(RecursosEducativos recursosEducativos);
        Iterable<RecursosEducativos> listar();

    }

