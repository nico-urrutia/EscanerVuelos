package domain;

import java.util.ArrayList;
import java.util.Objects;

public class Aerolinea {
	
	private String nombre;
	private String pais;
	private String codigoIATA;
	private ArrayList<Vuelo> vuelos;
	private ArrayList<Avion> aviones;
	public Aerolinea(String nombre, String pais, String codigoIATA, ArrayList<Vuelo> vuelos, ArrayList<Avion> aviones) {
		super();
		this.nombre = nombre;
		this.pais = pais;
		this.codigoIATA = codigoIATA;
		this.vuelos = vuelos;
		this.aviones = aviones;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getCodigoIATA() {
		return codigoIATA;
	}
	public void setCodigoIATA(String codigoIATA) {
		this.codigoIATA = codigoIATA;
	}
	public ArrayList<Vuelo> getVuelos() {
		return vuelos;
	}
	public void setVuelos(ArrayList<Vuelo> vuelos) {
		this.vuelos = vuelos;
	}
	public ArrayList<Avion> getAviones() {
		return aviones;
	}
	public void setAviones(ArrayList<Avion> aviones) {
		this.aviones = aviones;
	}
	
	@Override
	public int hashCode() {
	    return Objects.hash(codigoIATA);
	}

	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null || getClass() != obj.getClass()) return false;
	    Aerolinea other = (Aerolinea) obj;
	    return Objects.equals(codigoIATA, other.codigoIATA);
	}
	@Override
	public String toString() {
		return "Aerolinea [nombre=" + nombre + ", pais=" + pais + ", codigoIATA=" + codigoIATA + ", vuelos=" + vuelos
				+ ", aviones=" + aviones + "]";
	}
	
	
}
