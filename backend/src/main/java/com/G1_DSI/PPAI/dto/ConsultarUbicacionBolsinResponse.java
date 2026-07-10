package com.G1_DSI.PPAI.dto;

public class ConsultarUbicacionBolsinResponse {

    private ComisionMedicaResponse comisionMedicaUsuarioLogueado;

    public ConsultarUbicacionBolsinResponse(ComisionMedicaResponse comisionMedicaUsuarioLogueado) {
        this.comisionMedicaUsuarioLogueado = comisionMedicaUsuarioLogueado;
    }

    public ComisionMedicaResponse getComisionMedicaUsuarioLogueado() {
        return comisionMedicaUsuarioLogueado;
    }
}
