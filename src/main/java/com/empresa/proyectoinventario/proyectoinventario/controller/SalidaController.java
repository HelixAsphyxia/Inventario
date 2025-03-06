package com.empresa.proyectoinventario.proyectoinventario.controller;

import com.empresa.proyectoinventario.proyectoinventario.service.MovimientoService;
import com.empresa.proyectoinventario.proyectoinventario.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controlador encargado de manejar las solicitudes relacionadas con las salidas de inventario.
 */
@Controller
@RequestMapping("/salida")
public class SalidaController {

    // Inyección de dependencias para acceder a los servicios necesarios
    @Autowired
    private ProductoService productoService;

    @Autowired
    private MovimientoService movimientoService;

    @Autowired
    private com.empresa.proyectoinventario.proyectoinventario.repository.UsuarioRepository usuarioRepository;

    /**
     * Maneja la solicitud GET a la ruta "/salida" para mostrar la página de salidas de inventario.
     *
     * @param model El objeto utilizado para pasar atributos entre el controlador y la vista
     * @param error Mensaje de error opcional que se mostrará en la vista
     * @return El nombre de la vista que se debe mostrar (en este caso, "salida")
     */
    @GetMapping
    public String mostrarSalida(Model model, @RequestParam(required = false) String error) {
        // Lista de productos activos que se pasarán a la vista
        model.addAttribute("productos", productoService.listarActivos());

        // Si se ha recibido un mensaje de error, se pasa a la vista
        if (error != null) {
            model.addAttribute("error", error);
        }

        // Retorna el nombre de la vista de salidas
        return "salida";
    }

    /**
     * Maneja la solicitud POST para realizar una salida de inventario.
     *
     * @param idProducto El ID del producto que se va a sacar
     * @param cantidad La cantidad de producto a sacar
     * @param authentication El objeto de autenticación para obtener el usuario actual
     * @param model El objeto utilizado para pasar atributos entre el controlador y la vista
     * @return Redirecciona a la vista de salidas, con un mensaje de error en caso de fallo
     */
    @PostMapping("/sacar")
    public String sacarInventario(@RequestParam Integer idProducto, @RequestParam Integer cantidad,
                                  Authentication authentication, Model model) {
        try {
            // Obtiene el nombre del usuario autenticado
            String username = authentication.getName();

            // Obtiene el ID del usuario desde el repositorio de usuarios
            Integer idUsuario = usuarioRepository.findByNombre_usuario(username).getId_usuario();

            // Registra la salida de inventario
            movimientoService.registrarSalida(idProducto, idUsuario, cantidad);

            // Redirige a la página de salidas
            return "redirect:/salida";
        } catch (Exception e) {
            // En caso de error, redirige con un mensaje de error
            return "redirect:/salida?error=Error al sacar inventario: " + e.getMessage();
        }
    }
}
