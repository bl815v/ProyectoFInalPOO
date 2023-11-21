package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
		
		inicializarComponentes();
		
		Estandar.SeleccionarFondo(Ventana ,"/image/fondoInterfaz2.png");
		setResizable(true);
		setLocationRelativeTo(null);
		setVisible(true);
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
            	Estandar.adaptarPanel(Ventana, pl);
            	Estandar.adaptarPanel(Ventana, pr);
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
		Estandar.adaptarPanel(this, pl);
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
