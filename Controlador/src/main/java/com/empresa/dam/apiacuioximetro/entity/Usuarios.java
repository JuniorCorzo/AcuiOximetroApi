package com.empresa.dam.apiacuioximetro.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Table("usuarios")
public record Usuarios(
        // Identificador único del usuario.
        @Id @Column("id_usuario") @NotNull int idUsuario,

        // Rol del usuario en el sistema.

        @Column("rol") @NotNull @NotEmpty String rol,

        // Nombre del usuario.

        @Column("nombre") @NotNull @NotEmpty String nombre,

        // Apellido del usuario.
        @Column("apellido") @NotNull @NotEmpty String apellido,

        // Correo electrónico del usuario.

        @Column("correo") @NotNull @NotEmpty @Email String correo,

        // Clave de acceso del usuario.

        @Column("clave") @NotNull @NotEmpty String clave,
        @Column("token") String token) {
}