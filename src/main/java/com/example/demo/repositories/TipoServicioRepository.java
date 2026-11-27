package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.TipoServicio;

public interface TipoServicioRepository extends JpaRepository<TipoServicio, Long> {
}