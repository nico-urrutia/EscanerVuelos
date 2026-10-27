package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import domain.Aeropuerto;
import domain.Vuelo;

public class VentanaInicial extends JFrame {
	private static final long serialVersionUID = 1L;
	private ArrayList<Aeropuerto> aeropuertos;
	private ArrayList<Vuelo> vuelos;
	private JTable tabla=new JTable();


	public VentanaInicial(ArrayList<Aeropuerto> aeropuertos, ArrayList<Vuelo> vuelos) {
		this.aeropuertos = aeropuertos;
		this.vuelos = vuelos;

		JPanel panelPrincipal = new JPanel(new BorderLayout());

		// NORTH: cabecera con logo y título 
		JPanel panelTitulo = new JPanel(new FlowLayout(FlowLayout.CENTER));

		URL url = getClass().getResource("/recursos/logo.png");
		if (url != null) {
			ImageIcon icono = new ImageIcon(url);
			Image img = icono.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);		//Utilizacion de IA para escalar y ajustar la imagen 
			panelTitulo.add(new JLabel(new ImageIcon(img)));
		} else {
			System.err.println("No se encuentra la imagen /recursos/logo.png");
		}

		JLabel titulo = new JLabel("SKYPORT OPERATIONS", JLabel.CENTER);
		titulo.setFont(new Font("SansSerif", Font.BOLD, 20));
		panelTitulo.add(titulo);

		panelPrincipal.add(panelTitulo, BorderLayout.NORTH);

		// CENTER: búsqueda arriba, tabla abajo 
		JPanel panelCentro = new JPanel(new GridLayout(2, 1));


		//  BOX DE BUSQUEDA
		String[] opcionesBusqueda = {"Aeropuertos", "Vuelos"};
		JComboBox<String> comboBoxBusqueda = new JComboBox<>(opcionesBusqueda);


		JPanel panelBusqueda = new JPanel(); 
		panelCentro.add(panelBusqueda);

		panelBusqueda.add(new JLabel("Buscar por:"));
		panelBusqueda.add(comboBoxBusqueda);


		// TABLA CON LOS DATOS
		tabla = new JTable(new ModeloAeropuerto(aeropuertos));
		panelCentro.add(new JScrollPane(tabla));

		tabla.setGridColor(new Color(215, 222, 235));
		tabla.setRowHeight(34);

		comboBoxBusqueda.addActionListener(e -> {
			if (comboBoxBusqueda.getSelectedItem().equals("Aeropuertos")) {
				tabla.setModel(new ModeloAeropuerto(aeropuertos));
			} else {
				tabla.setModel(new ModeloVuelo(vuelos));
			}
		});

		// RENDERERS
		TableCellRenderer rendererCabecera=new TableCellRenderer() {

			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {
				// TODO Auto-generated method stub
				JLabel label=new JLabel(value.toString());
				label.setFont((table.getTableHeader().getFont().deriveFont(Font.ITALIC)));
				label.setHorizontalAlignment(JLabel.CENTER);
				label.setPreferredSize(new Dimension(0, 32));
				label.setOpaque(true);

				label.setForeground(Color.BLACK);
				label.setFont(getFont().deriveFont(Font.BOLD));

				return label;
			}
		};

		this.tabla.getTableHeader().setDefaultRenderer(rendererCabecera);

		TableCellRenderer miRenderer=(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)->{
			JLabel label= new JLabel();
			label.setHorizontalAlignment(JLabel.CENTER);
			label.setOpaque(true);
			label.setText(value.toString());
			label.setForeground(new Color(30, 41, 59));

			if (table.getModel() instanceof ModeloVuelo) {

				if (row %2 == 0) {
					label.setBackground(new Color(255, 255, 255));
				} else {
					label.setBackground(new Color(165, 190, 250));
				}

				if (isSelected) {
					label.setBackground(new Color(99, 102, 241));
					label.setForeground(Color.WHITE);
				}

				if (column == 5) {
					if (value.equals(false)) {
						label.setIcon(new ImageIcon(getClass().getResource("/recursos/enPista.png")));
						label.setText("");
					}
					else {
						label.setIcon(new ImageIcon(getClass().getResource("/recursos/volando.png")));
						label.setText("");

					}
				}
			} else {
				if (row %2 == 0) {
					label.setBackground(new Color(255, 255, 255));
				} else {
					label.setBackground(new Color(245, 180, 180));
				}
			}
			
			return  label;
		};

		this.tabla.setDefaultRenderer(Object.class, miRenderer);


		panelPrincipal.add(panelCentro, BorderLayout.CENTER);

		// ---------- Ventana ----------
		setContentPane(panelPrincipal);
		setTitle("Simulador de Aeropuertos");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		ImageIcon imagen= new ImageIcon(getClass().getResource("/recursos/logo.png"));
		setIconImage(imagen.getImage());
	}
}