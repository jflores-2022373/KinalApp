package com.jeshuaflores.kinalapp.repository;

import com.jeshuaflores.kinalapp.entity.DetalleVenta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// Capa de persistencia dedicada al almacenamiento masivo de los desgloses de facturas
public interface DetalleVentaRepository
        extends JpaRepository<DetalleVenta, Long> {

}