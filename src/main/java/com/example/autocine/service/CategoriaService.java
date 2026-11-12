package com.example.autocine.service;

import com.example.autocine.model.Categoria;
import com.example.autocine.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    // Listar todas las categorías
    public List<Categoria> listarTodas() {
        return categoriaRepository.findAll();
    }

    // Buscar categoría por ID
    public Categoria obtenerPorId(Long id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return categoria.orElse(null);
    }

    // Guardar o registrar una nueva categoría
    public Categoria guardar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    // Actualizar una categoría existente
    public Categoria actualizar(Long id, Categoria categoriaDetails) {
        Optional<Categoria> categoriaOptional = categoriaRepository.findById(id);
        if (categoriaOptional.isPresent()) {
            Categoria categoriaExistente = categoriaOptional.get();
            // Actualiza los campos según los atributos de tu modelo Categoria (ej. nombre)
            categoriaExistente.setNombre(categoriaDetails.getNombre());
            return categoriaRepository.save(categoriaExistente);
        }
        return null;
    }

    // Eliminar una categoría por ID
    public boolean eliminar(Long id) {
        if (categoriaRepository.existsById(id)) {
            categoriaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}