package domain;

public enum EstadoVuelo {
	A_TIEMPO("A tiempo"),
	RETRASADO("Retrasado"),
	CANCELADO("Cancelado");
	
	private final String texto;
	
	EstadoVuelo(String texto){
		this.texto = texto;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return texto;
	}
}
