package com.example.demo.repositories;

import com.example.demo.model.entities.Calificacion;
import com.example.demo.model.entities.Curso;
import org.springframework.data.repository.CrudRepository;

public interface CalificacionRepository extends CrudRepository<Calificacion, Long> {
}
