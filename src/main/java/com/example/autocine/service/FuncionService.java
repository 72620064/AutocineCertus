package com.example.autocine.service;

import com.example.autocine.model.Funcion;
import com.example.autocine.repository.FuncionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionService {

    @Autowired
    private FuncionRepository funcionRepository;

    public List<Funcion> listarTodas() {
        return funcionRepository.findAll();
    }

    public Funcion guardar(Funcion funcion) {
        return funcionRepository.save(funcion);
    }
}