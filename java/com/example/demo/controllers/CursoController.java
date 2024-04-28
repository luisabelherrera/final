package com.example.demo.controllers;

import com.example.demo.model.entities.Curso;
import com.example.demo.model.entities.Matricula;
import com.example.demo.services.CursoService;
import com.example.demo.services.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @RequestMapping("/curso/lista")
    public String lista7(Model modelo) {
        Iterable<Curso> cursos = cursoService.listar();
        modelo.addAttribute("cursos", cursos);
        return "Administrador/html/Matricula/TablaMatricula";

    }


    @RequestMapping("/curso/formulario-crear")
    public String crearForm7(Model modelo) {
        modelo.addAttribute("cursos", new Matricula());
        return "Administrador/html/Matricula/AgregarMatricula";

    }



    @PostMapping("/cursos/crear")
    public RedirectView crear7(@ModelAttribute Curso curso, Model model) {
        cursoService.registrar(curso);
        model.addAttribute("cursos", curso);
        return new RedirectView("/matricula/lista");
    }

}
