package com.example.Suscripciones.dtos;

import java.time.LocalDate;

public class SuscripcionResponseDTO {

    private Long id;
    private String nombreCliente;
    private String correo;
    private String plan;
    private LocalDate fechaInicio;
    private Boolean activa;

    public SuscripcionResponseDTO(Long id,
                                  String nombreCliente,
                                  String correo,
                                  String plan,
                                  LocalDate fechaInicio,
                                  Boolean activa) {

        this.id = id;
        this.nombreCliente = nombreCliente;
        this.correo = correo;
        this.plan = plan;
        this.fechaInicio = fechaInicio;
        this.activa = activa;
    }

    public Long getId() {
        return id;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getCorreo() {
        return correo;
    }

    public String getPlan() {
        return plan;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public Boolean getActiva() {
        return activa;
    }
}