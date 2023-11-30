package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class VentanaPareja extends JFrame{
	
	private JLayeredPane layeredPane;
	
	private PanelParejasInicio ppi;
	private PanelAbonopareja pap;
	private PanelHistorialComprasPareja phcp;
	
	public VentanaPareja() {
		JFrame Ventana = this;
		setTitle("Menu principal - HIDE&SEEK");
		setSize(730, 700);
		setMinimumSize(new Dimension(675, 580));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Estandar.alertaCerrarVentana(Ventana);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPareja.class.getResource("/image/icono.png")));
		
		inicializarComponentes();
		
		Estandar.SeleccionarFondo(Ventana ,"/image/fondoInterfaz2.png");
		setResizable(true);
		setLocationRelativeTo(null);
		setVisible(true);
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
            	Estandar.adaptarPanelCentro(Ventana, ppi);
            	Estandar.adaptarPanelCentro(Ventana, pap);
            	Estandar.adaptarPanelCentro(Ventana, phcp);

            }
        });
       
	}
	
	public void inicializarComponentes() {
		layeredPane = new JLayeredPane();
		getContentPane().add(layeredPane, BorderLayout.CENTER);
		ppi = new PanelParejasInicio();
		pap = new PanelAbonopareja();
		phcp = new PanelHistorialComprasPareja();
		
		layeredPane.add(ppi, Integer.valueOf(1));	
	
		Estandar.getFondoImagen().setBounds(0, 0, getWidth(), getHeight());
		layeredPane.add(Estandar.getFondoImagen(), Integer.valueOf(0));
		Estandar.adaptarPanelCentro(this, ppi);
	}

	public JLayeredPane getLayeredPane() {
		return layeredPane;
	}

	public void setLayeredPane(JLayeredPane layeredPane) {
		this.layeredPane = layeredPane;
	}

	public PanelParejasInicio getPpi() {
		return ppi;
	}

	public void setPpi(PanelParejasInicio ppi) {
		this.ppi = ppi;
	}

	public PanelAbonopareja getPap() {
		return pap;
	}

	public void setPap(PanelAbonopareja pap) {
		this.pap = pap;
	}

	public PanelHistorialComprasPareja getPhcp() {
		return phcp;
	}

	public void setPhcp(PanelHistorialComprasPareja phcp) {
		this.phcp = phcp;
	}

}
