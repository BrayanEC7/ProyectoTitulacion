package com.monsalve.inmoviliaria.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pagos")
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "pago_idllave_pk", nullable = false)
    private Long id;

    @Column(name = "stripe_payment_id", nullable = false)
    private String stripePaymentId;

    @Column(name = "descripcion", nullable = false)
    private String description;

    @Column(name = "monto", nullable = false)
    private Double amount;

    @Column(name = "moneda", nullable = false)
    private String currency;

    @Column(name = "estado", nullable = false)
    private String status;

    @Column(name = "fecha_creacion", nullable = false)
    private Date createdAt;

    @OneToOne
    @JoinColumn(name = "cliente_idllave_fk", referencedColumnName = "cliente_idllave_pk")
    private ClientesEntity cliente;
}
