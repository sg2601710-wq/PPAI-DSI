package PPAI;

public class Localidad {
    private String descripcion;
    private String nombre;
    private Provincia provincia;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public Localidad(String descripcion, Provincia provincia, String nombre) {
        this.descripcion = descripcion;
        this.provincia = provincia;
        this.nombre = nombre;
    }
}
