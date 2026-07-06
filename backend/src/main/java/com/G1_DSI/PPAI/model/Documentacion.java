package PPAI;

import java.util.Date;
import java.util.List;

public class Documentacion {

    private String asunto;
    private Date fechaPase;
    private Integer numero;
    private TipoDocumento tipoDocumento;
    private List<CambioEstadoDocumentacion> cambioEstadoDocumentaciones;
    private List<Archivo> archivoAdjunto;
    private ComisionMedica cmOrigen;

    public Documentacion(String asunto, TipoDocumento tipoDocumento, Integer numero, Date fechaPase, List<Archivo> archivoAdjunto, List<CambioEstadoDocumentacion> cambioEstadoDocumentaciones, ComisionMedica cmOrigen) {
        this.asunto = asunto;
        this.tipoDocumento = tipoDocumento;
        this.numero = numero;
        this.fechaPase = fechaPase;
        this.archivoAdjunto = archivoAdjunto;
        this.cambioEstadoDocumentaciones = cambioEstadoDocumentaciones;
        this.cmOrigen = cmOrigen;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public Date getFechaPase() {
        return fechaPase;
    }

    public void setFechaPase(Date fechaPase) {
        this.fechaPase = fechaPase;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public List<CambioEstadoDocumentacion> getCambioEstadoDocumentaciones() {
        return cambioEstadoDocumentaciones;
    }

    public void setCambioEstadoDocumentaciones(List<CambioEstadoDocumentacion> cambioEstadoDocumentaciones) {
        this.cambioEstadoDocumentaciones = cambioEstadoDocumentaciones;
    }

    public List<Archivo> getArchivoAdjunto() {
        return archivoAdjunto;
    }

    public void setArchivoAdjunto(List<Archivo> archivoAdjunto) {
        this.archivoAdjunto = archivoAdjunto;
    }

    public ComisionMedica getCmOrigen() {
        return cmOrigen;
    }

    public void setCmOrigen(ComisionMedica cmOrigen) {
        this.cmOrigen = cmOrigen;
    }
    // aceptar()
    // crearCE()
    // getDatosDocumentacion()
    // new()
    // remitar()
    // setEstado()
    // mostrarTipoDocumentacion()
}

