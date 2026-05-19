package com.jeshuaflores.kinalapp.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

// ENTIDAD DE DOMINIO: CLIENTE (MAPEADO DE DATOS MAESTROS)
@Entity
@Table(name = "clientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Column(nullable = false, length = 100)
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    @Column(nullable = false, length = 100)
    private String apellido;

    @Email(message = "Correo inválido")
    @Column(unique = true, length = 150)
    private String correo;

    @NotBlank(message = "El teléfono es obligatorio")
    @Column(nullable = false, length = 20)
    private String telefono;

    @Column(length = 250)
    private String direccion;

    @Column(length = 20)
    private String nit;

    @Column(nullable = false)
    private Boolean estado = true;
}