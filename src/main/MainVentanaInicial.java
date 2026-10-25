package main;

import java.time.LocalTime;
import java.util.ArrayList;

import domain.Aeropuerto;
import domain.Vuelo;
import gui.VentanaInicial;

public class MainVentanaInicial {

	public static void main(String[] args) {

		// Aeropuertos de prueba
		Aeropuerto mad = new Aeropuerto("MAD", "Adolfo Suárez", "Madrid", "ES", 100, 200, 4);
		Aeropuerto bio = new Aeropuerto("BIO", "Loiu", "Bilbao", "ES", 120, 80, 1);
		Aeropuerto bcn = new Aeropuerto("BCN", "El Prat", "Barcelona", "ES", 300, 120, 3);
		Aeropuerto lhr = new Aeropuerto("LHR", "Heathrow", "Londres", "GB", 150, -200, 2);

		ArrayList<Aeropuerto> aeropuertos = new ArrayList<>();
		aeropuertos.add(mad);
		aeropuertos.add(bio);
		aeropuertos.add(bcn);
		aeropuertos.add(lhr);

		// Vuelos de prueba (aerolínea y avión a null por ahora)
		Vuelo v1 = new Vuelo("IB3214", 0, 0, 0f, null, null, new ArrayList<>(), mad, lhr,
				LocalTime.of(10, 30), LocalTime.of(12, 45));
		Vuelo v2 = new Vuelo("VY1001", 0, 0, 0f, null, null, new ArrayList<>(), bcn, mad,
				LocalTime.of(8, 0), LocalTime.of(9, 20));
		Vuelo v3 = new Vuelo("UX1090", 0, 0, 0f, null, null, new ArrayList<>(), mad, bio,
				LocalTime.of(14, 15), LocalTime.of(15, 10));

		ArrayList<Vuelo> vuelos = new ArrayList<>();
		vuelos.add(v1);
		vuelos.add(v2);
		vuelos.add(v3);

		// Abrir la ventana
		new VentanaInicial(aeropuertos, vuelos).setVisible(true);
	}

}