package com.universidad.crud.service;

import com.universidad.crud.model.Producto;
import com.universidad.crud.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
}
