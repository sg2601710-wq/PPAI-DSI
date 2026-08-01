package com.G1_DSI.PPAI.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "sesiones")
public class Sesion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nombre_usuario", referencedColumnName = "nombre", nullable = false)
    private Usuario usuario;

    @Column(name = "fecha_hora_inicio", nullable = false)
    private LocalDateTime fechaHoraInicio;

    @Column(name = "fecha_hora_fin")
    private LocalDateTime fechaHoraFin;

    protected Sesion() {
    }

    public Sesion(LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin,  Usuario usuario) {
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public LocalDateTime getFechaHoraFin() {
        return fechaHoraFin;
    }

    public void setFechaHoraFin(LocalDateTime fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }

    public Usuario getUsuarioLogueado() {
        return usuario;
    }
}
