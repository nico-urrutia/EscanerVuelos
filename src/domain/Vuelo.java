package domain;

import java.util.Objects;

public class Vuelo {
	private String codVuelo;
	private int x;
	private int y;
	private float direccion;
	private boolean volando;
	private Aerolinea aerolinea;
	private Avion avion;
	public Vuelo(String codVuelo, int x, int y, float direccion, boolean volando, Aerolinea aerolinea, Avion avion) {
		super();
		this.codVuelo = codVuelo;
		this.x = x;
		this.y = y;
		this.direccion = direccion;
		this.volando = volando;
		this.aerolinea = aerolinea;
		this.avion = avion;
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
	public boolean isVolando() {
		return volando;
	}
	public void setVolando(boolean volando) {
		this.volando = volando;
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
	
	
	@Override
	public int hashCode() {
		return Objects.hash(aerolinea, avion, codVuelo, Float.valueOf(direccion), Boolean.valueOf(volando),
				Integer.valueOf(x), Integer.valueOf(y));
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vuelo other = (Vuelo) obj;
		return Objects.equals(aerolinea, other.aerolinea) && Objects.equals(avion, other.avion)
				&& Objects.equals(codVuelo, other.codVuelo)
				&& Float.floatToIntBits(direccion) == Float.floatToIntBits(other.direccion) && volando == other.volando
				&& x == other.x && y == other.y;
	}
	@Override
	public String toString() {
		return "Vuelo [codVuelo=" + codVuelo + ", x=" + x + ", y=" + y + ", direccion=" + direccion + ", volando="
				+ volando + ", aerolinea=" + aerolinea + ", avion=" + avion + "]";
	}
	
	
	

}
