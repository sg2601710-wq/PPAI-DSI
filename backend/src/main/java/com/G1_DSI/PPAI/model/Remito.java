package com.G1_DSI.PPAI.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="remitos")
public class Remito {

    @Id
    @Column(name="idRemito" ,nullable = false, unique = true)
    private Integer numero;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
            @JoinColumn(
                    name="nombreEstado",
                    referencedColumnName = "nombre",
                    nullable = false
            ),
            @JoinColumn(
                    name="ambitoEstado",
                    referencedColumnName = "ambito",
                    nullable = false
            )
    })
    private Estado estado;

    @Column(nullable = false)
    private LocalDate fechaCreacion;

    public Remito() {}

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
