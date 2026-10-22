package domain;

import java.util.Objects;

public class Pasajero {
	
	private String nombre;
	private String apellido;
	private String pasaporte;
	private Equipaje equipaje;
	private Vuelo vuelo;
	private boolean embarcado;
	private boolean abordo;
	private boolean aterrizado;
	
	public Pasajero(String nombre, String apellido, String pasaporte, Equipaje equipaje, Vuelo vuelo, boolean embarcado,
			boolean abordo, boolean aterrizado) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.pasaporte = pasaporte;
		this.equipaje = equipaje;
		this.vuelo = vuelo;
		this.embarcado = embarcado;
		this.abordo = abordo;
		this.aterrizado = aterrizado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getPasaporte() {
		return pasaporte;
	}

	public void setPasaporte(String pasaporte) {
		this.pasaporte = pasaporte;
	}

	public Equipaje getEquipaje() {
		return equipaje;
	}

	public void setEquipaje(Equipaje equipaje) {
		this.equipaje = equipaje;
	}

	public Vuelo getVuelo() {
		return vuelo;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}

	public boolean isEmbarcado() {
		return embarcado;
	}

	public void setEmbarcado(boolean embarcado) {
		this.embarcado = embarcado;
	}

	public boolean isAbordo() {
		return abordo;
	}

	public void setAbordo(boolean abordo) {
		this.abordo = abordo;
	}

	public boolean isAterrizado() {
		return aterrizado;
	}

	public void setAterrizado(boolean aterrizado) {
		this.aterrizado = aterrizado;
	}
	
	@Override
	public int hashCode() {
	    return Objects.hash(pasaporte);
	}

	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null || getClass() != obj.getClass()) return false;
	    Pasajero other = (Pasajero) obj;
	    return Objects.equals(pasaporte, other.pasaporte);
	}

	@Override
	public String toString() {
		return "Pasajero [nombre=" + nombre + ", apellido=" + apellido + ", pasaporte=" + pasaporte + "]";
	}
	
	
	
}
