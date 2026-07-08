package com.G1_DSI.PPAI.model;

import java.io.Serializable;
import java.util.Objects;

public class EmpleadoId implements Serializable {

    private String nombre;
    private String apellido;

    public EmpleadoId() {}

    public EmpleadoId(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmpleadoId that = (EmpleadoId) o;
        return Objects.equals(nombre, that.nombre) &&
                Objects.equals(apellido, that.apellido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, apellido);
    }
}
