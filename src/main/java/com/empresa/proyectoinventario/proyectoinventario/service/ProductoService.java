package com.empresa.proyectoinventario.proyectoinventario.service;

import com.empresa.proyectoinventario.proyectoinventario.model.Producto;
import com.empresa.proyectoinventario.proyectoinventario.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service  // Marca la clase como un servicio gestionado por Spring
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;  // Repositorio para interactuar con la tabla "Productos"

    /**
     * Lista todos los productos disponibles en el sistema.
     * @return Una lista con todos los productos.
     */
    public List<Producto> listarTodos() {
        return productoRepository.findAll();  // Devuelve todos los productos de la base de datos
    }

    /**
     * Lista solo los productos activos.
     * @return Una lista con los productos cuyo estatus es "Activo".
     */
    public List<Producto> listarActivos() {
        return productoRepository.findAll().stream()
                .filter(p -> "Activo".equals(p.getEstatus()))  // Filtra por productos activos
                .toList();  // Devuelve una lista con los productos filtrados
    }

    /**
     * Agrega un nuevo producto al inventario.
     * @param nombre El nombre del producto a agregar.
     * @return El producto creado y guardado en la base de datos.
     */
    public Producto agregarProducto(String nombre) {
        Producto producto = new Producto();
        producto.setNombre_producto(nombre);  // Establece el nombre del producto
        producto.setCantidad(0);  // Inicializa la cantidad en 0
        producto.setEstatus("Activo");  // Establece el estado como "Activo"
        return productoRepository.save(producto);  // Guarda el producto en la base de datos
    }

    /**
     * Aumenta la cantidad de un producto existente en el inventario.
     * @param id El ID del producto a aumentar.
     * @param cantidad La cantidad a agregar.
     * @return El producto actualizado.
     */
    public Producto aumentarInventario(Integer id, Integer cantidad) {
        // Verificación para asegurarse de que la cantidad es positiva
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor a 0");
        }
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));
        // Aumenta la cantidad del producto
        producto.setCantidad(producto.getCantidad() + cantidad);
        return productoRepository.save(producto);  // Guarda el producto actualizado en la base de datos
    }

    /**
     * Da de baja un producto, cambiando su estatus a "Inactivo".
     * @param id El ID del producto a dar de baja.
     * @return El producto con el estado actualizado a "Inactivo".
     */
    public Producto darBaja(Integer id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));
        producto.setEstatus("Inactivo");  // Cambia el estado del producto a "Inactivo"
        return productoRepository.save(producto);  // Guarda el producto actualizado en la base de datos
    }

    /**
     * Reactiva un producto, cambiando su estatus a "Activo".
     * @param id El ID del producto a reactivar.
     * @return El producto con el estado actualizado a "Activo".
     */
    public Producto reactivar(Integer id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));
        producto.setEstatus("Activo");  // Cambia el estado del producto a "Activo"
        return productoRepository.save(producto);  // Guarda el producto actualizado en la base de datos
    }
}
