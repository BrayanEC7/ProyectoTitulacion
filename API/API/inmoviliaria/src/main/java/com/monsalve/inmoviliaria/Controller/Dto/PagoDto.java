package com.monsalve.inmoviliaria.Controller.Dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class PagoDto {
    private long id;

    private String nombre;

    private String descripcion;

    private Integer precio;

    private String imagen;
}
