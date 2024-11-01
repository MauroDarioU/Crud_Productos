package com.universidad.crud.service;

import com.universidad.crud.model.Producto;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

// Devuelve lista de todos los productos y  Busca un producto por su ID.
public interface ProductoService {
    List<Producto> obtenerProductos();
    Optional<Producto> obtenerPorId(Long id);
}
