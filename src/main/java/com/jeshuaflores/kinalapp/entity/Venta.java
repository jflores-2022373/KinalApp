package com.jeshuaflores.kinalapp.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

// ===================================================================
// ENTIDAD DE DOMINIO: VENTA (TRANSACCIONES Y CABECERA DE FACTURACIÓN)
// ===================================================================
@Entity
@Table(name = "ventas")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate fechaVenta = LocalDate.now();

    @Column(nullable = false)
    private Double total;
    // Relación estructural Many-To-One: Asociación de la transacción con el cliente emisor
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(nullable = false)
    private Boolean estado = true;
}