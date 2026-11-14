package com.example.autocine.controller;

import com.example.autocine.model.Sede;
import com.example.autocine.service.SalaService;
import com.example.autocine.service.SedeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/sedes")
public class SedeWebController {

    @Autowired
    private SedeService sedeService;

    @Autowired
    private SalaService salaService;

    @GetMapping
    public String vitrinaSedes(@RequestParam(name = "ciudad", required = false) String ciudad, Model model) {
        List<Sede> lista = sedeService.listarTodas();

        if (ciudad != null && !ciudad.trim().isEmpty()) {
            String filtro = ciudad.toLowerCase();
            lista = lista.stream()
                    .filter(s -> s.getCiudad() != null && s.getCiudad().toLowerCase().contains(filtro))
                    .collect(Collectors.toList());
        }

        model.addAttribute("sedes", lista);
        model.addAttribute("salas", salaService.listarTodas());
        model.addAttribute("ciudad", ciudad);
        return "sedes";
    }
}