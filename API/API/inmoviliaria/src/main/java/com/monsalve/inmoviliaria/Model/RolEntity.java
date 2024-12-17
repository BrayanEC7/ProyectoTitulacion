package com.monsalve.inmoviliaria.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rol")
public class RolEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rol_idllave_pk", nullable = false)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "cliente_idllave_fk", referencedColumnName = "cliente_idllave_pk")
    private ClientesEntity cliente;

    @Column(name = "rol_user", nullable = false)
    private String user;

    @Column(name = "rol_password", nullable = false)
    private String password;

    @Column(name = "rol_estado", nullable = false)
    private String estado_rol;

    @Column(name = "rol_nombre", nullable = false)
    private String nombre_rol;
}
