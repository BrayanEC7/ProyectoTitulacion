package com.monsalve.inmoviliaria.Controller.Dto;

import lombok.Data;

import java.util.UUID;

@Data
public class InformacionDto {
    private UUID id;
    private String titulo;
    private String subtitulo;
    private String descripcion;
    private String categoria;
    private String correlativo;
    private Integer posicion;
}
