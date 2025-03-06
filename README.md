# Inventario - Sistema de Gestión de Inventarios

## 🌟 Bienvenido
Bienvenido al repositorio del proyecto **Inventario**, una aplicación web diseñada para la gestión eficiente de inventarios en una empresa. Desarrollada el **5 de marzo de 2025**, esta solución utiliza tecnologías modernas como **Spring Boot**, **Maven**, **Java**, y **Microsoft SQL Server**, ofreciendo una arquitectura robusta, escalable y segura.

Este proyecto fue creado como parte de una evaluación técnica, implementando un sistema modular que cumple con los requisitos de administración de inventarios, inicio de sesión, gestión de productos, movimientos y roles de usuario. El código y la documentación están disponibles públicamente para revisión y uso.

---

## 📋 Estructura del Repositorio
| **Carpeta/Archivo**         | **Descripción**                                      |
|-----------------------------|------------------------------------------------------|
| `SCRIPTS/`                  | Contiene scripts SQL para la creación y configuración de la base de datos. |
| `README.md`                 | Este archivo, que sirve como la guía principal del proyecto. |
| `src/main/resources/application.properties` | Archivo de configuración de la base de datos y la aplicación. |
| `src/main/resources/templates/` | Contiene las vistas HTML gestionadas por Thymeleaf. |
| `src/main/java/`            | Contiene el código fuente (modelos, controladores, servicios, repositorios). |
| `pom.xml`                   | Archivo de configuración de Maven con las dependencias del proyecto. |
| `diagrama_relacional.png`   | Diagrama relacional de la base de datos (ubicado en la raíz). |

---

## 🛠️ Detalles Técnicos

### IDE Utilizado
- **IntelliJ IDEA**: Versión 2024.3.4, utilizado para el desarrollo y depuración del proyecto.

### Lenguaje de Programación
- **Java**: Versión 22.0.1 (2024-04-16)  
  - Entorno de Ejecución: Java(TM) SE Runtime Environment (build 22.0.1+8-16)  
  - Máquina Virtual: Java HotSpot(TM) 64-Bit Server VM (build 22.0.1+8-16, mixed mode, sharing).

### Sistema de Gestión de Base de Datos
- **Microsoft SQL Server**: Versión 16.0.1000.6 (RTM - X64), gestionado mediante SQL Server Management Studio 2022.
- **Configuración de Conexión**:
  - La base de datos se configura ejecutando el script SQL ubicado en:
  - Correr el script que se encuentra en: 
    ```bash
     \proyecto-inventario\src\main\java\com\empresa\proyectoinventario\proyectoinventario\scripts\
- Nombre del script: inventario_db.sql
- Nombre del script para otro punto de la evaluacion: ConsultasDB.sql
### Herramientas de Desarrollo
- **Maven**.
- **Spring Boot**.
- **Spring Framework**.
- **Spring Security**.
- **JDBC Driver para SQL Server**: Versión 12.8.1.jre11 (definida en `pom.xml`).

## ✨ Características Destacadas
  - Arquitectura MVC: Implementada con Spring Boot 3.4.3 para una estructura modular y mantenible.
  - Gestión de Inventario: Permite agregar productos, aumentar existencias, dar de baja/reactivar, y visualizar inventarios activos/inactivos.
  - Módulo de Salida: Permite restar inventario con validaciones de cantidad.
  - Historial de Movimientos: Registra entradas y salidas con filtros por tipo, usuario y fecha.
  - Seguridad por Roles: Diferencia permisos entre Administrador y Almacenista.
  - Interfaz Dinámica: Utiliza Thymeleaf para vistas responsivas.
  - Validaciones: Incluye mensajes de error para inventario insuficiente o accesos no autorizados.
---

## 🚀 Cómo Correr la Aplicación

### Pasos Detallados
1. **Clona el Repositorio**  
   - Ejecuta en tu terminal:
     ```bash
     git clone https://github.com/HelixAsphyxia/Inventario.git
2. **Clona el Repositorio**  
   - Ve al directorio del proyecto, posicionate dentro de:
     ```bash
     proyecto-inventario\src\main\java\com\empresa\proyectoinventario\proyectoinventario
   - Corre este archivo llamado: ProyectoInventarioApplication.java

## Visualiza mi video!

Anexo drive para visualizar la explicacion de la prueba tecnica.

https://drive.google.com/file/d/1FCePusXPKr-9BtqLrCmvs25nWrCYS1kg/view?usp=drive_link

- Corre este archivo llamado: ProyectoInventarioApplication.java
![Desde IntelliJ IDEA](Run.png)
### ✨ Características Destacadas
Arquitectura modular con Spring Boot 3.4.3.
Integración segura con SQL Server y logging detallado.
Interfaz dinámica con Thymeleaf y seguridad con Spring Security 6.4.3.
### 📝 Notas Importantes

El diagrama relacional de la base de datos está anexado en la raíz del proyecto como diagrama_relacional.png. Por favor, revisa este archivo para entender la estructura de la base de datos.
La aplicación asume que los datos iniciales se cargan desde el script SQL. Asegúrate de ejecutarlo antes de correr la aplicación.

### 🙌 Agradecimientos
Agradezco profundamente la oportunidad de desarrollar este proyecto y el tiempo dedicado a su evaluación. Estoy abierto a retroalimentación para seguir mejorando. ¡Gracias!
