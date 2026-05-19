package com.jeshuaflores.kinalapp.controller;

import com.jeshuaflores.kinalapp.entity.Usuario;
import com.jeshuaflores.kinalapp.service.UsuarioService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort; // <--- Se agregó esta importación
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.*;

// ===================================================================
// CONTROLADOR DE ARQUITECTURA MVC - SEGMENTO: USUARIOS
// ===================================================================
@Controller
// Endpoints administrativos para la creación y listado de usuarios
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // =========================
    // LISTAR USUARIOS
    // =========================
    @GetMapping
    public String listar(Model model) {

        model.addAttribute(
                "usuarios",
                usuarioService.listar()
        );

        return "usuarios/lista";
    }

    // =========================
    // FORMULARIO NUEVO
    // =========================
    @GetMapping("/nuevo")
    public String nuevo(Model model) {

        model.addAttribute(
                "usuario",
                new Usuario()
        );

        return "usuarios/formulario";
    }

    // =========================
    // GUARDAR USUARIO
    // =========================
    @PostMapping("/guardar")
    public String guardar(
            @Valid @ModelAttribute Usuario usuario,
            BindingResult result,
            Model model
    ) {

        if (result.hasErrors()) {

            model.addAttribute(
                    "usuario",
                    usuario
            );

            return "usuarios/formulario";
        }

        usuarioService.guardar(usuario);

        return "redirect:/usuarios";
    }

    // =========================
    // EDITAR USUARIO
    // =========================
    @GetMapping("/editar/{id}")
    public String editar(
            @PathVariable Long id,
            Model model
    ) {

        Usuario usuario = usuarioService.buscarPorId(id);

        if (usuario == null) {

            return "redirect:/usuarios";
        }

        model.addAttribute(
                "usuario",
                usuario
        );

        return "usuarios/formulario";
    }

    // =========================
    // ELIMINAR USUARIO
    // =========================
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {

        usuarioService.eliminar(id);

        return "redirect:/usuarios";
    }
}