package com.G1_DSI.PPAI.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "estados")
@IdClass(EstadoId.class)
public class Estado {

    @Id
    @Column(name = "ambito", nullable = false, length = 100)
    private String ambito;

    @Id
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "descripcion", length = 500)
    private String descripcion;

    protected Estado() {
    }

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
        return "enviado".equalsIgnoreCase(nombre);
    }

}
