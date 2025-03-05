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
 * Controlador para gestionar el inventario de productos.
 */
@Controller
@RequestMapping("/inventario")
public class InventarioController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private MovimientoService movimientoService;

    @Autowired
    private com.empresa.proyectoinventario.proyectoinventario.repository.UsuarioRepository usuarioRepository;

    /**
     * Muestra la lista de productos en el inventario.
     *
     * @param model Modelo para la vista.
     * @param authentication Información de autenticación del usuario.
     * @return Vista del inventario.
     */
    @GetMapping
    public String mostrarInventario(Model model, Authentication authentication) {
        model.addAttribute("productos", productoService.listarTodos());
        String rol = authentication.getAuthorities().iterator().next().getAuthority();
        model.addAttribute("esAdministrador", "ROLE_ADMINISTRADOR".equals(rol));
        return "inventario";
    }

    /**
     * Agrega un nuevo producto al inventario.
     *
     * @param nombre Nombre del producto a agregar.
     * @param model Modelo para la vista.
     * @return Redirección a la vista del inventario.
     */
    @PostMapping("/agregar")
    public String agregarProducto(@RequestParam String nombre, Model model) {
        try {
            productoService.agregarProducto(nombre);
            return "redirect:/inventario";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("productos", productoService.listarTodos());
            return "inventario";
        }
    }

    /**
     * Aumenta la cantidad de un producto en el inventario.
     *
     * @param id ID del producto.
     * @param cantidad Cantidad a aumentar.
     * @param authentication Información de autenticación del usuario.
     * @param model Modelo para la vista.
     * @return Redirección a la vista del inventario.
     */
    @PostMapping("/aumentar")
    public String aumentarInventario(@RequestParam Integer id, @RequestParam Integer cantidad,
                                     Authentication authentication, Model model) {
        try {
            String username = authentication.getName();
            Integer idUsuario = usuarioRepository.findByNombre_usuario(username).getId_usuario();
            movimientoService.registrarEntrada(id, idUsuario, cantidad);
            return "redirect:/inventario";
        } catch (Exception e) {
            model.addAttribute("error", "Error al aumentar inventario: " + e.getMessage());
            model.addAttribute("productos", productoService.listarTodos());
            return "inventario";
        }
    }

    /**
     * Da de baja un producto en el inventario.
     *
     * @param id ID del producto a dar de baja.
     * @param model Modelo para la vista.
     * @return Redirección a la vista del inventario.
     */
    @PostMapping("/darBaja")
    public String darBaja(@RequestParam Integer id, Model model) {
        try {
            productoService.darBaja(id);
            return "redirect:/inventario";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("productos", productoService.listarTodos());
            return "inventario";
        }
    }

    /**
     * Reactiva un producto dado de baja en el inventario.
     *
     * @param id ID del producto a reactivar.
     * @param model Modelo para la vista.
     * @return Redirección a la vista del inventario.
     */
    @PostMapping("/reactivar")
    public String reactivar(@RequestParam Integer id, Model model) {
        try {
            productoService.reactivar(id);
            return "redirect:/inventario";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("productos", productoService.listarTodos());
            return "inventario";
        }
    }
}
