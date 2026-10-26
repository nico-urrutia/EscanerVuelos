package gui;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import domain.Vuelo;

public class PantallaAeropuerto {
	private String[] columnas = {"time","destination", "code", "gate","remark"};
	private List<Vuelo> vuelos;
	private TipoInformacion tipoInfo;
	
	//Constructor
	public PantallaAeropuerto(List<Vuelo> vuelos, TipoInformacion tipoInfo) {
		this.vuelos = vuelos;
		this.tipoInfo = tipoInfo;
		panelPrincipal.add(titulo, BorderLayout.NORTH);
		titulo.setIcon(new ImageIcon("recursos/avion.png"));
	}
	
	//Declaración del panel y componentes
	JPanel panelPrincipal = new JPanel(new BorderLayout());
	JLabel titulo = new JLabel(tipoInfo.name());
}
