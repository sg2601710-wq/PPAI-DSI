package com.G1_DSI.PPAI.model;

import java.io.Serializable;
import java.util.Objects;

public class EstadoId implements Serializable {

    private String ambito;

    private String nombre;

    public EstadoId() {
    }

    public EstadoId(String ambito, String nombre) {
        this.ambito = ambito;
        this.nombre = nombre;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        EstadoId estadoId = (EstadoId) o;
        return Objects.equals(ambito, estadoId.ambito)
                && Objects.equals(nombre, estadoId.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ambito, nombre);
    }
}
