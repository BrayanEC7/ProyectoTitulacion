package com.monsalve.inmoviliaria.Controller.Dto;

import lombok.Data;

import java.util.UUID;
@Data
public class RolDto {
    private UUID id;
    private UUID clienteId;
    private String user;
    private String password;
    private String estado_rol;
    private String nombre_rol;
    private String nombre_cli;
}
