package db;

import java.util.ArrayList;

import domain.Aerolinea;
import domain.Aeropuerto;
import domain.Avion;
import domain.Vuelo;

public class GestorBD {
	private static final String SQLITE_FILE = "resources/skyport.db";
    protected static final String CONNECTION_STRING = "jdbc:sqlite:" + SQLITE_FILE;

    
	public boolean cargarAeropuertos(ArrayList<Aeropuerto> aeropuertos) {
		return true;
	}

	public boolean cargarVuelos(ArrayList<Vuelo> vuelos) {
		return true;
	}

	public boolean cargarAerolineas(ArrayList<Aerolinea> aerolineas) {
		return true;
	}
	
	public boolean cargarAviones(ArrayList<Avion> aviones) {
		return true;
	}
	
	
}
