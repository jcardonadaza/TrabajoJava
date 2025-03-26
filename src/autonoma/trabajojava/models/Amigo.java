package autonoma.trabajojava.models;

<<<<<<< HEAD

=======
>>>>>>> 4808791b45cb41e4b0dc7398fddea521f0d0f7e4
import autonoma.trabajojava.exceptions.CorreoInvalidoException;
import autonoma.trabajojava.exceptions.TelefonoInvalidoException;

public class Amigo extends Persona {

    public Amigo(String nombres, String telefono, String correo) {
        super(nombres, telefono, correo);
    }

    // Método para agregar un amigo
    public void agregarAmigo() {
        if (!validarTelefono()) {
            throw new TelefonoInvalidoException("El teléfono no es válido. Debe comenzar con 606030.");
        }
        if (!validarCorreo()) {
            throw new CorreoInvalidoException("El correo debe contener una arroba '@'.");
        }
    }

    // Validación de teléfono
    public boolean validarTelefono() {
        return getTelefono().startsWith("606030");
    }

    // Validación de correo
    public boolean validarCorreo() {
        return getCorreo().indexOf('@') > 0;
    }
<<<<<<< HEAD
}


=======
}
>>>>>>> 4808791b45cb41e4b0dc7398fddea521f0d0f7e4
