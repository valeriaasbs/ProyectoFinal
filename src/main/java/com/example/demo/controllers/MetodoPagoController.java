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

import com.example.demo.models.MetodoPago;
import com.example.demo.repositories.MetodoPagoRepository;

@RestController
@RequestMapping("/metodos-pago")
public class MetodoPagoController {

    private final MetodoPagoRepository repo;

    public MetodoPagoController(MetodoPagoRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<MetodoPago> obtenerTodos() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Optional<MetodoPago> obtenerPorId(@PathVariable Long id) {
        return repo.findById(id);
    }

    @PostMapping
    public MetodoPago crear(@RequestBody MetodoPago metodoPago) {
        return repo.save(metodoPago);
    }

    @PutMapping("/{id}")
    public MetodoPago actualizar(@PathVariable Long id, @RequestBody MetodoPago metodoPago) {
        metodoPago.setId(id);
        return repo.save(metodoPago);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        repo.deleteById(id);
        return "{\"success\":true}";
    }
}