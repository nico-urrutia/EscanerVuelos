package domain;

import java.util.Objects;

public class Asiento {
	
	public enum EnumAsiento {
		PRIMERA_CLASE,
		BUSINESS,
		ECONOMY_PLUS,
		ECONOMY
	}

	public enum EnumLetras {
		A, B, C, D, E, F
	}
	
	private EnumAsiento tipo;
	private EnumLetras letra;
	private int fila;
	private boolean ocupado;
	public Asiento(EnumAsiento tipo, EnumLetras letra, int fila, boolean ocupado) {
		super();
		this.tipo = tipo;
		this.letra = letra;
		this.fila = fila;
		this.ocupado = ocupado;
	}
	public EnumAsiento getTipo() {
		return tipo;
	}
	public void setTipo(EnumAsiento tipo) {
		this.tipo = tipo;
	}
	public EnumLetras getLetra() {
		return letra;
	}
	public void setLetra(EnumLetras letra) {
		this.letra = letra;
	}
	public int getFila() {
		return fila;
	}
	public void setFila(int fila) {
		this.fila = fila;
	}
	public boolean isOcupado() {
		return ocupado;
	}
	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
	@Override
	public int hashCode() {
		return Objects.hash(Integer.valueOf(fila), letra, tipo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Asiento other = (Asiento) obj;
		return fila == other.fila && letra == other.letra && tipo == other.tipo;
	}
	@Override
	public String toString() {
		return "Asiento [tipo=" + tipo + ", letra=" + letra + ", fila=" + fila + ", ocupado=" + ocupado + "]";
	}
	
	
}
