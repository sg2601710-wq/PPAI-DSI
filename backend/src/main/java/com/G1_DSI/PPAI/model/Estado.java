package com.G1_DSI.PPAI.model;

import jakarta.persistence.*;

@Entity
@Table(name="estados")
@IdClass(EstadoId.class)
public class Estado {

    @Id
    @Column(nullable = false, length=50)
    private String ambito;

    @Id
    @Column(nullable = false, length=50)
    private String nombre;

    @Column
    private String descripcion;

    public Estado() {}

    public Estado(String ambito, String nombre, String descripcion) {
        this.ambito = ambito;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getAmbito() {
        return ambito;
    }

    public void setAmbito(String ambito) {
        this.ambito = ambito;
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

    public Boolean esEnviado() {
        return nombre.toLowerCase().equals("enviado");
    }

}
