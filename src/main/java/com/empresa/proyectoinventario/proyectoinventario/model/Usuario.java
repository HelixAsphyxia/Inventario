package com.empresa.proyectoinventario.proyectoinventario.model;

import jakarta.persistence.*;

/**
 * Representa un usuario en el sistema, con su respectiva información de acceso
 * y el rol asociado que determina sus permisos y acciones dentro del sistema.
 */
@Entity
@Table(name = "Usuarios")  // La clase está mapeada a la tabla "Usuarios" en la base de datos
public class Usuario {

    // Atributo que representa el identificador único de un usuario
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // La clave primaria es autogenerada con valor incremental
    @Column(name = "id_usuario")  // Define el nombre de la columna en la base de datos
    private Integer id_usuario;

    // Nombre de usuario único para la autenticación en el sistema
    @Column(name = "nombre_usuario")  // Define el nombre de la columna en la base de datos
    private String nombre_usuario;

    // Contraseña del usuario, utilizada para la autenticación
    @Column(name = "contraseña")  // Define el nombre de la columna en la base de datos
    private String contraseña;

    // Relación con el rol del usuario. Un usuario tiene un único rol asociado.
    @ManyToOne(fetch = FetchType.EAGER)  // Define que la relación es de muchos a uno con la tabla "Roles"
    @JoinColumn(name = "id_rol")  // Define la columna que enlaza con la tabla "Roles"
    private Rol rol;

    // Getters y Setters para acceder y modificar los valores de los atributos

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    // Método para representar el usuario como una cadena de texto
    @Override
    public String toString() {
        return "Usuario{id_usuario=" + id_usuario + ", nombre_usuario='" + nombre_usuario + "', contraseña='" + contraseña + "', rol=" + rol + "}";
    }
}
