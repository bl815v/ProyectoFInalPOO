package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelVerParejas extends JPanel{
	
	private JLabel etitulo;
	private JButton bhorario, bsedes, bcupo, bborrar, bvolver;

	public PanelVerParejas() {
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(680, 520));

		inicializarComponentes();
		setVisible(true);
		
	}

	public void inicializarComponentes() {
		// North
		JPanel norte = new JPanel();
		norte.setLayout(new BoxLayout(norte, BoxLayout.Y_AXIS));
		
		etitulo = Estandar.labelNegro("Tus parejas");
		norte.add(etitulo);
		
		add(norte, BorderLayout.NORTH);
		
		// Center
		JPanel centro = new JPanel();
		centro.setLayout(new BorderLayout());
		
		
		add(centro, BorderLayout.CENTER);
				
		// South
		JPanel sur = new JPanel();
		sur.setLayout(new BorderLayout());
		bvolver = Estandar.botonSinFondo("<- Regresar");
		bvolver.setActionCommand("bVOLVERVERPAREJAS");
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

	public JButton getBhorario() {
		return bhorario;
	}

	public void setBhorario(JButton bhorario) {
		this.bhorario = bhorario;
	}

	public JButton getBsedes() {
		return bsedes;
	}

	public void setBsedes(JButton bsedes) {
		this.bsedes = bsedes;
	}

	public JButton getBcupo() {
		return bcupo;
	}

	public void setBcupo(JButton bcupo) {
		this.bcupo = bcupo;
	}

	public JButton getBborrar() {
		return bborrar;
	}

	public void setBborrar(JButton bborrar) {
		this.bborrar = bborrar;
	}

	public JButton getBvolver() {
		return bvolver;
	}

	public void setBvolver(JButton bvolver) {
		this.bvolver = bvolver;
	}

}
