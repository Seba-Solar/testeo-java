package com.testview.testeo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/index")
    public String home(Model model){
        model.addAttribute("mensaje", "¡Bienvenido a Thymeleaf!");
        return "home";
    }

    @GetMapping("/registro")
    public String registro(){   return  "registro"; }
}
