package com.jeshuaflores.kinalapp.repository;

import com.jeshuaflores.kinalapp.entity.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
// Repositorio de consultas de seguridad y búsqueda de usuarios en la base de datos
public interface UsuarioRepository
        extends JpaRepository<Usuario, Long> {

    // =========================
    // BUSCAR USUARIO POR USERNAME
    // =========================

    // Consulta derivada (Query Method) para la validación de credenciales durante el login
    Optional<Usuario> findByUsername(String username);

}