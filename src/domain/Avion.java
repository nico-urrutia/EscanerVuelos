package domain;

import java.util.Objects;

public class Avion {
	
	private String matricula;
	private String modelo;
	private int capacidad;
	private Aerolinea aerolinea;
	private Vuelo vuelo;
	private boolean enVuelo;
	public Avion(String matricula, String modelo, int capacidad, Aerolinea aerolinea, Vuelo vuelo, boolean enVuelo) {
		super();
		this.matricula = matricula;
		this.modelo = modelo;
		this.capacidad = capacidad;
		this.aerolinea = aerolinea;
		this.vuelo = vuelo;
		this.enVuelo = enVuelo;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public Aerolinea getAerolinea() {
		return aerolinea;
	}
	public void setAerolinea(Aerolinea aerolinea) {
		this.aerolinea = aerolinea;
	}
	public Vuelo getVuelo() {
		return vuelo;
	}
	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}
	public boolean isEnVuelo() {
		return enVuelo;
	}
	public void setEnVuelo(boolean enVuelo) {
		this.enVuelo = enVuelo;
	}
	
	
	@Override
	public int hashCode() {
	    return Objects.hash(matricula);
	}

	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null || getClass() != obj.getClass()) return false;
	    Avion other = (Avion) obj;
	    return Objects.equals(matricula, other.matricula);
	}
	@Override
	public String toString() {
		return "Avion [matricula=" + matricula + ", modelo=" + modelo + ", capacidad=" + capacidad + ", aerolinea="
				+ aerolinea + ", vuelo=" + vuelo + ", enVuelo=" + enVuelo + "]";
	}
	
	
}
