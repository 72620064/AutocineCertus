package com.example.autocine.service;

import com.example.autocine.model.Sede;
import com.example.autocine.repository.SedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SedeService {

    @Autowired
    private SedeRepository sedeRepository;

    // Listar todas las sedes
    public List<Sede> listarTodas() {
        return sedeRepository.findAll();
    }

    // Buscar sede por ID
    public Sede obtenerPorId(Long id) {
        Optional<Sede> sede = sedeRepository.findById(id);
        return sede.orElse(null);
    }

    // Guardar o registrar una nueva sede
    public Sede guardar(Sede sede) {
        return sedeRepository.save(sede);
    }

    // Actualizar una sede existente
    public Sede actualizar(Long id, Sede sedeDetails) {
        Optional<Sede> sedeOptional = sedeRepository.findById(id);
        if (sedeOptional.isPresent()) {
            Sede sedeExistente = sedeOptional.get();
            
            // Ajusta estos setters según los atributos de tu modelo Sede (ej. nombre, direccion, ciudad, etc.)
            sedeExistente.setNombre(sedeDetails.getNombre());
            sedeExistente.setDireccion(sedeDetails.getDireccion());
            // sedeExistente.setCiudad(sedeDetails.getCiudad());
            
            return sedeRepository.save(sedeExistente);
        }
        return null;
    }

    // Eliminar una sede por ID
    public boolean eliminar(Long id) {
        if (sedeRepository.existsById(id)) {
            sedeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}