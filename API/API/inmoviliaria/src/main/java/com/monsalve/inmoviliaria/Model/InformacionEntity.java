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
@Table(name = "informacion")
public class InformacionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;
    @Column(name = "titulo_info", nullable = false)
    private String titulo;
    @Column(name = "subtitulo_info", nullable = false,columnDefinition = "TEXT")
    private String subtitulo;
    @Column(name = "descripcion_info", nullable = false, columnDefinition = "TEXT")
    private String descripcion;
    @Column(name = "categoria_info", nullable = false)
    private String categoria;
    @Column(name = "correlativo_info", nullable = false)
    private String correlativo;
    @Column(name = "posicion_info", nullable = false)
    private Integer posicion;
}
