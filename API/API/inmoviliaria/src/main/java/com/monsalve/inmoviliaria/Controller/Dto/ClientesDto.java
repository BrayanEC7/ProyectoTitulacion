package com.monsalve.inmoviliaria.Controller.Dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.util.UUID;

@Data
public class ClientesDto {
    private UUID id=null;
    private String nombre_cli;
    private String apellidos_cli;
    private String nrodoc_cli;
    private String telefono_cli;
    private String correo_cli;
    private String descripcion_cli;
    private String nombre_rol;
    private String tipodoc_cli;
    private String departamento_cli;
    private String distrito_cli;
    private String direccion_cli;
    private String pais_cli;
}
