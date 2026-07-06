package PPAI;
import java.time.LocalDateTime;

public class Sesion {
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;
    private Usuario usuario;
    public Sesion(){

    }
    public Sesion(LocalDateTime fechaHoraInicio, Usuario usuario, LocalDateTime fechaHoraFin) {
        this.fechaHoraInicio = fechaHoraInicio;
        this.usuario = usuario;
        this.fechaHoraFin = fechaHoraFin;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    // getUsuarioLogueado()
}
