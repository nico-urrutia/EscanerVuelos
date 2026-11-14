package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

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
        tabla.setRowHeight(36);
        tabla.setShowVerticalLines(false);
        
        tabla.getTableHeader().setDefaultRenderer((table, value, isSelected, hasFocus, row, column) -> {
            JLabel cabecera = new JLabel(value.toString(), JLabel.CENTER);
            cabecera.setOpaque(true);
            cabecera.setBackground(new Color(16, 42, 67));
            cabecera.setForeground(Color.WHITE);
            cabecera.setFont(cabecera.getFont().deriveFont(Font.BOLD));
            cabecera.setPreferredSize(new Dimension(0, 34));
            return cabecera;
        });

        TableCellRenderer renderer = (table, value, isSelected, hasFocus, row, column) -> {

            // 1. Color de fondo de la fila: pares y impares distintos
            Color fondoFila;
            if (row % 2 == 0) {
                fondoFila = Color.WHITE;
            } else {
                fondoFila = new Color(232, 240, 252);
            }
            if (isSelected) {
                fondoFila = new Color(180, 205, 240);
            }

            JPanel celda = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 4));
            celda.setBackground(fondoFila);

            JLabel label = new JLabel();
            label.setHorizontalAlignment(JLabel.CENTER);
            label.setForeground(new Color(30, 41, 59));
            if (value != null) {
                label.setText(value.toString());
            }

            if (column == 5) {
                // ESTADO: etiqueta con fondo y letra de colores según el estado
                label.setOpaque(true);
                label.setFont(label.getFont().deriveFont(Font.BOLD));
                label.setBorder(BorderFactory.createEmptyBorder(4, 14, 4, 14));

                if (value == EstadoVuelo.A_TIEMPO) {
                    label.setBackground(new Color(198, 239, 206));   // verde claro
                    label.setForeground(new Color(0, 97, 0));        // verde oscuro
                } else if (value == EstadoVuelo.RETRASADO) {
                    label.setBackground(new Color(255, 224, 178));   // naranja claro
                    label.setForeground(new Color(191, 87, 0));      // naranja oscuro
                } else if (value == EstadoVuelo.CANCELADO) {
                    label.setBackground(new Color(255, 199, 206));   // rojo claro
                    label.setForeground(new Color(156, 0, 6));       // rojo oscuro
                }

            } else if (column == 6) {
                // PUERTA
                if ("-".equals(value)) {
                    label.setForeground(Color.GRAY);
                } else {
                    label.setOpaque(true);
                    label.setBackground(new Color(16, 42, 67));      // azul oscuro
                    label.setForeground(Color.WHITE);
                    label.setFont(new Font("Monospaced", Font.BOLD, 14));
                    label.setBorder(BorderFactory.createEmptyBorder(4, 16, 4, 16));  //Con ayuda de la IA
                }
            }

            celda.add(label);
            return celda;
        };
        tabla.setDefaultRenderer(Object.class, renderer);

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
        ImageIcon imagen = new ImageIcon(getClass().getResource("/recursos/logo.png"));
		setIconImage(imagen.getImage());
        setVisible(true);
        
    }

    private boolean verSalidas() {
        return "Salidas".equals(comboTipo.getSelectedItem());	//Con ayuda de la IA
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
        if (nuevoEstado == EstadoVuelo.CANCELADO) {
            aeropuerto.liberarPuerta(v);
            aeropuerto.liberarPuertaLlegada(v);
        }
        cargarTabla();
    }

    private void asignarPuerta() {
        Vuelo v = vueloSeleccionado();
        if (v == null) return;

        if (v.getEstado() == EstadoVuelo.CANCELADO) {
            JOptionPane.showMessageDialog(this, "El vuelo " + v.getCodVuelo()
                    + " está cancelado, no se le puede asignar puerta");
            return;
        }

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