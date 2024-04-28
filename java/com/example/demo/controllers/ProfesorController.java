package com.example.demo.controllers;


import com.example.demo.model.entities.Profesor;
import com.example.demo.services.ProfesorService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;


    @RequestMapping("/profesor/lista")
    public String lista2(Model modelo) {
        Iterable<Profesor> profesor = profesorService.listar();
        modelo.addAttribute("profesor", profesor);
        return "Administrador/html/profesores/TablaProfesor";

    }

    @RequestMapping("/profesor/formulario-crear")
    public String crearForm2(Model modelo) {
        modelo.addAttribute("profesor", new Profesor());
        return "Administrador/html/profesores/agregarProfesor";

    }

    @GetMapping({"/PrincipalProfesor","/Horario","/Calificacion"} )
    public String mostrarFormularioCreacion2(Model modelo, HttpServletRequest request) {
        modelo.addAttribute("profesor", new Profesor());
        String requestURI = request.getRequestURI();
        if (requestURI.equals("/PrincipalProfesor")) {
            return "profesores/ventanasecundariaprofesores/principalprofesores";
        }
        else if (requestURI.equals("/Horario")) {
            return "profesores/ventanasecundariaprofesores/Horario";
        }
        else if (requestURI.equals("/Calificacion")) {
            return "profesores/ventanasecundariaprofesores/Calificaciones";
        }
        return "crearEstudiante";
    }


    @PostMapping("/profesor/crear")
    public RedirectView crear2(@ModelAttribute Profesor profesor, Model model) {
        profesorService.registrar(profesor);
        model.addAttribute("profesor", profesor);
        return new RedirectView("/profesor/lista");
    }



}
