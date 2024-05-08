package com.example.demo.repositories;

import com.example.demo.model.entities.Calificacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface CalificacionRepository extends JpaRepository<Calificacion, Long> {
}
