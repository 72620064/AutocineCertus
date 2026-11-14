package com.example.autocine.controller;

import com.example.autocine.model.Confiteria;
import com.example.autocine.service.ConfiteriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/confiteria")
public class ConfiteriaWebController {

    @Autowired
    private ConfiteriaService confiteriaService;

    @GetMapping
    public String vitrinaConfiteria(@RequestParam(name = "buscar", required = false) String buscar, Model model) {
        List<Confiteria> lista = confiteriaService.listarTodos();

        if (buscar != null && !buscar.trim().isEmpty()) {
            String filtro = buscar.toLowerCase();
            lista = lista.stream()
                    .filter(c -> (c.getNombre() != null && c.getNombre().toLowerCase().contains(filtro)) ||
                                 (c.getDescripcion() != null && c.getDescripcion().toLowerCase().contains(filtro)))
                    .collect(Collectors.toList());
        }

        model.addAttribute("confiterias", lista);
        model.addAttribute("buscar", buscar);
        return "confiteria";
    }
}