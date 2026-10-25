package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class VentanaInicial extends JFrame {
	private static final long serialVersionUID = 1L;

	public VentanaInicial() {
		
		setLayout(new BorderLayout());
		
		setTitle("Simulador de Aeropuertos");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
}
