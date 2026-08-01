package com.G1_DSI.PPAI.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "remitos")
public class Remito {

    @Id
    @Column(name = "numero", nullable = false)
    private Integer numero;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
            @JoinColumn(name = "ambito_estado", referencedColumnName = "ambito", nullable = false),
            @JoinColumn(name = "nombre_estado", referencedColumnName = "nombre", nullable = false)
    })
    private Estado estado;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDate fechaCreacion;

    protected Remito() {
    }

    public Remito(Integer numero, Estado estado, LocalDate fechaCreacion) {
        this.numero = numero;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }


}
