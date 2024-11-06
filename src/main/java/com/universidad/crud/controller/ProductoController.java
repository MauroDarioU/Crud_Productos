// Contiene las clases controladoras que manejan las solicitudes HTTP.
package com.universidad.crud.controller;

import com.universidad.crud.model.Producto;
import com.universidad.crud.service.ProductoService;

// Genera un constructor  (los campos final).
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Manejar solicitudes relacionadas con productos.
@RestController

@RequiredArgsConstructor

// URL para todos los endpoints de productos.
@RequestMapping("/api/productos")

public class ProductoController {

    // Inyecta el repositorio para acceder a la base de datos.
    private final ProductoService ProductoService;


    // Obtener todos los productos (GET /Productos)
    @GetMapping
    public List<Producto> obtenerProductos() {
        return ProductoService.obtenerProductos();
    }

    // obtener un producto por su ID (GET /productos/{id})
    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProductos(@PathVariable Long id) {
      Producto producto = ProductoService.obtenerPorId(id).orElseThrow(() -> new RuntimeException("El producto no existe"));
        return ResponseEntity.ok(producto);
    }

}
