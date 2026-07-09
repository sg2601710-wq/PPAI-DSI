package com.G1_DSI.PPAI.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "cambios_estados_bolsin")
@IdClass(CambioEstadoBolsinId.class)
public class CambioEstadoBolsin {

    @Id
    @Column(nullable = false)
    private Integer numeroBolsin;

    @Id
    @Column(nullable = false, length = 50)
    private String nombreEstado;

    @Id
    @Column(nullable = false, length = 50)
    private String ambitoEstado;

    @Id
    @Column(nullable = false)
    private LocalDateTime fechaHoraInicio;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "numeroBolsin",
            referencedColumnName = "numeroBolsin",
            nullable = false,
            insertable = false,
            updatable = false
    )
    private Bolsin bolsin;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
            @JoinColumn(
                    name="nombreEstado",
                    referencedColumnName = "nombre",
                    nullable = false,
                    insertable = false,
                    updatable = false
            ),
            @JoinColumn(
                    name="ambitoEstado",
                    referencedColumnName = "ambito",
                    nullable = false,
                    insertable = false,
                    updatable = false
            )
    })
    private Estado estado;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
            @JoinColumn(
                    name = "nombreResponsable",
                    referencedColumnName = "nombre",
                    nullable = false
            ),
            @JoinColumn(
                    name = "apellidoResponsable",
                    referencedColumnName = "apellido",
                    nullable = false
            )
    })
    private Empleado responsableCE;

    @Column
    private LocalDateTime fechaHoraFin;

    public CambioEstadoBolsin() {}

    public CambioEstadoBolsin(
            Integer numeroBolsin,
            String nombreEstado,
            String ambitoEstado,
            Bolsin bolsin,
            Estado estado,
            Empleado responsableCE,
            LocalDateTime fechaHoraFin,
            LocalDateTime fechaHoraInicio
    ) {
        this.numeroBolsin = numeroBolsin;
        this.nombreEstado = nombreEstado;
        this.ambitoEstado = ambitoEstado;
        this.bolsin = bolsin;
        this.estado = estado;
        this.responsableCE = responsableCE;
        this.fechaHoraFin = fechaHoraFin;
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public Integer getNumeroBolsin() {
        return numeroBolsin;
    }

    public void setNumeroBolsin(Integer numeroBolsin) {
        this.numeroBolsin = numeroBolsin;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    public String getAmbitoEstado() {
        return ambitoEstado;
    }

    public void setAmbitoEstado(String ambitoEstado) {
        this.ambitoEstado = ambitoEstado;
    }

    public Bolsin getBolsin() {
        return bolsin;
    }

    public void setBolsin(Bolsin bolsin) {
        this.bolsin = bolsin;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Empleado getResponsableCE() {
        return responsableCE;
    }

    public void setResponsableCE(Empleado responsableCE) {
        this.responsableCE = responsableCE;
    }

    public LocalDateTime getFechaHoraFin() {
        return fechaHoraFin;
    }

    public void setFechaHoraFin(LocalDateTime fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }

    public LocalDateTime getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public Boolean sosActual() {
        return fechaHoraFin == null;
    }

    public Boolean sosEnviado() {
        return estado.esEnviado();
    }

}
