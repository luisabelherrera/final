package com.example.demo.services;

import com.example.demo.model.entities.AsignaturaCursada;

import java.util.List;
import java.util.Optional;

public interface AsignaturaCursadaService {
 void guardar(AsignaturaCursada asignaturaCursada);
void actualizar(AsignaturaCursada asignaturaCursada);
 AsignaturaCursada obtenerPorId(Long id);
 List<AsignaturaCursada> listar();

    void eliminar(Long id);
}
