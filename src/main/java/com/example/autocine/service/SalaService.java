package com.example.autocine.service;

import com.example.autocine.model.Sala;
import com.example.autocine.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SalaService {

    @Autowired
    private SalaRepository salaRepository;

    public List<Sala> listarTodas() {
        return salaRepository.findAll();
    }

    public Sala obtenerPorId(Long id) {
        Optional<Sala> sala = salaRepository.findById(id);
        return sala.orElse(null);
    }

    public Sala guardar(Sala sala) {
        return salaRepository.save(sala);
    }

    public Sala actualizar(Long id, Sala salaDetails) {
        Optional<Sala> salaOptional = salaRepository.findById(id);
        if (salaOptional.isPresent()) {
            Sala salaExistente = salaOptional.get();
            salaExistente.setNombre(salaDetails.getNombre());
            salaExistente.setCapacidadVehiculos(salaDetails.getCapacidadVehiculos());
            salaExistente.setSede(salaDetails.getSede());
            return salaRepository.save(salaExistente);
        }
        return null;
    }

    public boolean eliminar(Long id) {
        if (salaRepository.existsById(id)) {
            salaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}