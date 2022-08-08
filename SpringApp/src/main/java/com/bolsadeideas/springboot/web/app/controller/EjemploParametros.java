package com.bolsadeideas.springboot.web.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.naming.Name;

@Controller
@RequestMapping("params")
public class EjemploParametros {

    @GetMapping("index")
    public String index(Model modelo){
        modelo.addAttribute("params","Enviar parametro desde URL");
        return "params/index";
    }

    @GetMapping("/ver")
    public String params(@RequestParam(name = "texto",required = false,defaultValue = "no se enviaron parametros") String texto, Model modelo){
        modelo.addAttribute("titulo","Recibir parametros");
        modelo.addAttribute("params","El paramtro recibido es: ".concat(texto));
        return "params/ver";
    }

    @GetMapping("/mix-params")
    public String params(@RequestParam(name = "saludo",required = false,defaultValue = "no se enviaron parametros") String texto, @RequestParam(name = "numero", required = false) Integer numeros, Model modelo){
        modelo.addAttribute("titulo","Recibir parametros");
        modelo.addAttribute("params","Saludo: ".concat(texto)+" y tengo "+numeros+" años");
        //return "params/ver";
        return  "Saludo: "+texto+" y tengo "+numeros+" años";
    }
}
