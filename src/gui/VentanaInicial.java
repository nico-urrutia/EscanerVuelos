package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellRenderer;

import domain.Aeropuerto;
import domain.Vuelo;

public class VentanaInicial extends JFrame {
	private static final long serialVersionUID = 1L;
	private ArrayList<Aeropuerto> aeropuertos;
	private ArrayList<Vuelo> vuelos;
	private JTable tabla = new JTable();
	private JComboBox<String> comboOrigen;
	private JComboBox<String> comboDestino;
	private TableCellRenderer rendererVuelos;

	public VentanaInicial(ArrayList<Aeropuerto> aeropuertos, ArrayList<Vuelo> vuelos) {
		this.aeropuertos = aeropuertos;
		this.vuelos = vuelos;

		JPanel panelPrincipal = new JPanel(new BorderLayout());

		// NORTH: cabecera con logo y título 
		JPanel panelTitulo = new JPanel(new FlowLayout(FlowLayout.CENTER));

		URL url = getClass().getResource("/recursos/logo.png");
		if (url != null) {
			ImageIcon icono = new ImageIcon(url);
			Image img = icono.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);		//Imagen escalada a 80x80 píxeles con IA
			panelTitulo.add(new JLabel(new ImageIcon(img)));
		} else {
			System.err.println("No se encuentra la imagen /recursos/logo.png");
		}

		JLabel titulo = new JLabel("SKYPORT OPERATIONS", JLabel.CENTER);
		titulo.setFont(new Font("SansSerif", Font.BOLD, 20));
		panelTitulo.add(titulo);

		panelPrincipal.add(panelTitulo, BorderLayout.NORTH);

		// CENTER: búsqueda arriba, tabla abajo 
		JPanel panelCentro = new JPanel(new BorderLayout());

		// PARTE DE ARRIBA: búsqueda
		String[] opcionesBusqueda = {"Aeropuertos", "Vuelos"};
		JComboBox<String> comboBoxBusqueda = new JComboBox<>(opcionesBusqueda);

		JPanel panelBusqueda = new JPanel();
		panelBusqueda.add(new JLabel("Buscar por:"));
		panelBusqueda.add(comboBoxBusqueda);

		CardLayout cartas = new CardLayout();	// Uso de CardLayout para cambiar entre filtros de aeropuertos y vuelos con IA
		JPanel panelFiltros = new JPanel(cartas);

		// Obtener lista de países únicos
		Set<String> paises = new TreeSet<>();
		for (Aeropuerto aeropuerto : aeropuertos) {
			paises.add(aeropuerto.getPais());
		}

		// Obtener lista de códigos de aeropuerto
		Set<String> codigos = new TreeSet<>();
		for (Aeropuerto aeropuerto : aeropuertos) {
			codigos.add(aeropuerto.getCodigoIATA());   
		}

		// Filtros para aeropuertos
		JPanel filtrosAeropuerto = new JPanel();

		JComboBox<String> comboPais = new JComboBox<>();
		agregarDatos(comboPais, paises);

		JTextField campoCiudad = new JTextField(15);
		filtrosAeropuerto.add(new JLabel("País:"));
		filtrosAeropuerto.add(comboPais);
		filtrosAeropuerto.add(new JLabel("Ciudad:"));
		filtrosAeropuerto.add(campoCiudad); 

		// Filtros para vuelos
		JPanel filtrosVuelo = new JPanel();

		comboOrigen = new JComboBox<>();
		agregarDatos(comboOrigen, codigos);

		comboDestino = new JComboBox<>();
		agregarDatos(comboDestino, codigos);

		filtrosVuelo.add(new JLabel("Origen:"));
		filtrosVuelo.add(comboOrigen);
		filtrosVuelo.add(new JLabel("Destino:"));
		filtrosVuelo.add(comboDestino);

		panelFiltros.add(filtrosAeropuerto, "Aeropuertos");
		panelFiltros.add(filtrosVuelo, "Vuelos");


		JPanel panelNorte = new JPanel(new BorderLayout());
		panelNorte.add(panelFiltros, BorderLayout.CENTER);
		panelNorte.add(panelBusqueda, BorderLayout.NORTH);

		panelCentro.add(panelNorte, BorderLayout.NORTH);

		// PARTE ABAJO: tabla
		tabla = new JTable(new ModeloAeropuerto(aeropuertos));
		panelCentro.add(new JScrollPane(tabla), BorderLayout.CENTER);

		tabla.setGridColor(new Color(215, 222, 235));
		tabla.setRowHeight(34);

		// RENDERERS
		TableCellRenderer rendererCabecera = new TableCellRenderer() {
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {
				JLabel label = new JLabel(value.toString());
				label.setFont(table.getTableHeader().getFont().deriveFont(Font.BOLD));
				label.setHorizontalAlignment(JLabel.CENTER);
				label.setPreferredSize(new Dimension(0, 32));
				label.setOpaque(true);

				if (table.getModel() instanceof ModeloVuelo) {
					label.setBackground(new Color(55, 90, 180));    // azul intenso
				} else {
					label.setBackground(new Color(176, 58, 72));    // rojo vino
				}
				label.setForeground(Color.WHITE);

				return label;
			}
		};

		this.tabla.getTableHeader().setDefaultRenderer(rendererCabecera);

		TableCellRenderer rendererAeropuerto = (table, value, isSelected, hasFocus, row, column) -> {
			JLabel label = new JLabel(value.toString());
			label.setHorizontalAlignment(JLabel.CENTER);
			label.setOpaque(true);
			label.setForeground(new Color(30, 41, 59));

			if (row % 2 == 0) {
				label.setBackground(Color.WHITE);
			} else {
				label.setBackground(new Color(251, 238, 238));
			}

			if (isSelected) {
				label.setBackground(new Color(176, 58, 72));
				label.setForeground(Color.WHITE);
			}
			return label;
		};

		rendererVuelos = (JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) -> {
			JLabel label = new JLabel();
			label.setHorizontalAlignment(JLabel.CENTER);
			label.setOpaque(true);
			label.setText(value != null ? value.toString() : "");
			label.setForeground(new Color(30, 41, 59));

			if (table.getModel() instanceof ModeloVuelo) {
				if (row % 2 == 0) {
					label.setBackground(Color.WHITE);
				} else {
					label.setBackground(new Color(236, 241, 252));
				}

				if (isSelected) {
					label.setBackground(new Color(55, 90, 180));
					label.setForeground(Color.WHITE);
				}

				if (column == 5) {
					if (Boolean.FALSE.equals(value)) {
						label.setIcon(new ImageIcon(getClass().getResource("/recursos/enPista.png")));
						label.setText("");
						label.setToolTipText("EN PISTA");
					} else {
						label.setIcon(new ImageIcon(getClass().getResource("/recursos/volando.png")));
						label.setText("");
						label.setToolTipText("VOLANDO");
					}
				}
			} 

			return label;
		};

		// Evento de ratón (Doble clic en filas)
		tabla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				if (evt.getClickCount() == 2) {
					int fila = tabla.rowAtPoint(evt.getPoint());
					if (fila != -1) {
						if (tabla.getModel() instanceof ModeloVuelo) {
							ModeloVuelo filaSeleccionada = (ModeloVuelo) tabla.getModel();
							new TrackerVuelo(filaSeleccionada.getVuelo(fila));
						} else if (tabla.getModel() instanceof ModeloAeropuerto) {
							ModeloAeropuerto filaSeleccionada = (ModeloAeropuerto) tabla.getModel();
							Aeropuerto aeropuerto = filaSeleccionada.getAeropuerto(fila);
							new VentanaAeropuerto(aeropuerto);
						}
					}
				}
			}
		});

		tabla.setDefaultRenderer(Object.class, rendererAeropuerto);
		
		
		
		//Ir filtrando los aeropuertos y vuelos según la selección de los combos de búsqueda y los campos de texto
		comboPais.addActionListener(e -> {
			String pais=(String) comboPais.getSelectedItem();
			ArrayList<Aeropuerto> listaAeropuertos=new ArrayList<Aeropuerto>();
			for (Aeropuerto a : this.aeropuertos) {
				if(pais== a.getPais() || pais.equals("Todos")) {
					listaAeropuertos.add(a);
				}
			}
			this.tabla.setModel(new ModeloAeropuerto(listaAeropuertos));
		});
		
		
		comboOrigen.addActionListener(e -> aplicarFiltrosVuelos());
		
		comboDestino.addActionListener(e ->aplicarFiltrosVuelos());
		
		// Listener para cambiar entre filtros de aeropuertos y vuelos
		comboBoxBusqueda.addActionListener(e -> {
			cartas.show(panelFiltros, (String) comboBoxBusqueda.getSelectedItem());
			if (comboBoxBusqueda.getSelectedItem().equals("Aeropuertos")) {
				tabla.setModel(new ModeloAeropuerto(aeropuertos));
				tabla.setDefaultRenderer(Object.class, rendererAeropuerto);
				tabla.getColumnModel().getColumn(1).setPreferredWidth(200);
			} else {
				aplicarFiltrosVuelos();
			}
		});
		
		
		
		

		tabla.setShowVerticalLines(false);
		panelPrincipal.add(panelCentro, BorderLayout.CENTER);

		// ---------- Ventana ----------
		this.setResizable(true);
		setVisible(true);
		setContentPane(panelPrincipal);
		setTitle("Simulador de Aeropuertos");
		setSize(950, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		ImageIcon imagen = new ImageIcon(getClass().getResource("/recursos/logo.png"));
		setIconImage(imagen.getImage());
	}
	
	private void aplicarFiltrosVuelos() {
	    String origen  = (String) comboOrigen.getSelectedItem();
	    String destino = (String) comboDestino.getSelectedItem();

	    ArrayList<Vuelo> listaVuelos = new ArrayList<>();
	    for (Vuelo v : this.vuelos) {
	        boolean cumpleOrigen = "Todos".equals(origen)
	                || v.getAeropuertoOrigen().getCodigoIATA().equals(origen);
	        boolean cumpleDestino = "Todos".equals(destino)
	                || v.getAeropuertoDestino().getCodigoIATA().equals(destino);

	        if (cumpleOrigen && cumpleDestino) {
	            listaVuelos.add(v);
	        }
	    }
	    tabla.setModel(new ModeloVuelo(listaVuelos));
	    tabla.setDefaultRenderer(Object.class, rendererVuelos);
	}

	private void agregarDatos(JComboBox<String> comboBox, Set<String> datos) {
		comboBox.addItem("Todos");
		for (String dato : datos) {
			comboBox.addItem(dato);
		}
	}
}