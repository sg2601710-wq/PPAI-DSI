package com.G1_DSI.PPAI.service;

import com.G1_DSI.PPAI.dto.LocalizacionBolsinResponse;
import com.G1_DSI.PPAI.dto.UbicacionBolsinRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class InterfazGPSTracker {

    private final RestClient restClient;
    private final String apiKey;

    public InterfazGPSTracker(
            @Value("${gps.tracker.base-url:http://localhost:8080}") String baseUrl,
            @Value("${gps.tracker.api-key:sk_xtr_9F3a7C21bE6d4A10f2c8e5b7d913}") String apiKey
    ) {
        this.restClient = RestClient.builder()
                .baseUrl(baseUrl)
                .build();
        this.apiKey = apiKey;
    }

    public List<LocalizacionBolsinResponse> obtenerUbicacionBolsines(List<UbicacionBolsinRequest> solicitudes) {
        List<LocalizacionBolsinResponse> ubicaciones = new ArrayList<>();

        for (UbicacionBolsinRequest solicitud : solicitudes) {
            XtrBolsinLocationResponse response = getBolsinLocation(solicitud);

            if (response != null && response.getItems() != null) {
                for (XtrBolsinLocationItem item : response.getItems()) {
                    ubicaciones.add(new LocalizacionBolsinResponse(
                            item.getNumeroBolsin(),
                            item.getLatitud(),
                            item.getLongitud(),
                            item.getFechaHoraUltimaActualizacion()
                    ));
                }
            }
        }

        return ubicaciones;
    }

    private XtrBolsinLocationResponse getBolsinLocation(UbicacionBolsinRequest solicitud) {
        return restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/api/xtr-4500l/getBolsinLocation")
                        .queryParam("numeroBolsin", solicitud.getNumeroBolsin())
                        .queryParam("codigoComisionMedicaOrigen", solicitud.getCodigoComisionMedicaOrigen())
                        .build())
                .header("X-API-Key", apiKey)
                .retrieve()
                .body(XtrBolsinLocationResponse.class);
    }

    private static class XtrBolsinLocationResponse {

        private List<XtrBolsinLocationItem> items;

        public List<XtrBolsinLocationItem> getItems() {
            return items;
        }

        public void setItems(List<XtrBolsinLocationItem> items) {
            this.items = items;
        }
    }

    private static class XtrBolsinLocationItem {

        private Integer numeroBolsin;
        private Double latitud;
        private Double longitud;
        private LocalDateTime fechaHoraUltimaActualizacion;

        public Integer getNumeroBolsin() {
            return numeroBolsin;
        }

        public void setNumeroBolsin(Integer numeroBolsin) {
            this.numeroBolsin = numeroBolsin;
        }

        public Double getLatitud() {
            return latitud;
        }

        public void setLatitud(Double latitud) {
            this.latitud = latitud;
        }

        public Double getLongitud() {
            return longitud;
        }

        public void setLongitud(Double longitud) {
            this.longitud = longitud;
        }

        public LocalDateTime getFechaHoraUltimaActualizacion() {
            return fechaHoraUltimaActualizacion;
        }

        public void setFechaHoraUltimaActualizacion(LocalDateTime fechaHoraUltimaActualizacion) {
            this.fechaHoraUltimaActualizacion = fechaHoraUltimaActualizacion;
        }
    }
}
