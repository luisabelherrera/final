package com.example.demo.controllers;

import com.example.demo.model.entities.Estudiante;
import com.example.demo.model.entities.RecursosEducativos;
import com.example.demo.services.RecursosEducativoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class RecursosEducativosController {

    @Autowired
    private RecursosEducativoService recursosEducativoService;

    @RequestMapping("/producto/lista")
    public String lista1(Model modelo) {
        Iterable<RecursosEducativos> recursosEducativos = recursosEducativoService.listar();
        modelo.addAttribute("recurso", recursosEducativos);
        return "alumno/ventanaSecundariaAlumno/RecursoEducativos";

    }


    @RequestMapping("/producto/formulario-crear")
    public String crearForm1(Model modelo) {
        modelo.addAttribute("recurso", new RecursosEducativos());
        return "profesores/ventanasecundariaprofesores/RecursoEducativos";

    }


    @PostMapping("/producto/crear1")
    @ResponseBody
    public ResponseEntity<String> crearProducto(@ModelAttribute RecursosEducativos recursosEducativos) {
        try {
            recursosEducativoService.registrar(recursosEducativos);
            return ResponseEntity.ok("RECURSO registrado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al registrar REcurso");
        }
    }
}