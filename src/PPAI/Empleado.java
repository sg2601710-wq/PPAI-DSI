package PPAI;

public class Empleado {
    private String nombre;
    private String email;
    private String apellido;
    private Rol rol;
    private ComisionMedica asignadoA;
    private Usuario usuario;

    public Empleado(String nombre, String email, String apellido, Rol rol, ComisionMedica asignadoA, Usuario usuario) {
        this.nombre = nombre;
        this.email = email;
        this.apellido = apellido;
        this.rol = rol;
        this.asignadoA = asignadoA;
        this.usuario = usuario;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public ComisionMedica getAsignadoA() {
        return asignadoA;
    }

    public void setAsignadoA(ComisionMedica asignadoA) {
        this.asignadoA = asignadoA;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    // public mostrarCM()
    // public sosGCM()
    // public esTuCM()
    // estaLogueado()
    // esTuUsuario()
}
