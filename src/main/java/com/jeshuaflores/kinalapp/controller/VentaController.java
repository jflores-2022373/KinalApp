package com.jeshuaflores.kinalapp.controller;

import com.jeshuaflores.kinalapp.entity.Venta;
import com.jeshuaflores.kinalapp.service.ClienteService;
import com.jeshuaflores.kinalapp.service.UsuarioService;
import com.jeshuaflores.kinalapp.service.VentaService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private UsuarioService usuarioService;

    // =========================
    // LISTAR VENTAS
    // =========================
    @GetMapping
    public String listar(Model model) {

        model.addAttribute(
                "ventas",
                ventaService.listar()
        );

        return "ventas/lista";
    }

    // =========================
    // FORMULARIO NUEVO
    // =========================
    @GetMapping("/nuevo")
    public String nuevo(Model model) {

        model.addAttribute(
                "venta",
                new Venta()
        );

        model.addAttribute(
                "clientes",
                clienteService.listar()
        );

        model.addAttribute(
                "usuarios",
                usuarioService.listar()
        );

        return "ventas/formulario";
    }

    // =========================
    // GUARDAR VENTA
    // =========================
    @PostMapping("/guardar")
    public String guardar(
            @Valid @ModelAttribute Venta venta,
            BindingResult result,
            Model model
    ) {

        if (result.hasErrors()) {

            model.addAttribute(
                    "clientes",
                    clienteService.listar()
            );

            model.addAttribute(
                    "usuarios",
                    usuarioService.listar()
            );

            return "ventas/formulario";
        }

        ventaService.guardar(venta);

        return "redirect:/ventas";
    }

    // =========================
    // EDITAR VENTA
    // =========================
    @GetMapping("/editar/{id}")
    public String editar(
            @PathVariable Long id,
            Model model
    ) {

        Venta venta = ventaService.buscarPorId(id);

        if (venta == null) {

            return "redirect:/ventas";
        }

        model.addAttribute(
                "venta",
                venta
        );

        model.addAttribute(
                "clientes",
                clienteService.listar()
        );

        model.addAttribute(
                "usuarios",
                usuarioService.listar()
        );

        return "ventas/formulario";
    }

    // =========================
    // ELIMINAR VENTA
    // =========================
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {

        ventaService.eliminar(id);

        return "redirect:/ventas";
    }
}