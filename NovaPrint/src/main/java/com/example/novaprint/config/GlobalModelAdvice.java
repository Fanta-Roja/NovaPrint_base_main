package com.example.novaprint.config;

import com.example.novaprint.entity.Usuario;
import com.example.novaprint.repository.UsuarioRepository;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

// Pasa el nombre del usuario a todas las vistas (para el menú).
@ControllerAdvice
public class GlobalModelAdvice {

    private final UsuarioRepository usuarioRepository;

    public GlobalModelAdvice(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @ModelAttribute
    public void datosDeSesion(Authentication auth, Model model) {
        if (auth == null || auth instanceof AnonymousAuthenticationToken || !auth.isAuthenticated()) {
            return;
        }
        String nombre = usuarioRepository.findByEmail(auth.getName())
                .map(Usuario::getNombre).orElse(auth.getName());
        model.addAttribute("usuarioNombre", nombre);
    }
}
