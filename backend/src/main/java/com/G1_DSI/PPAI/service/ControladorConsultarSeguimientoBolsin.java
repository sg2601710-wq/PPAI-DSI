package com.G1_DSI.PPAI.service;

import com.G1_DSI.PPAI.dto.ComisionMedicaResponse;
import com.G1_DSI.PPAI.dto.ConsultarUbicacionBolsinResponse;
import com.G1_DSI.PPAI.model.ComisionMedica;
import com.G1_DSI.PPAI.model.Empleado;
import com.G1_DSI.PPAI.model.Sesion;
import com.G1_DSI.PPAI.model.Usuario;
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

    private List<Sesion> sesiones;
    private List<Empleado> empleados;
    private Sesion sesionActual;
    private Usuario usuarioLogueado;
    private Empleado empleadoLogueado;
    private ComisionMedica comisionMedicaUsuarioLogueado;
    private Integer codigoComisionMedicaUsuarioLogueado;

    public ControladorConsultarSeguimientoBolsin(
            ISesionRepository sesionRepository,
            IEmpleadoRepository empleadoRepository
    ) {
        this.sesionRepository = sesionRepository;
        this.empleadoRepository = empleadoRepository;
        this.sesiones = new ArrayList<>();
        this.empleados = new ArrayList<>();
    }

    @EventListener(ContextRefreshedEvent.class)
    public void onApplicationEvent(ContextRefreshedEvent event) {
        cargarDatos();
    }

    private void cargarDatos() {
        this.sesiones = sesionRepository.findAll();
        this.empleados = empleadoRepository.findAll();
    }

    public ConsultarUbicacionBolsinResponse consultarUbicacionBolsin() {
        ComisionMedica comisionMedica = buscarCMUsuarioLogueado();

        if (comisionMedica == null) {
            return null;
        }

        return new ConsultarUbicacionBolsinResponse(toComisionMedicaResponse(comisionMedica));
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
        this.codigoComisionMedicaUsuarioLogueado = comisionMedicaUsuarioLogueado.getCodigo();
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
}
