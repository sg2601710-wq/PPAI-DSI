package com.G1_DSI.PPAI.model;

public class Archivo {
    private String nombreArchivo;
    private String tituloDocumento;

    public Archivo(String nombreArchivo, String tituloDocumento) {
        this.nombreArchivo = nombreArchivo;
        this.tituloDocumento = tituloDocumento;
    }
    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getTituloDocumento() {
        return tituloDocumento;
    }

    public void setTituloDocumento(String tituloDocumento) {
        this.tituloDocumento = tituloDocumento;
    }
}
