package com.empresa.proyectoinventario.proyectoinventario.service;

import com.empresa.proyectoinventario.proyectoinventario.model.Movimiento;
import com.empresa.proyectoinventario.proyectoinventario.model.Producto;
import com.empresa.proyectoinventario.proyectoinventario.model.Usuario;
import com.empresa.proyectoinventario.proyectoinventario.repository.MovimientoRepository;
import com.empresa.proyectoinventario.proyectoinventario.repository.ProductoRepository;
import com.empresa.proyectoinventario.proyectoinventario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service  // Marca la clase como un servicio gestionado por Spring
public class MovimientoService {

    @Autowired
    private MovimientoRepository movimientoRepository;  // Repositorio para acceder a la tabla "Movimientos"

    @Autowired
    private ProductoRepository productoRepository;  // Repositorio para acceder a la tabla "Productos"

    @Autowired
    private UsuarioRepository usuarioRepository;  // Repositorio para acceder a la tabla "Usuarios"

    /**
     * Registra una entrada de productos al inventario.
     * @param idProducto El ID del producto a ingresar.
     * @param idUsuario El ID del usuario que realiza la acción.
     * @param cantidad La cantidad de productos a ingresar.
     * @return El movimiento registrado.
     */
    public Movimiento registrarEntrada(Integer idProducto, Integer idUsuario, Integer cantidad) {
        // Validación para asegurarse de que la cantidad es positiva
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a 0");
        }
        // Buscar el producto y el usuario en las bases de datos
        Producto producto = productoRepository.findById(idProducto)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        // Actualizar la cantidad del producto en el inventario
        producto.setCantidad(producto.getCantidad() + cantidad);
        productoRepository.save(producto);  // Guardar los cambios del producto

        // Crear el movimiento de tipo "Entrada"
        Movimiento movimiento = new Movimiento();
        movimiento.setProducto(producto);
        movimiento.setUsuario(usuario);
        movimiento.setTipo_movimiento("Entrada");
        movimiento.setCantidad(cantidad);
        movimiento.setFecha_hora(LocalDateTime.now());  // Registrar la fecha y hora actuales

        // Guardar el movimiento en la base de datos y devolver el objeto movimiento
        return movimientoRepository.save(movimiento);
    }

    /**
     * Registra una salida de productos del inventario.
     * @param idProducto El ID del producto a retirar.
     * @param idUsuario El ID del usuario que realiza la acción.
     * @param cantidad La cantidad de productos a retirar.
     * @return El movimiento registrado.
     */
    public Movimiento registrarSalida(Integer idProducto, Integer idUsuario, Integer cantidad) {
        // Validación para asegurarse de que la cantidad es positiva
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a 0");
        }
        // Buscar el producto en la base de datos
        Producto producto = productoRepository.findById(idProducto)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));

        // Validación para asegurarse de que el producto está activo
        if (!"Activo".equals(producto.getEstatus())) {
            throw new IllegalArgumentException("El producto está inactivo");
        }

        // Validación para asegurarse de que hay suficiente inventario
        if (producto.getCantidad() < cantidad) {
            throw new IllegalArgumentException("No hay suficiente inventario");
        }

        // Buscar el usuario en la base de datos
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

        // Actualizar la cantidad del producto en el inventario
        producto.setCantidad(producto.getCantidad() - cantidad);
        productoRepository.save(producto);  // Guardar los cambios del producto

        // Crear el movimiento de tipo "Salida"
        Movimiento movimiento = new Movimiento();
        movimiento.setProducto(producto);
        movimiento.setUsuario(usuario);
        movimiento.setTipo_movimiento("Salida");
        movimiento.setCantidad(cantidad);
        movimiento.setFecha_hora(LocalDateTime.now());  // Registrar la fecha y hora actuales

        // Guardar el movimiento en la base de datos y devolver el objeto movimiento
        return movimientoRepository.save(movimiento);
    }

    /**
     * Obtiene todos los movimientos registrados en el sistema.
     * @return Una lista con todos los movimientos.
     */
    public List<Movimiento> listarMovimientos() {
        return movimientoRepository.findAll();  // Devuelve todos los movimientos de la base de datos
    }

    /**
     * Filtra los movimientos según el tipo especificado (Entrada o Salida).
     * @param tipo El tipo de movimiento a filtrar (Entrada o Salida).
     * @return Una lista de movimientos filtrados por tipo.
     */
    public List<Movimiento> filtrarMovimientos(String tipo) {
        return movimientoRepository.findAll().stream()
                .filter(m -> m.getTipo_movimiento().equalsIgnoreCase(tipo))  // Filtra por tipo de movimiento
                .toList();  // Devuelve una lista con los movimientos filtrados
    }
}
