package com.jeshuaflores.kinalapp.service;

import com.jeshuaflores.kinalapp.entity.DetalleVenta;
import com.jeshuaflores.kinalapp.repository.DetalleVentaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort; // <--- Se agregó esta importación para ordenar
import org.springframework.stereotype.Service;

import java.util.List;

// ===================================================================
// CAPA DE NEGOCIO: ADMINISTRACIÓN DE ÍTEMS INTERNOS DE FACTURACIÓN
// ===================================================================
@Service
public class DetalleVentaService {

    @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    // =========================
    // LISTAR DETALLES
    // =========================
    public List<DetalleVenta> listar() {

        // Se modificó para ordenar por el campo 'id' de forma Descendente (DESC)
        return detalleVentaRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    // =========================
    // GUARDAR DETALLE
    // =========================
    public DetalleVenta guardar(DetalleVenta detalleVenta) {

        return detalleVentaRepository.save(detalleVenta);
    }

    // =========================
    // BUSCAR DETALLE POR ID
    // =========================
    public DetalleVenta buscarPorId(Long id) {

        return detalleVentaRepository
                .findById(id)
                .orElse(null);
    }

    // =========================
    // ELIMINAR DETALLE
    // =========================
    public void eliminar(Long id) {

        DetalleVenta detalleVenta = buscarPorId(id);

        if (detalleVenta != null) {

            detalleVentaRepository.delete(detalleVenta);
        }
    }
}