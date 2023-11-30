package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class VentanaAdmin extends JFrame {

	private JLayeredPane layeredPane;

	private PanelAdmin pa;

	public VentanaAdmin() {
		JFrame Ventana = this;
		setTitle("Menu principal - HIDE&SEEK");
		setSize(730, 700);
		setMinimumSize(new Dimension(675, 580));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Estandar.alertaCerrarVentana(Ventana);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaAdmin.class.getResource("/image/icono.png")));

		inicializarComponentes();

		Estandar.SeleccionarFondo(Ventana, "/image/fondoInterfaz2.png");
		setResizable(true);
		setLocationRelativeTo(null);
		setVisible(true);
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				Estandar.adaptarPanelCentro(Ventana, pa);
			}
		});

	}

	public void inicializarComponentes() {
		layeredPane = new JLayeredPane();
		getContentPane().add(layeredPane, BorderLayout.CENTER);

		pa = new PanelAdmin();

		layeredPane.add(pa, Integer.valueOf(1));

		Estandar.getFondoImagen().setBounds(0, 0, getWidth(), getHeight());
		layeredPane.add(Estandar.getFondoImagen(), Integer.valueOf(0));
		Estandar.adaptarPanelCentro(this, pa);
	}

	public JLayeredPane getLayeredPane() {
		return layeredPane;
	}

	public void setLayeredPane(JLayeredPane layeredPane) {
		this.layeredPane = layeredPane;
	}

	public PanelAdmin getPa() {
		return pa;
	}

	public void setPa(PanelAdmin pa) {
		this.pa = pa;
	}

}
