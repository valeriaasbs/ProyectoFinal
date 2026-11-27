package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.MetodoPago;

public interface MetodoPagoRepository extends JpaRepository<MetodoPago, Long> {
}