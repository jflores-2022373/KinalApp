package com.jeshuaflores.kinalapp.controller;

import com.jeshuaflores.kinalapp.entity.Cliente;
import com.jeshuaflores.kinalapp.service.ClienteService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort; // <--- Se agregó esta importación para el ordenamiento
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.*;
// Módulo de control de tráfico para la gestión de clientes en el sistema
// CONTROLADOR DE ARQUITECTURA MVC - SEGMENTO: CLIENTES
@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // =========================
    // LISTAR CLIENTES
    // =========================
    @GetMapping
    // CONFIGURACIÓN DE RUTAS Y MAPEOS - PATRÓN MVC SPRING
    public String listar(Model model) {

        // Se modificó para ordenar por 'id' de forma descendente (los más nuevos primero)
        model.addAttribute(
                "clientes",
                clienteService.listar()
        );

        return "clientes/lista";
    }

    // =========================
    // FORMULARIO NUEVO
    // =========================
    @GetMapping("/nuevo")
    public String nuevo(Model model) {

        model.addAttribute(
                "cliente",
                new Cliente()
        );

        return "clientes/formulario";
    }

    // =========================
    // GUARDAR CLIENTE
    // =========================
    @PostMapping("/guardar")
    public String guardar(
            @Valid @ModelAttribute Cliente cliente,
            BindingResult result,
            Model model
    ) {

        if (result.hasErrors()) {

            model.addAttribute(
                    "cliente",
                    cliente
            );

            return "clientes/formulario";
        }

        clienteService.guardar(cliente);

        return "redirect:/clientes";
    }

    // =========================
    // EDITAR CLIENTE
    // =========================
    @GetMapping("/editar/{id}")
    public String editar(
            @PathVariable Long id,
            Model model
    ) {

        Cliente cliente = clienteService.buscarPorId(id);

        if (cliente == null) {

            return "redirect:/clientes";
        }

        model.addAttribute(
                "cliente",
                cliente
        );

        return "clientes/formulario";
    }

    // =========================
    // ELIMINAR CLIENTE
    // =========================
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {

        clienteService.eliminar(id);

        return "redirect:/clientes";
    }
}