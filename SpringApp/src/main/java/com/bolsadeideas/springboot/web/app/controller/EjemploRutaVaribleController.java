package com.bolsadeideas.springboot.web.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class EjemploRutaVaribleController {

    @GetMapping("/")
    public String index(){
        return "variable/index";
    }
    @GetMapping("string/{texto}")
    public String rutaVariable(@PathVariable String texto, Model modelo){
        modelo.addAttribute("titulo","Rutas variables");
        modelo.addAttribute("params","Variable desde @ParhVariable : "+texto);
        return "variable/ver";
    }

    @GetMapping("string/{texto}/{nombre}")
    public String rutaVariable(@PathVariable String texto,@PathVariable String nombre, Model modelo){
        modelo.addAttribute("titulo","Rutas variables");
        modelo.addAttribute("params","Variable desde @ParhVariable : "+texto+" soy "+nombre);
        return "variable/ver";
    }
}
