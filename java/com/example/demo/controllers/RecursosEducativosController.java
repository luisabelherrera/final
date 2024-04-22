package com.example.demo.controllers;

import com.example.demo.model.entities.RecursosEducativos;
import com.example.demo.services.RecursosEducativoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;

@Controller
public class RecursosEducativosController {

    @Autowired
    private RecursosEducativoService recursosEducativoService;

    @RequestMapping("/producto/lista")
    public String lista1(Model modelo) {
        Iterable<RecursosEducativos> recursosEducativos=recursosEducativoService.listar();
        modelo.addAttribute("recursos", recursosEducativos);
        return "alumno/ventanaSecundariaAlumno/RecursoEducativos";

    }

        @RequestMapping("/producto/formulario-crear")
    public String crearForm1(Model modelo) {
        modelo.addAttribute("recurso", new RecursosEducativos());
        return "profesores/ventanasecundariaprofesores/RecursoEducativos";

    }


    @PostMapping("/producto/crear")
    public RedirectView  crear1(@ModelAttribute RecursosEducativos recursosEducativos, Model model) {
        recursosEducativoService.registrar(recursosEducativos);
        model.addAttribute("recurso", recursosEducativos);
        return new RedirectView("/producto/lista");
    }

}