package PPAI;

import java.time.LocalDateTime;

public class CambioEstadoDocumentacion {
    private LocalDateTime fechaHoraFin;
    private LocalDateTime fechaHoraInicio;
    private Empleado empleado;
    private Estado estado;

    public CambioEstadoDocumentacion(LocalDateTime fechaHoraFin, Estado estado, Empleado empleado, LocalDateTime fechaHoraInicio) {
        this.fechaHoraFin = fechaHoraFin;
        this.estado = estado;
        this.empleado = empleado;
        this.fechaHoraInicio = fechaHoraInicio;
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

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    // sosActual()
}
