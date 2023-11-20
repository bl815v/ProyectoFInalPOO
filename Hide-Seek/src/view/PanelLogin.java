package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class PanelLogin extends JPanel{

	private JLabel etitulo, esubtitulo, eusuario, esubusuario, eclave, esubclave, enotienes;
	private JTextField tusuario;
	private JPasswordField tclave;
	private JButton bentrar, bregistrate; 
	
	public PanelLogin() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(270, 400));
		
		inicializarComponentes();
		setVisible(true);
	}
	
	public void inicializarComponentes() {
		
		etitulo = new JLabel("HIDE&SEEK");
		etitulo.setFont(new Font("Arial", Font.BOLD, 22));
		add(etitulo);
		
		esubtitulo = new JLabel("Incia sesion para continuar.");
		esubtitulo.setFont(new Font("Arial", Font.PLAIN, 16));
		esubtitulo.setForeground(new Color(92,92,102));
		add(esubtitulo);
		
		add(PanelRegister.Espacio());
		
		eusuario = new JLabel("Usuario"); 
		eusuario.setFont(new Font("Arial", Font.PLAIN, 18));
		add(eusuario);
		esubusuario = new JLabel("Ingrese su nombre de usuario (alias):");
		esubusuario.setFont(new Font("Arial", Font.PLAIN, 14));
		esubusuario.setForeground(new Color(92,92,102));
		add(esubusuario);
		
		JPanel panelAuxTusuario = new JPanel(new BorderLayout()); 
		panelAuxTusuario.setMaximumSize(new Dimension(600, 30)); 
        tusuario = new JTextField();
        tusuario.setBorder(null);
        tusuario.setBackground(null);
		tusuario.setFont(new Font("Arial", Font.PLAIN, 13));
		tusuario.setForeground(new Color(92,92,102));
        tusuario.setPreferredSize(new Dimension(300, 30)); 
        panelAuxTusuario.add(tusuario, BorderLayout.CENTER);
        add(panelAuxTusuario);
        
        add(PanelRegister.Separador());
		
		eclave = new JLabel("Clave"); 
		eclave.setFont(new Font("Arial", Font.PLAIN, 18));
		add(eclave);
		esubclave = new JLabel("Ingrese su clave:");
		esubclave.setFont(new Font("Arial", Font.PLAIN, 14));
		esubclave.setForeground(new Color(92,92,102));
		add(esubclave);

		JPanel panelAuxTclave = new JPanel(new BorderLayout()); 
		panelAuxTclave.setMaximumSize(new Dimension(600, 30)); 
        tclave = new JPasswordField();
        tclave.setBorder(null);
        tclave.setBackground(null);
        tclave.setFont(new Font("Arial", Font.PLAIN, 13));
        tclave.setForeground(new Color(92,92,102));
        tclave.setPreferredSize(new Dimension(300, 30));
        panelAuxTclave.add(tclave, BorderLayout.CENTER);
        add(panelAuxTclave);
        
        add(PanelRegister.Separador());
	
		bentrar = new JButton("Entrar ->");
		bentrar.setBackground(new Color(84, 160, 227));
		bentrar.setFont(new Font("Arial", Font.PLAIN, 18));
		bentrar.setForeground(new Color(255, 255, 255));
		bentrar.setActionCommand("bLOGIN");
		add(bentrar);
		
		add(PanelRegister.Espacio(1, 90));
		
		enotienes = new JLabel("No tienes una cuenta?"); 
		enotienes.setFont(new Font("Arial", Font.PLAIN, 14));
		enotienes.setForeground(new Color(92,92,102));
		add(enotienes);
		
		bregistrate = new JButton("Registrate"); 
		bregistrate.setBackground(null);
		bregistrate.setBorder(null);
		bregistrate.setFont(new Font("Arial", Font.PLAIN, 14));
		bregistrate.setForeground(new Color(84, 160, 227));
		bregistrate.setActionCommand("bREGISTRATE");
		add(bregistrate);
		
	}


	public JLabel getEtitulo() {
		return etitulo;
	}

	public void setEtitulo(JLabel etitulo) {
		this.etitulo = etitulo;
	}

	public JLabel getEsubtitulo() {
		return esubtitulo;
	}

	public void setEsubtitulo(JLabel esubtitulo) {
		this.esubtitulo = esubtitulo;
	}

	public JLabel getEusuario() {
		return eusuario;
	}

	public void setEusuario(JLabel eusuario) {
		this.eusuario = eusuario;
	}

	public JLabel getEclave() {
		return eclave;
	}

	public void setEclave(JLabel eclave) {
		this.eclave = eclave;
	}

	public JLabel getEnotienes() {
		return enotienes;
	}

	public void setEnotienes(JLabel enotienes) {
		this.enotienes = enotienes;
	}

	public JTextField getTusuario() {
		return tusuario;
	}

	public void setTusuario(JTextField tusuario) {
		this.tusuario = tusuario;
	}

	public JPasswordField getTclave() {
		return tclave;
	}

	public void setTclave(JPasswordField tclave) {
		this.tclave = tclave;
	}

	public JButton getBentrar() {
		return bentrar;
	}

	public void setBentrar(JButton bentrar) {
		this.bentrar = bentrar;
	}

	public JButton getBregistrate() {
		return bregistrate;
	}

	public void setBregistrate(JButton bregistrate) {
		this.bregistrate = bregistrate;
	}

}
