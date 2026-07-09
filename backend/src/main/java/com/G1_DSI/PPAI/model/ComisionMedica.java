package com.G1_DSI.PPAI.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="comisiones_medicas")
public class ComisionMedica {

    @Id
    @Column(nullable = false, unique = true)
    private Integer codigo;

    @Column
    private String direccion;

    @Column
    private String email;

    @Column(nullable = false)
    private String nombre;

    @Column
    private String telefono;

    public ComisionMedica() {}

    public ComisionMedica(Integer codigo, String direccion, String email, String nombre, String telefono) {
        this.codigo = codigo;
        this.direccion = direccion;
        this.email = email;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
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
