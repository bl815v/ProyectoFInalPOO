package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.ListadeCompras;
import model.ListadeParejas;
import model.ListadeProductos;
import model.Pareja;

public class PanelHistorialCompras extends JPanel{
	
	private JLabel etitulo;
	private JButton bvolver;
	private JTable tablacompras;
	
	private DefaultTableModel model; 
	public PanelHistorialCompras() {
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(680, 520));

		inicializarComponentes();
		setVisible(true);
		
	}

	public void inicializarComponentes() {
		// North
		JPanel norte = new JPanel();
		norte.setLayout(new BoxLayout(norte, BoxLayout.Y_AXIS));
		
		etitulo = Estandar.labelNegro("Tus compras");
		norte.add(etitulo);
		
		add(norte, BorderLayout.NORTH);
		
		// Center
		JPanel centro = new JPanel();
		centro.setLayout(new BorderLayout());
        String[] columnas = {"Nombre", "Precio", "Hora", "Sede"};
        model = new DefaultTableModel(null, columnas);
        tablacompras = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(tablacompras);
        centro.add(scrollPane, BorderLayout.CENTER);
		
		add(centro, BorderLayout.CENTER);
		
		// South
		JPanel sur = new JPanel();
		sur.setLayout(new BorderLayout());
		bvolver = Estandar.botonSinFondo("<- Regresar");
		bvolver.setActionCommand("bVOLVERVERHISTORIALCOMPRAS");
		sur.add(Estandar.Espacio(), BorderLayout.NORTH);
		sur.add(bvolver, BorderLayout.WEST);
		add(sur, BorderLayout.SOUTH);
	}

	public JLabel getEtitulo() {
		return etitulo;
	}

	public void setEtitulo(JLabel etitulo) {
		this.etitulo = etitulo;
	}

	public JButton getBvolver() {
		return bvolver;
	}

	public void setBvolver(JButton bvolver) {
		this.bvolver = bvolver;
	}

	public JTable getTablacompras() {
		return tablacompras;
	}

	public void setTablacompras(JTable tablacompras) {
		this.tablacompras = tablacompras;
	}

	public DefaultTableModel getModel() {
		return model;
	}

	public void setModel(DefaultTableModel model) {
		this.model = model;
	}
	
}
