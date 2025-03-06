package com.empresa.proyectoinventario.proyectoinventario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Logger;

/**
 * Controlador encargado de manejar las solicitudes relacionadas con la página de login.
 */
@Controller
public class LoginController {

    // Logger para generar mensajes de registro
    private static final Logger LOGGER = Logger.getLogger(LoginController.class.getName());

    /**
     * Maneja la solicitud GET a la ruta "/login" y muestra la página de inicio de sesión.
     *
     * @param model Objeto utilizado para pasar atributos entre el controlador y la vista
     * @return El nombre de la vista a mostrar (en este caso, "login")
     */
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        // Mensaje de log que indica que se está mostrando la página de login
        LOGGER.info("Mostrando página de login");

        // Retorna el nombre de la vista que se debe mostrar
        return "login";
    }
}
