package com.example.autocine.controller;

import com.example.autocine.model.Confiteria;
import com.example.autocine.service.ConfiteriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/confiteria")
public class ConfiteriaController {

    @Autowired
    private ConfiteriaService confiteriaService;

    @GetMapping
    public List<Confiteria> listar() {
        return confiteriaService.listarTodos();
    }

    @PostMapping
    public Confiteria guardar(@RequestBody Confiteria confiteria) {
        return confiteriaService.guardar(confiteria);
    }
}