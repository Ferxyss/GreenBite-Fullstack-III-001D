package com.example.Suscripciones.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Suscripciones.dtos.SuscripcionRequestDTO;
import com.example.Suscripciones.dtos.SuscripcionResponseDTO;
import com.example.Suscripciones.services.SuscripcionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/suscripciones")
public class SuscripcionController {

    private final SuscripcionService service;

    public SuscripcionController(SuscripcionService service) {
        this.service = service;
    }

    @GetMapping
    public List<SuscripcionResponseDTO> listar() {
        return service.listar();
    }

    @PostMapping
    public SuscripcionResponseDTO guardar(
            @Valid @RequestBody SuscripcionRequestDTO dto) {

        return service.guardar(dto);
    }

    @GetMapping("/{id}")
    public SuscripcionResponseDTO obtener(@PathVariable Long id) {
        return service.obtenerPorId(id);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}