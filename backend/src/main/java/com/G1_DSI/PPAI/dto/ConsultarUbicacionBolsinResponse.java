package com.G1_DSI.PPAI.dto;

import java.util.List;

public class ConsultarUbicacionBolsinResponse {

    private ComisionMedicaResponse comisionMedicaUsuarioLogueado;
    private List<UbicacionBolsinResponse> ubicacionesBolsines;

    public ConsultarUbicacionBolsinResponse(
            ComisionMedicaResponse comisionMedicaUsuarioLogueado,
            List<UbicacionBolsinResponse> ubicacionesBolsines
    ) {
        this.comisionMedicaUsuarioLogueado = comisionMedicaUsuarioLogueado;
        this.ubicacionesBolsines = ubicacionesBolsines;
    }

    public ComisionMedicaResponse getComisionMedicaUsuarioLogueado() {
        return comisionMedicaUsuarioLogueado;
    }

    public List<UbicacionBolsinResponse> getUbicacionesBolsines() {
        return ubicacionesBolsines;
    }
}
