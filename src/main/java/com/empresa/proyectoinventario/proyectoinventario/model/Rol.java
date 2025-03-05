package com.empresa.proyectoinventario.proyectoinventario.model;

import jakarta.persistence.*;

/**
 * Representa un rol en el sistema, asociado a los usuarios.
 *
 * Un rol tiene un identificador único y un nombre que describe el tipo de permisos
 * o acciones que los usuarios con este rol pueden realizar en el sistema.
 */
@Entity
@Table(name = "Roles")  // La clase está mapeada a la tabla "Roles" en la base de datos
public class Rol {

    // Atributo que representa el identificador único de un rol
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // La clave primaria es autogenerada con valor incremental
    @Column(name = "id_rol")  // Define el nombre de la columna en la base de datos
    private Integer id_rol;

    // Nombre del rol que describe el tipo de permisos que tiene el usuario
    @Column(name = "nombre_rol")  // Define el nombre de la columna en la base de datos
    private String nombre_rol;

    // Getters y Setters para acceder y modificar los valores de los atributos

    public Integer getId_rol() {
        return id_rol;
    }

    public void setId_rol(Integer id_rol) {
        this.id_rol = id_rol;
    }

    public String getNombre_rol() {
        return nombre_rol;
    }

    public void setNombre_rol(String nombre_rol) {
        this.nombre_rol = nombre_rol;
    }

    // Método para representar el rol como una cadena de texto
    @Override
    public String toString() {
        return "Rol{id_rol=" + id_rol + ", nombre_rol='" + nombre_rol + "'}";
    }
}
