package com.example.demo.controllers;


import com.example.demo.model.entities.Estudiante;
import com.example.demo.services.AsignaturaCursadaService;
import com.example.demo.services.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;



@Controller
@RequestMapping("/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;


    @Autowired
    private AsignaturaCursadaService asignaturaCursadaService;


    @GetMapping("/lista")
    public String lista(Model modelo) {
        Iterable<Estudiante> estudiantes = estudianteService.listar();
        modelo.addAttribute("estudiantes", estudiantes);
        return "Administrador/html/estudiantes/lista";
    }


    @GetMapping("/principal")
    public String principal(Model modelo) {
        return "Administrador/html/ventanaprincipalAdmin";
    }

    @GetMapping("/crear")
    public String mostrarFormularioCreacion(Model modelo) {
        modelo.addAttribute("estudiante", new Estudiante());
        return "Administrador/html/estudiantes/agregar";
    }


    @PostMapping("/crear")
    public RedirectView crearEstudiante(@ModelAttribute Estudiante estudiante, RedirectAttributes redirectAttributes) {
        estudianteService.crear(estudiante);
        redirectAttributes.addFlashAttribute("mensaje", "Estudiante registrado correctamente");
        return new RedirectView("/estudiantes/lista");
    }


    @GetMapping("/actualizar/{id}")
    public String mostrarFormularioActualizacion(@PathVariable Long id, Model modelo) {
        Estudiante estudiante = estudianteService.obtenerPorId(id).orElse(null);
        modelo.addAttribute("estudiante", estudiante);
        return "Administrador/html/estudiantes/modificar";
    }


    @PostMapping("/actualizar/{id}")
    public RedirectView actualizarEstudiante(@PathVariable Long id, @ModelAttribute Estudiante estudianteDetalles, RedirectAttributes redirectAttributes) {
        estudianteService.actualizar(id, estudianteDetalles);
        redirectAttributes.addFlashAttribute("mensaje", "Estudiante actualizado correctamente");
        return new RedirectView("/estudiantes/lista");
    }


    @GetMapping("/borrar/{id}")
    public String mostrarFormularioBorrar(@PathVariable Long id, Model modelo) {
        modelo.addAttribute("estudianteId", id);
        return "Administrador/html/estudiantes/borrar";
    }


    @PostMapping("/borrar/{id}")
    public RedirectView eliminarEstudiante(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            estudianteService.eliminar(id);
            redirectAttributes.addFlashAttribute("mensaje", "Estudiante eliminado correctamente");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al eliminar estudiante");
        }
        return new RedirectView("/estudiantes/lista");
    }
}