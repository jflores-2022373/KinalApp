package com.jeshuaflores.kinalapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;

// ===================================================================
// ENTIDAD DE DOMINIO: PRODUCTO (CONTROL DE INVENTARIO Y CATÁLOGO)
// ===================================================================
@Entity
@Table(name = "productos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Column(nullable = false, length = 150)
    private String nombre;

    @NotBlank(message = "La descripción es obligatoria")
    @Column(nullable = false, length = 300)
    private String descripcion;

    @Min(value = 1, message = "El precio debe ser mayor a 0")
    @Column(nullable = false)
    private Double precio;

    @Min(value = 0, message = "El stock no puede ser negativo")
    @Column(nullable = false)
    private Integer stock;

    @Column(length = 100)
    private String categoria;

    @Column(nullable = false)
    private Boolean estado = true;

    @Column(nullable = false)
    private LocalDate fechaIngreso = LocalDate.now();
}