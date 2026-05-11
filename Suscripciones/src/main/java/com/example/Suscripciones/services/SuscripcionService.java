package com.example.Suscripciones.services;

import java.util.List;

import com.example.Suscripciones.dtos.SuscripcionRequestDTO;
import com.example.Suscripciones.dtos.SuscripcionResponseDTO;

public interface SuscripcionService {

    List<SuscripcionResponseDTO> listar();

    SuscripcionResponseDTO guardar(SuscripcionRequestDTO dto);

    SuscripcionResponseDTO obtenerPorId(Long id);

    void eliminar(Long id);
}