package gui;

import javax.swing.*;

import domain.Aeropuerto;
public class SeleccionarPantallaAeropuerto extends JFrame{
	private static final long serialVersionUID = 1L;
	Aeropuerto aeropuerto;
	public SeleccionarPantallaAeropuerto(Aeropuerto aeropuerto) {
		this.aeropuerto = aeropuerto;
		 String[] opciones = {"Usuario", "Controlador aéreo"};	        
	     int seleccion = JOptionPane.showOptionDialog(
	            this,                                           
	            "¿Cómo deseas acceder al aeropuerto?",         
	            "Tipo de Acceso",                              
	            JOptionPane.DEFAULT_OPTION,                     
	            JOptionPane.QUESTION_MESSAGE,                   
	            null,                                          
	            opciones,
	            null
	        );
	        if (seleccion == 0) {
	        	new VentanaAeropuerto(aeropuerto);
	        } else if (seleccion == 1) {
	        	new LoginControlador(aeropuerto).setVisible(true);;	        	 
	        }
	}

}