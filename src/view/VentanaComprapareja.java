package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class VentanaComprapareja extends JFrame {

	private PanelTiendaPareja ptp;
	private JLayeredPane layeredPane;

	public VentanaComprapareja() {
		JFrame Ventana = this;
		setTitle("Catalogo - HIDE&SEEK");
		setSize(750, 680);
		setMinimumSize(new Dimension(770, 620));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Estandar.alertaCerrarVentana(Ventana);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaComprapareja.class.getResource("/image/icono.png")));

		inicializarComponentes();

		Estandar.SeleccionarFondo(Ventana, "/image/fondoInterfaz2.png");
		setResizable(true);
		setLocationRelativeTo(null);
		setVisible(true);
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				Estandar.adaptarPanelCentro(Ventana, ptp);
			}
		});

	}

	public void inicializarComponentes() {
		layeredPane = new JLayeredPane();
		getContentPane().add(layeredPane, BorderLayout.CENTER);
		ptp = new PanelTiendaPareja();
		layeredPane.add(ptp, Integer.valueOf(1));

		Estandar.getFondoImagen().setBounds(0, 0, getWidth(), getHeight());
		layeredPane.add(Estandar.getFondoImagen(), Integer.valueOf(0));
		Estandar.adaptarPanelCentro(this, ptp);
	}

	public PanelTiendaPareja getPtp() {
		return ptp;
	}

	public void setPtp(PanelTiendaPareja ptp) {
		this.ptp = ptp;
	}

	public JLayeredPane getLayeredPane() {
		return layeredPane;
	}

	public void setLayeredPane(JLayeredPane layeredPane) {
		this.layeredPane = layeredPane;
	}

}
