package gui;

import java.util.List;

import domain.Vuelo;

public class ModeloControlador extends ModeloVuelo {
    private static final long serialVersionUID = 1L;

    private String[] columnasControl = { "Vuelo", "Origen", "Destino",
            "Hora de salida", "Hora de llegada", "Estado", "Puerta" };
    private List<Vuelo> listaVuelos;

    private boolean salidas;

    public ModeloControlador(List<Vuelo> vuelos, boolean salidas) {
        super(vuelos);
        this.listaVuelos = vuelos;
        this.salidas = salidas;
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
            case 6: {
                String puerta;
                if (salidas) {
                    puerta = vuelo.getPuertaEmbarque();
                } else {
                    puerta = vuelo.getPuertaLlegada();
                }
                if (puerta != null) {
                    return puerta;
                }
                return "-";
            }
            default: return null;
        }
    }
}