package com.example.autocine.service;

import com.example.autocine.model.Confiteria;
import com.example.autocine.repository.ConfiteriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConfiteriaService {

    @Autowired
    private ConfiteriaRepository confiteriaRepository;

    public List<Confiteria> listarTodos() {
        return confiteriaRepository.findAll();
    }

    public Confiteria obtenerPorId(Long id) {
        Optional<Confiteria> confiteria = confiteriaRepository.findById(id);
        return confiteria.orElse(null);
    }

    public Confiteria guardar(Confiteria confiteria) {
        return confiteriaRepository.save(confiteria);
    }

    public Confiteria actualizar(Long id, Confiteria confiteriaDetails) {
        Optional<Confiteria> confiteriaOptional = confiteriaRepository.findById(id);
        if (confiteriaOptional.isPresent()) {
            Confiteria confiteriaExistente = confiteriaOptional.get();
            confiteriaExistente.setNombre(confiteriaDetails.getNombre());
            confiteriaExistente.setDescripcion(confiteriaDetails.getDescripcion());
            confiteriaExistente.setPrecio(confiteriaDetails.getPrecio());
            confiteriaExistente.setStock(confiteriaDetails.getStock());
            return confiteriaRepository.save(confiteriaExistente);
        }
        return null;
    }

    public boolean eliminar(Long id) {
        if (confiteriaRepository.existsById(id)) {
            confiteriaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}