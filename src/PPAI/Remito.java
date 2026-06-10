package PPAI;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Remito {
   private LocalDate fecha;
   private Integer numero;
   private Estado estado;
   private ComisionMedica origen;
   private ComisionMedica destino;
   // Para poder hacer la composición:
   private List<DetalleRemito> detalleRemito = new ArrayList<>();
   public void crearDetalleRemito(String areaCMCDestino) {
       // Suponiendo que el constructor de DetalleRemito recibe los datos necesarios
       DetalleRemito nuevoDetalleRemito = new DetalleRemito() ;
       this.detalleRemito.add(nuevoDetalleRemito);
   }

   public LocalDate getFecha() {
       return fecha;
   }

   public void setFecha(LocalDate fecha) {
       this.fecha = fecha;
   }

   public Integer getNumero() {
       return numero;
   }

   public void setNumero(Integer numero) {
       this.numero = numero;
   }

   public Estado getEstado() {
       return estado;
   }

   public void setEstado(Estado estado) {
       this.estado = estado;
   }

   public ComisionMedica getDestino() {
       return destino;
   }

   public void setDestino(ComisionMedica destino) {
       this.destino = destino;
   }

   public List<DetalleRemito> getDetalleRemito() {
       // Devuelve una copia de lectura. Si intentan modificarla desde fuera, lanzará una excepción.
       return Collections.unmodifiableList(this.detalleRemito);
   }
   // El set no va porque se llama al metodo de creación para poder crear el Detalle Remito.
   //public void setDetalleRemito(List<DetalleRemito> detalleRemito) {
   //    this.detalleRemito = detalleRemito;
   public ComisionMedica getOrigen() {
       return origen;
   }

   public void setOrigen(ComisionMedica origen) {
       this.origen = origen;
   }
   // actualizarEstadoDoc()
    // buscarDocumentacion()
    // estasGenerado()
    // getDatosRemito()
    // modificarDocumentacionIncluida()
    // mostrarInformacionRemito()
    // new()
    // tenesEstaCMDestino()
    // tenesEstaCMOrigen()
    // tomarDocumentacion()
}
