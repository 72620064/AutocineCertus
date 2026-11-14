package com.example.autocine.controller;

import com.example.autocine.model.*;
import com.example.autocine.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminWebController {

    @Autowired private PeliculaService peliculaService;
    @Autowired private CategoriaService categoriaService;
    @Autowired private SedeService sedeService;
    @Autowired private SalaService salaService;
    @Autowired private FuncionService funcionService;
    @Autowired private ConfiteriaService confiteriaService;

    @GetMapping
    public String panelAdmin(@RequestParam(name = "tab", defaultValue = "peliculas") String tab, Model model) {
        cargarListas(model);
        model.addAttribute("peliculaForm", new Pelicula());
        model.addAttribute("categoriaForm", new Categoria());
        model.addAttribute("sedeForm", new Sede());
        model.addAttribute("salaForm", new Sala());
        model.addAttribute("funcionForm", new Funcion());
        model.addAttribute("confiteriaForm", new Confiteria());
        model.addAttribute("tab", tab);
        return "admin";
    }

    private void cargarListas(Model model) {
        model.addAttribute("peliculas", peliculaService.listarTodas());
        model.addAttribute("categorias", categoriaService.listarTodas());
        model.addAttribute("sedes", sedeService.listarTodas());
        model.addAttribute("salas", salaService.listarTodas());
        model.addAttribute("funciones", funcionService.listarTodas());
        model.addAttribute("confiterias", confiteriaService.listarTodos());
    }

    // --- PELÍCULAS ---
    @PostMapping("/peliculas/guardar")
    public String guardarPelicula(@ModelAttribute("peliculaForm") Pelicula pelicula) {
        if (pelicula.getId() != null && pelicula.getId() > 0) peliculaService.actualizar(pelicula.getId(), pelicula);
        else { pelicula.setId(null); peliculaService.guardar(pelicula); }
        return "redirect:/admin?tab=peliculas";
    }

    @GetMapping("/peliculas/editar/{id}")
    public String editarPelicula(@PathVariable("id") Long id, Model model) {
        cargarListas(model);
        model.addAttribute("peliculaForm", peliculaService.obtenerPorId(id));
        model.addAttribute("categoriaForm", new Categoria());
        model.addAttribute("sedeForm", new Sede());
        model.addAttribute("salaForm", new Sala());
        model.addAttribute("funcionForm", new Funcion());
        model.addAttribute("confiteriaForm", new Confiteria());
        model.addAttribute("tab", "peliculas");
        return "admin";
    }

    @GetMapping("/peliculas/eliminar/{id}")
    public String eliminarPelicula(@PathVariable("id") Long id) {
        peliculaService.eliminar(id);
        return "redirect:/admin?tab=peliculas";
    }

    // --- CATEGORÍAS ---
    @PostMapping("/categorias/guardar")
    public String guardarCategoria(@ModelAttribute("categoriaForm") Categoria categoria) {
        if (categoria.getId() != null && categoria.getId() > 0) categoriaService.actualizar(categoria.getId(), categoria);
        else { categoria.setId(null); categoriaService.guardar(categoria); }
        return "redirect:/admin?tab=categorias";
    }

    @GetMapping("/categorias/eliminar/{id}")
    public String eliminarCategoria(@PathVariable("id") Long id) {
        categoriaService.eliminar(id);
        return "redirect:/admin?tab=categorias";
    }

    // --- SEDES ---
    @PostMapping("/sedes/guardar")
    public String guardarSede(@ModelAttribute("sedeForm") Sede sede) {
        if (sede.getId() != null && sede.getId() > 0) sedeService.actualizar(sede.getId(), sede);
        else { sede.setId(null); sedeService.guardar(sede); }
        return "redirect:/admin?tab=sedes";
    }

    @GetMapping("/sedes/eliminar/{id}")
    public String eliminarSede(@PathVariable("id") Long id) {
        sedeService.eliminar(id);
        return "redirect:/admin?tab=sedes";
    }

    // --- SALAS ---
    @PostMapping("/salas/guardar")
    public String guardarSala(@ModelAttribute("salaForm") Sala sala) {
        if (sala.getId() != null && sala.getId() > 0) salaService.actualizar(sala.getId(), sala);
        else { sala.setId(null); salaService.guardar(sala); }
        return "redirect:/admin?tab=salas";
    }

    @GetMapping("/salas/eliminar/{id}")
    public String eliminarSala(@PathVariable("id") Long id) {
        salaService.eliminar(id);
        return "redirect:/admin?tab=salas";
    }

    // --- FUNCIONES ---
    @PostMapping("/funciones/guardar")
    public String guardarFuncion(@ModelAttribute("funcionForm") Funcion funcion) {
        if (funcion.getId() != null && funcion.getId() > 0) funcionService.actualizar(funcion.getId(), funcion);
        else { funcion.setId(null); funcionService.guardar(funcion); }
        return "redirect:/admin?tab=funciones";
    }

    @GetMapping("/funciones/eliminar/{id}")
    public String eliminarFuncion(@PathVariable("id") Long id) {
        funcionService.eliminar(id);
        return "redirect:/admin?tab=funciones";
    }

    // --- CONFITERÍA ---
    @PostMapping("/confiteria/guardar")
    public String guardarConfiteria(@ModelAttribute("confiteriaForm") Confiteria confiteria) {
        if (confiteria.getId() != null && confiteria.getId() > 0) confiteriaService.actualizar(confiteria.getId(), confiteria);
        else { confiteria.setId(null); confiteriaService.guardar(confiteria); }
        return "redirect:/admin?tab=confiteria";
    }

    @GetMapping("/confiteria/eliminar/{id}")
    public String eliminarConfiteria(@PathVariable("id") Long id) {
        confiteriaService.eliminar(id);
        return "redirect:/admin?tab=confiteria";
    }
}