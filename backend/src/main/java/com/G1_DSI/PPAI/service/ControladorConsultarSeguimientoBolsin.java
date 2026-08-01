package com.G1_DSI.PPAI.service;

import com.G1_DSI.PPAI.dto.ComisionMedicaResponse;
import com.G1_DSI.PPAI.dto.ConsultarUbicacionBolsinResponse;
import com.G1_DSI.PPAI.dto.LocalizacionBolsinResponse;
import com.G1_DSI.PPAI.dto.UbicacionBolsinRequest;
import com.G1_DSI.PPAI.dto.UbicacionBolsinResponse;
// Hay que cambiar esto de model.* para que solo usemos lo que necesitamos
import com.G1_DSI.PPAI.model.*;
import com.G1_DSI.PPAI.repository.IBolsinRepository;
import com.G1_DSI.PPAI.repository.IEmpleadoRepository;
import com.G1_DSI.PPAI.repository.ISesionRepository;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ControladorConsultarSeguimientoBolsin {

    private final ISesionRepository sesionRepository;
    private final IEmpleadoRepository empleadoRepository;
    private final IBolsinRepository bolsinRepository;
    private final InterfazGPSTracker interfazGPSTracker;

    private List<Sesion> sesiones;
    private List<Empleado> empleados;
    private Sesion sesionActual;
    private Usuario usuarioLogueado;
    private Empleado empleadoLogueado;
    private ComisionMedica comisionMedicaUsuarioLogueado;
    private List<Bolsin> bolsines;

    public ControladorConsultarSeguimientoBolsin(
            ISesionRepository sesionRepository,
            IEmpleadoRepository empleadoRepository,
            IBolsinRepository bolsinRepository,
            InterfazGPSTracker interfazGPSTracker
    ) {
        this.sesionRepository = sesionRepository;
        this.empleadoRepository = empleadoRepository;
        this.bolsinRepository = bolsinRepository;
        this.interfazGPSTracker = interfazGPSTracker;
        this.sesiones = new ArrayList<>();
        this.empleados = new ArrayList<>();
        this.bolsines = new ArrayList<>();
    }

    @EventListener(ContextRefreshedEvent.class)
    public void onApplicationEvent(ContextRefreshedEvent event) {
        cargarDatos();
    }

    private void cargarDatos() {
        this.sesiones = sesionRepository.findAll();
        this.empleados = empleadoRepository.findAll();
        this.bolsines = bolsinRepository.findAll();
    }

    public ConsultarUbicacionBolsinResponse consultarUbicacionBolsin() {
        ComisionMedica comisionMedica = buscarCMUsuarioLogueado();

        if (comisionMedica == null) {
            return null;
        }

        List<Bolsin> bolsinesEnEstadoEnviado = buscarBolsinesEnviados();
        List<UbicacionBolsinResponse> ubicacionesBolsines = obtenerDatosLocalizacionBolsines(bolsinesEnEstadoEnviado);

        return new ConsultarUbicacionBolsinResponse(
                toComisionMedicaResponse(comisionMedica),
                ubicacionesBolsines
        );
    }

    private ComisionMedica buscarCMUsuarioLogueado() {
        // Esto se hace para simplificar, después tendriamos que ver si no vamos a implementar un login
        // real y que de ahí se ponga al objeto de la sesión actual
        this.sesionActual = buscarSesionActual();

        if (sesionActual == null) {
            return null;
        }

        this.usuarioLogueado = sesionActual.getUsuarioLogueado();
        this.empleadoLogueado = null;

        for (Empleado empleado : empleados) {
            if (empleado.esTuUsuario(usuarioLogueado)) {
                this.empleadoLogueado = empleado;
                break;
            }
        }


        if (empleadoLogueado == null) {
            return null;
        }

        this.comisionMedicaUsuarioLogueado = empleadoLogueado.getCM();
        return comisionMedicaUsuarioLogueado;
    }

    private Sesion buscarSesionActual() {
        return sesiones.stream()
                .filter(sesion -> sesion.getFechaHoraFin() == null)
                .findFirst()
                .orElse(null);
    }
    

    private ComisionMedicaResponse toComisionMedicaResponse(ComisionMedica comisionMedica) {
        return new ComisionMedicaResponse(
                comisionMedica.getCodigo(),
                comisionMedica.getNombre(),
                comisionMedica.getDireccion(),
                comisionMedica.getTelefono(),
                comisionMedica.getEmail()
        );
    }

    private List<Bolsin> buscarBolsinesEnviados() {

        List<Bolsin> bolsinesEnEstadoEnviado = new ArrayList<>();

        for (Bolsin bolsin : bolsines) {
            if (bolsin.esTuCMOrigen(comisionMedicaUsuarioLogueado) && bolsin.sosEnviado()) {
                bolsinesEnEstadoEnviado.add(bolsin);
            }
        }

        return bolsinesEnEstadoEnviado;
    }

    private List<UbicacionBolsinResponse> obtenerDatosLocalizacionBolsines(List<Bolsin> bolsinesEnEstadoEnviado) {
        List<UbicacionBolsinRequest> solicitudes = new ArrayList<>();

        for (Bolsin bolsin : bolsinesEnEstadoEnviado) {
            solicitudes.add(new UbicacionBolsinRequest(
                    bolsin.getNumeroBolsin(),
                    bolsin.getCmOrigen().getCodigo()
            ));
        }

        List<LocalizacionBolsinResponse> localizaciones = interfazGPSTracker.obtenerUbicacionBolsines(solicitudes);
        List<UbicacionBolsinResponse> ubicacionesBolsines = new ArrayList<>();

        for (LocalizacionBolsinResponse localizacion : localizaciones) {
            Bolsin bolsin = null;

            for (Bolsin bolsinEnviado : bolsinesEnEstadoEnviado) {
                if (bolsinEnviado.getNumeroBolsin().equals(localizacion.getNumeroBolsin())) {
                    bolsin = bolsinEnviado;
                    break;
                }
            }

            if (bolsin != null) {
                ubicacionesBolsines.add(new UbicacionBolsinResponse(
                        localizacion.getNumeroBolsin(),
                        bolsin.getNumeroPrecinto(),
                        bolsin.getCmDestino().getCodigo(),
                        bolsin.getCmDestino().getNombre(),
                        localizacion.getLatitud(),
                        localizacion.getLongitud(),
                        localizacion.getFechaHoraUltimaActualizacion()
                ));
            }
        }

        return ubicacionesBolsines;
    }

}
