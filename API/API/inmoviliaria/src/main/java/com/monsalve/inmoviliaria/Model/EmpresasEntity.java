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
@Table(name = "empresas")
public class EmpresasEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "empresas_idllave_pk", nullable = false)
    private UUID id;
    @Column(name = "emp_nombre", nullable = false)
    private String nombre_emp;
    @Column(name = "emp_departamento", nullable = false)
    private String departamento_emp;
    @Column(name = "emp_provincia", nullable = false)
    private String provincia_emp;
    @Column(name = "emp_direccion", nullable = false)
    private String direccion_emp;
    @Column(name = "emp_sitioWeb", nullable = false)
    private String sitioWeb_emp;
    @Column(name = "emp_telefono", nullable = false)
    private String telefono_emp;
    @Column(name = "emp_email", nullable = false)
    private String email_emp;
    @Column(name = "emp_tipoDocumento", nullable = false)
    private String tipoDocumento_emp;
    @Column(name = "emp_numeroDocumento", nullable = false)
    private Integer numeroDocumento_emp;
    @Column(name = "emp_descripcion", nullable = false, columnDefinition = "TEXT")
    private String descripcion_emp;
    @Column(name = "emp_logo", nullable = false, columnDefinition = "TEXT")
    private String logo_emp;
}
