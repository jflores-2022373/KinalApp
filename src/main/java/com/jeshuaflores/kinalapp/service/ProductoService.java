package com.jeshuaflores.kinalapp.service;

import com.jeshuaflores.kinalapp.entity.Producto;
import com.jeshuaflores.kinalapp.repository.ProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort; // <--- Se agregó esta importación para ordenar
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    // =========================
    // LISTAR PRODUCTOS
    // =========================
    public List<Producto> listar() {

        // Se modificó para ordenar por 'id' de forma Descendente (DESC)
        return productoRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    // =========================
    // GUARDAR PRODUCTO
    // =========================
    public Producto guardar(Producto producto) {

        return productoRepository.save(producto);
    }

    // =========================
    // BUSCAR PRODUCTO POR ID
    // =========================
    public Producto buscarPorId(Long id) {

        return productoRepository
                .findById(id)
                .orElse(null);
    }

    // =========================
    // ELIMINAR PRODUCTO
    // =========================
    public void eliminar(Long id) {

        Producto producto = buscarPorId(id);

        if (producto != null) {

            productoRepository.delete(producto);
        }
    }
}