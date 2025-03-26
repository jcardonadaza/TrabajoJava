
package autonoma.trabajojava.models;

public abstract class Persona {
    private String nombres;
    private String telefono;
    private String correo;

    public Persona(String nombres, String telefono, String correo) {
        this.nombres = nombres;
        this.telefono = telefono;
        this.correo = correo;
    }

    // Métodos getter y setter
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}