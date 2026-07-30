package com.G1_DSI.PPAI.dto;

import java.time.LocalDateTime;

public class UbicacionBolsinResponse {

    private Integer numeroBolsin;
    private Integer numeroPrecinto;
    private String codigoComisionMedicaDestino;
    private String nombreComisionMedicaDestino;
    private Double latitud;
    private Double longitud;
    private LocalDateTime fechaHoraUltimaActualizacion;

    public UbicacionBolsinResponse(
            Integer numeroBolsin,
            Integer numeroPrecinto,
            String codigoComisionMedicaDestino,
            String nombreComisionMedicaDestino,
            Double latitud,
            Double longitud,
            LocalDateTime fechaHoraUltimaActualizacion
    ) {
        this.numeroBolsin = numeroBolsin;
        this.numeroPrecinto = numeroPrecinto;
        this.codigoComisionMedicaDestino = codigoComisionMedicaDestino;
        this.nombreComisionMedicaDestino = nombreComisionMedicaDestino;
        this.latitud = latitud;
        this.longitud = longitud;
        this.fechaHoraUltimaActualizacion = fechaHoraUltimaActualizacion;
    }

    public Integer getNumeroBolsin() {
        return numeroBolsin;
    }

    public Integer getNumeroPrecinto() {
        return numeroPrecinto;
    }

    public String getCodigoComisionMedicaDestino() {
        return codigoComisionMedicaDestino;
    }

    public String getNombreComisionMedicaDestino() {
        return nombreComisionMedicaDestino;
    }

    public Double getLatitud() {
        return latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public LocalDateTime getFechaHoraUltimaActualizacion() {
        return fechaHoraUltimaActualizacion;
    }
}
