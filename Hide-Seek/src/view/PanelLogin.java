package view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PanelLogin extends JPanel{

	private JLabel eblanco, etitulo, esubtitulo, eusuario, eclave, enotienes;
	private JTextField tusuario;
	private JPasswordField tclave;
	private JButton bentrar, bregistrate; 
	
	public PanelLogin() {
		//setLayout(new GridLayout(14, 4));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(380, 450));
		
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
		JSeparator espacio = new JSeparator();
		espacio.setForeground(getBackground());
		add(espacio);
		
		
		eusuario = new JLabel("Usuario"); 
		eusuario.setFont(new Font("Arial", Font.PLAIN, 18));
		add(eusuario);
		
		JPanel panelAuxTusuario = new JPanel(new BorderLayout()); 
		panelAuxTusuario.setMaximumSize(new Dimension(600, 30)); 
		
		eblanco = new JLabel(" ");
        tusuario = new JTextField();
        tusuario.setFocusable(false);
        tusuario.setBorder(null);
        tusuario.setBackground(null);
		tusuario.setText("Ingresa tu nombre de usuario");
		tusuario.setFont(new Font("Arial", Font.PLAIN, 13));
		tusuario.setForeground(new Color(92,92,102));
        tusuario.setPreferredSize(new Dimension(300, 30)); 
        tusuario.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		if(e.getClickCount() == 1) {
        			tusuario.setFocusable(true);
        			tusuario.requestFocus();
        			tusuario.setText("");
        		}
        	}
        });
        
        panelAuxTusuario.add(eblanco, BorderLayout.WEST);
        panelAuxTusuario.add(tusuario, BorderLayout.CENTER);
        add(panelAuxTusuario);
        
        JSeparator separador = new JSeparator();
		add(separador);
		
		eclave = new JLabel("Clave"); 
		eclave.setFont(new Font("Arial", Font.PLAIN, 18));
		add(eclave);

		JPanel panelAuxTclave = new JPanel(new BorderLayout()); 
		panelAuxTclave.setMaximumSize(new Dimension(600, 30)); 

		eblanco = new JLabel(" ");
        tclave = new JPasswordField();
        tclave.setFocusable(false);
        tclave.setBorder(null);
        tclave.setBackground(null);
		tclave.setText("**********");
        tclave.setFont(new Font("Arial", Font.PLAIN, 13));
        tclave.setForeground(new Color(92,92,102));
        tclave.setPreferredSize(new Dimension(300, 30));
        tclave.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		if(e.getClickCount() == 1) {
        			tclave.setFocusable(true);
        			tclave.requestFocus();
        			tclave.setText("");
        		}
        	}
        });
        panelAuxTclave.add(eblanco, BorderLayout.WEST);
        panelAuxTclave.add(tclave, BorderLayout.CENTER);
        add(panelAuxTclave);
        
        separador = new JSeparator();
		add(separador);
		
		bentrar = new JButton("Entrar ->");
		bentrar.setBackground(new Color(84, 160, 227));
		bentrar.setFont(new Font("Arial", Font.PLAIN, 18));
		bentrar.setForeground(new Color(255, 255, 255));
		bentrar.setActionCommand("bLOGIN");
		add(bentrar);
		
		espacio = new JSeparator();
		espacio.setForeground(getBackground());
		add(espacio);
		
		enotienes = new JLabel("No tienes una cuenta?"); 
		enotienes.setFont(new Font("Arial", Font.PLAIN, 14));
		enotienes.setForeground(new Color(92,92,102));
		add(enotienes);
		
		bregistrate = new JButton("Registrate"); 
		bregistrate.setBackground(null);
		bregistrate.setBorder(null);
		bregistrate.setFont(new Font("Arial", Font.PLAIN, 14));
		bregistrate.setForeground(new Color(84, 160, 227));
		bregistrate.setActionCommand("bREGISTRAR");
		add(bregistrate);
		
	}

	public JLabel getEblanco() {
		return eblanco;
	}

	public void setEblanco(JLabel eblanco) {
		this.eblanco = eblanco;
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
