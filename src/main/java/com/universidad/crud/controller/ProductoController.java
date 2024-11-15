// Contiene las clases controladoras que manejan las solicitudes HTTP.
package com.universidad.crud.controller;

import com.universidad.crud.model.Producto;
import com.universidad.crud.service.ProductoService;

// Genera un constructor  (los campos final).
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.universidad.crud.exceptions.EntityNotFoundExceptions;

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
    public ResponseEntity<Producto> obtenerproductos(@PathVariable Long id) {
      Producto producto = ProductoService.obtenerPorId(id).orElseThrow(() -> new RuntimeException("El producto no existe"));
        return ResponseEntity.ok(producto);
    }

    // Crear un nuevo producto
    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
        Producto nuevoProducto = ProductoService.crearProducto(producto).orElseThrow(() -> new EntityNotFoundExceptions("error al crear el producto"));
         return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProducto);
    }

    // Actualizar producto
       @PutMapping("/{id}")
    public ResponseEntity<Producto>   actualizarProducto(@PathVariable Long id, @RequestBody Producto producto) {
        Producto productoActualizado = ProductoService.actualizarProducto(id, producto) .orElseThrow(() -> new EntityNotFoundExceptions("Problemas al actualizar el producto"));
            return ResponseEntity.ok(productoActualizado);
    }

    //eliminar un producto por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        ProductoService.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }

}
