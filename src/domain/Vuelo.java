package domain;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Objects;

public class Vuelo {
	
	private String codVuelo;
	private double x;
	private double y;
	private float direccion;
	private Aerolinea aerolinea;
	private Avion avion;
	private ArrayList<Pasajero> pasajeros;
	private Aeropuerto aeropuertoOrigen;
	private Aeropuerto aeropuertoDestino;
	private LocalTime horaSalida;
	private LocalTime horaLlegada;
	private boolean isOnLand;
	private boolean hasArrived;
	private EstadoVuelo estado;
	private String puertaEmbarque;
	private String puertaLlegada;

	public Vuelo(String codVuelo, double x, double y, float direccion, Aerolinea aerolinea, Avion avion, ArrayList<Pasajero> pasajeros, Aeropuerto aeropuertoOrigen, Aeropuerto aeropuertoDestino, LocalTime horaSalida, LocalTime horaLlegada, EstadoVuelo estado) {
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
		double dx = aeropuertoDestino.getX() - aeropuertoOrigen.getX();
		double dy = aeropuertoDestino.getY() - aeropuertoOrigen.getY();
		this.direccion = (float) (Math.atan2(dy, dx) + Math.PI / 2);// idea de Gemini 4 Argon.
		this.estado = (estado != null) ? estado : EstadoVuelo.A_TIEMPO;
	}
	public String getCodVuelo() {
		return codVuelo;
	}
	public void setCodVuelo(String codVuelo) {
		this.codVuelo = codVuelo;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
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
	
	public boolean isOnLand() {
		return isOnLand;
	}
	public void setOnLand(boolean isOnLand) {
		this.isOnLand = isOnLand;
	}
	
	public boolean isHasArrived() {
		return hasArrived;
	}
	public void setHasArrived(boolean hasArrived) {
		this.hasArrived = hasArrived;
	}
	
	public EstadoVuelo getEstado() {
		return estado;
	}
	public void setEstado(EstadoVuelo estado) {
		this.estado = estado;
	}
	
	public String getPuertaEmbarque() {
		return puertaEmbarque;
	}
	public void setPuertaEmbarque(String puertaEmbarque) {
		this.puertaEmbarque = puertaEmbarque;
	}
	
	public double calcularProgreso() {
		if (hasArrived) {
			return 100.0;
		}
		double totalX = aeropuertoDestino.getX() - aeropuertoOrigen.getX();
		double totalY = aeropuertoDestino.getY() - aeropuertoOrigen.getY();
		double distanciaTotal = Math.sqrt(Math.pow(totalX, 2) + Math.pow(totalY, 2));

		double restanteX = aeropuertoDestino.getX() - x;
		double restanteY = aeropuertoDestino.getY() - y;
		double distanciaRestante = Math.sqrt(Math.pow(restanteX, 2) + Math.pow(restanteY, 2));

		return (1 - (distanciaRestante / distanciaTotal)) * 100;
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
	public String getPuertaLlegada() {
		return puertaLlegada;
	}
	public void setPuertaLlegada(String puertaLlegada) {
		this.puertaLlegada = puertaLlegada;
	}
	
	
}
