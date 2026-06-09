package PPAI;
import java.time.LocalDateTime;

public class Sesion {
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;

    public Sesion(){

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

    public Sesion(LocalDateTime fechaHoraInicio, LocalDateTime fechaHoraFin) {
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
    }
}
