package com.monsalve.inmoviliaria.Controller.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class PropiedadesDto {
    private UUID id=null;
    private String titulo_prop;
    private int codigo_prop;
    private String foto_principal_prop;
    private String foto_secundaria_prop;
    private String categoria_prop;
    private String estado_venta_prop;
    private String descripcion_prop;
    private String provincia_prop;
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "America/Lima")
    private Date fecha_publicacion_prop=new Date();
    private String activar_prop;
    private String coordenadas_prop;
    private String area_total_prop;
    private String manzana_prop;
    private String lote_prop;
    private Double precio_prop;
    private UUID clienteId;
    private String nombre_cli;
    private String correo_cli;
    private String telefono_cli;
    private String nrodoc_cli;
    private String tipodoc_cli;

}
