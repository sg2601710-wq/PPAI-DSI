package com.G1_DSI.PPAI.model;

import jakarta.persistence.*;

@Entity
@Table(name="empleados")
@IdClass(EmpleadoId.class)
public class Empleado {

    @Id
    @Column(nullable = false, length = 100)
    private String nombre;

    @Id
    @Column(nullable = false, length = 100)
    private String apellido;

    @Column
    private String email;

    public Empleado() {}

    public Empleado(String nombre, String apellido) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
