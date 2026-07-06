package com.G1_DSI.PPAI.model;

public class DetalleRemito {
    private String areaCMCDestino;
    private Documentacion documentacion;

    public DetalleRemito(String areaCMCDestino, Documentacion documentacion) {
        this.areaCMCDestino = areaCMCDestino;
        this.documentacion = documentacion;
    }
    // Creación objeto anónimo:
    public DetalleRemito() {
    }

    public String getAreaCMCDestino() {
        return areaCMCDestino;
    }

    public void setAreaCMCDestino(String areaCMCDestino) {
        this.areaCMCDestino = areaCMCDestino;
    }

    public Documentacion getDocumentacion() {
        return documentacion;
    }

    public void setDocumentacion(Documentacion documentacion) {
        this.documentacion = documentacion;
    }
    // aceptarDocumentacion()
    // actualizarEstadoDoc()
    //mostrarDocumentacion()
}
