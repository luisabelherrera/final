package com.example.demo.controllers;


import com.example.demo.model.entities.imagen;
import com.example.demo.services.ImagenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;



@Controller
public class ImagenControlller {
    @Autowired
    private ImagenRepository registrarUsuariosService;

    @PostMapping("/cargarImagen")
    public String cargarImagen(@RequestParam("nombre") String nombre, @RequestParam("imagen") MultipartFile file) {
        try {
            imagen imagen = new imagen();
            imagen.setNombre(nombre);
            imagen.setDatos(file.getBytes());

            registrarUsuariosService.guardarImagen(imagen);
        } catch (Exception e) {
        }
        return "redirect:/verImagenes";
    }


    @GetMapping("/verImagenes")
    public String verImagenes(Model model) {
        List<imagen> imagenes = registrarUsuariosService.obtenerTodasLasImagenes();
   model.addAttribute("imagenes", imagenes);
        return "crearEstudiante";
    }


    @GetMapping("/verImagen/{id}")
    public ResponseEntity<byte[]> verImagen(@PathVariable Long id) {
        imagen imagen = registrarUsuariosService.obtenerImagenPorId(id);
        if (imagen != null) {
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(imagen.getDatos());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
