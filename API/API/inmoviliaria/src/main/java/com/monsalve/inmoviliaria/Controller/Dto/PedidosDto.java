package com.monsalve.inmoviliaria.Controller.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class PedidosDto {
    private UUID id;
    private String nombres_pedido;
    private String email_pedido;
    private String empresa_pedido;
    private String telefono_pedido;
    private String mensaje_pedido;
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "America/Lima")
    private Date fecha_registro_pedido=new Date();
}
