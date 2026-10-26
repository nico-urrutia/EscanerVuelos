package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import domain.Aeropuerto;
import domain.Vuelo;

public class VentanaInicial extends JFrame {
	private static final long serialVersionUID = 1L;
	private ArrayList<Aeropuerto> aeropuertos;
	private ArrayList<Vuelo> vuelos;
	private JTable tabla;

	public VentanaInicial(ArrayList<Aeropuerto> aeropuertos, ArrayList<Vuelo> vuelos) {
		this.aeropuertos = aeropuertos;
		this.vuelos = vuelos;

		JPanel panelPrincipal = new JPanel(new BorderLayout());

		// ---------- NORTH: cabecera con logo y título ----------
		JPanel panelTitulo = new JPanel(new FlowLayout(FlowLayout.CENTER));

		URL url = getClass().getResource("/recursos/logo.png");
		if (url != null) {
			ImageIcon icono = new ImageIcon(url);
			Image img = icono.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);		//Utilizacion de IA para escalar y ajustar la imagen 
			panelTitulo.add(new JLabel(new ImageIcon(img)));
		} else {
			System.err.println("No se encuentra la imagen /recursos/logo.png");
		}

		JLabel titulo = new JLabel("SKYPORT OPERATIONS", JLabel.CENTER);
		titulo.setFont(new Font("SansSerif", Font.BOLD, 20));
		panelTitulo.add(titulo);

		panelPrincipal.add(panelTitulo, BorderLayout.NORTH);

		// ---------- CENTER: búsqueda arriba, tabla abajo ----------
		JPanel panelCentro = new JPanel(new GridLayout(2, 1));

		JPanel panelBusqueda = new JPanel(); 
		panelCentro.add(panelBusqueda);

		tabla = new JTable(new ModeloAeropuerto(aeropuertos));
		panelCentro.add(new JScrollPane(tabla));

		panelPrincipal.add(panelCentro, BorderLayout.CENTER);

		// ---------- Ventana ----------
		setContentPane(panelPrincipal);
		setTitle("Simulador de Aeropuertos");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
}