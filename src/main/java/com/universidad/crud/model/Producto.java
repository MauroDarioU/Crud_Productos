package com.universidad.crud.model;

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
    private String Nombre;
    @Column(name = "descripcion")
    private String Descripcion;
    @Column(name = "precio")
    private double Precio;
    @Column(name = "stock")
    private String Stock;
}
