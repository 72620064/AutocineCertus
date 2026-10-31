package com.example.autocine.service;

import com.example.autocine.model.Sede;
import com.example.autocine.repository.SedeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SedeService {

    @Autowired
    private SedeRepository sedeRepository;

    public List<Sede> listarTodas() {
        return sedeRepository.findAll();
    }

    public Sede guardar(Sede sede) {
        return sedeRepository.save(sede);
    }
}