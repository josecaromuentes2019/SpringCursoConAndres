package com.bolsadeideas.springboot.web.app.controller;

import com.bolsadeideas.springboot.web.app.models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/app")
public class IndexController {
    @GetMapping({"/index",""})
    public String index(Map<String , Object> map){
        map.put("titulo","Hola Mundo con mapa");
        return "index";
    }

    @RequestMapping("/perfil")
    public String perfil(Model modelo){

        Usuario usuario = new Usuario();
        usuario.setNombre("Juan");
        usuario.setApellido("Martinez");
        usuario.setEmail("jose@correo");

        modelo.addAttribute("usuario",usuario);
        return  "perfil";
    }

    @GetMapping("/listar")
    public String listar(Model modelo){
        Usuario usuario = new Usuario();

        List<Usuario> usuarios = Arrays.asList(
                new Usuario("Jose","Caro","muentes@correo"),
                new Usuario("Juan","Perez","juan@correo"),
                new Usuario("Luisa","Lopez","lopez@correo"),
                new Usuario("Tom","Matias","tom@correo")
        );

        /*modelo.addAttribute("usuarios",usuarios);*/
        modelo.addAttribute("titulo","Listar usuarios");
        return "listar";
    }

    @ModelAttribute("usuarios")
    public List<Usuario> listaUsuarios(){

        List<Usuario> usuarios = Arrays.asList(
                new Usuario("Jose","Caro","muentes@correo"),
                new Usuario("Juan","Perez","juan@correo"),
                new Usuario("Luisa","Lopez","lopez@correo"),
                new Usuario("Tom","Matias","tom@correo")
        );

        return usuarios;
    }
}
