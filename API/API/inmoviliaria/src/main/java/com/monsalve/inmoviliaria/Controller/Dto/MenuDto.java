package com.monsalve.inmoviliaria.Controller.Dto;

import lombok.Data;

import java.util.UUID;

@Data
public class MenuDto {
    private UUID menu_idllave_pk;
    private String nombre;
    private String url;
    private String icono;
    private String orden;
    private String nombrePadre=null;
    private UUID codigoPadre;
}
