package com.example.novaprint.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "servicios")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre;

    @Column(nullable = false, length = 300)
    private String descripcion;

    @Column(nullable = false)
    private String icono;

    @Column(name = "precio_unitario", nullable = false, precision = 8, scale = 2)
    private BigDecimal precioUnitario;

    @Column(name = "recargo_color", nullable = false, precision = 8, scale = 2)
    private BigDecimal recargoColor = BigDecimal.ZERO;

    @Column(name = "permite_doble_cara", nullable = false)
    private boolean permiteDobleCara;

    public Servicio() {}

    public Servicio(String nombre, String descripcion, String icono, String precioUnitario,
                    String recargoColor, boolean permiteDobleCara) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.icono = icono;
        this.precioUnitario = new BigDecimal(precioUnitario);
        this.recargoColor = new BigDecimal(recargoColor);
        this.permiteDobleCara = permiteDobleCara;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public String getIcono() { return icono; }
    public void setIcono(String icono) { this.icono = icono; }
    public BigDecimal getPrecioUnitario() { return precioUnitario; }
    public void setPrecioUnitario(BigDecimal precioUnitario) { this.precioUnitario = precioUnitario; }
    public BigDecimal getRecargoColor() { return recargoColor; }
    public void setRecargoColor(BigDecimal recargoColor) { this.recargoColor = recargoColor; }
    public boolean isPermiteDobleCara() { return permiteDobleCara; }
    public void setPermiteDobleCara(boolean permiteDobleCara) { this.permiteDobleCara = permiteDobleCara; }
}
