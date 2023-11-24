package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

public class VentanaCliente extends JFrame{
	
	private JLayeredPane layeredPane;
	
	private PanelCliente pc;
	private PanelAbono pa;
	
	
	public VentanaCliente() {
		JFrame Ventana = this;
		setTitle("Menu principal - HIDE&SEEK");
		setSize(730, 700);
		setMinimumSize(new Dimension(675, 580));
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
            	Estandar.adaptarPanelCentro(Ventana, pc);
            	Estandar.adaptarPanelCentro(Ventana, pa);
            }
        });
       
	}
	
	public void inicializarComponentes() {
		layeredPane = new JLayeredPane();
		getContentPane().add(layeredPane, BorderLayout.CENTER);
		pc = new PanelCliente();
		pa = new PanelAbono();
		
		layeredPane.add(pc, Integer.valueOf(1));	
	
		Estandar.fondoImagen.setBounds(0, 0, getWidth(), getHeight());
		layeredPane.add(Estandar.fondoImagen, Integer.valueOf(0));
		Estandar.adaptarPanelCentro(this, pc);
	}

	
	public JLayeredPane getLayeredPane() {
		return layeredPane;
	}

	public void setLayeredPane(JLayeredPane layeredPane) {
		this.layeredPane = layeredPane;
	}

	public PanelCliente getPc() {
		return pc;
	}

	public void setPc(PanelCliente pc) {
		this.pc = pc;
	}

	public PanelAbono getPa() {
		return pa;
	}

	public void setPa(PanelAbono pa) {
		this.pa = pa;
	}
	
}
