package com.example.demo.controllers;



import com.example.demo.model.entities.Profesor;
import com.example.demo.model.entities.RecursosEducativos;
import com.example.demo.services.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;


    @RequestMapping("/profesor/lista")
    public String lista1(Model modelo) {
        Iterable<Profesor> profesor = profesorService.listar();
        modelo.addAttribute("profesor", profesor);
        return "ventanasecundariaprofesor/modificar";

    }

    @RequestMapping("/profesor/formulario-crear")
    public String crearForm1(Model modelo) {
        modelo.addAttribute("profesor", new RecursosEducativos());
        return "ventanasecundariaprofesor/modificar";

    }


    @PostMapping("/profesor/crear")
    public RedirectView crear1(@ModelAttribute Profesor profesor, Model model) {
        profesorService.registrar(profesor);
        model.addAttribute("profesor", profesor);
        return new RedirectView("/profesor/lista");
    }



}
