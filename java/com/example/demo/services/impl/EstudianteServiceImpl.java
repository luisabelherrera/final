package com.example.demo.services.impl;

import com.example.demo.model.entities.Estudiante;
import com.example.demo.repositories.EstudianteRepository;
import com.example.demo.services.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class  EstudianteServiceImpl  implements EstudianteService {


    @Autowired
    private EstudianteRepository estudianteRepository;

    @Override
    public Iterable<Estudiante> listar() {
      return estudianteRepository.findAll();
    }

    @Override
    public Optional<Estudiante> obtenerPorId(Long id) {
        return estudianteRepository.findById(id);
    }

    @Override
    public Estudiante crear(Estudiante estudiante) {
        return estudianteRepository.save(estudiante);
    }

    @Override
    public Estudiante actualizar(Long id, Estudiante estudianteDetalles) {
        Optional<Estudiante> optionalEstudiante = estudianteRepository.findById(id);
        if (optionalEstudiante.isPresent()) {
            Estudiante estudianteExistente = optionalEstudiante.get();
            estudianteExistente.setNombreCompleto(estudianteDetalles.getNombreCompleto());
            estudianteExistente.setFechaNacimiento(estudianteDetalles.getFechaNacimiento());
            estudianteExistente.setDirección(estudianteDetalles.getDirección());
            estudianteExistente.setTeléfono(estudianteDetalles.getTeléfono());
            estudianteExistente.setCorreoElectrónico(estudianteDetalles.getCorreoElectrónico());
            estudianteExistente.setGénero(estudianteDetalles.getGénero());
            estudianteExistente.setNacionalidad(estudianteDetalles.getNacionalidad());
            return estudianteRepository.save(estudianteExistente);
        }
        return null;
    }

    @Override
    public void eliminar(Long id) {
        estudianteRepository.deleteById(id);
    }
}