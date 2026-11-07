package domain;

import java.util.ArrayList;
import java.util.Objects;

public class Avion {
	
	private String matricula;
	private String modelo;
	private Aerolinea aerolinea;
	private Vuelo vuelo;
	private boolean enVuelo;
	private ArrayList<Asiento> asientos;
	private double speed;
	
	public Avion(String matricula, String modelo, Aerolinea aerolinea, Vuelo vuelo, boolean enVuelo, ArrayList<Asiento> asientos, double speed) {
		super();
		this.matricula = matricula;
		this.modelo = modelo;
		this.aerolinea = aerolinea;
		this.vuelo = vuelo;
		this.enVuelo = enVuelo;
		this.asientos = asientos;
		this.speed = speed;
	}

	public Avion(String matricula, String modelo, Aerolinea aerolinea, Vuelo vuelo, boolean enVuelo, ArrayList<Asiento> asientos) {
		this(matricula, modelo, aerolinea, vuelo, enVuelo, asientos, 0.25);
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
		return asientos.size();
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
	
	public ArrayList<Asiento> getAsientos() {
		return asientos;
	}
	public void setAsientos(ArrayList<Asiento> asientos) {
		this.asientos = asientos;
	}
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
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
		return "Avion [matricula=" + matricula + ", modelo=" + modelo + ", capacidad=" + asientos.size() + ", enVuelo=" + enVuelo + "]";

	}
	
	
}
