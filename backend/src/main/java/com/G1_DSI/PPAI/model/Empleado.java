package com.G1_DSI.PPAI.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "empleados")
public class Empleado {

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 100)
    private String apellido;

    // la PK de empleado, puede ser el email? o deberiamos hacerla compuesta con nombre,
    // apellido y email
    @Id
    @Column(name = "email", nullable = false, unique = true, length = 150)
    private String email;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nombre_usuario", referencedColumnName = "nombre", nullable= false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nombre_rol", referencedColumnName = "nombre", nullable= false)
    private Rol rol;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codigo_cm", referencedColumnName = "codigo")
    private ComisionMedica CM;

    protected Empleado() {
    }

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

    // mismo caso aca, hay que ver como hacemos para que la comparación sea por objeto y no por código
    public Boolean esTuCM(ComisionMedica comisionMedica) {
        return CM != null
                && comisionMedica != null
                && Objects.equals(CM.getCodigo(), comisionMedica.getCodigo());
    }

    // Hay que ver como se soluciona esto, porque si comparamos por objetos completos salta error
    public Boolean esTuUsuario(Usuario usuario) {
        return usuario != null
                && this.usuario != null
                && Objects.equals(this.usuario.getNombre(), usuario.getNombre());
    }

    public Boolean sosGCM() {
        return rol != null && rol.esGCM();
    }
}
