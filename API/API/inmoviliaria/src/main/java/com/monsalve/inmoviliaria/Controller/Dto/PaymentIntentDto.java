package com.monsalve.inmoviliaria.Controller.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.Date;
import java.util.UUID;

@Data
public class PaymentIntentDto {
    private Long id;
    private String stripePaymentId;
    private String description;
    private Double amount;
    private String currency;
    private String status;
    @JsonFormat(pattern = "dd-MM-yyyy", timezone = "America/Lima")
    private Date createdAt;
    private UUID clienteId;
    private String nombre_cli;
    private String apellidos_cli;
    private String nrodoc_cli;
    private String correo_cli;
    private String tipodoc_cli;
}
