package com.monsalve.inmoviliaria.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_menu")
public class MenuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "menu_idllave_pk", nullable = false)
    private UUID menu_idllave_pk;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "url", nullable = false)
    private String url;

    @Column(name = "icono", nullable = false)
    private String icono;

    @Column(name = "orden", nullable = false)
    private String orden;

    @Column(name = "codigoPadre", nullable = true)
    private UUID codigoPadre=null;
}
