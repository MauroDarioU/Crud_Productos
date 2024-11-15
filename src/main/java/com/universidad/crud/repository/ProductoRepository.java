package com.universidad.crud.repository;

import com.universidad.crud.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

// Interfaz que extiende JpaRepository para proveer operaciones CRUD predefinidas.
public interface ProductoRepository extends JpaRepository<Producto, Long > {

    // Todos los productos activos
    @Query("SELECT u FROM Producto u WHERE u.isActive = true")
    List<Producto> findAllActive();

    // Encontrar un producto por ID
    @Query("SELECT u FROM Producto u WHERE u.id = :id AND u.isActive = true")
    Optional<Producto> findActiveById(@Param("id") long id);

    // Encontrar un producto por nombre
    @Query("SELECT u FROM Producto u LEFT JOIN FETCH u.roles WHERE u.nombre = :nombre AND u.isActive = true")
    Optional<Producto> findActiveByNombre(@Param("nombre") String nombre);
}
