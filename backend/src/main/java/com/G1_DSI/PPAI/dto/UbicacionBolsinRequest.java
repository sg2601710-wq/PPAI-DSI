package com.G1_DSI.PPAI.dto;

public class UbicacionBolsinRequest {

    private Integer numeroBolsin;
    private String codigoComisionMedicaOrigen;

    public UbicacionBolsinRequest(Integer numeroBolsin, String codigoComisionMedicaOrigen) {
        this.numeroBolsin = numeroBolsin;
        this.codigoComisionMedicaOrigen = codigoComisionMedicaOrigen;
    }

    public Integer getNumeroBolsin() {
        return numeroBolsin;
    }

    public String getCodigoComisionMedicaOrigen() {
        return codigoComisionMedicaOrigen;
    }
}
