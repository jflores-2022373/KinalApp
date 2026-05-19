package com.jeshuaflores.kinalapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // =========================
    // USUARIOS EN MEMORIA
    // =========================
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {

        UserDetails admin = User
                .withDefaultPasswordEncoder()
                .username("admin")
                .password("1234")
                .roles("ADMIN")
                .build();

        UserDetails user = User
                .withDefaultPasswordEncoder()
                .username("user")
                .password("1234")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(
                admin,
                user
        );
    }

    // =========================
    // CONFIGURACIÓN DE SEGURIDAD
    // =========================
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)
            throws Exception {

        http

                // =========================
                // AUTORIZACIONES
                // =========================
                .authorizeHttpRequests(auth -> auth

                        // ARCHIVOS ESTÁTICOS
                        .requestMatchers(
                                "/css/**",
                                "/js/**",
                                "/img/**"
                        ).permitAll()

                        // LOGIN
                        .requestMatchers(
                                "/login"
                        ).permitAll()

                        // DASHBOARD
                        .requestMatchers(
                                "/"
                        ).hasAnyRole("ADMIN", "USER")

                        // =========================
                        // SOLO ADMIN
                        // =========================
                        .requestMatchers(

                                // USUARIOS
                                "/usuarios/**",

                                // VENTAS
                                "/ventas/**",

                                // DETALLE VENTAS
                                "/detalleventas/**",

                                // EDITAR Y ELIMINAR CLIENTES
                                "/clientes/editar/**",
                                "/clientes/eliminar/**",

                                // EDITAR Y ELIMINAR PRODUCTOS
                                "/productos/editar/**",
                                "/productos/eliminar/**"

                        ).hasRole("ADMIN")

                        // =========================
                        // ADMIN Y USER
                        // =========================
                        .requestMatchers(

                                // CLIENTES
                                "/clientes",
                                "/clientes/nuevo",
                                "/clientes/guardar",

                                // PRODUCTOS
                                "/productos",
                                "/productos/nuevo",
                                "/productos/guardar"

                        ).hasAnyRole("ADMIN", "USER")

                        // =========================
                        // CUALQUIER OTRA RUTA
                        // =========================
                        .anyRequest()
                        .authenticated()
                )

                // =========================
                // LOGIN
                // =========================
                .formLogin(form -> form

                        .loginPage("/login")

                        .defaultSuccessUrl("/", true)

                        .failureUrl("/login?error")

                        .permitAll()
                )

                // =========================
                // LOGOUT
                // =========================
                .logout(logout -> logout

                        .logoutSuccessUrl("/login?logout")

                        .permitAll()
                )

                // =========================
                // ACCESO DENEGADO
                // =========================
                .exceptionHandling(exception -> exception

                        .accessDeniedPage("/acceso-denegado")
                );

        return http.build();
    }
}