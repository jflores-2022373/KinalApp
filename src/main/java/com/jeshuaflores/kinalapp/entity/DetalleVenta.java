package com.jeshuaflores.kinalapp.entity;

import jakarta.persistence.*;
import lombok.*;

// ===================================================================
// ENTIDAD DE DOMINIO: DETALLE VENTA (DESGLOSE DE ARTÍCULOS COMPRADOS)
// ===================================================================
@Entity
@Table(name = "detalle_venta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class DetalleVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer cantidad;

    @Column(nullable = false)
    private Double subtotal;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "venta_id", nullable = false)
    private Venta venta;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "producto_id", nullable = false)
    private Producto producto;
}