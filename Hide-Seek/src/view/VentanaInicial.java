package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class VentanaInicial extends JFrame{

	private PanelLogin pl;
	private PanelRegister pr;
	private JLayeredPane layeredPane;

	
	public VentanaInicial() {
		JFrame Ventana = this;
		setTitle("Incie sesion");
		setSize(400, 540);
		setMinimumSize(new Dimension(280, 500));
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
            	Estandar.adaptarPanelCentro(Ventana, pl);
            	Estandar.adaptarPanelCentro(Ventana, pr);
            }
        });
       
	}
	
	public void inicializarComponentes() {
		layeredPane = new JLayeredPane();
		getContentPane().add(layeredPane, BorderLayout.CENTER);
		pl = new PanelLogin();
		pr = new PanelRegister();
		layeredPane.add(pl, Integer.valueOf(1));	
	
		Estandar.fondoImagen.setBounds(0, 0, getWidth(), getHeight());
		layeredPane.add(Estandar.fondoImagen, Integer.valueOf(0));
		Estandar.adaptarPanelCentro(this, pl);
	}
	
        
	public PanelRegister getPr() {
		return pr;
	}

	public void setPr(PanelRegister pr) {
		this.pr = pr;
	}

	public PanelLogin getPl() {
		return pl;
	}

	public void setPl(PanelLogin pl) {
		this.pl = pl;
	}


	public JLayeredPane getLayeredPane() {
		return layeredPane;
	}

	public void setLayeredPane(JLayeredPane layeredPane) {
		this.layeredPane = layeredPane;
	}
    
    
	
}
