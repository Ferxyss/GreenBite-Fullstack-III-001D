package com.example.Suscripciones.services;

import com.example.Suscripciones.dtos.SuscripcionRequestDTO;
import com.example.Suscripciones.dtos.SuscripcionResponseDTO;
import com.example.Suscripciones.models.Suscripcion;
import com.example.Suscripciones.repositories.SuscripcionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SuscripcionServiceTest {
    private SuscripcionRepository repository;
    private SuscripcionServiceImpl service;

    @BeforeEach
    void setup() {

        repository = Mockito.mock(SuscripcionRepository.class);
        service = new SuscripcionServiceImpl(repository);
    }

    @Test
    void deberiaGuardarSuscripcion() {

        SuscripcionRequestDTO dto = new SuscripcionRequestDTO();

        dto.setNombreCliente("Claudio");
        dto.setCorreo("claudio@gmail.com");
        dto.setPlan("Premium");
        dto.setActiva(true);

        Suscripcion guardada = new Suscripcion(
                1L,
                dto.getNombreCliente(),
                dto.getCorreo(),
                dto.getPlan(),
                LocalDate.now(),
                dto.getActiva()
        );

        when(repository.save(any(Suscripcion.class)))
                .thenReturn(guardada);
        SuscripcionResponseDTO response =
                service.guardar(dto);
        assertNotNull(response);
        assertEquals(
                "Claudio",
                response.getNombreCliente()
        );

        verify(repository, times(1))
                .save(any(Suscripcion.class));
    }

    @Test
    void deberiaListarSuscripciones() {

        List<Suscripcion> lista = List.of(
                new Suscripcion(
                        1L,
                        "Claudio",
                        "claudio@gmail.com",
                        "Premium",
                        LocalDate.now(),
                        true
                ),
                new Suscripcion(
                        2L,
                        "María",
                        "maria@gmail.com",
                        "Basic",
                        LocalDate.now(),
                        true
                )
        );

        when(repository.findAll()).thenReturn(lista);

        List<SuscripcionResponseDTO> resultado =
                service.listar();
        assertEquals(2, resultado.size());
        verify(repository, times(1))
                .findAll();
    }

    @Test
    void deberiaObtenerSuscripcionPorId() {

        Suscripcion suscripcion = new Suscripcion(
                1L,
                "Claudio",
                "claudio@gmail.com",
                "Premium",
                LocalDate.now(),
                true
        );

        when(repository.findById(1L))
                .thenReturn(Optional.of(suscripcion));
        SuscripcionResponseDTO response =
                service.obtenerPorId(1L);
        assertEquals(
                "Claudio",
                response.getNombreCliente()
        );
    }

    @Test
    void deberiaEliminarSuscripcion() {
        service.eliminar(1L);
        verify(repository, times(1))
                .deleteById(1L);
    }
}