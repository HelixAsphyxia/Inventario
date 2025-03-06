package com.empresa.proyectoinventario.proyectoinventario.repository;

import com.empresa.proyectoinventario.proyectoinventario.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
}