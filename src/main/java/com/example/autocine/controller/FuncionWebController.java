package com.example.autocine.controller;

import com.example.autocine.model.Funcion;
import com.example.autocine.service.FuncionService;
import com.example.autocine.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/funciones")
public class FuncionWebController {

    @Autowired
    private FuncionService funcionService;

    @Autowired
    private PeliculaService peliculaService;

    @GetMapping
    public String carteleraFunciones(
            @RequestParam(name = "peliculaId", required = false) Long peliculaId,
            @RequestParam(name = "fecha", required = false) String fecha,
            Model model) {

        List<Funcion> lista = funcionService.listarTodas();

        if (peliculaId != null) {
            lista = lista.stream()
                    .filter(f -> f.getPelicula() != null && peliculaId.equals(f.getPelicula().getId()))
                    .collect(Collectors.toList());
        }

        if (fecha != null && !fecha.trim().isEmpty()) {
            lista = lista.stream()
                    .filter(f -> f.getFecha() != null && f.getFecha().toString().equals(fecha))
                    .collect(Collectors.toList());
        }

        model.addAttribute("funciones", lista);
        model.addAttribute("peliculas", peliculaService.listarTodas());
        model.addAttribute("peliculaSeleccionada", peliculaId);
        model.addAttribute("fechaSeleccionada", fecha);
        return "funciones";
    }
}