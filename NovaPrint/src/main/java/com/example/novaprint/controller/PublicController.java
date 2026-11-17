package com.example.novaprint.controller;

import com.example.novaprint.entity.Contacto;
import com.example.novaprint.entity.Usuario;
import com.example.novaprint.repository.ContactoRepository;
import com.example.novaprint.repository.ServicioRepository;
import com.example.novaprint.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

// Páginas públicas: portada, login, registro y contacto.
@Controller
public class PublicController {

    private final UsuarioRepository usuarioRepository;
    private final ContactoRepository contactoRepository;
    private final ServicioRepository servicioRepository;
    private final PasswordEncoder passwordEncoder;

    public PublicController(UsuarioRepository usuarioRepository, ContactoRepository contactoRepository,
                            ServicioRepository servicioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.contactoRepository = contactoRepository;
        this.servicioRepository = servicioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Portada con la lista de servicios.
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("servicios", servicioRepository.findAll());
        return "index";
    }

    // Formulario de inicio de sesión.
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // Formulario de registro.
    @GetMapping("/registro")
    public String registro() {
        return "registro";
    }

    // Valida los datos y crea el usuario con la contraseña cifrada.
    @PostMapping("/procesarRegistro")
    public String procesarRegistro(@RequestParam String nombre,
                                   @RequestParam String email,
                                   @RequestParam String telefono,
                                   @RequestParam String password,
                                   @RequestParam String confirmarPassword,
                                   Model model) {
        String error = null;
        if (nombre.isBlank() || telefono.isBlank()) {
            error = "Completa tu nombre y tu teléfono.";
        } else if (password.length() < 6) {
            error = "La contraseña debe tener al menos 6 caracteres.";
        } else if (!password.equals(confirmarPassword)) {
            error = "Las contraseñas no coinciden.";
        } else if (usuarioRepository.existsByEmail(email.trim().toLowerCase())) {
            error = "Ese correo ya está registrado. Prueba iniciando sesión.";
        }
        if (error != null) {
            model.addAttribute("error", error);
            model.addAttribute("nombre", nombre);
            model.addAttribute("email", email);
            model.addAttribute("telefono", telefono);
            return "registro";
        }

        Usuario u = new Usuario();
        u.setNombre(nombre.trim());
        u.setEmail(email.trim().toLowerCase());
        u.setTelefono(telefono.trim());
        u.setPassword(passwordEncoder.encode(password));
        usuarioRepository.save(u);
        return "redirect:/login?registroExitoso";
    }

    // Guarda el mensaje del formulario de contacto.
    @PostMapping("/procesarContacto")
    public String procesarContacto(@RequestParam String nombre,
                                   @RequestParam String email,
                                   @RequestParam(required = false) String telefono,
                                   @RequestParam String mensaje,
                                   RedirectAttributes redirect) {
        Contacto c = new Contacto();
        c.setNombre(nombre.trim());
        c.setEmail(email.trim());
        c.setTelefono(telefono);
        c.setMensaje(mensaje.length() > 1000 ? mensaje.substring(0, 1000) : mensaje);
        contactoRepository.save(c);
        redirect.addAttribute("exito", true);
        return "redirect:/#contacto";
    }
}
