package com.example.autocine.model;

import jakarta.persistence.*;

@Entity
@Table(name = "sala")
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre; // Ej: Sala VIP, Sala Estándar
    private int capacidadVehiculos;

    @ManyToOne
    @JoinColumn(name = "sede_id")
    private Sede sede;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getCapacidadVehiculos() { return capacidadVehiculos; }
    public void setCapacidadVehiculos(int capacidadVehiculos) { this.capacidadVehiculos = capacidadVehiculos; }

    public Sede getSede() { return sede; }
    public void setSede(Sede sede) { this.sede = sede; }
}