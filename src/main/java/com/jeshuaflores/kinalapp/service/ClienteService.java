package com.jeshuaflores.kinalapp.service;

import com.jeshuaflores.kinalapp.entity.Cliente;
import com.jeshuaflores.kinalapp.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort; // <--- Se agregó esta importación para ordenar
import org.springframework.stereotype.Service;

import java.util.List;

// ===================================================================
// CAPA DE NEGOCIO: GESTIÓN ESPECÍFICA DE OPERACIONES DE CLIENTES
// ===================================================================
@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    // =========================
    // LISTAR CLIENTES
    // =========================
    public List<Cliente> listar() {

        // Se modificó para ordenar por el campo 'id' de forma Descendente (DESC)
        return clienteRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    // =========================
    // GUARDAR CLIENTE
    // =========================
    public Cliente guardar(Cliente cliente) {

        return clienteRepository.save(cliente);
    }

    // =========================
    // BUSCAR CLIENTE POR ID
    // =========================
    public Cliente buscarPorId(Long id) {

        return clienteRepository
                .findById(id)
                .orElse(null);
    }

    // =========================
    // ELIMINAR CLIENTE
    // =========================
    public void eliminar(Long id) {

        Cliente cliente = buscarPorId(id);

        if (cliente != null) {

            clienteRepository.delete(cliente);
        }
    }
}