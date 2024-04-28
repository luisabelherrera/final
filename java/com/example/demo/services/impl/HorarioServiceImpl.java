package com.example.demo.services.impl;


import com.example.demo.model.entities.Horario;
import com.example.demo.repositories.HorarioRepository;
import com.example.demo.services.HorarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HorarioServiceImpl implements HorarioService {



    @Autowired
    private HorarioRepository horarioRepository;

    @Override
    public void registrar(Horario horario) {
        horarioRepository.save(horario);
    }

    @Override
    public Iterable<Horario> listar() {
        return horarioRepository.findAll();
    }

}
