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
		
		// Europa
		Aeropuerto mad = new Aeropuerto("MAD", "Adolfo Suárez Madrid-Barajas", "Madrid", "ES", 45.3, 29.6, 4);
		Aeropuerto bcn = new Aeropuerto("BCN", "Josep Tarradellas Barcelona-El Prat", "Barcelona", "ES", 46.9, 28.8, 3);
		Aeropuerto bio = new Aeropuerto("BIO", "Loiu", "Bilbao", "ES", 45.6, 27.8, 1);
		Aeropuerto lhr = new Aeropuerto("LHR", "Heathrow", "Londres", "GB", 46.5, 21.8, 5);
		Aeropuerto cdg = new Aeropuerto("CDG", "Charles de Gaulle", "París", "FR", 47.2, 24.2, 4);
		Aeropuerto fra = new Aeropuerto("FRA", "Frankfurt", "Fráncfort", "DE", 49.2, 23.5, 4);
		Aeropuerto ams = new Aeropuerto("AMS", "Schiphol", "Ámsterdam", "NL", 48.1, 21.8, 6);
		Aeropuerto fco = new Aeropuerto("FCO", "Leonardo da Vinci-Fiumicino", "Roma", "IT", 51.1, 28.2, 4);
		Aeropuerto ist = new Aeropuerto("IST", "Istanbul Airport", "Estambul", "TR", 56.0, 29.3, 5);

		// América del Norte
		Aeropuerto jfk = new Aeropuerto("JFK", "John F. Kennedy", "Nueva York", "US", 22.4, 29.2, 4);
		Aeropuerto lax = new Aeropuerto("LAX", "Los Angeles International", "Los Ángeles", "US", 9.2, 33.8, 4);
		Aeropuerto ord = new Aeropuerto("ORD", "O'Hare International", "Chicago", "US", 18.2, 28.5, 8);
		Aeropuerto yyz = new Aeropuerto("YYZ", "Toronto Pearson", "Toronto", "CA", 20.8, 27.2, 5);
		Aeropuerto mex = new Aeropuerto("MEX", "Benito Juárez", "Ciudad de México", "MX", 12.4, 42.7, 2);

		// América del Sur
		Aeropuerto bog = new Aeropuerto("BOG", "El Dorado", "Bogotá", "CO", 21.5, 53.5, 2);
		Aeropuerto gru = new Aeropuerto("GRU", "Guarulhos", "São Paulo", "BR", 30.8, 72.5, 2);
		Aeropuerto eze = new Aeropuerto("EZE", "Ministro Pistarini-Ezeiza", "Buenos Aires", "AR", 26.2, 82.0, 2);
		Aeropuerto scl = new Aeropuerto("SCL", "Arturo Merino Benítez", "Santiago", "CL", 22.5, 81.5, 2);

		// África y Oriente Medio
		Aeropuerto cmn = new Aeropuerto("CMN", "Mohammed V", "Casablanca", "MA", 44.2, 35.0, 2);
		Aeropuerto cai = new Aeropuerto("CAI", "Cairo International", "El Cairo", "EG", 56.8, 36.8, 3);
		Aeropuerto jnb = new Aeropuerto("JNB", "O. R. Tambo", "Johannesburgo", "ZA", 54.8, 76.5, 2);
		Aeropuerto dxb = new Aeropuerto("DXB", "Dubai International", "Dubái", "AE", 64.7, 39.6, 2);

		// Asia y Oceanía
		Aeropuerto del = new Aeropuerto("DEL", "Indira Gandhi", "Nueva Delhi", "IN", 72.5, 38.5, 4);
		Aeropuerto sin = new Aeropuerto("SIN", "Changi", "Singapur", "SG", 81.2, 56.1, 3);
		Aeropuerto pek = new Aeropuerto("PEK", "Beijing Capital", "Pekín", "CN", 83.8, 29.5, 3);
		Aeropuerto icn = new Aeropuerto("ICN", "Incheon International", "Seúl", "KR", 88.0, 31.4, 4);
		Aeropuerto hnd = new Aeropuerto("HND", "Haneda", "Tokio", "JP", 92.2, 32.4, 4);
		Aeropuerto syd = new Aeropuerto("SYD", "Kingsford Smith", "Sídney", "AU", 93.8, 81.5, 3);

		ArrayList<Aeropuerto> aeropuertos = new ArrayList<>();
		aeropuertos.add(mad);
		aeropuertos.add(bcn);
		aeropuertos.add(bio);
		aeropuertos.add(lhr);
		aeropuertos.add(cdg);
		aeropuertos.add(fra);
		aeropuertos.add(ams);
		aeropuertos.add(fco);
		aeropuertos.add(ist);
		aeropuertos.add(jfk);
		aeropuertos.add(lax);
		aeropuertos.add(ord);
		aeropuertos.add(yyz);
		aeropuertos.add(mex);
		aeropuertos.add(bog);
		aeropuertos.add(gru);
		aeropuertos.add(eze);
		aeropuertos.add(scl);
		aeropuertos.add(cmn);
		aeropuertos.add(cai);
		aeropuertos.add(jnb);
		aeropuertos.add(dxb);
		aeropuertos.add(del);
		aeropuertos.add(sin);
		aeropuertos.add(pek);
		aeropuertos.add(icn);
		aeropuertos.add(hnd);
		aeropuertos.add(syd);

		Avion a1 = new Avion("EC-LMN", "Airbus A320", null, null, true, new ArrayList<>(), 0.25);     // En vuelo
		Avion a2 = new Avion("N737AA", "Boeing 737", null, null, false, new ArrayList<>(), 0.22);     // En tierra
		Avion a3 = new Avion("F-GZNP", "Airbus A350", null, null, true, new ArrayList<>(), 0.35);     // En vuelo
		Avion a4 = new Avion("G-ZBJB", "Boeing 787", null, null, false, new ArrayList<>(), 0.32);     // En tierra
		Avion a5 = new Avion("D-AIKQ", "Airbus A330", null, null, true, new ArrayList<>(), 0.28);     // En vuelo
		Avion a6 = new Avion("JA891A", "Boeing 777", null, null, false, new ArrayList<>(), 0.36);     // En tierra
		Avion a7 = new Avion("A6-EEU", "Airbus A380", null, null, true, new ArrayList<>(), 0.38);     // En vuelo
		Avion a8 = new Avion("CC-BGG", "Boeing 787-9", null, null, false, new ArrayList<>(), 0.33);   // En tierra
		Avion a9 = new Avion("9V-SKA", "Airbus A350-900", null, null, true, new ArrayList<>(), 0.37); // En vuelo
		Avion a10 = new Avion("VH-OQA", "Boeing 747-8", null, null, false, new ArrayList<>(), 0.34);  // En tierra

		Aerolinea ib = new Aerolinea("Iberia", "ES", "IB", new ArrayList<>(), new ArrayList<>());
		Aerolinea vy = new Aerolinea("Vueling", "ES", "VY", new ArrayList<>(), new ArrayList<>());
		Aerolinea ba = new Aerolinea("British Airways", "GB", "BA", new ArrayList<>(), new ArrayList<>());
		Aerolinea af = new Aerolinea("Air France", "FR", "AF", new ArrayList<>(), new ArrayList<>());
		Aerolinea lh = new Aerolinea("Lufthansa", "DE", "LH", new ArrayList<>(), new ArrayList<>());
		Aerolinea kl = new Aerolinea("KLM", "NL", "KL", new ArrayList<>(), new ArrayList<>());
		Aerolinea az = new Aerolinea("ITA Airways", "IT", "AZ", new ArrayList<>(), new ArrayList<>());
		Aerolinea tk = new Aerolinea("Turkish Airlines", "TR", "TK", new ArrayList<>(), new ArrayList<>());
		Aerolinea dl = new Aerolinea("Delta Air Lines", "US", "DL", new ArrayList<>(), new ArrayList<>());
		Aerolinea aa = new Aerolinea("American Airlines", "US", "AA", new ArrayList<>(), new ArrayList<>());
		Aerolinea ac = new Aerolinea("Air Canada", "CA", "AC", new ArrayList<>(), new ArrayList<>());
		Aerolinea am = new Aerolinea("Aeroméxico", "MX", "AM", new ArrayList<>(), new ArrayList<>());
		Aerolinea av = new Aerolinea("Avianca", "CO", "AV", new ArrayList<>(), new ArrayList<>());
		Aerolinea la = new Aerolinea("LATAM Airlines", "CL", "LA", new ArrayList<>(), new ArrayList<>());
		Aerolinea ar = new Aerolinea("Aerolíneas Argentinas", "AR", "AR", new ArrayList<>(), new ArrayList<>());
		Aerolinea at = new Aerolinea("Royal Air Maroc", "MA", "AT", new ArrayList<>(), new ArrayList<>());
		Aerolinea ms = new Aerolinea("EgyptAir", "EG", "MS", new ArrayList<>(), new ArrayList<>());
		Aerolinea ek = new Aerolinea("Emirates", "AE", "EK", new ArrayList<>(), new ArrayList<>());
		Aerolinea ai = new Aerolinea("Air India", "IN", "AI", new ArrayList<>(), new ArrayList<>());
		Aerolinea sq = new Aerolinea("Singapore Airlines", "SG", "SQ", new ArrayList<>(), new ArrayList<>());
		Aerolinea ca = new Aerolinea("Air China", "CN", "CA", new ArrayList<>(), new ArrayList<>());
		Aerolinea ke = new Aerolinea("Korean Air", "KR", "KE", new ArrayList<>(), new ArrayList<>());
		Aerolinea nh = new Aerolinea("All Nippon Airways", "JP", "NH", new ArrayList<>(), new ArrayList<>());
		Aerolinea qf = new Aerolinea("Qantas", "AU", "QF", new ArrayList<>(), new ArrayList<>());

		ArrayList<Vuelo> vuelos = new ArrayList<>();

		// Europa
		vuelos.add(new Vuelo("IB3214", mad.getX(), mad.getY(), 0f, ib, a1, new ArrayList<>(), mad, bio, LocalTime.of(7, 0), LocalTime.of(8, 5)));
		vuelos.add(new Vuelo("VY1001", bcn.getX(), bcn.getY(), 0f, vy, a2, new ArrayList<>(), bcn, mad, LocalTime.of(8, 0), LocalTime.of(9, 20)));
		vuelos.add(new Vuelo("BA0461", lhr.getX(), lhr.getY(), 0f, ba, a3, new ArrayList<>(), lhr, mad, LocalTime.of(15, 20), LocalTime.of(18, 45)));
		vuelos.add(new Vuelo("AF1401", bcn.getX(), bcn.getY(), 0f, af, a4, new ArrayList<>(), bcn, cdg, LocalTime.of(9, 50), LocalTime.of(11, 55)));
		vuelos.add(new Vuelo("LH1115", fra.getX(), fra.getY(), 0f, lh, a5, new ArrayList<>(), fra, fco, LocalTime.of(12, 10), LocalTime.of(14, 0)));
		vuelos.add(new Vuelo("KL1698", ams.getX(), ams.getY(), 0f, kl, a6, new ArrayList<>(), ams, lhr, LocalTime.of(17, 0), LocalTime.of(17, 25)));
		vuelos.add(new Vuelo("AZ0063", fco.getX(), fco.getY(), 0f, az, a1, new ArrayList<>(), fco, ist, LocalTime.of(10, 15), LocalTime.of(13, 50)));
		vuelos.add(new Vuelo("TK1855", ist.getX(), ist.getY(), 0f, tk, a3, new ArrayList<>(), ist, bcn, LocalTime.of(14, 30), LocalTime.of(17, 15)));

		// América del Norte y Central
		vuelos.add(new Vuelo("AA0100", jfk.getX(), jfk.getY(), 0f, aa, a2, new ArrayList<>(), jfk, lax, LocalTime.of(9, 0), LocalTime.of(12, 15)));
		vuelos.add(new Vuelo("DL0405", ord.getX(), ord.getY(), 0f, dl, a5, new ArrayList<>(), ord, jfk, LocalTime.of(11, 20), LocalTime.of(14, 35)));
		vuelos.add(new Vuelo("AC0791", yyz.getX(), yyz.getY(), 0f, ac, a4, new ArrayList<>(), yyz, lax, LocalTime.of(8, 30), LocalTime.of(10, 55)));
		vuelos.add(new Vuelo("AM0408", mex.getX(), mex.getY(), 0f, am, a1, new ArrayList<>(), mex, jfk, LocalTime.of(7, 15), LocalTime.of(13, 0)));
		vuelos.add(new Vuelo("AM0646", lax.getX(), lax.getY(), 0f, am, a6, new ArrayList<>(), lax, mex, LocalTime.of(13, 40), LocalTime.of(18, 25)));

		// América del Sur e Interamericanos
		vuelos.add(new Vuelo("AV0085", bog.getX(), bog.getY(), 0f, av, a3, new ArrayList<>(), bog, eze, LocalTime.of(21, 10), LocalTime.of(5, 30)));
		vuelos.add(new Vuelo("LA8005", gru.getX(), gru.getY(), 0f, la, a8, new ArrayList<>(), gru, scl, LocalTime.of(10, 0), LocalTime.of(13, 15)));
		vuelos.add(new Vuelo("AR1302", eze.getX(), eze.getY(), 0f, ar, a5, new ArrayList<>(), eze, jfk, LocalTime.of(22, 30), LocalTime.of(8, 30)));
		vuelos.add(new Vuelo("LA0530", scl.getX(), scl.getY(), 0f, la, a7, new ArrayList<>(), scl, bog, LocalTime.of(6, 45), LocalTime.of(11, 30)));
		vuelos.add(new Vuelo("AV0020", bog.getX(), bog.getY(), 0f, av, a2, new ArrayList<>(), bog, jfk, LocalTime.of(15, 0), LocalTime.of(20, 50)));

		// África y Oriente Medio
		vuelos.add(new Vuelo("AT0970", cmn.getX(), cmn.getY(), 0f, at, a1, new ArrayList<>(), cmn, mad, LocalTime.of(11, 0), LocalTime.of(13, 50)));
		vuelos.add(new Vuelo("MS0777", cai.getX(), cai.getY(), 0f, ms, a4, new ArrayList<>(), cai, lhr, LocalTime.of(9, 30), LocalTime.of(12, 45)));
		vuelos.add(new Vuelo("EK0762", jnb.getX(), jnb.getY(), 0f, ek, a7, new ArrayList<>(), jnb, dxb, LocalTime.of(13, 25), LocalTime.of(23, 40)));
		vuelos.add(new Vuelo("MS0840", cai.getX(), cai.getY(), 0f, ms, a5, new ArrayList<>(), cai, jnb, LocalTime.of(23, 15), LocalTime.of(7, 10)));
		vuelos.add(new Vuelo("EK0924", cai.getX(), cai.getY(), 0f, ek, a8, new ArrayList<>(), cai, dxb, LocalTime.of(18, 45), LocalTime.of(23, 10)));

		// Asia y Oceanía
		vuelos.add(new Vuelo("AI0380", del.getX(), del.getY(), 0f, ai, a3, new ArrayList<>(), del, sin, LocalTime.of(23, 0), LocalTime.of(7, 15)));
		vuelos.add(new Vuelo("SQ0221", sin.getX(), sin.getY(), 0f, sq, a9, new ArrayList<>(), sin, syd, LocalTime.of(20, 40), LocalTime.of(6, 25)));
		vuelos.add(new Vuelo("CA0925", pek.getX(), pek.getY(), 0f, ca, a6, new ArrayList<>(), pek, hnd, LocalTime.of(9, 10), LocalTime.of(13, 40)));
		vuelos.add(new Vuelo("KE0703", icn.getX(), icn.getY(), 0f, ke, a1, new ArrayList<>(), icn, hnd, LocalTime.of(10, 0), LocalTime.of(12, 20)));
		vuelos.add(new Vuelo("QF0026", hnd.getX(), hnd.getY(), 0f, qf, a10, new ArrayList<>(), hnd, syd, LocalTime.of(22, 0), LocalTime.of(8, 30)));
		vuelos.add(new Vuelo("SQ0802", sin.getX(), sin.getY(), 0f, sq, a4, new ArrayList<>(), sin, pek, LocalTime.of(8, 30), LocalTime.of(14, 40)));

		// Intercontinentales y Transoceánicos
		vuelos.add(new Vuelo("IB6251", mad.getX(), mad.getY(), 0f, ib, a3, new ArrayList<>(), mad, jfk, LocalTime.of(12, 25), LocalTime.of(14, 40)));
		vuelos.add(new Vuelo("IB6827", mad.getX(), mad.getY(), 0f, ib, a9, new ArrayList<>(), mad, gru, LocalTime.of(23, 55), LocalTime.of(6, 30)));
		vuelos.add(new Vuelo("DL0126", jfk.getX(), jfk.getY(), 0f, dl, a4, new ArrayList<>(), jfk, bcn, LocalTime.of(18, 30), LocalTime.of(8, 15)));
		vuelos.add(new Vuelo("NH0212", cdg.getX(), cdg.getY(), 0f, nh, a5, new ArrayList<>(), cdg, hnd, LocalTime.of(20, 0), LocalTime.of(16, 30)));
		vuelos.add(new Vuelo("EK0001", dxb.getX(), dxb.getY(), 0f, ek, a7, new ArrayList<>(), dxb, lhr, LocalTime.of(7, 45), LocalTime.of(12, 15)));
		vuelos.add(new Vuelo("EK0414", dxb.getX(), dxb.getY(), 0f, ek, a10, new ArrayList<>(), dxb, syd, LocalTime.of(2, 0), LocalTime.of(22, 50)));
		vuelos.add(new Vuelo("KE0012", lax.getX(), lax.getY(), 0f, ke, a9, new ArrayList<>(), lax, icn, LocalTime.of(23, 30), LocalTime.of(5, 0)));
		vuelos.add(new Vuelo("LH0506", fra.getX(), fra.getY(), 0f, lh, a8, new ArrayList<>(), fra, gru, LocalTime.of(21, 55), LocalTime.of(4, 50)));
		vuelos.add(new Vuelo("BA0057", lhr.getX(), lhr.getY(), 0f, ba, a7, new ArrayList<>(), lhr, jnb, LocalTime.of(19, 5), LocalTime.of(7, 55)));

		for (Vuelo v : vuelos) {
			v.getAerolinea().getVuelos().add(v);
		}
		new VentanaInicial(aeropuertos, vuelos).setVisible(true);
	}
}