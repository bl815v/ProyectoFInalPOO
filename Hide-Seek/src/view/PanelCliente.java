package view;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelCliente extends JPanel{
	
	private JLabel etitulo, enombre;

	
	public PanelCliente() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(270, 400));

		inicializarComponentes();
		setVisible(true);
		
	}
	
	public void inicializarComponentes() {
		etitulo = new JLabel("HIDE&SEEK");
		etitulo.setFont(new Font("Arial", Font.BOLD, 22));
		add(etitulo);
		


		add(Estandar.Espacio());

		enombre = new JLabel("Bienvenido, "); 
		enombre.setFont(new Font("Arial", Font.PLAIN, 18));
		add(enombre);
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
	
	
}
