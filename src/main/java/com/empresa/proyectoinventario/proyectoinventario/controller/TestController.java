package com.empresa.proyectoinventario.proyectoinventario.controller;

import com.empresa.proyectoinventario.proyectoinventario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Logger;

/**
 * Controlador encargado de realizar una prueba de conexión a la base de datos.
 *
 * Este controlador verifica la conexión a la base de datos obteniendo y mostrando una lista de usuarios.
 */
@Controller
public class TestController {

    // Inyección de dependencia para interactuar con el repositorio de usuarios
    @Autowired
    private UsuarioRepository usuarioRepository;

    // Logger para registrar mensajes de información o error durante la ejecución
    private static final Logger LOGGER = Logger.getLogger(TestController.class.getName());

    /**
     * Maneja la solicitud GET a la ruta "/test-db" y verifica la conexión a la base de datos.
     *
     * @param model El objeto utilizado para pasar atributos entre el controlador y la vista
     * @return El nombre de la vista que se debe mostrar (en este caso, "test-db")
     */
    @GetMapping("/test-db")
    public String testDatabaseConnection(Model model) {
        try {
            // Obtiene la lista de todos los usuarios desde la base de datos
            var usuarios = usuarioRepository.findAll();

            // Registra la cantidad de usuarios encontrados
            LOGGER.info("Número de usuarios encontrados: " + usuarios.size());

            // Registra información sobre cada usuario encontrado
            for (var usuario : usuarios) {
                LOGGER.info("Usuario: " + usuario);
            }

            // Añade la lista de usuarios y el mensaje de éxito al modelo
            model.addAttribute("usuarios", usuarios);
            model.addAttribute("message", "Conexión a la base de datos exitosa! Usuarios encontrados: " + usuarios.size());
        } catch (Exception e) {
            // Si ocurre un error, se registra y se pasa un mensaje de error al modelo
            LOGGER.severe("Error al conectar a la base de datos: " + e.getMessage());
            model.addAttribute("message", "Error al conectar a la base de datos: " + e.getMessage());
        }

        // Retorna el nombre de la vista para mostrar el resultado de la prueba
        return "test-db";
    }
}
