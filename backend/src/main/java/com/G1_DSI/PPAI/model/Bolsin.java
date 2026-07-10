package com.G1_DSI.PPAI.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="bolsines")
public class Bolsin {

    @Id
    @Column(nullable = false)
    private Integer numeroBolsin;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cmOrigen", referencedColumnName = "codigo", nullable = false)
    private ComisionMedica cmOrigen;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "cmDestino", referencedColumnName = "codigo", nullable = false)
    private ComisionMedica cmDestino;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="numeroBolsin", referencedColumnName = "numeroBolsin")
    private List<CambioEstadoBolsin> cambioEstadoBolsin = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="numeroBolsin", referencedColumnName = "numeroBolsin")
    private List<Remito> remito = new ArrayList<>();

    @Column(nullable = false)
    private Integer numeroPrecinto;

    @Column(nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(precision = 10, scale = 2)
    // Decido poner big decimal porque el peso tiene que ser preciso y no tener redondeo
    private BigDecimal peso;

    public Bolsin() {}

    public Bolsin(
            Integer numeroBolsin,
            Integer numeroPrecinto,
            LocalDateTime fechaCreacion,
            ComisionMedica cmOrigen,
            ComisionMedica cmDestino,
            List<CambioEstadoBolsin> cambioEstadoBolsin,
            List<Remito> remito,
            BigDecimal peso) {
        this.numeroBolsin = numeroBolsin;
        this.numeroPrecinto = numeroPrecinto;
        this.fechaCreacion = fechaCreacion;
        this.cmOrigen = cmOrigen;
        this.cmDestino = cmDestino;
        this.cambioEstadoBolsin = cambioEstadoBolsin;
        this.remito = remito;
        this.peso = peso;
    }

    public Integer getNumeroBolsin() {
        return numeroBolsin;
    }

    public void setNumeroBolsin(Integer numeroBolsin) {
        this.numeroBolsin = numeroBolsin;
    }

    public Integer getNumeroPrecinto() {
        return numeroPrecinto;
    }

    public void setNumeroPrecinto(Integer numeroPrecinto) {
        this.numeroPrecinto = numeroPrecinto;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public ComisionMedica getCmOrigen() {
        return cmOrigen;
    }

    public void setCmOrigen(ComisionMedica cmOrigen) {
        this.cmOrigen = cmOrigen;
    }

    public ComisionMedica getCmDestino() {
        return cmDestino;
    }

    public void setCmDestino(ComisionMedica cmDestino) {
        this.cmDestino = cmDestino;
    }

    public List<CambioEstadoBolsin> getCambioEstadoBolsin() {
        return cambioEstadoBolsin;
    }

    public void setCambioEstadoBolsin(List<CambioEstadoBolsin> cambioEstadoBolsin) {
        this.cambioEstadoBolsin = cambioEstadoBolsin;
    }

    public List<Remito> getRemito() {
        return remito;
    }

    public void setRemito(List<Remito> remito) {
        this.remito = remito;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public Boolean esTuCMOrigen(ComisionMedica comisionMedica) {
        return comisionMedica != null
                && this.cmOrigen != null
                && Objects.equals(this.cmOrigen.getCodigo(), comisionMedica.getCodigo());
    }

    public Boolean sosEnviado() {
        for (CambioEstadoBolsin cambio : cambioEstadoBolsin) {
            if (cambio.sosActual()) {
                return cambio.sosEnviado();
            }
        }

        return false;
    }
}
