package com.example.Suscripciones.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "suscripciones")
public class Suscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;
    private String nombreCliente;
    private String correo;
    private String plan;
    private LocalDate fechaInicio;
    private Boolean activa;

    public Suscripcion() {
    }

    public Suscripcion(Long id,
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

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Boolean getActiva() {
        return activa;
    }

    public void setActiva(Boolean activa) {
        this.activa = activa;
    }
}
