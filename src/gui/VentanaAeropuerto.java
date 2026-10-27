package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import domain.Aeropuerto;

public class VentanaAeropuerto extends JFrame {

    private static final long serialVersionUID = 1L;

    private final Color azulOscuro = new Color(16, 42, 67);
    private final Color azulClaro = new Color(182, 221, 255);
    private final Color verdeClaro = new Color(185, 242, 220);
    private final Color grisFondo = new Color(244, 247, 251);

    public VentanaAeropuerto(Aeropuerto aeropuerto) {

        // Panel principal
        JPanel principal = new JPanel(new BorderLayout(20, 25));
        principal.setBackground(grisFondo);
        principal.setBorder(new EmptyBorder(20, 25, 25, 25));

        // Cabecera
        JPanel cabecera = new JPanel(new BorderLayout());
        cabecera.setBackground(azulOscuro);
        cabecera.setBorder(new EmptyBorder(15, 20, 15, 20));

        JLabel titulo = new JLabel("AEROPUERTO");
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("Arial", Font.BOLD, 28));
        
        cabecera.add(titulo, BorderLayout.CENTER);

        principal.add(cabecera, BorderLayout.NORTH);

        // Información del aeropuerto
        JPanel informacion = new JPanel(new GridLayout(1, 2, 25, 0));
        informacion.setOpaque(false);

        // Fotografía
        JPanel panelFoto = new JPanel(new BorderLayout());
        panelFoto.setBackground(Color.WHITE);
        panelFoto.setBorder(new LineBorder(
                new Color(210, 220, 230), 1, true));

        JLabel foto = new JLabel(
                "<html><center>Fotografía del<br>"
                + "Aeropuerto de Bilbao</center></html>",
                SwingConstants.CENTER);

        foto.setForeground(azulOscuro);
        foto.setFont(new Font("Arial", Font.BOLD, 20));
        foto.setOpaque(true);
        foto.setBackground(new Color(220, 232, 243));

        // Imagen remota opcional
        try {
            URL url = new URL(
                "https://images.unsplash.com/photo-1436491865332-7a61a109cc05"
                + "?auto=format&fit=crop&w=1000&q=85"
            );

            ImageIcon icono = new ImageIcon(url);
            Image imagen = icono.getImage().getScaledInstance(
                    420, 420, Image.SCALE_SMOOTH);

            foto.setIcon(new ImageIcon(imagen));
            foto.setText("");
        } catch (Exception e) {
            // Se conserva el texto si no se puede cargar la imagen.
        }

        panelFoto.add(foto, BorderLayout.CENTER);
        informacion.add(panelFoto);

        // Datos del aeropuerto
        JPanel datos = new JPanel(new BorderLayout(0, 12));
        datos.setBackground(Color.WHITE);
        datos.setBorder(new EmptyBorder(15, 15, 15, 15));

        JLabel nombre = new JLabel("Aeropuerto de " + aeropuerto.getCiudad());

        nombre.setForeground(azulOscuro);
        nombre.setFont(new Font("Arial", Font.BOLD, 24));

        datos.add(nombre, BorderLayout.NORTH);

        JPanel filas = new JPanel(new GridLayout(0, 1, 0, 4));
        filas.setBackground(Color.WHITE);

        agregarDato(filas, "Codigo IATA", aeropuerto.getCodigoIATA());
        agregarDato(filas, "Nombre", aeropuerto.getNombre());
        agregarDato(filas, "Ciudad", aeropuerto.getCiudad());
        agregarDato(filas, "Pais", aeropuerto.getPais());
        agregarDato(filas, "x", String.valueOf(aeropuerto.getX()));
        agregarDato(filas, "y", String.valueOf(aeropuerto.getY()));
        agregarDato(filas, "Número de pistas", String.valueOf(aeropuerto.getNumPistas()));

        datos.add(filas, BorderLayout.CENTER);
        informacion.add(datos);

        principal.add(informacion, BorderLayout.CENTER);

        // Botones inferiores
        JPanel botones = new JPanel(new GridLayout(1, 2, 25, 0));
        botones.setOpaque(false);
        botones.setPreferredSize(new Dimension(100, 125));

        JButton llegadas = crearBoton(
                "LLEGADAS", azulClaro);

        JButton salidas = crearBoton(
                "SALIDAS", verdeClaro);

        // Más adelante conectaremos estos botones a sus pantallas.
        llegadas.addActionListener(e ->
                javax.swing.JOptionPane.showMessageDialog(
                        this, "Aquí aparecerá la pantalla de llegadas."));

        salidas.addActionListener(e ->
                javax.swing.JOptionPane.showMessageDialog(
                        this, "Aquí aparecerá la pantalla de salidas."));

        botones.add(llegadas);
        botones.add(salidas);

        principal.add(botones, BorderLayout.SOUTH);

        setContentPane(principal);
        setTitle("Aeropuerto de Bilbao");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 750);
        setMinimumSize(new Dimension(850, 600));
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void agregarDato(
            JPanel panel, String etiqueta, String valor) {

        JPanel fila = new JPanel(new BorderLayout(8, 0));
        fila.setBackground(Color.WHITE);
        fila.setBorder(BorderFactory.createMatteBorder(
                0, 0, 1, 0, new Color(225, 232, 240)));

        JLabel texto = new JLabel(etiqueta);
        texto.setFont(new Font("Arial", Font.PLAIN, 14));
        texto.setForeground(azulOscuro);

        JLabel dato = new JLabel(valor, SwingConstants.RIGHT);
        dato.setFont(new Font("Arial", Font.BOLD, 14));
        dato.setForeground(azulOscuro);

        fila.add(texto, BorderLayout.CENTER);
        fila.add(dato, BorderLayout.EAST);

        panel.add(fila);
    }

    private JButton crearBoton(String texto, Color color) {

        JButton boton = new JButton(texto);
        boton.setFont(new Font("Arial", Font.BOLD, 25));
        boton.setForeground(azulOscuro);
        boton.setBackground(color);
        boton.setOpaque(true);
        boton.setBorder(new EmptyBorder(20, 15, 20, 15));
        boton.setFocusPainted(false);
        boton.setCursor(
                new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        return boton;
    }

    public static void main(String[] args) {

        Aeropuerto bio = new Aeropuerto("BIO", "Loiu", "Bilbao", "ES", 120, 80, 1);
                new VentanaAeropuerto(bio);
    }
}
