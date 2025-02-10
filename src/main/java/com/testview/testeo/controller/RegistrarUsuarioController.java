package com.testview.testeo.controller;

import com.testview.testeo.model.UsuarioModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrarUsuarioController {
    @PostMapping
    public String registrarUsuario(@ModelAttribute UsuarioModel usuario){
    return "Registro exitoso";
    }
}
