package com.G1_DSI.PPAI.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cambios_estados_bolsines")
public class CambioEstadoBolsin {

    // hay que ver si no vamos a hacer que esto sea una PK compuesta o si lo dejamos como PK
    // simple y nos facilitamos la vida
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fecha_hora_inicio", nullable = false)
    private LocalDateTime fechaHoraInicio;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
            @JoinColumn(name = "ambito_estado", referencedColumnName = "ambito", nullable = false),
            @JoinColumn(name = "nombre_estado", referencedColumnName = "nombre", nullable = false)
    })
    private Estado estado;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "email_responsable", referencedColumnName = "email", nullable = false)
    private Empleado responsableCE;

    @Column(name = "fecha_hora_fin")
    private LocalDateTime fechaHoraFin;

    protected CambioEstadoBolsin() {
    }

    public CambioEstadoBolsin(
            Estado estado,
            Empleado responsableCE,
            LocalDateTime fechaHoraFin,
            LocalDateTime fechaHoraInicio
    ) {
        this.estado = estado;
        this.responsableCE = responsableCE;
        this.fechaHoraFin = fechaHoraFin;
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public Long getId() {
        return id;
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
