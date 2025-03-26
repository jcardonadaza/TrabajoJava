package autonoma.trabajojava.main;

import autonoma.trabajojava.exceptions.AmigoYaRegistradoException;
import autonoma.tranajojava.exceptions.CorreoInvalidoException;
import autonoma.trabajojava.exceptions.TelefonoInvalidoException;
import autonoma.trajajojava.models.Amigo;
import autonoma.trbajojava.models.DirectorioAmigos;

public class DirectorioAmigosApp {
    public static void main(String[] args) {
        // Crear instancia del directorio de amigos
        DirectorioAmigos directorio = new DirectorioAmigos();

        // Crear un nuevo amigo
        try {
            Amigo amigo1 = new Amigo("Juan Pérez", "6060301234", "juanperez@email.com");
            directorio.agregarNuevoAmigo(amigo1);
            System.out.println("Amigo agregado correctamente.");

            // Intentar agregar un amigo con correo duplicado
            Amigo amigo2 = new Amigo("Maria López", "6060305678", "juanperez@email.com");
            directorio.agregarNuevoAmigo(amigo2);  // Esto lanzará una excepción
        } catch (AmigoYaRegistradoException e) {
            System.out.println(e.getMessage());
        } catch (TelefonoInvalidoException e) {
            System.out.println(e.getMessage());
        } catch (CorreoInvalidoException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error inesperado: " + e.getMessage());
        }
    }
}