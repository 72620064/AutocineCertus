package com.example.autocine.service;

import com.example.autocine.model.Sala;
import com.example.autocine.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaService {

    @Autowired
    private SalaRepository salaRepository;

    public List<Sala> listarTodas() {
        return salaRepository.findAll();
    }

    public Sala guardar(Sala sala) {
        return salaRepository.save(sala);
    }
}