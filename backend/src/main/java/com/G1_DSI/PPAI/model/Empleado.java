package com.G1_DSI.PPAI.model;

import jakarta.persistence.*;

import java.util.Objects;

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

    @OneToOne
    @JoinColumn(name="idUsuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name="idRol", nullable = false, insertable = false, updatable = false)
    private Rol rol;

    @ManyToOne
    @JoinColumn(name="codigoCM", nullable = false, insertable = false, updatable = false)
    private ComisionMedica CM;

    public Empleado() {}

    public Empleado(String nombre, String apellido, String email,  Usuario usuario, Rol rol, ComisionMedica CM) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.usuario = usuario;
        this.rol = rol;
        this.CM = CM;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public ComisionMedica getCM() {
        // Hay que ver si no hacemos que solamente retorne el código, o dejamos que tenga el objeto completo
        return CM;
    }

    public void setCM(ComisionMedica CM) {
        this.CM = CM;
    }

    public Boolean esTuCM(ComisionMedica comisionMedica) {
        return CM != null
                && comisionMedica != null
                && Objects.equals(CM.getCodigo(), comisionMedica.getCodigo());
    }

    public Boolean esTuUsuario(Usuario usuario) {
        return usuario != null
                && this.usuario != null
                && Objects.equals(this.usuario.getId(), usuario.getId());
    }

    public Boolean sosGCM(Rol rol) {
        return rol != null && rol.esGCM();
    }
}
