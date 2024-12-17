package com.monsalve.inmoviliaria.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pedidos")
public class PedidosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pedido_idllave_pk", nullable = false)
    private UUID id;

    @Column(name = "pedido_nombres", nullable = false)
    private String nombres_pedido;

    @Column(name = "pedido_email", nullable = false)
    private String email_pedido;

    @Column(name = "pedido_empresa", nullable = false)
    private String empresa_pedido;

    @Column(name = "pedido_telefono", nullable = false)
    private String telefono_pedido;

    @Column(name = "pedido_mensaje", nullable = false)
    private String mensaje_pedido;
    @Column(name = "pedido_fecha_registro", nullable = false)
    private Date fecha_registro_pedido;
}
