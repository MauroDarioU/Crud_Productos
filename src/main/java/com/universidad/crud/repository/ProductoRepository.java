package com.universidad.crud.repository;

import com.universidad.crud.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// Interfaz que extiende JpaRepository para proveer operaciones CRUD predefinidas.
public interface ProductoRepository extends JpaRepository<Producto, Long > {
}
