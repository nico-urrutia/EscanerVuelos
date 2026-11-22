package db;

import java.util.ArrayList;

import domain.Aerolinea;
import domain.Aeropuerto;
import domain.Avion;
import domain.Vuelo;

//Imports para la base de datos
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class GestorBD {
	private static final String SQLITE_FILE = "src/recursos/skyport.db";//base de datos creada con Gemini 4 Neon
    protected static final String CONNECTION_STRING = "jdbc:sqlite:" + SQLITE_FILE;

    
	public boolean cargarAeropuertos(ArrayList<Aeropuerto> aeropuertos) {
		return true;
	}

	public boolean cargarVuelos(ArrayList<Vuelo> vuelos, ArrayList<Aeropuerto> aeropuertos, ArrayList<Aerolinea> aerolineas, ArrayList<Avion> aviones) {
		for (Vuelo v : vuelos) {//Esto antes iba en el main, pero ahora tiene que estar despues de leer los datos de la BD
		    v.getAerolinea().getVuelos().add(v);
		    v.getAeropuertoOrigen().getSalidas().add(v);
		    v.getAeropuertoDestino().getLlegadas().add(v);
		}
		return true;
	}

	public boolean cargarAerolineas(ArrayList<Aerolinea> aerolineas) {
		return true;
	}
	
	public boolean cargarAviones(ArrayList<Avion> aviones) {
		return true;
	}
	
	
}
