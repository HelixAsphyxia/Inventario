package com.empresa.proyectoinventario.proyectoinventario.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * Representa un movimiento de inventario en el sistema.
 *
 * Un movimiento se refiere a una acción realizada sobre un producto, como su ingreso o salida
 * del inventario. Un movimiento tiene un tipo (por ejemplo, entrada o salida), una cantidad
 * de producto y la fecha y hora en que ocurrió.
 */
@Entity
@Table(name = "Movimientos")  // Se especifica que esta clase está mapeada a la tabla "Movimientos" en la base de datos
public class Movimiento {

    // Atributo que representa el identificador único de un movimiento
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // La clave primaria es autogenerada con valor incremental
    @Column(name = "id_movimiento") // Nombre de la columna en la base de datos
    private Integer id_movimiento;

    // Relación de muchos a uno con la entidad Producto, un movimiento pertenece a un solo producto
    @ManyToOne
    @JoinColumn(name = "id_producto") // La columna "id_producto" en la tabla "Movimientos" se refiere a un producto
    private Producto producto;

    // Relación de muchos a uno con la entidad Usuario, un movimiento es realizado por un solo usuario
    @ManyToOne
    @JoinColumn(name = "id_usuario") // La columna "id_usuario" en la tabla "Movimientos" se refiere a un usuario
    private Usuario usuario;

    // Tipo de movimiento (por ejemplo, "entrada" o "salida")
    @Column(name = "tipo_movimiento")
    private String tipo_movimiento;

    // Cantidad de producto movida en este movimiento
    @Column(name = "cantidad")
    private Integer cantidad;

    // Fecha y hora en que el movimiento ocurrió
    @Column(name = "fecha_hora")
    private LocalDateTime fecha_hora;

    // Getters y Setters para acceder y modificar los valores de los atributos

    public Integer getId_movimiento() {
        return id_movimiento;
    }

    public void setId_movimiento(Integer id_movimiento) {
        this.id_movimiento = id_movimiento;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getTipo_movimiento() {
        return tipo_movimiento;
    }

    public void setTipo_movimiento(String tipo_movimiento) {
        this.tipo_movimiento = tipo_movimiento;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDateTime getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(LocalDateTime fecha_hora) {
        this.fecha_hora = fecha_hora;
    }
}
