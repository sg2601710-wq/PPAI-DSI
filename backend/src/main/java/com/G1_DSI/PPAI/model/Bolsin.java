package com.G1_DSI.PPAI.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "bolsines")
public class Bolsin {

    @Id
    @Column(name = "numero_bolsin", nullable = false)
    private Integer numeroBolsin;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codigo_cm_origen", referencedColumnName = "codigo", nullable = false)
    private ComisionMedica cmOrigen;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codigo_cm_destino", referencedColumnName = "codigo")
    private ComisionMedica cmDestino;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "numero_bolsin", referencedColumnName = "numero_bolsin", nullable = false)
    private List<CambioEstadoBolsin> cambioEstadoBolsin = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "numero_bolsin", referencedColumnName = "numero_bolsin")
    private List<Remito> remito = new ArrayList<>();

    @Column(name = "numero_precinto")
    private Integer numeroPrecinto;

    @Column(name = "fecha_creacion", nullable = false)
    private LocalDateTime fechaCreacion;

    @Column(name = "peso", precision = 10, scale = 2)
    private BigDecimal peso;

    protected Bolsin() {
    }

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

    // hay que ver si hacemos que simplemente compare los objetos o si hacemos que compare
    // con el código de la comisión para evitar errores
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
