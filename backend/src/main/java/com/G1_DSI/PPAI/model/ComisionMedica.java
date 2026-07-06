package PPAI;

public class ComisionMedica {
    private Integer codigo;
    private String direccion;
    private String email;
    private String nombre;
    private Integer telefono;
    private Localidad localidad;

    public ComisionMedica(Integer codigo, String direccion, String email, String nombre, Integer telefono, Localidad localidad) {
        this.codigo = codigo;
        this.direccion = direccion;
        this.email = email;
        this.nombre = nombre;
        this.telefono = telefono;
        this.localidad = localidad;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
