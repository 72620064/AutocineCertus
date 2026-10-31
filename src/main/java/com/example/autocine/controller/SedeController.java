package com.example.autocine.controller;

import com.example.autocine.model.Sede;
import com.example.autocine.service.SedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sedes")
public class SedeController {

    @Autowired
    private SedeService sedeService;

    @GetMapping
    public List<Sede> listar() {
        return sedeService.listarTodas();
    }

    @PostMapping
    public Sede guardar(@RequestBody Sede sede) {
        return sedeService.guardar(sede);
    }
}