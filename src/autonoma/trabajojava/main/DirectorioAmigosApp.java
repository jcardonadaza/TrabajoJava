package autonoma.trabajojava.main;

import autonoma.trabajojava.exceptions.AmigoYaRegistradoException;
import autonoma.trabajojava.exceptions.CorreoInvalidoException;
import autonoma.trabajojava.exceptions.TelefonoInvalidoException;
import autonoma.trabajojava.models.Amigo;
import autonoma.trabajojava.models.DirectorioAmigos;

import java.util.Scanner;

public class DirectorioAmigosApp {
    public static void main(String[] args) {
        // Crear instancia del directorio de amigos
        DirectorioAmigos directorio = new DirectorioAmigos();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al Directorio de Amigos");

        while (true) {
            try {
                // Solicitar datos del usuario
                System.out.print("Ingrese el nombre del amigo: ");
                String nombre = scanner.nextLine();

                System.out.print("Ingrese el teléfono del amigo: ");
                String telefono = scanner.nextLine();

                System.out.print("Ingrese el correo del amigo: ");
                String correo = scanner.nextLine();

                // Crear y agregar el amigo
                Amigo amigo = new Amigo(nombre, telefono, correo);
                directorio.agregarNuevoAmigo(amigo);
                System.out.println("Amigo agregado correctamente.");

            } catch (AmigoYaRegistradoException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (TelefonoInvalidoException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (CorreoInvalidoException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }

            // Preguntar si desea agregar otro amigo
            System.out.print("¿Desea agregar otro amigo? (s/n): ");
            String respuesta = scanner.nextLine();
            if (!respuesta.equalsIgnoreCase("s")) {
                break;
            }
        }

        System.out.println("Gracias por usar el Directorio de Amigos.");
        scanner.close();
    }
}