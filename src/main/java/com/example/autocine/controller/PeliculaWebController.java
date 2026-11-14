package com.example.autocine.controller;

import com.example.autocine.model.Pelicula;
import com.example.autocine.service.CategoriaService;
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
@RequestMapping("/peliculas")
public class PeliculaWebController {

    @Autowired
    private PeliculaService peliculaService;

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public String carteleraClientes(
            @RequestParam(name = "buscar", required = false) String buscar,
            @RequestParam(name = "categoriaId", required = false) Long categoriaId,
            Model model) {

        List<Pelicula> lista = peliculaService.listarTodas();

        if (buscar != null && !buscar.trim().isEmpty()) {
            String filtro = buscar.toLowerCase();
            lista = lista.stream()
                    .filter(p -> (p.getTitulo() != null && p.getTitulo().toLowerCase().contains(filtro)) ||
                                 (p.getDirector() != null && p.getDirector().toLowerCase().contains(filtro)))
                    .collect(Collectors.toList());
        }

        if (categoriaId != null) {
            lista = lista.stream()
                    .filter(p -> p.getCategoria() != null && categoriaId.equals(p.getCategoria().getId()))
                    .collect(Collectors.toList());
        }

        model.addAttribute("peliculas", lista);
        model.addAttribute("categorias", categoriaService.listarTodas());
        model.addAttribute("buscar", buscar);
        model.addAttribute("categoriaSeleccionada", categoriaId);
        return "peliculas";
    }
}