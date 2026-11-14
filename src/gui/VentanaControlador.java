package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import domain.Aerolinea;
import domain.Aeropuerto;
import domain.EstadoVuelo;
import domain.Vuelo;

public class VentanaControlador extends JFrame {
    private static final long serialVersionUID = 1L;

    private Aeropuerto aeropuerto;
    private JTable tabla;
    private JComboBox<String> comboTipo;

    public VentanaControlador(Aeropuerto aeropuerto) {
        this.aeropuerto = aeropuerto;

        // Arriba: título y combo Salidas/Llegadas
        JLabel titulo = new JLabel("CONTROL AÉREO - " + aeropuerto.getNombre()
                + " (" + aeropuerto.getCodigoIATA() + ")", JLabel.CENTER);
        titulo.setFont(new Font("SansSerif", Font.BOLD, 20));

        comboTipo = new JComboBox<>(new String[] { "Salidas", "Llegadas" });

        JPanel panelNorte = new JPanel(new BorderLayout());
        panelNorte.add(titulo, BorderLayout.NORTH);
        JPanel panelCombo = new JPanel();
        panelCombo.add(new JLabel("Ver:"));
        panelCombo.add(comboTipo);
        panelNorte.add(panelCombo, BorderLayout.CENTER);

        // Centro: tabla
        tabla = new JTable();

        // Abajo: botones
        JButton botonATiempo = new JButton("A tiempo");
        JButton botonRetrasado = new JButton("Retrasado");
        JButton botonCancelado = new JButton("Cancelado");
        JButton botonPuerta = new JButton("Asignar puerta");

        JPanel panelBotones = new JPanel();
        panelBotones.add(botonATiempo);
        panelBotones.add(botonRetrasado);
        panelBotones.add(botonCancelado);
        panelBotones.add(botonPuerta);

        // Listeners
        comboTipo.addActionListener(e -> cargarTabla());
        botonATiempo.addActionListener(e -> cambiarEstado(EstadoVuelo.A_TIEMPO));
        botonRetrasado.addActionListener(e -> cambiarEstado(EstadoVuelo.RETRASADO));
        botonCancelado.addActionListener(e -> cambiarEstado(EstadoVuelo.CANCELADO));
        botonPuerta.addActionListener(e -> asignarPuerta());

        add(panelNorte, BorderLayout.NORTH);
        add(new JScrollPane(tabla), BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        cargarTabla();

        setTitle("Controlador aéreo - " + aeropuerto.getCiudad());
        setSize(900, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        Aeropuerto bio = new Aeropuerto("BIO", "Loiu", "Bilbao", "ES", 45.6, 27.8, 1);
        Aeropuerto mad = new Aeropuerto("MAD", "Adolfo Suárez Madrid-Barajas", "Madrid", "ES", 45.3, 29.6, 4);
        Aeropuerto bcn = new Aeropuerto("BCN", "Josep Tarradellas", "Barcelona", "ES", 46.9, 28.8, 3);
        Aeropuerto lhr = new Aeropuerto("LHR", "Heathrow", "Londres", "GB", 46.5, 21.8, 5);

        Aerolinea ib = new Aerolinea("Iberia", "ES", "IB", new ArrayList<>(), new ArrayList<>());
        Aerolinea vy = new Aerolinea("Vueling", "ES", "VY", new ArrayList<>(), new ArrayList<>());
        Aerolinea ba = new Aerolinea("British Airways", "GB", "BA", new ArrayList<>(), new ArrayList<>());

        // Llegadas a Bilbao
        Vuelo v1 = new Vuelo("IB3214", 45.3, 29.6, 0f, ib, null, new ArrayList<>(),
                mad, bio, LocalTime.of(7, 0), LocalTime.of(8, 5), null);
        Vuelo v2 = new Vuelo("VY1002", 46.9, 28.8, 0f, vy, null, new ArrayList<>(),
                bcn, bio, LocalTime.of(10, 30), LocalTime.of(11, 25), null);
        Vuelo v3 = new Vuelo("BA0462", 46.5, 21.8, 0f, ba, null, new ArrayList<>(),
                lhr, bio, LocalTime.of(13, 15), LocalTime.of(15, 40), null);

        // Salidas de Bilbao
        Vuelo v4 = new Vuelo("IB3215", 45.6, 27.8, 0f, ib, null, new ArrayList<>(),
                bio, mad, LocalTime.of(9, 0), LocalTime.of(10, 5), null);
        Vuelo v5 = new Vuelo("VY1003", 45.6, 27.8, 0f, vy, null, new ArrayList<>(),
                bio, bcn, LocalTime.of(12, 0), LocalTime.of(13, 0), null);
        Vuelo v6 = new Vuelo("BA0463", 45.6, 27.8, 0f, ba, null, new ArrayList<>(),
                bio, lhr, LocalTime.of(16, 45), LocalTime.of(19, 10), EstadoVuelo.RETRASADO);

        bio.getLlegadas().add(v1);
        bio.getLlegadas().add(v2);
        bio.getLlegadas().add(v3);

        bio.getSalidas().add(v4);
        bio.getSalidas().add(v5);
        bio.getSalidas().add(v6);

        new VentanaControlador(bio);
    }

    private boolean verSalidas() {
        return "Salidas".equals(comboTipo.getSelectedItem());
    }

    private void cargarTabla() {
    	    ArrayList<Vuelo> lista;
    	    if (verSalidas()) {
    	        lista = aeropuerto.getSalidas();
    	    } else {
    	        lista = aeropuerto.getLlegadas();
    	    }
    	    tabla.setModel(new ModeloControlador(lista));
    }

    // Devuelve el vuelo seleccionado, o null si no hay ninguno
    private Vuelo vueloSeleccionado() {
        int fila = tabla.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Selecciona un vuelo primero");
            return null;
        }
        return ((ModeloVuelo) tabla.getModel()).getVuelo(fila);
    }

    private void cambiarEstado(EstadoVuelo nuevoEstado) {
        Vuelo v = vueloSeleccionado();
        if (v == null) return;
        v.setEstado(nuevoEstado);
        cargarTabla();
    }

    private void asignarPuerta() {
        Vuelo v = vueloSeleccionado();
        if (v == null) return;

        String puerta;
        if (verSalidas()) {
            puerta = aeropuerto.asignarPuerta(v);
        } else {
            puerta = aeropuerto.asignarPuertaLlegada(v);
        }

        if (puerta == null) {
            JOptionPane.showMessageDialog(this, "No quedan puertas libres");
        } else {
            JOptionPane.showMessageDialog(this, "Vuelo " + v.getCodVuelo() + " → puerta " + puerta);
        }
    }
}