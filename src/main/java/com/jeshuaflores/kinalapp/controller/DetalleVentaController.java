package com.jeshuaflores.kinalapp.controller;

import com.jeshuaflores.kinalapp.entity.DetalleVenta;
import com.jeshuaflores.kinalapp.service.DetalleVentaService;
import com.jeshuaflores.kinalapp.service.ProductoService;
import com.jeshuaflores.kinalapp.service.VentaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/detalleventas")
public class DetalleVentaController {

    @Autowired
    private DetalleVentaService detalleVentaService;

    @Autowired
    private VentaService ventaService;

    @Autowired
    private ProductoService productoService;

    // =========================
    // LISTAR DETALLES
    // =========================
    @GetMapping
    public String listar(Model model) {

        model.addAttribute(
                "detalleventas",
                detalleVentaService.listar()
        );

        return "detalleventas/lista";
    }

    // =========================
    // FORMULARIO NUEVO
    // =========================
    @GetMapping("/nuevo")
    public String nuevo(Model model) {

        model.addAttribute(
                "detalleVenta",
                new DetalleVenta()
        );

        model.addAttribute(
                "ventas",
                ventaService.listar()
        );

        model.addAttribute(
                "productos",
                productoService.listar()
        );

        return "detalleventas/formulario";
    }

    // =========================
    // GUARDAR DETALLE
    // =========================
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute DetalleVenta detalleVenta) {

        double subtotal =
                detalleVenta.getCantidad()
                        * detalleVenta.getProducto().getPrecio();

        detalleVenta.setSubtotal(subtotal);

        detalleVentaService.guardar(detalleVenta);

        return "redirect:/detalleventas";
    }

    // =========================
    // EDITAR DETALLE
    // =========================
    @GetMapping("/editar/{id}")
    public String editar(
            @PathVariable Long id,
            Model model
    ) {

        DetalleVenta detalleVenta =
                detalleVentaService.buscarPorId(id);

        if (detalleVenta == null) {

            return "redirect:/detalleventas";
        }

        model.addAttribute(
                "detalleVenta",
                detalleVenta
        );

        model.addAttribute(
                "ventas",
                ventaService.listar()
        );

        model.addAttribute(
                "productos",
                productoService.listar()
        );

        return "detalleventas/formulario";
    }

    // =========================
    // ELIMINAR DETALLE
    // =========================
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {

        detalleVentaService.eliminar(id);

        return "redirect:/detalleventas";
    }
}