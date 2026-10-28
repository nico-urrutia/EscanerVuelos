package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import domain.Aerolinea;
import domain.Aeropuerto;
import domain.Avion;
import domain.Vuelo;

public class PantallaLlegadasSalidas {
	private String[] columnas = {"hora","destino", "cod", "puerta","estado"};
	private List<Vuelo> vuelos;
	private TipoInformacion tipoInfo;
	private Aeropuerto aeropuerto;
	
	
	//Colores que se utilizarán (seleccionados con IA)
	// Colores base estilo panel mecánico clásico
	private final Color negroFondo   = new Color(15, 15, 15);     // Fondo del panel principal
	private final Color negroOscuro= new Color(10, 10, 10);     // Header oscuro
	private final Color amarilloLed  = new Color(255, 215, 0);    // Amarillo fosforito/matriz de LED
	private final Color gris   = new Color(40, 40, 40);      // Gris contraste
	private final Color seleccion    = new Color(45, 45, 20);      // Resaltado tenue al seleccionar
	
	//Declaración del panel y componentes
	JPanel panelPrincipal = new JPanel(new BorderLayout());
	JLabel titulo = new JLabel();
	ImageIcon imagenAvion = new ImageIcon(getClass().getResource("/recursos/volando.png"));

	
	//Constructor
	public PantallaLlegadasSalidas(List<Vuelo> vuelos, Aeropuerto aeropuerto, TipoInformacion tipoInfo) {
		
		this.tipoInfo = tipoInfo;
		this.aeropuerto = aeropuerto;
		this.vuelos = filtrarVuelos(vuelos);
		
		//Crear label parte superior
		titulo.setIcon(imagenAvion);
		titulo.setText(this.tipoInfo.toString()+ "  ---- Aeropuerto "+this.aeropuerto.getNombre()+", "+this.aeropuerto.getCiudad()+" ("+this.aeropuerto.getCodigoIATA()+")");
		titulo.setBackground(amarilloLed);
		titulo.setForeground(negroOscuro);
		titulo.setFont(new Font("Arial", Font.BOLD, 14));
		titulo.setHorizontalTextPosition(JLabel.RIGHT);
		titulo.setOpaque(true);

		
		//Tabla de datos
		DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

		for (Vuelo vuelo : this.vuelos) {
			if (tipoInfo.equals(TipoInformacion.SALIDAS)) {
				   modelo.addRow(new Object[] {
					        vuelo.getHoraSalida(),
					        vuelo.getAeropuertoDestino().getNombre() +" (" +vuelo.getAeropuertoDestino().getCodigoIATA() + ")",
					        vuelo.getCodVuelo(),
					        "A1",
					        "A tiempo"
					    });
			} else {
				   modelo.addRow(new Object[] {
					        vuelo.getHoraLlegada(),
					        vuelo.getAeropuertoOrigen().getNombre() +" (" +vuelo.getAeropuertoOrigen().getCodigoIATA() + ")",
					        vuelo.getCodVuelo(),
					        "A1",
					        "A tiempo"
					    });
			}
		}

		JTable tabla = new JTable(modelo);

		//Configurar panel
		
		panelPrincipal.add(titulo, BorderLayout.NORTH);
		panelPrincipal.setBackground(negroFondo);
		JScrollPane j = new JScrollPane(tabla);
		j.setBackground(negroFondo);
		j.getViewport().setBackground(negroFondo);
		
		panelPrincipal.add(j, BorderLayout.CENTER);
		tabla.setDefaultRenderer(Object.class, miRendererCeldas);
		tabla.setBackground(negroFondo);
		tabla.getTableHeader().setDefaultRenderer(miRendererHeader);
		
		
		// Pantalla aeropuerto
		// ---------- Ventana ----------
		JFrame ventana = new JFrame("Informacion" +this.aeropuerto.getCodigoIATA()+ " "+this.tipoInfo);
			ventana.setContentPane(panelPrincipal);
			ventana.setTitle(this.tipoInfo.toString()+"("+this.aeropuerto.getCodigoIATA()+")");
			ventana.setSize(800, 600);
			ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			ventana.setLocationRelativeTo(null);
			ventana.setVisible(true);
			ImageIcon icono = new ImageIcon(getClass().getResource("/recursos/logo.png"));
			ventana.setIconImage(icono.getImage());
	}
	
	
	//Método para filtrar aviones
	public List<Vuelo> filtrarVuelos (List<Vuelo> vuelos){
		List<Vuelo> vuelosFiltrados = new ArrayList<Vuelo>();
		vuelos.forEach(vuelo -> {
		    if (vuelo.getAeropuertoOrigen().equals(this.aeropuerto)) vuelosFiltrados.add(vuelo);
		});
		return vuelosFiltrados;
	}
	
	//Renderer para cabecera
	TableCellRenderer miRendererHeader = (table, value, isSelected, hasFocus, row, column) -> {
	    JLabel header = new JLabel(value != null ? value.toString().toUpperCase() : "");
	    header.setOpaque(true);
	    header.setBackground(new Color(15, 15, 15));
	    header.setForeground(amarilloLed);
	    header.setFont(new Font("Arial", Font.BOLD, 12));
	    header.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(50, 50, 50)));
	    return header;
	};
	
	//Renderer para la celdas
	TableCellRenderer miRendererCeldas = new DefaultTableCellRenderer() {
	    @Override
	    public Component getTableCellRendererComponent(
	            JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	        
	        JLabel cell = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

	        if (row % 2 == 0) {
	        	cell.setBackground(negroFondo);
	        } else cell.setBackground(gris);
	        
	        cell.setForeground(amarilloLed);
	        cell.setFont(new Font("Arial", Font.BOLD, 12));
	        // Fondos alternados y selección en sintonía con azulClaro
	        if (isSelected) {
	            cell.setBackground(seleccion);
	        } else {
	            cell.setBackground(negroFondo);
	        }

	        return cell;
	    }
	};
	
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
		
		new PantallaLlegadasSalidas(vuelos, madrid,TipoInformacion.SALIDAS);
		
	}
}
