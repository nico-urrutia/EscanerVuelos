package gui;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import domain.Vuelo;

public class ModeloVuelo extends DefaultTableModel {
	
	private String[] columnas= {"codigoVuelo","origen","destino","horaSalida","horaLlegada","estado"};
	private List<Vuelo> vuelos;
	
	public ModeloVuelo(List<Vuelo> vuelos) {
		this.vuelos = vuelos;
	}
	
	public int getRowCount() {
		if (vuelos == null) {
			return 0;
		}else {
		return vuelos.size();
		}
	}
	
	public int getColumnCount() {
		return columnas.length;
	}
	
	public boolean isCellEditable(int row, int column) {
		return false;
	}
	
	public String getColumnName(int column) {
		return this.columnas[column];	
	}
	
	public Object getValueAt(int row, int column) {
		Vuelo vuelo = vuelos.get(row);
		switch(column) {
			case 0: return vuelo.getCodVuelo();
			case 1: return vuelo.getAeropuertoOrigen().getCodigoIATA();
			case 2: return vuelo.getAeropuertoDestino().getCodigoIATA();
			case 3: return vuelo.getHoraSalida();
			case 4: return vuelo.getHoraLlegada();
			case 5: if(vuelo.getAvion() != null) {
				return vuelo.getAvion().isEnVuelo();
			}else {
				return false;
			}	
			default: return null;
		}
	}
	
}
