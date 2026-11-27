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

import com.example.demo.models.EstadoPedido;
import com.example.demo.repositories.EstadoPedidoRepository;

@RestController
@RequestMapping("/estados-pedido")
public class EstadoPedidoController {

    private final EstadoPedidoRepository repo;

    public EstadoPedidoController(EstadoPedidoRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<EstadoPedido> obtenerTodos() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Optional<EstadoPedido> obtenerPorId(@PathVariable Long id) {
        return repo.findById(id);
    }

    @PostMapping
    public EstadoPedido crear(@RequestBody EstadoPedido estadoPedido) {
        return repo.save(estadoPedido);
    }

    @PutMapping("/{id}")
    public EstadoPedido actualizar(@PathVariable Long id, @RequestBody EstadoPedido estadoPedido) {
        estadoPedido.setId(id);
        return repo.save(estadoPedido);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        repo.deleteById(id);
        return "{\"success\":true}";
    }
}