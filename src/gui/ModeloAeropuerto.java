package gui;
//------------------------------------------------------------------
import java.util.List;

import javax.swing.table.DefaultTableModel;

import domain.Aeropuerto;

public class ModeloAeropuerto extends DefaultTableModel {
	
	private List<Aeropuerto> aeropuertos;
	private final String[] columnas= {"codigoIATA","nombre","ciudad","pais","x","y","numPistas"};
	
	public ModeloAeropuerto(List<Aeropuerto> aeropuertos) {
		this.aeropuertos=aeropuertos;
	}
	
	
	public int getRowCount() {
		if (aeropuertos == null) {
			return 0;
		}else {
			return aeropuertos.size();
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
		Aeropuerto aeropuerto = aeropuertos.get(row);
		switch(column) {
			case 0: return aeropuerto.getCodigoIATA();
			case 1: return aeropuerto.getNombre();
			case 2: return aeropuerto.getCiudad();
			case 3: return aeropuerto.getPais();
			case 4: return aeropuerto.getX();
			case 5: return aeropuerto.getY();
			case 6: return aeropuerto.getNumPistas();
			default: return null;
		}
	}
	
	public Aeropuerto getAeropuerto(int fila) {
	    return aeropuertos.get(fila);
	}
	
	
}
