package com.universidad.crud.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private long id;

    // Atributos de la tabla
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "precio")
    private double precio;
    @Column(name = "stock")
    private String stock;
}
