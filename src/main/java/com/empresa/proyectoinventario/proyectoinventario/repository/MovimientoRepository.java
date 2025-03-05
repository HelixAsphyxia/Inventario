package com.empresa.proyectoinventario.proyectoinventario.repository;

import com.empresa.proyectoinventario.proyectoinventario.model.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimientoRepository extends JpaRepository<Movimiento, Integer> {
}