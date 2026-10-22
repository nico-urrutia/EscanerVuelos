package domain;

import java.util.ArrayList;
import java.util.Objects;

public class Aeropuerto {

	private String codigoIATA;
	private String nombre;
	private String ciudad;
	private String pais;
	private int x;
	private int y;
	private int numPistas;
	private ArrayList<Vuelo> salidas;
	private ArrayList<Vuelo> llegadas;
	private ArrayList<Avion> avionesEnTierra;

	public Aeropuerto(String codigoIATA, String nombre, String ciudad, String pais, int x, int y, int numPistas) {
		this.codigoIATA = codigoIATA;
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.pais = pais;
		this.x = x;
		this.y = y;
		this.numPistas = numPistas;
		this.salidas = new ArrayList<>();
		this.llegadas = new ArrayList<>();
		this.avionesEnTierra = new ArrayList<>();
	}

	public String getCodigoIATA() {
		return codigoIATA;
	}

	public void setCodigoIATA(String codigoIATA) {
		this.codigoIATA = codigoIATA;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getNumPistas() {
		return numPistas;
	}

	public void setNumPistas(int numPistas) {
		this.numPistas = numPistas;
	}

	public ArrayList<Vuelo> getSalidas() {
		return salidas;
	}

	public void setSalidas(ArrayList<Vuelo> salidas) {
		this.salidas = salidas;
	}

	public ArrayList<Vuelo> getLlegadas() {
		return llegadas;
	}

	public void setLlegadas(ArrayList<Vuelo> llegadas) {
		this.llegadas = llegadas;
	}

	public ArrayList<Avion> getAvionesEnTierra() {
		return avionesEnTierra;
	}

	public void setAvionesEnTierra(ArrayList<Avion> avionesEnTierra) {
		this.avionesEnTierra = avionesEnTierra;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoIATA);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aeropuerto other = (Aeropuerto) obj;
		return Objects.equals(codigoIATA, other.codigoIATA);
	}

	@Override
	public String toString() {
		return "Aeropuerto [codigoIATA=" + codigoIATA + ", nombre=" + nombre + ", ciudad=" + ciudad + ", pais=" + pais
				+ ", x=" + x + ", y=" + y + ", numPistas=" + numPistas + ", salidas=" + salidas.size() + ", llegadas="
				+ llegadas.size() + ", avionesEnTierra=" + avionesEnTierra.size() + "]";
	}
	
	
	
	
	
}