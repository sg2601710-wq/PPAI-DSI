package com.G1_DSI.PPAI.dto;

public class UsuarioLogueadoResponse {

    private Integer id;
    private String nombre;

    public UsuarioLogueadoResponse(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}
