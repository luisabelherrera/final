package com.example.demo.repositories;

import com.example.demo.model.entities.Periodo;
import org.springframework.data.repository.CrudRepository;

public interface PeriodoRepository extends CrudRepository<Periodo, Long> {
}