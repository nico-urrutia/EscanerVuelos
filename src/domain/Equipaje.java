package domain;

import java.util.Objects;

public class Equipaje {
	
	private String id;
	private float peso;
	private Pasajero pasajero;
	private Vuelo vuelo;
	
	public Equipaje(String id, float peso, Pasajero pasajero, Vuelo vuelo) {
		super();
		this.id = id;
		this.peso = peso;
		this.pasajero = pasajero;
		this.vuelo = vuelo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public Pasajero getPasajero() {
		return pasajero;
	}

	public void setPasajero(Pasajero pasajero) {
		this.pasajero = pasajero;
	}

	public Vuelo getVuelo() {
		return vuelo;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(id, pasajero, Float.valueOf(peso), vuelo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipaje other = (Equipaje) obj;
		return Objects.equals(id, other.id) && Objects.equals(pasajero, other.pasajero)
				&& Float.floatToIntBits(peso) == Float.floatToIntBits(other.peso) && Objects.equals(vuelo, other.vuelo);
	}

	@Override
	public String toString() {
		return "Equipaje [id=" + id + ", peso=" + peso + ", pasajero=" + pasajero + ", vuelo=" + vuelo + "]";
	}
	
	
	
}
