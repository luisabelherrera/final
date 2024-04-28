package com.example.demo.controllers;

import com.example.demo.model.entities.Calificacion;
import com.example.demo.services.CalificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class CalificacionController {

    @Autowired
    private CalificacionService calificacionService;

    @RequestMapping("/Calificacion/lista")
    public String lista4(Model modelo) {
        Iterable<Calificacion> calificacions = calificacionService.listar();
        modelo.addAttribute("calificacion", calificacions);
        return "alumno/ventanaSecundariaAlumno/Miscalificacion";

    }


    @RequestMapping("/Calificacion/formulario-crear")
    public String crearForm4(Model modelo) {
        modelo.addAttribute("calificacion", new Calificacion());
        return "profesores/ventanasecundariaprofesores/Calificaciones";

    }


    @PostMapping("/Calificacion/crear1")
    @ResponseBody
    public ResponseEntity<String> crearProducto4(@ModelAttribute Calificacion calificacion) {
        try {
            calificacionService.registrar(calificacion);
            return ResponseEntity.ok("calificacion registrada correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al registrar calificacion");
        }
    }
}




