package gui;
import java.awt.*;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.swing.*;
import domain.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


//añadir aeropuertos de origen y destino en el mapa(funcion de conversion de coordenadas a pixeles)


public class TrackerVuelo extends JFrame {
	private static final long serialVersionUID = 1L;
	Vuelo vuelo;
	//static VentanaInicial ventanaInicial;

	public TrackerVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
		//ventanaInicial = ventanaInicial;
		JPanel informacionVuelo = new JPanel(new BorderLayout());//Panel para mostrar la información del vuelo y el tracker en tiempo real
		String codvuelo = vuelo.getCodVuelo();
		Aerolinea aerolinea = vuelo.getAerolinea();
		Aeropuerto aeropuertoOrigen = vuelo.getAeropuertoOrigen();
		Aeropuerto aeropuertoDestino = vuelo.getAeropuertoDestino();
		JLabel labelPrincipal = new JLabel("Vuelo: " + codvuelo + ";  Aerolinea: " + aerolinea.getNombre() + 
				";  Ruta: " + aeropuertoOrigen.getCodigoIATA() + "-" + aeropuertoDestino.getCodigoIATA());
	    labelPrincipal.setPreferredSize(new Dimension(600, 50));
	    labelPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		add(labelPrincipal, BorderLayout.NORTH);
		
		Avion avion = vuelo.getAvion();
		double x = vuelo.getX();
		double y = vuelo.getY();
		LocalTime horaSalida = vuelo.getHoraSalida();
		LocalTime horaLlegada = vuelo.getHoraLlegada();
		
		JLabel labelSecundario = new JLabel("Avion: " + avion.getModelo() + ";  Posicion: (" + x + "," + y + ");  Salida: " + horaSalida.toString() + ";  Llegada: " + horaLlegada.toString());
	    labelSecundario.setPreferredSize(new Dimension(600, 50));
	    labelSecundario.setHorizontalAlignment(SwingConstants.CENTER);
		add(labelSecundario, BorderLayout.SOUTH);
		BufferedImage imagenMapa, imagenAvion, imagenAeropuerto;
		try {
			imagenMapa = ImageIO.read(new File("src/recursos/mapa.png"));
			imagenAvion = ImageIO.read(new File("src/recursos/avion.png"));
			imagenAeropuerto = ImageIO.read(new File("src/recursos/location.png"));
		} catch (IOException e) {
			imagenMapa = null;
			imagenAvion = null;
			imagenAeropuerto = null;
			e.printStackTrace();
		}
		
	    final BufferedImage mapaFinal = imagenMapa;
	    final BufferedImage avionFinal = imagenAvion;
	    final BufferedImage aeropuertoFinal = imagenAeropuerto;
		JPanel panelTracker = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(mapaFinal, 0, 0, getWidth(), getHeight(), null);
				g.drawImage(avionFinal, (int) (vuelo.getX() * getWidth() / 100), (int) (vuelo.getY() * getHeight() / 100), 30, 30, null);
				g.drawImage(aeropuertoFinal, (int) (vuelo.getAeropuertoOrigen().getX() * getWidth() / 100), (int) (vuelo.getAeropuertoOrigen().getY() * getHeight() / 100), 20, 20, null);
				g.drawImage(aeropuertoFinal, (int) (vuelo.getAeropuertoDestino().getX() * getWidth() / 100), (int) (vuelo.getAeropuertoDestino().getY() * getHeight() / 100), 20, 20, null);
			}		
		};
		add(panelTracker, BorderLayout.CENTER);
		
		this.setTitle("Tracker - Vuelo " + vuelo.getCodVuelo());
		this.setSize(1000, 700);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		if(this.vuelo.isOnLand()) {
			if(this.vuelo.isHasArrived()) {
				//dibujar avion en aeropuerto destino				
			}else {
				//Dibujar avion en aeropuero incial
			}
		}else{
			//Tracker y dibujador en tiempo real
		}

	}


}
