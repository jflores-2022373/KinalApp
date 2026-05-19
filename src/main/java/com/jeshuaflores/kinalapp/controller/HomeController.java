package com.jeshuaflores.kinalapp.controller;

import com.jeshuaflores.kinalapp.service.ClienteService;
import com.jeshuaflores.kinalapp.service.ProductoService;
import com.jeshuaflores.kinalapp.service.UsuarioService;
import com.jeshuaflores.kinalapp.service.VentaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private VentaService ventaService;

    @GetMapping("/")
    public String inicio(Model model) {

        model.addAttribute(
                "totalProductos",
                productoService.listar().size()
        );

        model.addAttribute(
                "totalClientes",
                clienteService.listar().size()
        );

        model.addAttribute(
                "totalUsuarios",
                usuarioService.listar().size()
        );

        model.addAttribute(
                "totalVentas",
                ventaService.listar().size()
        );

        return "dashboard";
    }

}