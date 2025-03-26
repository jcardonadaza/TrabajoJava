package autonoma.trabajojava.models;

import autonoma.proyectojava.exceptions.AmigoNoEncontradoException;
import autonoma.proyectojava.exceptions.AmigoYaRegistradoException;

import java.util.ArrayList;
import java.util.List;

public class DirectorioAmigos {
    private List<Amigo> listaAmigos;

    public DirectorioAmigos() {
        this.listaAmigos = new ArrayList<>();
    }

    // Método para agregar un nuevo amigo
    public void agregarNuevoAmigo(Amigo amigo) {
        if (validarAmigoDuplicado(amigo.getCorreo())) {
            throw new AmigoYaRegistradoException("El amigo con ese correo ya está registrado.");
        }

        amigo.agregarAmigo(); // Validamos el teléfono y correo al agregar
        listaAmigos.add(amigo);
    }

    // Método para buscar un amigo por correo
    public Amigo buscarAmigoPorCorreo(String correo) {
        for (Amigo amigo : listaAmigos) {
            if (amigo.getCorreo().equals(correo)) {
                return amigo;
            }
        }
        throw new AmigoNoEncontradoException("No se encontró un amigo con ese correo.");
    }

    // Método para validar si un amigo ya está registrado por correo
    private boolean validarAmigoDuplicado(String correo) {
        for (Amigo amigo : listaAmigos) {
            if (amigo.getCorreo().equals(correo)) {
                return true;
            }
        }
        return false;
    }

    // Método para ver información sobre la aplicación
    public void verAcerca() {
        System.out.println("Aplicación de gestión de amigos. Versión 1.0");
        System.out.println("Desarrollado por: Tu Nombre");
    }
}







