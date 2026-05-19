package com.jeshuaflores.kinalapp.service;

import com.jeshuaflores.kinalapp.entity.Venta;
import com.jeshuaflores.kinalapp.repository.VentaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort; // <--- Se agregó esta importación para ordenar
import org.springframework.stereotype.Service;

import java.util.List;

// ===================================================================
// CAPA DE NEGOCIO: ORQUESTADOR PRINCIPAL TRANSACCIONAL DE VENTAS
// ===================================================================
@Service
public class VentaService {
    // Bloque transaccional crítico: Procesamiento y almacenamiento de comprobantes de venta
    @Autowired
    private VentaRepository ventaRepository;

    // =========================
    // LISTAR VENTAS
    // =========================
    public List<Venta> listar() {

        // Se modificó para ordenar por el campo 'id' de forma Descendente (DESC)
        return ventaRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    // =========================
    // GUARDAR VENTA
    // =========================
    public Venta guardar(Venta venta) {

        return ventaRepository.save(venta);
    }

    // =========================
    // BUSCAR VENTA POR ID
    // =========================
    public Venta buscarPorId(Long id) {

        return ventaRepository
                .findById(id)
                .orElse(null);
    }

    // =========================
    // ELIMINAR VENTA
    // =========================
    public void eliminar(Long id) {

        Venta venta = buscarPorId(id);

        if (venta != null) {

            ventaRepository.delete(venta);
        }
    }
}