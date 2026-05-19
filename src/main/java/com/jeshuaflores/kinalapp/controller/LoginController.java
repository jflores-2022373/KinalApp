package com.jeshuaflores.kinalapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

// Gestión de peticiones de inicio de sesión y renderizado del login customizado
@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {

        return "login";
    }

}