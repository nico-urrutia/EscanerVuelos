package gui;

import java.awt.BorderLayout;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import domain.Aerolinea;
import domain.Aeropuerto;
import domain.Avion;
import domain.Vuelo;

public class PantallaAeropuerto {
	private String[] columnas = {"time","destination", "code", "gate","remark"};
	private List<Vuelo> vuelos;
	private TipoInformacion tipoInfo;
	private Aeropuerto aeropuerto;
	
	//Constructor
	public PantallaAeropuerto(List<Vuelo> vuelos, TipoInformacion tipoInfo) {
		
		this.vuelos = vuelos;
		this.tipoInfo = tipoInfo;
		this.aeropuerto = (this.tipoInfo == TipoInformacion.SALIDAS) ? vuelos.getFirst().getAeropuertoOrigen() : vuelos.getFirst().getAeropuertoDestino();
		
		panelPrincipal.add(titulo, BorderLayout.NORTH);
		titulo.setIcon(new ImageIcon("recursos/avion.png"));
		titulo.setText(this.tipoInfo.toString());
		
		// Pantalla aeropuerto
		// ---------- Ventana ----------
		JFrame ventana = new JFrame("Informacion" +this.aeropuerto.getCodigoIATA()+ " "+this.tipoInfo);
			ventana.setContentPane(panelPrincipal);
			ventana.setTitle(this.tipoInfo.toString()+"("+this.aeropuerto.getCodigoIATA()+")");
			ventana.setSize(800, 600);
			ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			ventana.setLocationRelativeTo(null);
			ventana.setVisible(true);
	}
	
	//Declaración del panel y componentes
	JPanel panelPrincipal = new JPanel(new BorderLayout());
	JLabel titulo = new JLabel();
	
	//Programa principal para pruebas
	public static void main(String[] args) {
	
	// Datos de prueba generados con IA
	//--------------------------------------------------------------------------------------
		Aerolinea aerolinea = new Aerolinea(
		        "Iberia", "España", "IB",
		        new ArrayList<>(), new ArrayList<>());

		// Aeropuertos
		Aeropuerto madrid = new Aeropuerto(
		        "MAD", "Adolfo Suárez Madrid-Barajas",
		        "Madrid", "España",
		        40.4936, -3.5668, 4);

		Aeropuerto nuevaYork = new Aeropuerto(
		        "JFK", "John F. Kennedy",
		        "Nueva York", "Estados Unidos",
		        40.6413, -73.7781, 6);

		Aeropuerto londres = new Aeropuerto(
		        "LHR", "Heathrow",
		        "Londres", "Reino Unido",
		        51.4700, -0.4543, 5);

		Aeropuerto paris = new Aeropuerto(
		        "CDG", "Charles de Gaulle",
		        "París", "Francia",
		        49.0097, 2.5479, 5);

		Aeropuerto bilbao = new Aeropuerto(
		        "BIO", "Aeropuerto de Bilbao",
		        "Bilbao", "España",
		        43.3011, -2.9106, 2);

		// Aviones
		Avion avion1 = new Avion(
		        "EC-ABC", "Airbus A320",
		        aerolinea, null, true,
		        new ArrayList<>());

		Avion avion2 = new Avion(
		        "EC-DEF", "Airbus A321",
		        aerolinea, null, true,
		        new ArrayList<>());

		Avion avion3 = new Avion(
		        "EC-GHI", "Airbus A350",
		        aerolinea, null, true,
		        new ArrayList<>());

		// Lista de vuelos
		List<Vuelo> vuelos = new ArrayList<>();

		Vuelo vuelo1 = new Vuelo(
		        "IB123", 20, 30, 45.0f,
		        aerolinea, avion1,
		        new ArrayList<>(),
		        madrid, nuevaYork,
		        LocalTime.of(10, 0),
		        LocalTime.of(14, 0));

		Vuelo vuelo2 = new Vuelo(
		        "IB456", 40, 60, 90.0f,
		        aerolinea, avion2,
		        new ArrayList<>(),
		        madrid, londres,
		        LocalTime.of(11, 30),
		        LocalTime.of(13, 15));

		Vuelo vuelo3 = new Vuelo(
		        "IB789", 80, 100, 180.0f,
		        aerolinea, avion3,
		        new ArrayList<>(),
		        madrid, paris,
		        LocalTime.of(15, 0),
		        LocalTime.of(17, 10));

		Vuelo vuelo4 = new Vuelo(
		        "IB321", 120, 50, 270.0f,
		        aerolinea, avion1,
		        new ArrayList<>(),
		        bilbao, madrid,
		        LocalTime.of(9, 15),
		        LocalTime.of(10, 20));

		Vuelo vuelo5 = new Vuelo(
		        "IB654", 200, 80, 315.0f,
		        aerolinea, avion2,
		        new ArrayList<>(),
		        paris, madrid,
		        LocalTime.of(18, 45),
		        LocalTime.of(20, 50));

		// Asociar avión-vuelo
		avion1.setVuelo(vuelo1);
		avion2.setVuelo(vuelo2);
		avion3.setVuelo(vuelo3);

		// Añadir a la lista
		vuelos.add(vuelo1);
		vuelos.add(vuelo2);
		vuelos.add(vuelo3);
		vuelos.add(vuelo4);
		vuelos.add(vuelo5);
		//----------------------------------------------------------------------------
		
		new PantallaAeropuerto(vuelos, TipoInformacion.SALIDAS);
		
	}
}
