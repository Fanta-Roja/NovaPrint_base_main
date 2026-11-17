package com.example.novaprint.repository;

import com.example.novaprint.entity.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ContactoRepository extends JpaRepository<Contacto, Long> {
    List<Contacto> findAllByOrderByFechaEnvioDesc();
}
