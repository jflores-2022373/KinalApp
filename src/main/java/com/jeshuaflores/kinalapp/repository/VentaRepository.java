package com.jeshuaflores.kinalapp.repository;

import com.jeshuaflores.kinalapp.entity.Venta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// Manejador transaccional para el almacenamiento y reporte de cabeceras de venta
public interface VentaRepository
        extends JpaRepository<Venta, Long> {

}
