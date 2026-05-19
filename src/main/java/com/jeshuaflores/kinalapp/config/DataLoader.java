package com.jeshuaflores.kinalapp.config;

import com.jeshuaflores.kinalapp.entity.*;
import com.jeshuaflores.kinalapp.repository.*;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initData(
            ProductoRepository productoRepository,
            ClienteRepository clienteRepository,
            UsuarioRepository usuarioRepository,
            VentaRepository ventaRepository,
            DetalleVentaRepository detalleVentaRepository
    ) {

        return args -> {

            Random random = new Random();

            // =========================================
            // PRODUCTOS
            // =========================================

            if(productoRepository.count() == 0) {

                List<Producto> productos = new ArrayList<>();

                for(int i = 1; i <= 1000; i++) {

                    Producto producto = new Producto();

                    producto.setNombre("Producto " + i);

                    producto.setDescripcion(
                            "Descripcion del producto " + i);

                    producto.setPrecio(
                            50.0 + random.nextInt(500));

                    producto.setStock(
                            random.nextInt(200));

                    producto.setCategoria(
                            "Categoria " + (i % 10));

                    producto.setEstado(true);

                    producto.setFechaIngreso(
                            LocalDate.now());

                    productos.add(producto);
                }

                productoRepository.saveAll(productos);

                System.out.println("1000 PRODUCTOS INSERTADOS");
            }

            // =========================================
            // CLIENTES
            // =========================================

            if(clienteRepository.count() == 0) {

                List<Cliente> clientes = new ArrayList<>();

                for(int i = 1; i <= 1000; i++) {

                    Cliente cliente = new Cliente();

                    cliente.setNombre("Cliente" + i);

                    cliente.setApellido("Apellido" + i);

                    cliente.setCorreo(
                            "cliente" + i + "@gmail.com");

                    cliente.setTelefono(
                            "5555" + i);

                    cliente.setDireccion(
                            "Direccion " + i);

                    cliente.setNit(
                            "1000" + i);

                    cliente.setEstado(true);

                    clientes.add(cliente);
                }

                clienteRepository.saveAll(clientes);

                System.out.println("1000 CLIENTES INSERTADOS");
            }

            // =========================================
            // USUARIOS
            // =========================================

            if(usuarioRepository.count() == 0) {

                List<Usuario> usuarios = new ArrayList<>();

                for(int i = 1; i <= 1000; i++) {

                    Usuario usuario = new Usuario();

                    usuario.setUsername(
                            "usuario" + i);

                    usuario.setNombre(
                            "Usuario " + i);

                    usuario.setCorreo(
                            "usuario" + i + "@gmail.com");

                    usuario.setPassword("1234");

                    if(i % 2 == 0) {
                        usuario.setRol("ADMIN");
                    } else {
                        usuario.setRol("USER");
                    }

                    usuario.setEstado(true);

                    usuarios.add(usuario);
                }

                usuarioRepository.saveAll(usuarios);

                System.out.println("1000 USUARIOS INSERTADOS");
            }

            // =========================================
            // VENTAS
            // =========================================

            if(ventaRepository.count() == 0) {

                List<Cliente> clientes =
                        clienteRepository.findAll();

                List<Usuario> usuarios =
                        usuarioRepository.findAll();

                List<Venta> ventas = new ArrayList<>();

                for(int i = 1; i <= 1000; i++) {

                    Venta venta = new Venta();

                    venta.setFechaVenta(
                            LocalDate.now());

                    venta.setTotal(
                            100.0 + random.nextInt(1000));

                    venta.setCliente(
                            clientes.get(
                                    random.nextInt(clientes.size())
                            )
                    );

                    venta.setUsuario(
                            usuarios.get(
                                    random.nextInt(usuarios.size())
                            )
                    );

                    venta.setEstado(true);

                    ventas.add(venta);
                }

                ventaRepository.saveAll(ventas);

                System.out.println("1000 VENTAS INSERTADAS");
            }

            // =========================================
            // DETALLE VENTAS
            // =========================================

            if(detalleVentaRepository.count() == 0) {

                List<Venta> ventas =
                        ventaRepository.findAll();

                List<Producto> productos =
                        productoRepository.findAll();

                List<DetalleVenta> detalles =
                        new ArrayList<>();

                for(int i = 1; i <= 1000; i++) {

                    DetalleVenta detalle =
                            new DetalleVenta();

                    Producto producto =
                            productos.get(
                                    random.nextInt(productos.size())
                            );

                    int cantidad =
                            random.nextInt(10) + 1;

                    detalle.setVenta(
                            ventas.get(
                                    random.nextInt(ventas.size())
                            )
                    );

                    detalle.setProducto(producto);

                    detalle.setCantidad(cantidad);

                    detalle.setSubtotal(
                            producto.getPrecio() * cantidad
                    );

                    detalles.add(detalle);
                }

                detalleVentaRepository.saveAll(detalles);

                System.out.println("1000 DETALLES INSERTADOS");
            }

            System.out.println("DATOS GENERADOS CORRECTAMENTE");
        };
    }
}