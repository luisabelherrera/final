package com.example.demo.repositories;


import com.example.demo.model.entities.imagen;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RegistrarUsuariosRepository extends JpaRepository<imagen, Long> {


}
