package com.G1_DSI.PPAI.dto;

public class ComisionMedicaResponse {

    private Integer codigo;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;

    public ComisionMedicaResponse(
            Integer codigo,
            String nombre,
            String direccion,
            String telefono,
            String email
    ) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }
}
