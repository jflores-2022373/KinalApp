package com.jeshuaflores.kinalapp.repository;

import com.jeshuaflores.kinalapp.entity.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// Componente de acceso a datos (DAO) para operaciones de persistencia del Cliente
public interface ClienteRepository
        extends JpaRepository<Cliente, Long> {

}