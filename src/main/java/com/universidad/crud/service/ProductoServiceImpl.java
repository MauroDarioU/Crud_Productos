package com.universidad.crud.service;

import com.universidad.crud.model.Producto;
import com.universidad.crud.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.time.ZonedDateTime;


//  Marca como un componente de servicio de Spring.
@Service

@RequiredArgsConstructor

// Inyecta el repositorio para acceder a la base de datos.
public class ProductoServiceImpl implements ProductoService {
    private final ProductoRepository productoRepository;


    @Override
    public List<Producto> obtenerProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<Producto> obtenerPorId(Long id) {
        return productoRepository.findById(id);
    }
    @Override
    public Optional<Producto> crearProducto(Producto Producto) {
        Producto ProductoParaGuardar = new Producto();
        Producto.builder()
                .nombre(Producto.getnombre())
                .descripcion(Producto.getdescripcion())
                .precio(Producto.getprecio())
                .stock(Producto.getstock());
        return Optional.of(ProductoRepository.save(ProductoParaGuardar));
    }

    @Override
    public Optional<Producto> actualizarProducto(Long id, Producto producto) {
        Optional<Producto> productoViejo = productoRepository.findById(id);
        if (productoViejo.isPresent()) {
            Producto productoParaActualizar = productoViejo.get();
            productoParaActualizar.setnombre(producto.getnombre());
            productoParaActualizar.setdescripcion(producto.getdescripcion());
            productoParaActualizar.setprecio(producto.getprecio());
            productoParaActualizar.setstock(producto.getstock());
            productoParaActualizar.setUpdatedAt(ZonedDateTime.now());
            return Optional.of(productoRepository.save(productoParaActualizar));
        } else {
            // Devuelve vacío al no encontrar el producto
            return Optional.empty();
        }
    }
    // Eliminar un producto
    @Override
    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }
}