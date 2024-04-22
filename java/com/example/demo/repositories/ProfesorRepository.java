package com.example.demo.repositories;

import com.example.demo.model.entities.Estudiante;
import com.example.demo.model.entities.Profesor;
import org.springframework.data.repository.CrudRepository;

public interface ProfesorRepository extends CrudRepository<Profesor, Long> {
}
