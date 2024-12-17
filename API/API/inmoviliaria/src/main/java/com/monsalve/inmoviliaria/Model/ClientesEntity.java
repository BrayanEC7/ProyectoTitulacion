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
@Table(name = "cliente")
public class ClientesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cliente_idllave_pk", nullable = false)
    private UUID id;

    @Column(name = "cli_nombre", nullable = false)
    private String nombre_cli;

    @Column(name = "cli_apellidos", nullable = false)
    private String apellidos_cli;

    @Column(name = "cli_departamento", nullable = true)
    private String departamento_cli;

    @Column(name = "cli_distrito", nullable = true)
    private String distrito_cli;

    @Column(name = "cli_direccion", nullable = true)
    private String direccion_cli;

    @Column(name = "cli_tipodoc", nullable = true)
    private String tipodoc_cli;

    @Column(name = "cli_nrodoc", nullable = false)
    private String nrodoc_cli;

    @Column(name = "cli_telefono", nullable = false)
    private String telefono_cli;

    @Column(name = "cli_correo", nullable = false)
    private String correo_cli;

    @Column(name = "cli_pais", nullable = true)
    private String pais_cli;

    @Column(name = "cli_descripcion", nullable = false)
    private String descripcion_cli;


}
