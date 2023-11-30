package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaAgregarSede extends JFrame {

	private JLayeredPane layeredPane;
	private JPanel panelAgregar;

	private JLabel etitulo, enombre, edireccion;
	private JButton bagregar, bcancelar;
	private JTextField tnombre, tdireccion;

	public VentanaAgregarSede() {
		JFrame Ventana = this;
		setTitle("Agregar sede");
		setSize(700, 300);
		setMinimumSize(new Dimension(700, 300));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Estandar.alertaCerrarVentana(Ventana);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaAgregarSede.class.getResource("/image/icono.png")));

		inicializarComponentes();

		Estandar.SeleccionarFondo(Ventana, "/image/fondoInterfaz2.png");
		setResizable(true);
		setLocationRelativeTo(null);
		setVisible(true);
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				Estandar.adaptarPanelCentro(Ventana, panelAgregar);
			}
		});

	}

	public void inicializarComponentes() {
		layeredPane = new JLayeredPane();
		getContentPane().add(layeredPane, BorderLayout.CENTER);

		panelAgregar = new JPanel(new BorderLayout());

		etitulo = Estandar.labelNegro("Agregar sede");
		panelAgregar.add(etitulo, BorderLayout.NORTH);

		JPanel auxCentro = new JPanel(new GridLayout(2, 2, 20, 20));
		enombre = Estandar.labelNegro("Nombre:");
		auxCentro.add(enombre);

		tnombre = Estandar.campoTexto();
		tnombre.setBackground(new Color(216, 239, 242));
		auxCentro.add(tnombre);

		edireccion = Estandar.labelNegro("Direccion:");
		auxCentro.add(edireccion);

		tdireccion = Estandar.campoTexto();
		tdireccion.setBackground(new Color(216, 239, 242));
		auxCentro.add(tdireccion);

		panelAgregar.add(auxCentro, BorderLayout.CENTER);

		JPanel auxSur = new JPanel(new GridLayout(1, 3, 20, 20));

		bcancelar = Estandar.boton("Cancelar");
		bcancelar.setActionCommand("bCancelarSEDE");
		auxSur.add(bcancelar);

		auxSur.add(Estandar.Espacio());

		bagregar = Estandar.boton("Agregar");
		bagregar.setActionCommand("bAGREGARSEDE");
		auxSur.add(bagregar);

		panelAgregar.add(auxSur, BorderLayout.SOUTH);

		layeredPane.add(panelAgregar, Integer.valueOf(1));

		Estandar.getFondoImagen().setBounds(0, 0, getWidth(), getHeight());
		layeredPane.add(Estandar.getFondoImagen(), Integer.valueOf(0));
		Estandar.adaptarPanelCentro(this, panelAgregar);
	}

	public JLayeredPane getLayeredPane() {
		return layeredPane;
	}

	public void setLayeredPane(JLayeredPane layeredPane) {
		this.layeredPane = layeredPane;
	}

	public JPanel getPanelAgregar() {
		return panelAgregar;
	}

	public void setPanelAgregar(JPanel panelAgregar) {
		this.panelAgregar = panelAgregar;
	}

	public JLabel getEtitulo() {
		return etitulo;
	}

	public void setEtitulo(JLabel etitulo) {
		this.etitulo = etitulo;
	}

	public JLabel getEnombre() {
		return enombre;
	}

	public void setEnombre(JLabel enombre) {
		this.enombre = enombre;
	}

	public JLabel getEdireccion() {
		return edireccion;
	}

	public void setEdireccion(JLabel edireccion) {
		this.edireccion = edireccion;
	}

	public JButton getBagregar() {
		return bagregar;
	}

	public void setBagregar(JButton bagregar) {
		this.bagregar = bagregar;
	}

	public JButton getBcancelar() {
		return bcancelar;
	}

	public void setBcancelar(JButton bcancelar) {
		this.bcancelar = bcancelar;
	}

	public JTextField getTnombre() {
		return tnombre;
	}

	public void setTnombre(JTextField tnombre) {
		this.tnombre = tnombre;
	}

	public JTextField getTdireccion() {
		return tdireccion;
	}

	public void setTdireccion(JTextField tdireccion) {
		this.tdireccion = tdireccion;
	}

}
