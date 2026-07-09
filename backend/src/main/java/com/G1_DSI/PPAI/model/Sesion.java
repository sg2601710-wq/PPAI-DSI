package com.G1_DSI.PPAI.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="sesiones")
public class Sesion {

    @Id
    @Column(name = "idSesion", nullable = false, unique = true)
    private Integer idSesion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idUsuario", referencedColumnName = "id", nullable = false)
    private Usuario usuario;

    @Column(nullable = false)
    private LocalDate fechaHoraInicio;

    @Column
    private LocalDate fechaHoraFin;

    public Sesion() {}

    public Sesion(Integer idSesion, LocalDate fechaHoraInicio, LocalDate fechaHoraFin,  Usuario usuario) {
        this.idSesion = idSesion;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.usuario = usuario;
    }

    public Integer getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(Integer idSesion) {
        this.idSesion = idSesion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(LocalDate fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public LocalDate getFechaHoraFin() {
        return fechaHoraFin;
    }

    public void setFechaHoraFin(LocalDate fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }

    public Usuario getUsuarioLogueado() {
        return usuario;
    }
}
