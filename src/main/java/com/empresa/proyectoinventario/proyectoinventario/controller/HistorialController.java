package com.empresa.proyectoinventario.proyectoinventario.controller;

import com.empresa.proyectoinventario.proyectoinventario.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controlador para gestionar el historial de movimientos en el inventario.
 */
@Controller
@RequestMapping("/historico")
public class HistorialController {

    @Autowired
    private MovimientoService movimientoService;

    /**
     * Muestra el historial de movimientos.
     * Si se proporciona un tipo de movimiento, filtra los resultados.
     *
     * @param model Modelo de la vista para pasar datos.
     * @param tipo  Tipo de movimiento a filtrar (opcional).
     * @return Nombre de la vista "historico".
     */
    @GetMapping
    public String mostrarHistorico(Model model, @RequestParam(required = false) String tipo) {
        if (tipo != null && !tipo.isEmpty()) {
            model.addAttribute("movimientos", movimientoService.filtrarMovimientos(tipo));
            model.addAttribute("filtro", tipo);
        } else {
            model.addAttribute("movimientos", movimientoService.listarMovimientos());
        }
        return "historico";
    }
}