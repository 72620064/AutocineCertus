package com.example.autocine.controller;

import com.example.autocine.service.CategoriaService;
import com.example.autocine.service.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categorias")
public class CategoriaWebController {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private PeliculaService peliculaService;

    @GetMapping
    public String vitrinaCategorias(Model model) {
        model.addAttribute("categorias", categoriaService.listarTodas());
        model.addAttribute("peliculas", peliculaService.listarTodas());
        return "categorias";
    }
}