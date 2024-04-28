package com.example.demo.controllers;


import com.example.demo.model.entities.Matricula;
import com.example.demo.services.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class MatriculaController {


    @Autowired
    private MatriculaService matriculaService;

    @RequestMapping("/matricula/lista")
    public String lista6(Model modelo) {
        Iterable<Matricula> matricula = matriculaService.listar();
        modelo.addAttribute("matriculas", matricula);
        return "Administrador/html/Matricula/TablaMatricula";

    }


    @RequestMapping("/matricula/formulario-crear")
    public String crearForm6(Model modelo) {
        modelo.addAttribute("matriculas", new Matricula());
        return "Administrador/html/Matricula/AgregarMatricula";

    }



    @PostMapping("/matricula/crear")
    public RedirectView crear6(@ModelAttribute Matricula matricula, Model model) {
        matriculaService.registrar(matricula);
        model.addAttribute("matriculas", matricula);
        return new RedirectView("/matricula/lista");
    }

}
