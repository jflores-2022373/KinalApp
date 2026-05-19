package com.jeshuaflores.kinalapp.repository;

import com.jeshuaflores.kinalapp.entity.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository
        extends JpaRepository<Cliente, Long> {

}