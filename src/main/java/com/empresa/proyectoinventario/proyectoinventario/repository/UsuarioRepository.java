package com.empresa.proyectoinventario.proyectoinventario.repository;

import com.empresa.proyectoinventario.proyectoinventario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    @Query("SELECT u FROM Usuario u WHERE u.nombre_usuario = :nombreUsuario")
    Usuario findByNombre_usuario(@Param("nombreUsuario") String nombreUsuario);
}