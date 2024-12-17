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
@Table(name = "tb_propiedades")
public class PropiedadesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "propiedad_idllave_pk", nullable = false)
    private UUID id;
    @Column(name = "prop_codigo", nullable = false, unique = true)
    private int codigo_prop;
    @Column(name = "prop_titulo", nullable = false)
    private String titulo_prop;

    @Column(name = "prop_foto_principal", nullable = false, columnDefinition = "TEXT")
    private String foto_principal_prop;

    @Column(name = "prop_foto_secundaria", nullable = false, columnDefinition = "TEXT")
    private String foto_secundaria_prop;

    @Column(name = "prop_categoria", nullable = false)
    private String categoria_prop;

    @Column(name = "prop_estado_venta", nullable = false)
    private String estado_venta_prop;
    @Column(name = "prop_descripcion", nullable = false)
    private String descripcion_prop;

    @Column(name = "prop_provincia", nullable = false)
    private String provincia_prop;

    @Column(name = "prop_fecha_publicacion", nullable = false)
    private Date fecha_publicacion_prop;

    @Column(name = "prop_activar",nullable=false)
    private String activar_prop;
    @Column(name = "prop_coordenadas", nullable = false)
    private String coordenadas_prop;

    @Column(name = "prop_area_total", nullable = false)
    private String area_total_prop;

    @Column(name = "prop_manzana", nullable = false)
    private String manzana_prop;

    @Column(name = "prop_lote", nullable = false)
    private String lote_prop;

    @Column(name = "prop_precio", nullable = false)
    private Double precio_prop;

    @ManyToOne
    @JoinColumn(name = "cliente_idllave_fk", referencedColumnName = "cliente_idllave_pk")
    private ClientesEntity cliente;
}
