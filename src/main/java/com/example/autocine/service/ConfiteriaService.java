package com.example.autocine.service;

import com.example.autocine.model.Confiteria;
import com.example.autocine.repository.ConfiteriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfiteriaService {

    @Autowired
    private ConfiteriaRepository confiteriaRepository;

    public List<Confiteria> listarTodos() {
        return confiteriaRepository.findAll();
    }

    public Confiteria guardar(Confiteria confiteria) {
        return confiteriaRepository.save(confiteria);
    }
}