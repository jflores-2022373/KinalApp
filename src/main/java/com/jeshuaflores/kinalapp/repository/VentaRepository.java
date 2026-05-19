package com.jeshuaflores.kinalapp.repository;

import com.jeshuaflores.kinalapp.entity.Venta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaRepository
        extends JpaRepository<Venta, Long> {

}