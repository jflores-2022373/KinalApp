package com.jeshuaflores.kinalapp.service;

import com.jeshuaflores.kinalapp.entity.Usuario;
import com.jeshuaflores.kinalapp.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort; // <--- Se agregó esta importación para ordenar
import org.springframework.stereotype.Service;

import java.util.List;

// ===================================================================
// CAPA DE NEGOCIO: ADMINISTRACIÓN Y CIFRADO DE USUARIOS DEL SISTEMA
// ===================================================================
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // =========================
    // LISTAR USUARIOS
    // =========================
    public List<Usuario> listar() {

        // Se modificó para ordenar por el campo 'id' de forma Descendente (DESC)
        return usuarioRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    // =========================
    // GUARDAR USUARIO
    // =========================
    public Usuario guardar(Usuario usuario) {

        return usuarioRepository.save(usuario);
    }

    // =========================
    // BUSCAR USUARIO POR ID
    // =========================
    public Usuario buscarPorId(Long id) {

        return usuarioRepository
                .findById(id)
                .orElse(null);
    }

    // =========================
    // ELIMINAR USUARIO
    // =========================
    public void eliminar(Long id) {

        Usuario usuario = buscarPorId(id);

        if (usuario != null) {

            usuarioRepository.delete(usuario);
        }
    }
}