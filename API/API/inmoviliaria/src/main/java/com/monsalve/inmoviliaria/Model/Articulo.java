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
@Table(name = "articulo")
public class Articulo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "articulo_idllave_pk", nullable = false)
    private long id;
    @Column(name = "art_nombre", nullable = false)
    private String nombre;
    @Column(name = "art_descripcion", nullable = false)
    private String descripcion;
    @Column(name = "art_precio", nullable = false)
    private Integer precio;
    @Column(name = "art_imagen", nullable = false)
    private String imagen;
}
