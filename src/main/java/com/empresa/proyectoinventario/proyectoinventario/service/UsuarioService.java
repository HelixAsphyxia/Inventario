package com.empresa.proyectoinventario.proyectoinventario.service;

import com.empresa.proyectoinventario.proyectoinventario.model.Usuario;
import com.empresa.proyectoinventario.proyectoinventario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service  // Marca la clase como un servicio gestionado por Spring
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;  // Repositorio para interactuar con la tabla "Usuarios"

    /**
     * Busca un usuario por su nombre de usuario.
     * @param nombreUsuario El nombre de usuario a buscar.
     * @return El usuario encontrado o null si no existe.
     */
    public Usuario findByNombreUsuario(String nombreUsuario) {
        return usuarioRepository.findByNombre_usuario(nombreUsuario);  // Busca el usuario por nombre en el repositorio
    }
}
