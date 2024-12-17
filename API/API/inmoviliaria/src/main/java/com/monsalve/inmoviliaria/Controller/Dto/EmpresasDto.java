package com.monsalve.inmoviliaria.Controller.Dto;

import lombok.Data;

import java.util.UUID;

@Data
public class EmpresasDto {
    private UUID id;
    private String nombre_emp;
    private String departamento_emp;
    private String provincia_emp;
    private String direccion_emp;
    private String sitioWeb_emp;
    private String telefono_emp;
    private String email_emp;
    private String tipoDocumento_emp;
    private Integer numeroDocumento_emp;
    private String descripcion_emp;
    private String logo_emp;


}
