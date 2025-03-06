-- Crear la base de datos (opcional, ajusta el nombre según tu sistema)
CREATE DATABASE tienda_ejemplo;
USE tienda_ejemplo;

-- Crear la tabla productos
CREATE TABLE productos (
    idProducto INT PRIMARY KEY,
    nombre VARCHAR(40),
    precio DECIMAL(16,2)
);

-- Insertar datos en la tabla productos
INSERT INTO productos (idProducto, nombre, precio) VALUES
(1, 'LAPTOP', 3000.00),
(2, 'PC', 4000.00),
(3, 'MOUSE', 100.00),
(4, 'TECLADO', 150.00),
(5, 'MONITOR', 2000.00),
(6, 'MICROFONO', 350.00),
(7, 'AUDIFONOS', 450.00);

-- Crear la tabla ventas
CREATE TABLE ventas (
    idVenta INT PRIMARY KEY,
    idProducto INT,
    cantidad INT,
    FOREIGN KEY (idProducto) REFERENCES productos(idProducto)
);

-- Insertar datos en la tabla ventas
INSERT INTO ventas (idVenta, idProducto, cantidad) VALUES
(1, 1, 5),
(2, 1, 15),
(3, 2, 1),
(4, 3, 6),
(5, 4, 2),
(6, 5, 1),
(7, 6, 4),
(8, 7, 5),
(9, 6, 2),
(10, 1, 8);

-- Consultas para demostrar los resultados

-- 1.5) Traer todos los productos que tengan una venta
SELECT DISTINCT p.*
FROM productos p
INNER JOIN ventas v ON p.idProducto = v.idProducto;

-- 1.6) Traer todos los productos que tengan ventas y la cantidad total de productos vendidos
SELECT 
    p.idProducto,
    p.nombre,
    p.precio,
    SUM(v.cantidad) AS total_vendido
FROM productos p
LEFT JOIN ventas v ON p.idProducto = v.idProducto
GROUP BY p.idProducto, p.nombre, p.precio;

-- 1.7) Traer todos los productos (independientemente de si tienen ventas o no) y la suma total ($) vendida por producto
SELECT 
    p.idProducto,
    p.nombre,
    p.precio,
    COALESCE(SUM(v.cantidad * p.precio), 0) AS total_vendido_dolares
FROM productos p
LEFT JOIN ventas v ON p.idProducto = v.idProducto
GROUP BY p.idProducto, p.nombre, p.precio;

-- Opcional: Ver los datos originales para verificar
SELECT * FROM productos;
SELECT * FROM ventas;