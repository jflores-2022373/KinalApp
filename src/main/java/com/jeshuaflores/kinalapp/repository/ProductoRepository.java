package com.jeshuaflores.kinalapp.repository;

import com.jeshuaflores.kinalapp.entity.Producto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository
        extends JpaRepository<Producto, Long> {

}