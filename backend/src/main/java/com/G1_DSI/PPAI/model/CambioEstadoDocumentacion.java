package com.G1_DSI.PPAI.model;

import java.time.LocalDateTime;

public class CambioEstadoDocumentacion {
    private LocalDateTime fechaHoraFin;
    private LocalDateTime fechaHoraInicio;
    private Empleado responsableCE;

    public CambioEstadoDocumentacion(LocalDateTime fechaHoraFin, LocalDateTime fechaHoraInicio, Empleado responsableCE) {
        this.fechaHoraFin = fechaHoraFin;
        this.fechaHoraInicio = fechaHoraInicio;
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

    public Empleado getResponsableCE() {
        return responsableCE;
    }

    public void setResponsableCE(Empleado responsableCE) {
        this.responsableCE = responsableCE;
    }
    // sosActual()
}
