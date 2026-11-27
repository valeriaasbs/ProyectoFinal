package com.example.demo.models;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cliente;
    private String telefono;
    private String tipoServicio; // Ej. "Estándar", "EyE", "Sesión Estudio"
    private String estado;       // Ej. "Recibido", "En edición", "Listo para entrega"
    private BigDecimal total;
    private BigDecimal anticipo;
    private LocalDate fechaEntrega;
    
}