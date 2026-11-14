package gui;

import java.util.List;

import domain.Vuelo;

public class ModeloControlador extends ModeloVuelo {
    private static final long serialVersionUID = 1L;

    private String[] columnasControl = { "Vuelo", "Origen", "Destino",
            "Hora de salida", "Hora de llegada", "Estado", "Puerta" };
    private List<Vuelo> listaVuelos;

    public ModeloControlador(List<Vuelo> vuelos) {
        super(vuelos);
        this.listaVuelos = vuelos;
    }

    @Override
    public int getColumnCount() {
        return columnasControl.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnasControl[column];
    }

    @Override
    public Object getValueAt(int row, int column) {
        Vuelo vuelo = listaVuelos.get(row);
        switch (column) {
            case 0: return vuelo.getCodVuelo();
            case 1: return vuelo.getAeropuertoOrigen().getCodigoIATA();
            case 2: return vuelo.getAeropuertoDestino().getCodigoIATA();
            case 3: return vuelo.getHoraSalida();
            case 4: return vuelo.getHoraLlegada();
            case 5: return vuelo.getEstado();
            case 6:
                if (vuelo.getPuertaEmbarque() != null) {
                    return vuelo.getPuertaEmbarque();
                }
                if (vuelo.getPuertaLlegada() != null) {
                    return vuelo.getPuertaLlegada();
                }
                return "-";
            default: return null;
        }
    }
}