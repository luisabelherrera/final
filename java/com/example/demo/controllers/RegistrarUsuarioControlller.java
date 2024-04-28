package com.example.demo.controllers;


import com.example.demo.model.entities.Calificacion;
import com.example.demo.model.entities.RegistrarUsuario;
import com.example.demo.services.RegistrarUsuariosService;
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
public class RegistrarUsuarioControlller {


    @Autowired
    private RegistrarUsuariosService registrarUsuariosService;

    @RequestMapping("/Usuario/lista")
    public String lista5(Model modelo) {
        Iterable<RegistrarUsuario> registrarUsuarios = registrarUsuariosService.listar();
        modelo.addAttribute("Usuario", registrarUsuarios);
        return "Administrador/html/Roles/CrearRoles";

    }


    @RequestMapping("/Usuario/formulario-crear")
    public String crearForm5(Model modelo) {
        modelo.addAttribute("Usuario", new RegistrarUsuario());
        return "profesores/ventanasecundariaprofesores/Calificaciones";

    }


    @PostMapping("/Usuario/crear1")
    @ResponseBody
    public ResponseEntity<String> crearProducto5(@ModelAttribute RegistrarUsuario registrarUsuario) {
        try {
            registrarUsuariosService.registrar(registrarUsuario);
            return ResponseEntity.ok("calificacion registrada correctamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al registrar calificacion");
        }
    }
}



