package com.G1_DSI.PPAI.controller;

import com.G1_DSI.PPAI.dto.ConsultarUbicacionBolsinResponse;
import com.G1_DSI.PPAI.service.ControladorConsultarSeguimientoBolsin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bolsines")
@CrossOrigin(origins = "*")
public class VentanaConsultarSeguimientoBolsin {

    private final ControladorConsultarSeguimientoBolsin controladorConsultarSeguimientoBolsin;

    public VentanaConsultarSeguimientoBolsin(ControladorConsultarSeguimientoBolsin controladorConsultarSeguimientoBolsin) {
        this.controladorConsultarSeguimientoBolsin = controladorConsultarSeguimientoBolsin;
    }

    @PostMapping("/consultar-ubicacion")
    public ResponseEntity<ConsultarUbicacionBolsinResponse> opcionConsultarUbicacionBolsin() {
        ConsultarUbicacionBolsinResponse response = mostrarCMUsuarioLogueado(habilitarVentana());

        if (response == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(response);
    }

    private ConsultarUbicacionBolsinResponse habilitarVentana() {
        return controladorConsultarSeguimientoBolsin.consultarUbicacionBolsin();
    }

    private ConsultarUbicacionBolsinResponse mostrarCMUsuarioLogueado(ConsultarUbicacionBolsinResponse response) {
        return response;
    }
}
