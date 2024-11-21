package com.universidad.crud.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

//  Indica que esta clase es una entidad JPA.
@Entity

// Genera getters, setters.
@Data

//  Nombre de la tabla en la base de datos.
@Table(name = "crud_producto")
@NoArgsConstructor
@Builder
@AllArgsConstructor

public class Producto {

    // id es la clave primaria (PK), se genera automaticamente
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Atributos de la tabla
    @Size(min = 1, message = "El nombre debe tener por lo menos 1 caracter")

    @Column(name = "nombre")
    private String nombre;


    @Column(name = "descripcion")
    private String descripcion;


    @Column(name = "precio")
    private BigDecimal precio;


    @Column(name = "stock")
    private int stock;

    // Fecha de creación
    @CreatedDate
    @Column(name = "created_at")
    private ZonedDateTime createdAt;

    // Fecha de última modificación (automática)
    @LastModifiedDate
    @Column(name = "updated_at")
    private ZonedDateTime updatedAt;

}
