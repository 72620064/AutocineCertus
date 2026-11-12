package com.example.autocine.service;

import com.example.autocine.model.Funcion;
import com.example.autocine.repository.FuncionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionService {

    @Autowired
    private FuncionRepository funcionRepository;

    // Listar todas las funciones
    public List<Funcion> listarTodas() {
        return funcionRepository.findAll();
    }

    // Buscar función por ID
    public Funcion obtenerPorId(Long id) {
        Optional<Funcion> funcion = funcionRepository.findById(id);
        return funcion.orElse(null);
    }

    // Guardar o registrar una nueva función
    public Funcion guardar(Funcion funcion) {
        return funcionRepository.save(funcion);
    }

    // Actualizar una función existente
    public Funcion actualizar(Long id, Funcion funcionDetails) {
        Optional<Funcion> funcionOptional = funcionRepository.findById(id);
        if (funcionOptional.isPresent()) {
            Funcion funcionExistente = funcionOptional.get();
            
            // Ajusta estos setters según los atributos de tu modelo Funcion (ej. fecha, hora, precio, película, sala)
            funcionExistente.setFecha(funcionDetails.getFecha());
            funcionExistente.setHora(funcionDetails.getHora());
            funcionExistente.setPrecio(funcionDetails.getPrecio());
            // funcionExistente.setPelicula(funcionDetails.getPelicula());
            // funcionExistente.setSala(funcionDetails.getSala());
            
            return funcionRepository.save(funcionExistente);
        }
        return null;
    }

    // Eliminar una función por ID
    public boolean eliminar(Long id) {
        if (funcionRepository.existsById(id)) {
            funcionRepository.deleteById(id);
            return true;
        }
        return false;
    }
}