package domain;

import java.util.Objects;

public class Pasajero {
	
	public enum EstadoPasajero { EN_TERMINAL, EMBARCADO, A_BORDO, ATERRIZADO }
	
	private String nombre;
	private String apellido;
	private String pasaporte;
	private Equipaje equipaje;
	private Vuelo vuelo;
	private EstadoPasajero estado;
	
	public Pasajero(String nombre, String apellido, String pasaporte, Equipaje equipaje, Vuelo vuelo, EstadoPasajero estado) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.pasaporte = pasaporte;
		this.equipaje = equipaje;
		this.vuelo = vuelo;
		this.estado = estado;
		
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

	public EstadoPasajero getEstado() {
		return estado;
	}
	
	public void setEstado(EstadoPasajero estado) {
		this.estado = estado;
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
