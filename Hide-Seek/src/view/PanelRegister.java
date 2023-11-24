package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class PanelRegister extends JPanel{

	private JLabel etitulo, esubtitulo, enombre, esubnombre, egenero, esubgenero, ecorreo, esubcorreo;
	private JLabel eusuario, esubusuario, eclave, esubclave, erepetir, esubrepetir, eyatienes;
	private JComboBox<String> lista_genero;
	private JTextField tnombre, tcorreo, tusuario;
	private JPasswordField tclave, trepetir;
	private JButton bregistrar, blogin; 
	
	public PanelRegister() {
		setLayout(new GridLayout(1, 2, 20, 0));
		setPreferredSize(new Dimension(670, 500));
		
		inicializarComponentes();
		setVisible(true);
		
		Estandar.revisarTextField(tnombre, esubnombre, "Ingrese sus nombres y apellidos:");
		Estandar.revisarTextField(tusuario, esubusuario, "Ingrese su nombre de usuario (alias):");
		Estandar.revisarTextField(tcorreo, esubcorreo, "Ingrese su correo electronico:");
		
		Estandar.revisarTextField(tclave, esubclave, "Ingrese su clave:");
		Estandar.revisarTextField(trepetir, esubrepetir, "Ingrese la anterior clave:");
	}
	
	public void inicializarComponentes() {
		JPanel Izquierda = new JPanel();
		Izquierda.setLayout(new BoxLayout(Izquierda, BoxLayout.Y_AXIS));
		JPanel Derecha = new JPanel();
		Derecha.setLayout(new BoxLayout(Derecha, BoxLayout.Y_AXIS));
				
		etitulo = Estandar.HideSeek();
		Izquierda.add(etitulo);
		esubtitulo = Estandar.labelGris("Registrese para continuar.");
		Izquierda.add(esubtitulo);
		
		JSeparator espacio = Estandar.Espacio(1,50);
		Izquierda.add(espacio);
		
		enombre = Estandar.labelNegro("Nombres y apellidos"); 
		Izquierda.add(enombre);
		esubnombre = Estandar.labelGris("Ingrese sus nombres y apellidos:");
		Izquierda.add(esubnombre);
		
		JPanel panelAuxTnombre = new JPanel(new BorderLayout()); 
		panelAuxTnombre.setMaximumSize(new Dimension(600, 30)); 
		tnombre = campoTexto();
        panelAuxTnombre.add(tnombre, BorderLayout.CENTER);
        Izquierda.add(panelAuxTnombre);
        Izquierda.add(Estandar.Separador());
		
		egenero = Estandar.labelNegro("Genero"); 
		Izquierda.add(egenero);
		esubgenero = Estandar.labelGris("Ingrese su genero:");
		Izquierda.add(esubgenero);
		
		JPanel panelAuxgenero = new JPanel(new BorderLayout());
		panelAuxgenero.setAlignmentX(LEFT_ALIGNMENT); 
		panelAuxgenero.setMaximumSize(new Dimension(250, 30)); 
		lista_genero = new JComboBox<String>();
		lista_genero.addItem("Femenino");
		lista_genero.addItem("Masculino");
		lista_genero.addItem("Otro");
		lista_genero.setFont(new Font("Arial", Font.PLAIN, 13));
		lista_genero.setForeground(new Color(92,92,102));
		lista_genero.setActionCommand("LISTAgenero");
		panelAuxgenero.add(lista_genero, BorderLayout.CENTER);
		Izquierda.add(panelAuxgenero);
		Izquierda.add(Estandar.Espacio());
		
		Derecha.add(Estandar.Espacio(1, 95));
		eusuario = Estandar.labelNegro("Usuario");
		Derecha.add(eusuario);
		esubusuario = Estandar.labelGris("Ingrese un nombre de usuario (alias):");
		Derecha.add(esubusuario);
		
		JPanel panelAuxTusuario = new JPanel(new BorderLayout()); 
		panelAuxTusuario.setMaximumSize(new Dimension(600, 30)); 
        tusuario = campoTexto(); 
        panelAuxTusuario.add(tusuario, BorderLayout.CENTER);
        Derecha.add(panelAuxTusuario);
        Derecha.add(Estandar.Separador());
        
        ecorreo = Estandar.labelNegro("Correo"); 
		Derecha.add(ecorreo);
		esubcorreo = Estandar.labelGris("Ingrese su correo electronico:");
		Derecha.add(esubcorreo);
		
		JPanel panelAuxTcorreo = new JPanel(new BorderLayout()); 
		panelAuxTcorreo.setMaximumSize(new Dimension(600, 30)); 
		tcorreo = campoTexto();
		panelAuxTcorreo.add(tcorreo, BorderLayout.CENTER);
		Derecha.add(panelAuxTcorreo);
		Derecha.add(Estandar.Separador());

		eclave = Estandar.labelNegro("Clave"); 
		Izquierda.add(eclave);
		esubclave = Estandar.labelGris("Ingrese una clave:");
		Izquierda.add(esubclave);
		
		JPanel panelAuxTclave = new JPanel(new BorderLayout()); 
		panelAuxTclave.setMaximumSize(new Dimension(600, 30)); 
        tclave = campoClave();
        panelAuxTclave.add(tclave, BorderLayout.CENTER);
        Izquierda.add(panelAuxTclave);
        Izquierda.add(Estandar.Separador(500, 30));
		
		erepetir = Estandar.labelNegro("Repita la clave"); 
		erepetir.setFont(new Font("Arial", Font.PLAIN, 18));
		Derecha.add(erepetir);
		esubrepetir = Estandar.labelGris("Ingrese la anterior clave:");
		Derecha.add(esubrepetir);
		
		JPanel panelAuxTrepetir = new JPanel(new BorderLayout()); 
		panelAuxTrepetir.setMaximumSize(new Dimension(600, 30)); 
        trepetir = campoClave();
        panelAuxTrepetir.add(trepetir, BorderLayout.CENTER);
        Derecha.add(panelAuxTrepetir);
        Derecha.add(Estandar.Separador());
		
		
		Derecha.add(Estandar.Espacio(1, 50));
		bregistrar = Estandar.boton("Registrar");
		bregistrar.setActionCommand("bREGISTRAR");
		Derecha.add(bregistrar);
		

		Izquierda.add(Estandar.Espacio(1, 60));
		eyatienes = Estandar.labelGris("Ya tienes una cuenta?"); 
		eyatienes.setFont(new Font("Arial", Font.PLAIN, 14));
		Izquierda.add(eyatienes);
		
		blogin = Estandar.botonSinFondo("Inicia sesion"); 
		blogin.setActionCommand("bmenuLOGIN");
		Izquierda.add(blogin);
		
		add(Izquierda);
		add(Derecha);
		
	}
	
	private JTextField campoTexto() {
		JTextField campo = new JTextField();
		campo.setBorder(null);
		campo.setBackground(null);
		campo.setFont(new Font("Arial", Font.PLAIN, 13));
		campo.setForeground(new Color(92,92,102));
		campo.setPreferredSize(new Dimension(300, 30)); 
		return campo;
	}
	
	private JPasswordField campoClave() {
		JPasswordField campo = new JPasswordField();
		campo.setBorder(null);
		campo.setBackground(null);
		campo.setFont(new Font("Arial", Font.PLAIN, 13));
		campo.setForeground(new Color(92,92,102));
		campo.setPreferredSize(new Dimension(300, 30));
		return campo;
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

	public JLabel getEnombre() {
		return enombre;
	}

	public void setEnombre(JLabel enombre) {
		this.enombre = enombre;
	}

	public JLabel getEsubnombre() {
		return esubnombre;
	}

	public void setEsubnombre(JLabel esubnombre) {
		this.esubnombre = esubnombre;
	}

	public JLabel getEgenero() {
		return egenero;
	}

	public void setEgenero(JLabel egenero) {
		this.egenero = egenero;
	}

	public JLabel getEsubgenero() {
		return esubgenero;
	}

	public void setEsubgenero(JLabel esubgenero) {
		this.esubgenero = esubgenero;
	}

	public JLabel getEcorreo() {
		return ecorreo;
	}

	public void setEcorreo(JLabel ecorreo) {
		this.ecorreo = ecorreo;
	}

	public JLabel getEsubcorreo() {
		return esubcorreo;
	}

	public void setEsubcorreo(JLabel esubcorreo) {
		this.esubcorreo = esubcorreo;
	}

	public JLabel getEusuario() {
		return eusuario;
	}

	public void setEusuario(JLabel eusuario) {
		this.eusuario = eusuario;
	}

	public JLabel getEsubusuario() {
		return esubusuario;
	}

	public void setEsubusuario(JLabel esubusuario) {
		this.esubusuario = esubusuario;
	}

	public JLabel getEclave() {
		return eclave;
	}

	public void setEclave(JLabel eclave) {
		this.eclave = eclave;
	}

	public JLabel getEsubclave() {
		return esubclave;
	}

	public void setEsubclave(JLabel esubclave) {
		this.esubclave = esubclave;
	}

	public JLabel getErepetir() {
		return erepetir;
	}

	public void setErepetir(JLabel erepetir) {
		this.erepetir = erepetir;
	}

	public JLabel getEsubrepetir() {
		return esubrepetir;
	}

	public void setEsubrepetir(JLabel esubrepetir) {
		this.esubrepetir = esubrepetir;
	}

	public JLabel getEyatienes() {
		return eyatienes;
	}

	public void setEyatienes(JLabel eyatienes) {
		this.eyatienes = eyatienes;
	}

	public JComboBox<String> getLista_genero() {
		return lista_genero;
	}

	public void setLista_genero(JComboBox<String> lista_genero) {
		this.lista_genero = lista_genero;
	}

	public JTextField getTnombre() {
		return tnombre;
	}

	public void setTnombre(JTextField tnombre) {
		this.tnombre = tnombre;
	}

	public JTextField getTcorreo() {
		return tcorreo;
	}

	public void setTcorreo(JTextField tcorreo) {
		this.tcorreo = tcorreo;
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

	public JPasswordField getTrepetir() {
		return trepetir;
	}

	public void setTrepetir(JPasswordField trepetir) {
		this.trepetir = trepetir;
	}

	public JButton getBregistrar() {
		return bregistrar;
	}

	public void setBregistrar(JButton bregistrar) {
		this.bregistrar = bregistrar;
	}

	public JButton getBlogin() {
		return blogin;
	}

	public void setBlogin(JButton blogin) {
		this.blogin = blogin;
	}

	

}
