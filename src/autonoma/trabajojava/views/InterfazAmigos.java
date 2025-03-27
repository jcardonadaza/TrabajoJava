package autonoma.trabajojava.views;

import autonoma.trabajojava.models.Amigo;
import autonoma.trabajojava.models.DirectorioAmigos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfazAmigos extends JFrame {

    private DirectorioAmigos directorio;
    private JTextField tfNombre, tfTelefono, tfCorreo;
    private JTextField tfBuscarCorreo;
    private JTextArea taInformacion;
    private JButton btnAgregar, btnBuscar, btnVerInfo, btnSalir;

    public InterfazAmigos() {
        directorio = new DirectorioAmigos();

        // Configuración de la ventana
        setTitle("Directorio de Amigos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana
        setLayout(new FlowLayout());

        // Colores para la interfaz
        Color colorFondo = new Color(255, 255, 204); // Amarillo pastel
        Color colorTexto = new Color(33, 33, 33); // Gris oscuro
        Color colorAgregar = new Color(76, 175, 80); // Verde
        Color colorBuscar = new Color(33, 150, 243); // Azul
        Color colorVerInfo = new Color(255, 193, 7); // Amarillo oscuro
        Color colorSalir = new Color(244, 67, 54); // Rojo

        getContentPane().setBackground(colorFondo);

        // Campos de texto
        tfNombre = new JTextField(20);
        tfTelefono = new JTextField(20);
        tfCorreo = new JTextField(20);
        tfBuscarCorreo = new JTextField(20);

        // Área de texto para mostrar información
        taInformacion = new JTextArea(5, 30);
        taInformacion.setEditable(false);
        taInformacion.setBackground(Color.LIGHT_GRAY);
        taInformacion.setForeground(colorTexto);

        // Botones
        btnAgregar = new JButton("Agregar Amigo");
        btnBuscar = new JButton("Buscar Amigo");
        btnVerInfo = new JButton("Ver Información");
        btnSalir = new JButton("Salir");

        // Estilo de los botones
        btnAgregar.setBackground(colorAgregar);
        btnAgregar.setForeground(Color.BLACK); // Letras negras
        btnBuscar.setBackground(colorBuscar);
        btnBuscar.setForeground(Color.BLACK); // Letras negras
        btnVerInfo.setBackground(colorVerInfo);
        btnVerInfo.setForeground(Color.BLACK); // Letras negras
        btnSalir.setBackground(colorSalir);
        btnSalir.setForeground(Color.BLACK); // Letras negras

        // Agregar los componentes a la ventana
        add(new JLabel("Nombre:"));
        add(tfNombre);
        add(new JLabel("Teléfono:"));
        add(tfTelefono);
        add(new JLabel("Correo:"));
        add(tfCorreo);
        add(btnAgregar);

        add(new JLabel("Buscar por correo:"));
        add(tfBuscarCorreo);
        add(btnBuscar);

        add(btnVerInfo);
        add(taInformacion);
        add(btnSalir);

        // Eventos de los botones
        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Amigo amigo = new Amigo(tfNombre.getText(), tfTelefono.getText(), tfCorreo.getText());
                    directorio.agregarNuevoAmigo(amigo);
                    taInformacion.setText("Amigo agregado correctamente.");

                    // Limpiar los campos de texto después de agregar un amigo
                    tfNombre.setText("");
                    tfTelefono.setText("");
                    tfCorreo.setText("");
                } catch (Exception ex) {
                    taInformacion.setText("Error: " + ex.getMessage());
                }
            }
        });

        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Amigo amigo = directorio.buscarAmigoPorCorreo(tfBuscarCorreo.getText());
                    taInformacion.setText("Amigo encontrado: " + amigo.getNombres() + "\nTeléfono: " + amigo.getTelefono());
                } catch (Exception ex) {
                    taInformacion.setText("Error: " + ex.getMessage());
                }
            }
        });

        btnVerInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                taInformacion.setText("Aplicacion de gestion de amigos.\nVersión 1.0\nDesarrollado por: \nJuan Jose Cardona\nAlejandro Giraldo Pareja");
            }
        });

        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Cierra la aplicación
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                InterfazAmigos ventana = new InterfazAmigos();
                ventana.setVisible(true);
            }
        });
    }
}