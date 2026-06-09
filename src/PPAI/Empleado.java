package PPAI;

public class Empleado {
    private String nombre;
    private String email;
    private String apellido;
    private Rol rol;
    private ComisionMedica comisionMedica;

    public Empleado(ComisionMedica comisionMedica, Rol rol, String apellido, String nombre, String email) {
        this.comisionMedica = comisionMedica;
        this.rol = rol;
        this.apellido = apellido;
        this.nombre = nombre;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ComisionMedica getComisionMedica() {
        return comisionMedica;
    }

    public void setComisionMedica(ComisionMedica comisionMedica) {
        this.comisionMedica = comisionMedica;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    // public mostrarCM()
    // public sosGCM()
    // public esTuCM()
}
