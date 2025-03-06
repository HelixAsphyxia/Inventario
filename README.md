# Inventario - Sistema de Gestión de Inventarios

## 🌟 Bienvenido
Bienvenido al repositorio del proyecto **Inventario**, una aplicación web diseñada para la gestión eficiente de inventarios en una empresa. Desarrollada el **5 de marzo de 2025**, esta solución utiliza tecnologías modernas como **Spring Boot**, **Maven**, **Java**, y **Microsoft SQL Server**, ofreciendo una arquitectura robusta, escalable y segura.

Este proyecto fue creado como parte de una evaluación técnica, implementando un sistema modular que cumple con los requisitos de administración de inventarios, inicio de sesión, gestión de productos, movimientos y roles de usuario. El código y la documentación están disponibles públicamente para revisión y uso.

---

## 📋 Estructura del Repositorio
| **Carpeta/Archivo**         | **Descripción**                                      |
|-----------------------------|------------------------------------------------------|
| `SCRIPTS/`                  | Contiene scripts SQL para la creación y configuración de la base de datos. |
| `README.md`                 | Guía principal del proyecto.                                           |
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
- **Maven**: Gestiona las dependencias y el ciclo de vida del proyecto.
- **Spring Boot**: Versión 3.4.3, framework principal para la arquitectura MVC.
- **Spring Framework**: Proporciona la base para los beans y la inyección de dependencias.
- **Spring Security**: Versión 6.4.3, para la gestión de autenticación y autorización.
- **Thymeleaf**: Motor de plantillas para las vistas dinámicas.
- **JDBC Driver para SQL Server**: Versión 12.8.1.jre11, definido en `pom.xml` para la conexión a la base de datos.

---

## 📦 Dependencias del Proyecto
A continuación, se listan las dependencias principales definidas en el archivo `pom.xml`, gestionadas por Maven. Estas bibliotecas habilitan las funcionalidades clave de la aplicación.

| **Grupo/Artefacto**                        | **Versión**    | **Descripción**                              |
|--------------------------------------------|----------------|----------------------------------------------|
| `org.springframework.boot:spring-boot-starter-parent` | 3.4.3          | Define la versión base y gestiona dependencias comunes de Spring Boot. |
| `org.springframework.boot:spring-boot-starter-web`    | 3.4.3          | Soporte para aplicaciones web con Spring MVC y Tomcat embebido. |
| `org.springframework.boot:spring-boot-starter-thymeleaf` | 3.4.3       | Integra Thymeleaf como motor de plantillas para vistas. |
| `org.springframework.boot:spring-boot-starter-data-jpa` | 3.4.3      | Proporciona soporte para JPA y Hibernate. |
| `org.springframework.boot:spring-boot-starter-jdbc`    | 3.4.3          | Soporte para conexiones JDBC con HikariCP. |
| `com.microsoft.sqlserver:mssql-jdbc`        | 12.8.1.jre11   | Controlador JDBC para conectar a Microsoft SQL Server. |
| `org.springframework.boot:spring-boot-starter-security` | 3.4.3      | Gestión de autenticación y autorización con Spring Security. |
| `org.springframework.boot:spring-boot-starter-logging` | 3.4.3      | Configura logging con Logback por defecto. |

#### **Dependencias Transitorias (Incluidas Automáticamente)**
Estas dependencias se derivan de los "starters" principales y son gestionadas por Maven:
- `org.hibernate:hibernate-core:6.6.8.Final` - Motor de persistencia para JPA.
- `org.springframework:spring-data-jpa:3.4.3` - Extensión de Spring Data para JPA.
- `org.springframework:spring-orm:6.2.3` - Soporte ORM de Spring.
- `org.springframework:spring-jdbc:6.2.3` - Soporte JDBC de Spring.
- `com.zaxxer:HikariCP:5.1.0` - Pool de conexiones de base de datos.
- `com.fasterxml.jackson.core:jackson-databind:2.18.2` - Serialización/deserialización JSON.
- `org.apache.tomcat.embed:tomcat-embed-core:10.1.36` - Servidor web embebido.
- `ch.qos.logback:logback-classic:1.5.16` - Implementación de logging.
- `org.slf4j:slf4j-api:2.0.16` - API de logging.

Para ver el árbol completo de dependencias, ejecuta:
```bash
mvn dependency:tree
```
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

### 📝 Notas Importantes

El diagrama relacional de la base de datos está anexado en la raíz del proyecto como diagrama_relacional.png. Por favor, revisa este archivo para entender la estructura de la base de datos.
La aplicación asume que los datos iniciales se cargan desde el script SQL. Asegúrate de ejecutarlo antes de correr la aplicación.

### 🙌 Agradecimientos
Agradezco profundamente la oportunidad de desarrollar este proyecto y el tiempo dedicado a su evaluación. Estoy abierto a retroalimentación para seguir mejorando. ¡Gracias!
