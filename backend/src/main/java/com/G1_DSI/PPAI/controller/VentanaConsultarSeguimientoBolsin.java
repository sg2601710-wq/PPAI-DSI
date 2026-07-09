package com.G1_DSI.PPAI.controller;

import com.G1_DSI.PPAI.service.ControladorConsultarSeguimientoBolsin;
import org.springframework.web.bind.annotation.CrossOrigin;
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
}
