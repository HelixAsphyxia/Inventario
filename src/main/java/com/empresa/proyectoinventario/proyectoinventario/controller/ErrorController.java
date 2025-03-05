package com.empresa.proyectoinventario.proyectoinventario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {

    /**
     * Maneja los errores generales de la aplicación.
     * Agrega un mensaje de error al modelo y retorna la vista "error".
     */
    @GetMapping("/error")
    public String handleError(Model model) {
        model.addAttribute("errorMessage", "Ocurrió un error inesperado. Por favor, intenta de nuevo.");
        return "error";
    }
}