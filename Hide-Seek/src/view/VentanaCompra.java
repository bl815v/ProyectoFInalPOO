package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class VentanaCompra extends JFrame{
	
	private PanelTienda pt;
	private JLayeredPane layeredPane;
	
	public VentanaCompra() {
		JFrame Ventana = this;
		setTitle("Catalogo - HIDE&SEEK");
		setSize(730, 700);
		setMinimumSize(new Dimension(710, 620));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Estandar.alertaCerrarVentana(Ventana);

		inicializarComponentes();
		
		Estandar.SeleccionarFondo(Ventana ,"/image/fondoInterfaz2.png");
		setResizable(true);
		setLocationRelativeTo(null);
		setVisible(true);
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
            	Estandar.adaptarPanelCentro(Ventana, pt);
            }
        });
       
	}
	
	public void inicializarComponentes() {
		layeredPane = new JLayeredPane();
		getContentPane().add(layeredPane, BorderLayout.CENTER);
		pt = new PanelTienda();
		layeredPane.add(pt, Integer.valueOf(1));	
	
		Estandar.fondoImagen.setBounds(0, 0, getWidth(), getHeight());
		layeredPane.add(Estandar.fondoImagen, Integer.valueOf(0));
		Estandar.adaptarPanelCentro(this, pt);
	}

	public PanelTienda getPt() {
		return pt;
	}

	public void setPt(PanelTienda pt) {
		this.pt = pt;
	}

	public JLayeredPane getLayeredPane() {
		return layeredPane;
	}

	public void setLayeredPane(JLayeredPane layeredPane) {
		this.layeredPane = layeredPane;
	}
	
}

