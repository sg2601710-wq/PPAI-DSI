package com.G1_DSI.PPAI.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "comisiones_medicas")
public class ComisionMedica {

    @Id
    @Column(name = "codigo", nullable = false, length = 50)
    private String codigo;

    @Column(name = "direccion", length = 200)
    private String direccion;

    @Column(name = "email", length = 150)
    private String email;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "telefono", length = 50)
    private String telefono;

    protected ComisionMedica() {
    }

    public ComisionMedica(String codigo, String direccion, String email, String nombre, String telefono) {
        this.codigo = codigo;
        this.direccion = direccion;
        this.email = email;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


}
