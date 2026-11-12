package com.example.autocine.controller;

import com.example.autocine.service.PeliculaService;
import com.example.autocine.service.ConfiteriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private PeliculaService peliculaService;

    @Autowired
    private ConfiteriaService confiteriaService;

    @GetMapping("/")
    public String index(Model model) {
        // Enviamos las listas de películas y confitería hacia la vista HTML
        model.addAttribute("peliculas", peliculaService.listarTodas());
        model.addAttribute("confiterias", confiteriaService.listarTodos());
        return "index"; // Esto busca el archivo index.html en src/main/resources/templates/
    }
}