package com.empresa.proyectoinventario.proyectoinventario.config;

import com.empresa.proyectoinventario.proyectoinventario.model.Usuario;
import com.empresa.proyectoinventario.proyectoinventario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collections;
import java.util.logging.Logger;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private static final Logger LOGGER = Logger.getLogger(SecurityConfig.class.getName());

    /**
     * Configura la cadena de filtros de seguridad.
     * Define permisos de acceso, autenticación y logout.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        LOGGER.info("Configurando SecurityFilterChain");
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/css/**", "/images/**", "/js/**").permitAll()
                        .requestMatchers("/", "/login", "/test-db").permitAll()
                        .requestMatchers("/inventario/**").hasAnyRole("ADMINISTRADOR", "ALMACENISTA")
                        .requestMatchers("/salida/**").hasRole("ALMACENISTA")
                        .requestMatchers("/historico/**").hasRole("ADMINISTRADOR")
                        .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .permitAll()
                        .defaultSuccessUrl("/inventario", true)
                        .failureUrl("/login?error=true")
                )
                .logout((logout) -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
                        .logoutSuccessUrl("/login?logout=true")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                        .permitAll()
                        .addLogoutHandler((request, response, authentication) -> {
                            LOGGER.info("Cerrando sesión para el usuario: " + (authentication != null ? authentication.getName() : "ninguno"));
                        })
                )
                .csrf().disable();
        return http.build();
    }

    /**
     * Proporciona el servicio de autenticación de usuarios.
     * Busca el usuario en la base de datos y asigna roles.
     */
    @Bean
    public UserDetailsService userDetailsService() {
        LOGGER.info("Cargando UserDetailsService");
        return username -> {
            LOGGER.info("Intentando autenticar usuario: " + username);
            Usuario usuario = usuarioRepository.findByNombre_usuario(username);
            if (usuario == null) {
                LOGGER.warning("Usuario no encontrado: " + username);
                throw new UsernameNotFoundException("Usuario no encontrado: " + username);
            }
            LOGGER.info("Usuario encontrado: " + usuario.getNombre_usuario() +
                    ", Contraseña: " + usuario.getContraseña() +
                    ", Rol: " + usuario.getRol().getNombre_rol());
            String role = "ROLE_" + usuario.getRol().getNombre_rol().toUpperCase();
            LOGGER.info("Rol mapeado a: " + role);
            return new org.springframework.security.core.userdetails.User(
                    usuario.getNombre_usuario(),
                    usuario.getContraseña(),
                    Collections.singletonList(new SimpleGrantedAuthority(role))
            );
        };
    }

    /**
     * Configura el codificador de contraseñas.
     * No aplica encriptación (solo para desarrollo, no recomendado en producción).
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        LOGGER.info("Configurando NoOpPasswordEncoder (sin encriptación)");
        return NoOpPasswordEncoder.getInstance();
    }
}
