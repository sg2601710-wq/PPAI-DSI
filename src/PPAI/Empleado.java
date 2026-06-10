package PPAI;

public class Empleado {
    private String nombre;
    private String email;
    private String apellido;
    private Rol rol;
    private ComisionMedica asignadoA;

    public Empleado(String nombre, String apellido, String email, Rol rol, ComisionMedica asignadoA) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.rol = rol;
        this.asignadoA = asignadoA;
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
    // public mostrarCM()
    // public sosGCM()
    // public esTuCM()
}
