package com.G1_DSI.PPAI.model;

import java.io.Serializable;
import java.util.Objects;

public class EstadoId implements Serializable {

    private String nombre;
    private String ambito;

    public EstadoId(){}

    public EstadoId(String nombre, String ambito) {
        this.nombre = nombre;
        this.ambito = ambito;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAmbito() {
        return ambito;
    }

    public void setAmbito(String ambito) {
        this.ambito = ambito;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstadoId that = (EstadoId) o;
        return Objects.equals(nombre, that.nombre) &&
                Objects.equals(ambito, that.ambito);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, ambito);
    }
}
