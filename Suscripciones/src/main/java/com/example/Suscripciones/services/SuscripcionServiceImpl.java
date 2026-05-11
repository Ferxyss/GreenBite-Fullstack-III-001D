package com.example.Suscripciones.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Suscripciones.dtos.SuscripcionRequestDTO;
import com.example.Suscripciones.dtos.SuscripcionResponseDTO;
import com.example.Suscripciones.models.Suscripcion;
import com.example.Suscripciones.repositories.SuscripcionRepository;

@Service
public class SuscripcionServiceImpl implements SuscripcionService {
    private final SuscripcionRepository repository;
    public SuscripcionServiceImpl(SuscripcionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<SuscripcionResponseDTO> listar() {
        return repository.findAll()
                .stream()
                .map(this::convertirDTO)
                .toList();
    }

    @Override
    public SuscripcionResponseDTO guardar(SuscripcionRequestDTO dto) {

        Suscripcion suscripcion = new Suscripcion();
        suscripcion.setNombreCliente(dto.getNombreCliente());
        suscripcion.setCorreo(dto.getCorreo());
        suscripcion.setPlan(dto.getPlan());
        suscripcion.setActiva(dto.getActiva());
        suscripcion.setFechaInicio(LocalDate.now());
        return convertirDTO(repository.save(suscripcion));
    }

    @Override
    public SuscripcionResponseDTO obtenerPorId(Long id) {

        Suscripcion suscripcion = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Suscripción no encontrada"));
        return convertirDTO(suscripcion);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    private SuscripcionResponseDTO convertirDTO(Suscripcion s) {
        return new SuscripcionResponseDTO(
                s.getId(),
                s.getNombreCliente(),
                s.getCorreo(),
                s.getPlan(),
                s.getFechaInicio(),
                s.getActiva()
        );
    }
}