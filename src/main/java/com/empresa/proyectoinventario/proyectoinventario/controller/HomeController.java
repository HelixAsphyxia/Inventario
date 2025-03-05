package com.empresa.proyectoinventario.proyectoinventario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Logger;

/**
 * Controlador para gestionar la página de inicio.
 */
@Controller
public class HomeController {

    private static final Logger LOGGER = Logger.getLogger(HomeController.class.getName());

    /**
     * Maneja las solicitudes a la raíz ("/") y redirige a la página de inicio de sesión.
     *
     * @return Redirección a la ruta "/login".
     */
    @GetMapping("/")
    public String home() {
        LOGGER.info("Accediendo a la raíz, redirigiendo a /login");
        return "redirect:/login";
    }
}
