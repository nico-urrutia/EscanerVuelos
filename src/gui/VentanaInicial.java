package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaInicial extends JFrame {
	private static final long serialVersionUID = 1L;

	public VentanaInicial() {
		
		JPanel panelPrincipal=new JPanel(new BorderLayout());
		
		
		
		setTitle("Simulador de Aeropuertos");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
}
