package com.jeshuaflores.kinalapp.controller;

import com.jeshuaflores.kinalapp.entity.Producto;
import com.jeshuaflores.kinalapp.service.ProductoService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort; // <--- Se agregó esta importación
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    // =========================
    // LISTAR PRODUCTOS
    // =========================
    @GetMapping
    public String listar(Model model) {

        model.addAttribute(
                "productos",
                productoService.listar()
        );

        return "productos/lista";
    }

    // =========================
    // FORMULARIO NUEVO
    // =========================
    @GetMapping("/nuevo")
    public String nuevo(Model model) {

        model.addAttribute(
                "producto",
                new Producto()
        );

        return "productos/formulario";
    }

    // =========================
    // GUARDAR PRODUCTO
    // =========================
    @PostMapping("/guardar")
    public String guardar(
            @Valid @ModelAttribute Producto producto,
            BindingResult result,
            Model model
    ) {

        if (result.hasErrors()) {

            model.addAttribute(
                    "producto",
                    producto
            );

            return "productos/formulario";
        }

        productoService.guardar(producto);

        return "redirect:/productos";
    }

    // =========================
    // EDITAR PRODUCTO
    // =========================
    @GetMapping("/editar/{id}")
    public String editar(
            @PathVariable Long id,
            Model model
    ) {

        Producto producto = productoService.buscarPorId(id);

        if (producto == null) {

            return "redirect:/productos";
        }

        model.addAttribute(
                "producto",
                producto
        );

        return "productos/formulario";
    }

    // =========================
    // ELIMINAR PRODUCTO
    // =========================
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {

        productoService.eliminar(id);

        return "redirect:/productos";
    }
}