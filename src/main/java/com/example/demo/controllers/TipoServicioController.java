package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.TipoServicio;
import com.example.demo.repositories.TipoServicioRepository;

@RestController
@RequestMapping("/tipos-servicio")
public class TipoServicioController {

    private final TipoServicioRepository repo;

    public TipoServicioController(TipoServicioRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<TipoServicio> obtenerTodos() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Optional<TipoServicio> obtenerPorId(@PathVariable Long id) {
        return repo.findById(id);
    }

    @PostMapping
    public TipoServicio crear(@RequestBody TipoServicio tipoServicio) {
        return repo.save(tipoServicio);
    }

    @PutMapping("/{id}")
    public TipoServicio actualizar(@PathVariable Long id, @RequestBody TipoServicio tipoServicio) {
        tipoServicio.setId(id);
        return repo.save(tipoServicio);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        repo.deleteById(id);
        return "{\"success\":true}";
    }
}