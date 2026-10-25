package gui;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import domain.Aeropuerto;
import domain.Vuelo;

public class VentanaInicial extends JFrame {
	private static final long serialVersionUID = 1L;
	private ArrayList<Aeropuerto> aeropuertos;
	private ArrayList<Vuelo> vuelos;
	
	

	public VentanaInicial(ArrayList<Aeropuerto> aeropuertos, ArrayList<Vuelo> vuelos) {
		this.aeropuertos=aeropuertos;
		this.vuelos=vuelos;
		
		JPanel panelPrincipal=new JPanel(new BorderLayout());
		JTable tabla=new JTable(new ModeloAeropuerto(aeropuertos));
		JScrollPane scrollPane=new JScrollPane(tabla);
		panelPrincipal.add(scrollPane, BorderLayout.CENTER);
		
		
		
		setContentPane(panelPrincipal);
		setTitle("Simulador de Aeropuertos");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
}
