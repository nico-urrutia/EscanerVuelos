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


//Añadir aeropuertos de origen y destino en el mapa(funcion de conversion de coordenadas a pixeles)


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
		JLabel labelPrincipal = new JLabel("Vuelo: " + codvuelo + ";  Aerlinea: " + aerolinea.getNombre() + 
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
			protected void paintComponent(Graphics g) {//Metodo escrito con ayuda de Gemini 4 Argon.
				super.paintComponent(g);
				if (mapaFinal != null) {
					double mapRatio = (double) mapaFinal.getWidth() / mapaFinal.getHeight();
					double panelRatio = (double) getWidth() / getHeight();
					double mapW, mapH, offsetX = 0, offsetY = 0;

					if (panelRatio > mapRatio) {
						mapH = getHeight();
						mapW = mapH * mapRatio;
						offsetX = (getWidth() - mapW) / 2.0;
					} else {
						mapW = getWidth();
						mapH = mapW / mapRatio;
						offsetY = (getHeight() - mapH) / 2.0;
					}

					Graphics2D g2d = (Graphics2D) g.create();
					g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
					g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

					g2d.drawImage(mapaFinal, (int) Math.round(offsetX), (int) Math.round(offsetY), (int) Math.round(mapW), (int) Math.round(mapH), null);

					int pinSize = 20;
					int pinTipOffsetX = pinSize / 2;
					int pinTipOffsetY = (int) Math.round(pinSize * 0.89);
					int origX = (int) Math.round(offsetX + (vuelo.getAeropuertoOrigen().getX() * mapW / 100.0));
					int origY = (int) Math.round(offsetY + (vuelo.getAeropuertoOrigen().getY() * mapH / 100.0));
					int destX = (int) Math.round(offsetX + (vuelo.getAeropuertoDestino().getX() * mapW / 100.0));
					int destY = (int) Math.round(offsetY + (vuelo.getAeropuertoDestino().getY() * mapH / 100.0));

					g2d.drawImage(aeropuertoFinal, origX - pinTipOffsetX, origY - pinTipOffsetY, pinSize, pinSize, null);
					g2d.drawImage(aeropuertoFinal, destX - pinTipOffsetX, destY - pinTipOffsetY, pinSize, pinSize, null);

					int avionSize = 19;
					int avionHalf = avionSize / 2;
					int avionX = (int) Math.round(offsetX + (vuelo.getX() * mapW / 100.0));
					int avionY = (int) Math.round(offsetY + (vuelo.getY() * mapH / 100.0));

					double dx = destX - origX;
					double dy = destY - origY;
					double angulo = Math.atan2(dy, dx) + Math.PI / 2.0;

					g2d.rotate(angulo, avionX, avionY);
					g2d.drawImage(avionFinal, avionX - avionHalf, avionY - avionHalf, avionSize, avionSize, null);
					g2d.dispose();
				}
			}		
		};
		add(panelTracker, BorderLayout.CENTER);
		
		this.setTitle("Tracker - Vuelo " + vuelo.getCodVuelo());
		this.setSize(1000, 700);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		ImageIcon imagen = new ImageIcon(getClass().getResource("/recursos/logo.png"));
		setIconImage(imagen.getImage());
		this.setVisible(true);
		final class TrackerV extends Thread{
			Vuelo vuelo;
			public TrackerV(Vuelo vuelo) {
				this.vuelo = vuelo;
			}
			@Override
			public void run() {
				double speed = vuelo.getAvion().getSpeed();
				double x = vuelo.getX();
				double y = vuelo.getY();
				double destX = this.vuelo.getAeropuertoDestino().getX();
				double destY = this.vuelo.getAeropuertoDestino().getY();
				double distance = Math.sqrt(Math.pow(destX - x, 2) + Math.pow(destY - y, 2));
				double dX = destX - x;
				double dY = destY - y;
				if(vuelo.isOnLand()) {
					if(vuelo.isHasArrived()) {
						panelTracker.repaint();				
					}else {
						panelTracker.repaint();
					}
				}else{
					while(!vuelo.isOnLand()) {
						x = vuelo.getX();
						y = vuelo.getY();
						dX = destX - x;
						dY = destY - y;
						distance = Math.sqrt(Math.pow(dX, 2) + Math.pow(dY, 2));
						if(distance <= speed) {
							vuelo.setX(destX);
							vuelo.setY(destY);
							vuelo.setOnLand(true);
							vuelo.setHasArrived(true);
							labelSecundario.setText("Avion: " + avion.getModelo() + ";  Posicion: (" + vuelo.getX() + "," + vuelo.getY() + ");  Salida: " + horaSalida.toString() +
									";  Llegada: " + horaLlegada.toString() + ";  Progreso: 100%");
						}else {
							vuelo.setX(x + (dX / distance) * speed);
							vuelo.setY(y + (dY / distance) * speed);
						}
						labelSecundario.setText("Avion: " + avion.getModelo() + ";  Posicion: (" + vuelo.getX() + "," + vuelo.getY() + ");  Salida: " + horaSalida.toString() +
								";  Llegada: " + horaLlegada.toString() + ";  Progreso: " + String.format("%.2f", vuelo.calcularProgreso()) + "%");
						panelTracker.repaint();
						try {
							sleep(1000);//Tracker a tiempo real, para que vaya mas rapido, se pude disminuir el tiempo de sleep.
						} catch (InterruptedException e) {
							panelTracker.repaint();
						}					
					}						
				}				
			}
			
		}
		TrackerV tracker = new TrackerV(vuelo);
		tracker.start();

		


	}


}
