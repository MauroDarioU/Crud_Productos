// Contiene las clases controladoras que manejan las solicitudes HTTP.
package com.universidad.crud.controller;

import com.universidad.crud.validation.CodigoError;
import com.universidad.crud.exceptions.BadRequestException;
import com.universidad.crud.model.Producto;
import com.universidad.crud.exceptions.EntityNotFoundException;
import com.universidad.crud.service.ProductoService;

// Genera un constructor  (los campos final).
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.Entity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Manejar solicitudes relacionadas con productos.
@RestController
@Slf4j
@RequiredArgsConstructor
@Entity
@Tag(name = "Productos", description = "Operaciones relacionadas con la gestion de productos")

// URL para todos los endpoints de productos.
@RequestMapping("/api/productos")

public class ProductoController {

    // Inyecta el repositorio para acceder a la base de datos.
    private final ProductoService ProductoService;

    @Operation(summary = "Obtener todos los productos.", description = "Retorna una lista de todos los productos registrados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de productos obtenida correctamente.",
                    content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Producto.class))),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor.", content = @Content)
     })

    // Obtener todos los productos (GET /Productos)
    @GetMapping
    public List<Producto> obtenerProductos() {
        return ProductoService.obtenerProductos();
    }

    @Operation(summary = "Obtener un producto por su ID.", description = "Retorna un producto obtenido por su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto obtenido correctamente.",
                    content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = Producto.class))),
            @ApiResponse(responseCode = "404", description = "No se encontró el producto."),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor.", content = @Content)
    })

    // obtener un producto por su ID (GET /productos/{id})
    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProducto(@PathVariable Long id) {
      Producto producto = ProductoService.obtenerPorId(id).orElseThrow(() ->
      new EntityNotFoundException(
              CodigoError.PRODUCTO_NO_ENCONTRADO.getCodigo(),
              CodigoError.PRODUCTO_NO_ENCONTRADO.getDescripcion(id)));
      log.info("El producto con ID {} es:{}", id, producto);
      return ResponseEntity.ok(producto);
    }

    @Operation(summary = "Agrega un producto.", description = "Retorna el estado de la operacion.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Producto agregado correctamente.",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Producto.class))),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor.", content = @Content)
    })

    // Crear un nuevo producto
    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
        Producto nuevoProducto = ProductoService.crearProducto(producto).orElseThrow(() ->
        new EntityNotFoundException(
                CodigoError.PRODUCTO_NO_PUDO_SER_CREADO.getCodigo(),
                CodigoError.PRODUCTO_NO_PUDO_SER_ACTUALIZADO.getDescripcion()));
        log.info("El producto fue creado correctamente");
         return ResponseEntity.status(HttpStatus.CREATED).body(nuevoProducto);
    }

    @Operation(summary = "Modifica un producto.", description = "Retorna el estado de la operacion.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto modificado correctamente.",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Producto.class))),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor.", content = @Content)
    })

    // Actualizar producto
       @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Long id, @RequestBody Producto producto) {
        Producto productoActualizado = ProductoService.actualizarProducto(id, producto) .orElseThrow(() ->
        new EntityNotFoundException(
                CodigoError.PRODUCTO_NO_PUDO_SER_ACTUALIZADO.getCodigo(),
                CodigoError.PRODUCTO_NO_PUDO_SER_ACTUALIZADO.getDescripcion(id)));
        log.info("El producto se actualizo correctamente");
            return ResponseEntity.ok(productoActualizado);
    }

    @Operation(summary = "Elimina un producto.", description = "Retorna el estado de la operacion.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto eliminado correctamente.",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Producto.class))),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor.", content = @Content)
    })

    //eliminar un producto por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> eliminarProducto(@PathVariable Long id) {
        Producto productoEliminado = ProductoService.eliminarProducto(id) .orElseThrow(() ->
        new BadRequestException(
                CodigoError.PRODUCTO_NO_PUDO_SER_BORRADO.getCodigo(),
                CodigoError.PRODUCTO_NO_PUDO_SER_BORRADO.getDescripcion(id)));
        Map<String, String> respuesta = new HashMap<>();
        respuesta.put("mensaje",String.format("El producto con ID %d ha sido eliminado", productoEliminado.getId()));
        log.info("El producto con ID {} ha sido eliminado", id);
        return ResponseEntity.ok(respuesta);
    }

}
