package com.G1_DSI.PPAI.dto;

import java.time.LocalDateTime;

public class LocalizacionBolsinResponse {

    private Integer numeroBolsin;
    private Double latitud;
    private Double longitud;
    private LocalDateTime fechaHoraUltimaActualizacion;

    public LocalizacionBolsinResponse(
            Integer numeroBolsin,
            Double latitud,
            Double longitud,
            LocalDateTime fechaHoraUltimaActualizacion
    ) {
        this.numeroBolsin = numeroBolsin;
        this.latitud = latitud;
        this.longitud = longitud;
        this.fechaHoraUltimaActualizacion = fechaHoraUltimaActualizacion;
    }

    public Integer getNumeroBolsin() {
        return numeroBolsin;
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
