-- Crear la base de datos
CREATE DATABASE inventario_db;
GO

-- Usar la base de datos
USE inventario_db;
GO

-- Crear tabla Roles
CREATE TABLE Roles (
                       id_rol INT NOT NULL IDENTITY(1,1),
                       nombre_rol NVARCHAR(50) NOT NULL UNIQUE,
                       CONSTRAINT PK_Roles PRIMARY KEY (id_rol)
);
GO

-- Crear tabla Usuarios
CREATE TABLE Usuarios (
                          id_usuario INT NOT NULL IDENTITY(1,1),
                          nombre_usuario NVARCHAR(50) NOT NULL UNIQUE,
                          contraseña NVARCHAR(100) NOT NULL,
                          id_rol INT NOT NULL,
                          CONSTRAINT PK_Usuarios PRIMARY KEY (id_usuario),
                          CONSTRAINT FK_Usuarios_Roles FOREIGN KEY (id_rol) REFERENCES Roles(id_rol)
);
GO

-- Crear tabla Productos
CREATE TABLE Productos (
                           id_producto INT NOT NULL IDENTITY(1,1),
                           nombre_producto NVARCHAR(100) NOT NULL,
                           cantidad INT NOT NULL DEFAULT 0,
                           estatus NVARCHAR(10) NOT NULL DEFAULT 'Activo',
                           CONSTRAINT PK_Productos PRIMARY KEY (id_producto),
                           CONSTRAINT CHK_cantidad CHECK (cantidad >= 0),
                           CONSTRAINT CHK_estatus CHECK (estatus IN ('Activo', 'Inactivo'))
);
GO

-- Crear tabla Movimientos
CREATE TABLE Movimientos (
                             id_movimiento INT NOT NULL IDENTITY(1,1),
                             id_producto INT NOT NULL,
                             id_usuario INT NOT NULL,
                             tipo_movimiento NVARCHAR(10) NOT NULL,
                             cantidad INT NOT NULL,
                             fecha_hora DATETIME NOT NULL DEFAULT GETDATE(),
                             CONSTRAINT PK_Movimientos PRIMARY KEY (id_movimiento),
                             CONSTRAINT FK_Movimientos_Productos FOREIGN KEY (id_producto) REFERENCES Productos(id_producto),
                             CONSTRAINT FK_Movimientos_Usuarios FOREIGN KEY (id_usuario) REFERENCES Usuarios(id_usuario),
                             CONSTRAINT CHK_cantidad_mov CHECK (cantidad > 0),
                             CONSTRAINT CHK_tipo_movimiento CHECK (tipo_movimiento IN ('Entrada', 'Salida'))
);
GO

-- Insertar datos iniciales en Roles
INSERT INTO Roles (nombre_rol)
VALUES ('Administrador'), ('Almacenista');
GO

-- Insertar datos iniciales en Usuarios
INSERT INTO Usuarios (nombre_usuario, contraseña, id_rol)
VALUES
('admin1', 'admin123', 1),
('almacenista1', 'almacen123', 2);
GO

-- Insertar datos iniciales en Productos
INSERT INTO Productos (nombre_producto, cantidad, estatus)
VALUES
('Laptop', 10, 'Activo'),
('Monitor', 5, 'Activo'),
('Teclado', 0, 'Inactivo');
GO

-- Insertar datos iniciales en Movimientos
INSERT INTO Movimientos (id_producto, id_usuario, tipo_movimiento, cantidad, fecha_hora)
VALUES
(1, 1, 'Entrada', 10, '2025-03-01 10:00:00'),
(2, 1, 'Entrada', 5, '2025-03-02 14:30:00'),
(1, 2, 'Salida', 2, '2025-03-03 09:15:00');
GO