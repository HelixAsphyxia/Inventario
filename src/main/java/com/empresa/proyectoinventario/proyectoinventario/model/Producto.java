package com.empresa.proyectoinventario.proyectoinventario.model;

import jakarta.persistence.*;

/**
 * Representa un producto en el inventario del sistema.
 *
 * Un producto tiene un identificador único, un nombre, una cantidad disponible en el inventario,
 * y un estatus que indica su disponibilidad o estado en el sistema.
 */
@Entity
@Table(name = "productos")  // La clase está mapeada a la tabla "productos" en la base de datos
public class Producto {

    // Atributo que representa el identificador único de un producto
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // La clave primaria es autogenerada con valor incremental
    private Long id_producto;

    // Nombre del producto
    private String nombre_producto;

    // Cantidad de unidades disponibles del producto en el inventario
    private int cantidad;

    // Estatus del producto, indica si está activo, inactivo o cualquier otro estado
    private String estatus;

    // Getters y Setters para acceder y modificar los valores de los atributos

    public Long getId_producto() {
        return id_producto;
    }

    public void setId_producto(Long id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
}
