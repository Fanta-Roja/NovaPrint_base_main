package com.example.novaprint.config;

import com.example.novaprint.entity.Servicio;
import com.example.novaprint.repository.ServicioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

// Carga los servicios iniciales al arrancar.
@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner cargarDatos(ServicioRepository servicios) {
        return args -> {
            if (servicios.count() == 0) {
                servicios.saveAll(List.of(
                    new Servicio("Fotocopias", "Copias nítidas de documentos, libros y apuntes, en A4 u oficio.",
                            "fa-copy", "0.10", "0.40", true),
                    new Servicio("Impresiones", "Imprime tus archivos PDF o Word desde un USB o por correo.",
                            "fa-print", "0.20", "0.50", true),
                    new Servicio("Planos y gran formato", "Impresión en A3, A2 y A1 para planos y láminas.",
                            "fa-drafting-compass", "3.00", "2.00", false),
                    new Servicio("Escaneo", "Digitalizamos tus documentos y te los enviamos por correo.",
                            "fa-file-import", "0.50", "0.00", false),
                    new Servicio("Anillado y empastado", "Trabajos, tesis e informes listos para presentar.",
                            "fa-book", "4.00", "0.00", false),
                    new Servicio("Plastificado", "Protege carnés, certificados y fotos con acabado brillante.",
                            "fa-id-card", "1.50", "0.00", false)
                ));
            }
        };
    }
}
