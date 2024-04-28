package com.example.demo.controllers;

import com.example.demo.model.entities.Estudiante;
import com.example.demo.services.EstudianteService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;



@Controller
public class EstudianteController {


    @Autowired
    private EstudianteService estudianteService;

    @GetMapping("/lista")
    public String lista(Model modelo) {
        Iterable<Estudiante> estudiantes = estudianteService.listar();
        modelo.addAttribute("estudiantes", estudiantes);
        return "Administrador/html/estudiantes/lista";
    }

    @GetMapping({"/formulario-crear", "/agregar" , "/borrar","/listar","/Principal"} )
    public String mostrarFormularioCreacion(Model modelo, HttpServletRequest request) {
        modelo.addAttribute("estudiante", new Estudiante());
        String requestURI = request.getRequestURI();
        if (requestURI.equals("/formulario-crear")) {
            return "crearEstudiante";
        } else if (requestURI.equals("/agregar")) {
            return "Administrador/html/estudiantes/agregar";
        }
         else if (requestURI.equals("/borrar")) {
          return "Administrador/html/estudiantes/borrar";
    }

        else if (requestURI.equals("/Principal")) {
            return "Administrador/html/ventanaprincipalAdmin";
        }


        else if (requestURI.equals("/listar")) {
            return "Administrador/html/estudiantes/lista";
        }
        return "crearEstudiante";
    }

    @PostMapping("/estudiante/crear1")
    @ResponseBody
    public ResponseEntity<String> crearEstudiante(@ModelAttribute Estudiante estudiante) {
        try {
            estudianteService.registrar(estudiante);
            return ResponseEntity.ok("Estudiante registrado correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al registrar estudiante");
        }
    }


    @PostMapping("/borrar")
    public String eliminarEstudiante(@RequestParam("id") long id, Model model) {
        try {
            estudianteService.eliminarPorId(id);
            model.addAttribute("mensaje", "Estudiante eliminado correctamente");
        } catch (EntityNotFoundException e) {
            model.addAttribute("error", "Error al eliminar estudiante: El estudiante con ID " + id + " no existe.");
        } catch (Exception e) {
            model.addAttribute("error", "Error al eliminar estudiante");
        }
       return "Administrador/html/estudiantes/lista";
    }

    @PostMapping("/estudiante/crear")
    public RedirectView crearEstudiante(@ModelAttribute Estudiante estudiante, RedirectAttributes redirectAttributes) {
        estudianteService.registrar(estudiante);
        redirectAttributes.addFlashAttribute("mensaje", "Estudiante registrado correctamente");
        return new RedirectView("/lista");
    }
}