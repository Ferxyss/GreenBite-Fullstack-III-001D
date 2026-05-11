package com.example.Suscripciones.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Suscripciones.models.Suscripcion;

public interface SuscripcionRepository
        extends JpaRepository<Suscripcion, Long> {
}