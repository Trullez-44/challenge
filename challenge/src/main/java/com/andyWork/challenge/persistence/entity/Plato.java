package com.andyWork.challenge.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Plato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "plato_id")
    private Integer platoId;
    //-------//
    
    private String nombre;
    private String descripcion;
    private int precio;

    public Plato() {
    }
    public Integer getPlatoId() {
        return platoId;
    }
    public void setPlatoId(Integer platoId) {
        this.platoId = platoId;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public int getPrecio() {
        return precio;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Plato [platoId=" + platoId + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio="
                + precio + "]";
    }

    
}
