package domain;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Objects;

public class Vuelo {
	
	private String codVuelo;
	private int x;
	private int y;
	private float direccion;
	private Aerolinea aerolinea;
	private Avion avion;
	private ArrayList<Pasajero> pasajeros;
	private Aeropuerto aeropuertoOrigen;
	private Aeropuerto aeropuertoDestino;
	private LocalTime horaSalida;
	private LocalTime horaLlegada;
	
	
	public Vuelo(String codVuelo, int x, int y, float direccion, Aerolinea aerolinea, Avion avion, ArrayList<Pasajero> pasajeros, Aeropuerto aeropuertoOrigen, Aeropuerto aeropuertoDestino, LocalTime horaSalida, LocalTime horaLlegada) {
		super();
		this.codVuelo = codVuelo;
		this.x = x;
		this.y = y;
		this.direccion = direccion;
		this.aerolinea = aerolinea;
		this.avion = avion;
		this.pasajeros = pasajeros;
		this.aeropuertoOrigen = aeropuertoOrigen;
		this.aeropuertoDestino = aeropuertoDestino;
		this.horaSalida = horaSalida;
		this.horaLlegada = horaLlegada;
	}
	public String getCodVuelo() {
		return codVuelo;
	}
	public void setCodVuelo(String codVuelo) {
		this.codVuelo = codVuelo;
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
	public float getDireccion() {
		return direccion;
	}
	public void setDireccion(float direccion) {
		this.direccion = direccion;
	}
	public Aerolinea getAerolinea() {
		return aerolinea;
	}
	public void setAerolinea(Aerolinea aerolinea) {
		this.aerolinea = aerolinea;
	}
	public Avion getAvion() {
		return avion;
	}
	public void setAvion(Avion avion) {
		this.avion = avion;
	}
	
	public ArrayList<Pasajero> getPasajeros() {
		return pasajeros;
	}
	
	public void setPasajeros(ArrayList<Pasajero> pasajeros) {
		this.pasajeros = pasajeros;
	}
	
	public Aeropuerto getAeropuertoOrigen() {
		return aeropuertoOrigen;
	}
	
	public void setAeropuertoOrigen(Aeropuerto aeropuertoOrigen) {
		this.aeropuertoOrigen = aeropuertoOrigen;
	}
	
	public Aeropuerto getAeropuertoDestino() {
		return aeropuertoDestino;
	}
	
	public void setAeropuertoDestino(Aeropuerto aeropuertoDestino) {
		this.aeropuertoDestino = aeropuertoDestino;
	}
	
	public LocalTime getHoraSalida() {
		return horaSalida;
	}
	
	public void setHoraSalida(LocalTime horaSalida) {
		this.horaSalida = horaSalida;
	}
	
	public LocalTime getHoraLlegada() {
		return horaLlegada;
	}
	
	public void setHoraLlegada(LocalTime horaLlegada) {
		this.horaLlegada = horaLlegada;
	}
	
	@Override
	public int hashCode() {
	    return Objects.hash(codVuelo);
	}

	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null || getClass() != obj.getClass()) return false;
	    Vuelo other = (Vuelo) obj;
	    return Objects.equals(codVuelo, other.codVuelo);
	}
	
	@Override
	public String toString() {
		return "Vuelo [codVuelo=" + codVuelo + ", x=" + x + ", y=" + y + ", direccion=" + direccion + ", horaSalida=" + horaSalida + ", horaLlegada=" + horaLlegada + "]";

	}
	
	

}
