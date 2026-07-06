package PPAI;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bolsin {
    private LocalDate fecha;
    private Integer numeroBolsin;
    private Integer numeroPrecinto;
    private Double peso;
    private ComisionMedica origen;
    private ComisionMedica destino;
    private List<CambioEstadoBolsin> cambioEstado;
    // Para poder hacer la composición:
    private List<Remito> Remito = new ArrayList<>();

    public void crearRemito() {
        // Suponiendo que el constructor de DetalleRemito recibe los datos necesarios
        Remito nuevoRemito = new Remito();
        this.Remito.add(nuevoRemito);
    }

    // Creación de objeto sin parámetros. Objeto anónimo.
    public Bolsin() {
    }

    public Bolsin(LocalDate fecha, Integer numeroBolsin, Integer numeroPrecinto, Double peso, ComisionMedica origen, ComisionMedica destino, List<CambioEstadoBolsin> cambioEstado, List<Remito> remito) {
        this.fecha = fecha;
        this.numeroBolsin = numeroBolsin;
        this.numeroPrecinto = numeroPrecinto;
        this.peso = peso;
        this.origen = origen;
        this.destino = destino;
        this.cambioEstado = cambioEstado;
        Remito = remito;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
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

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public ComisionMedica getOrigen() {
        return origen;
    }

    public void setOrigen(ComisionMedica origen) {
        this.origen = origen;
    }

    public ComisionMedica getDestino() {
        return destino;
    }

    public void setDestino(ComisionMedica destino) {
        this.destino = destino;
    }

    public List<CambioEstadoBolsin> getCambioEstado() {
        return cambioEstado;
    }

    public void setCambioEstado(List<CambioEstadoBolsin> cambioEstado) {
        this.cambioEstado = cambioEstado;
    }

    public List<Remito> getRemito() {
        // Devuelve una copia de lectura. Si intentan modificarla desde fuera, lanzará una excepción.
        return Collections.unmodifiableList(this.Remito);
    }
    // asociarRemito()
    // crearCEBolsin()
    // esTuCMOrigen()
    // mostrarDatos()
    // new() --> No sé si es lo mismo que el constructor, entiendo que fuera
    // de la programación si, pero no sé si acá adentro es o no lo mismo.
    // obtenerCMDestino()
    // obtenerInformacionRemito()
    // setDetalleBolsin()
    // sosEnviado()
}
