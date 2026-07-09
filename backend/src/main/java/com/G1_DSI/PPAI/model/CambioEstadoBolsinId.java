package com.G1_DSI.PPAI.model;

import java.io.Serializable;
import java.util.Objects;

public class CambioEstadoBolsinId implements Serializable {

    private Integer numeroBolsin;

    private String nombreEstado;

    private  String ambitoEstado;

    public CambioEstadoBolsinId() {}

    public CambioEstadoBolsinId(Integer numeroBolsin, String nombreEstado, String ambitoEstado) {
        this.numeroBolsin = numeroBolsin;
        this.nombreEstado = nombreEstado;
        this.ambitoEstado = ambitoEstado;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CambioEstadoBolsinId that = (CambioEstadoBolsinId) o;
        return Objects.equals(numeroBolsin, that.numeroBolsin) &&
                Objects.equals(nombreEstado, that.nombreEstado) &&
                Objects.equals(ambitoEstado, that.ambitoEstado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numeroBolsin, nombreEstado, ambitoEstado);
    }

}
