package com.G1_DSI.PPAI.model;

public class Estado {
    private String ambito;
    private String descripcion;
    private String nombre;

    public Estado(String nombre, String ambito, String descripcion) {
        this.nombre = nombre;
        this.ambito = ambito;
        this.descripcion = descripcion;
    }

    public String getAmbito() {
        return ambito;
    }

    public void setAmbito(String ambito) {
        this.ambito = ambito;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    // esAmbitoBolsin()
     // esAmbitoDocumentacion()
    // esAmbitoRemito()
    // esEnviado()
    // esRecibidaYAceptada()
    // esRecibidoEnCMDestino()
    // esRecibidoYAceptado()
}
