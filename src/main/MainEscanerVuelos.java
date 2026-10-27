package main;

import java.time.LocalTime;
import java.util.ArrayList;

import domain.Aerolinea;
import domain.Aeropuerto;
import domain.Avion;
import domain.Vuelo;
import gui.TrackerVuelo;
import gui.VentanaInicial;

public class MainEscanerVuelos {

	public static void main(String[] args) {

		//Utilizacion de la IA para crear instancias de las clases y poder tener ejemplos
		
		// España
		Aeropuerto mad = new Aeropuerto("MAD", "Adolfo Suárez Madrid-Barajas", "Madrid", "ES", 100, 200, 4);
		Aeropuerto bio = new Aeropuerto("BIO", "Loiu", "Bilbao", "ES", 120, 80, 1);
		Aeropuerto bcn = new Aeropuerto("BCN", "Josep Tarradellas Barcelona-El Prat", "Barcelona", "ES", 300, 120, 3);
		Aeropuerto agp = new Aeropuerto("AGP", "Málaga-Costa del Sol", "Málaga", "ES", 90, 380, 2);
		Aeropuerto vlc = new Aeropuerto("VLC", "Manises", "Valencia", "ES", 260, 220, 1);
		Aeropuerto pmi = new Aeropuerto("PMI", "Son Sant Joan", "Palma de Mallorca", "ES", 350, 230, 2);
		Aeropuerto svq = new Aeropuerto("SVQ", "San Pablo", "Sevilla", "ES", 50, 350, 1);

		// Europa
		Aeropuerto lhr = new Aeropuerto("LHR", "Heathrow", "Londres", "GB", 150, -200, 5);
		Aeropuerto cdg = new Aeropuerto("CDG", "Charles de Gaulle", "París", "FR", 220, -120, 3);
		Aeropuerto fra = new Aeropuerto("FRA", "Frankfurt", "Fráncfort", "DE", 320, -140, 2);
		Aeropuerto ams = new Aeropuerto("AMS", "Schiphol", "Ámsterdam", "NL", 240, -220, 1);
		Aeropuerto fco = new Aeropuerto("FCO", "Leonardo da Vinci-Fiumicino", "Roma", "IT", 380, 100, 3);

		// Internacionales
		Aeropuerto jfk = new Aeropuerto("JFK", "John F. Kennedy", "Nueva York", "US", -450, -50, 8);
		Aeropuerto hnd = new Aeropuerto("HND", "Haneda", "Tokio", "JP", 750, -100, 3);

		ArrayList<Aeropuerto> aeropuertos = new ArrayList<>();
		aeropuertos.add(mad);
		aeropuertos.add(bio);
		aeropuertos.add(bcn);
		aeropuertos.add(agp);
		aeropuertos.add(vlc);
		aeropuertos.add(pmi);
		aeropuertos.add(svq);
		aeropuertos.add(lhr);
		aeropuertos.add(cdg);
		aeropuertos.add(fra);
		aeropuertos.add(ams);
		aeropuertos.add(fco);
		aeropuertos.add(jfk);
		aeropuertos.add(hnd);

		
		Avion a1 = new Avion("EC-LMN", "Airbus A320", null, null, true, new ArrayList<>());  // En vuelo
		Avion a2 = new Avion("EC-XYZ", "Boeing 737", null, null, false, new ArrayList<>()); // En tierra
		Avion a3 = new Avion("EC-ABC", "Airbus A350", null, null, true, new ArrayList<>());  // En vuelo
		Avion a4 = new Avion("EC-DEF", "Boeing 787", null, null, false, new ArrayList<>()); // En tierra
		Avion a5 = new Avion("EC-GHI", "Airbus A330", null, null, true, new ArrayList<>());  // En vuelo
		Avion a6 = new Avion("EC-JKL", "ATR 72", null, null, false, new ArrayList<>());     // En tierra

		Aerolinea ib = new Aerolinea("Iberia", "ES", "IB", new ArrayList<>(), new ArrayList<>());
		Aerolinea ux = new Aerolinea("Air Europa", "ES", "UX", new ArrayList<>(), new ArrayList<>());
		Aerolinea vy = new Aerolinea("Vueling", "ES", "VY", new ArrayList<>(), new ArrayList<>());
		Aerolinea fr = new Aerolinea("Ryanair", "IE", "FR", new ArrayList<>(), new ArrayList<>());
		Aerolinea ba = new Aerolinea("British Airways", "GB", "BA", new ArrayList<>(), new ArrayList<>());
		Aerolinea af = new Aerolinea("Air France", "FR", "AF", new ArrayList<>(), new ArrayList<>());
		Aerolinea lh = new Aerolinea("Lufthansa", "DE", "LH", new ArrayList<>(), new ArrayList<>());
		Aerolinea kl = new Aerolinea("KLM", "NL", "KL", new ArrayList<>(), new ArrayList<>());
		Aerolinea az = new Aerolinea("ITA Airways", "IT", "AZ", new ArrayList<>(), new ArrayList<>());
		Aerolinea dl = new Aerolinea("Delta Air Lines", "US", "DL", new ArrayList<>(), new ArrayList<>());
		Aerolinea nh = new Aerolinea("All Nippon Airways", "JP", "NH", new ArrayList<>(), new ArrayList<>());

		ArrayList<Vuelo> vuelos = new ArrayList<>();

		// Vuelos Nacionales
		vuelos.add(new Vuelo("IB3214", 0, 0, 0f, ib, a1, new ArrayList<>(), mad, bio, LocalTime.of(7, 0), LocalTime.of(8, 5)));
		vuelos.add(new Vuelo("UX1090", 0, 0, 0f, ux, a2, new ArrayList<>(), mad, bio, LocalTime.of(14, 15), LocalTime.of(15, 10)));
		vuelos.add(new Vuelo("VY1001", 0, 0, 0f, vy, a3, new ArrayList<>(), bcn, mad, LocalTime.of(8, 0), LocalTime.of(9, 20)));
		vuelos.add(new Vuelo("VY1002", 0, 0, 0f, vy, a4, new ArrayList<>(), mad, bcn, LocalTime.of(19, 30), LocalTime.of(20, 50)));
		vuelos.add(new Vuelo("UX2150", 0, 0, 0f, ux, a5, new ArrayList<>(), mad, agp, LocalTime.of(11, 45), LocalTime.of(13, 0)));
		vuelos.add(new Vuelo("FR4512", 0, 0, 0f, fr, a6, new ArrayList<>(), bio, pmi, LocalTime.of(9, 15), LocalTime.of(10, 40)));
		vuelos.add(new Vuelo("VY3901", 0, 0, 0f, vy, a1, new ArrayList<>(), svq, bcn, LocalTime.of(6, 45), LocalTime.of(8, 20)));

		// Vuelos Europeos
		vuelos.add(new Vuelo("IB3166", 0, 0, 0f, ib, a2, new ArrayList<>(), mad, lhr, LocalTime.of(10, 30), LocalTime.of(12, 0)));
		vuelos.add(new Vuelo("BA0461", 0, 0, 0f, ba, a3, new ArrayList<>(), lhr, mad, LocalTime.of(15, 20), LocalTime.of(18, 45)));
		vuelos.add(new Vuelo("AF1401", 0, 0, 0f, af, a4, new ArrayList<>(), bcn, cdg, LocalTime.of(9, 50), LocalTime.of(11, 55)));
		vuelos.add(new Vuelo("LH1115", 0, 0, 0f, lh, a5, new ArrayList<>(), mad, fra, LocalTime.of(12, 10), LocalTime.of(14, 45)));
		vuelos.add(new Vuelo("KL1698", 0, 0, 0f, kl, a6, new ArrayList<>(), bio, ams, LocalTime.of(17, 0), LocalTime.of(19, 15)));
		vuelos.add(new Vuelo("AZ0063", 0, 0, 0f, az, a1, new ArrayList<>(), fco, mad, LocalTime.of(21, 10), LocalTime.of(23, 40)));

		// Vuelos Transoceánicos
		vuelos.add(new Vuelo("IB6251", 0, 0, 0f, ib, a3, new ArrayList<>(), mad, jfk, LocalTime.of(12, 25), LocalTime.of(14, 40)));
		vuelos.add(new Vuelo("DL0126", 0, 0, 0f, dl, a4, new ArrayList<>(), jfk, bcn, LocalTime.of(18, 30), LocalTime.of(8, 15)));
		vuelos.add(new Vuelo("NH0212", 0, 0, 0f, nh, a5, new ArrayList<>(), cdg, hnd, LocalTime.of(20, 0), LocalTime.of(16, 30)));

		for (Vuelo v : vuelos) {
			v.getAerolinea().getVuelos().add(v);
		}

		new VentanaInicial(aeropuertos, vuelos).setVisible(true);
		//new TrackerVuelo(vuelos.get(1)).setVisible(true);
	}
}