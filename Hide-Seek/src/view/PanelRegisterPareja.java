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

import model.ListadeSedes;
import model.Sede;

public class PanelRegisterPareja extends JPanel{

	private JLabel etitulo, esubtitulo, enombre, esubnombre, egenero, esubgenero, ecorreo, esubcorreo;
	private JLabel eusuario, esubusuario, eclave, esubclave, erepetir, esubrepetir, ecredito, esubcredito, esede, esubsede;
	private JComboBox<String> lista_genero, lista_sedes;
	private JTextField tnombre, tcorreo, tusuario, tcredito;
	private JPasswordField tclave, trepetir;
	private JButton bsiguiente, bregresar; 
	
	public PanelRegisterPareja() {
		setLayout(new GridLayout(1, 2, 20, 0));
		setPreferredSize(new Dimension(670, 650));
	
		inicializarComponentes();
		setVisible(true);
		
		Estandar.revisarTextField(tnombre, esubnombre, "Ingrese sus nombres y apellidos:");
		Estandar.revisarTextField(tusuario, esubusuario, "Ingrese su nombre de usuario (alias):");
		Estandar.revisarTextField(tcorreo, esubcorreo, "Ingrese su correo electronico:");
		Estandar.revisarTextField(tcredito, esubcredito, "Ingrese la cantidad de dinero ($):");
		
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
		tnombre = Estandar.campoTexto();
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
		lista_genero.setActionCommand("LISTAgeneropareja");
		panelAuxgenero.add(lista_genero, BorderLayout.CENTER);
		Izquierda.add(panelAuxgenero);
		Izquierda.add(Estandar.Espacio());
		
		esede = Estandar.labelNegro("Sede"); 
		Izquierda.add(esede);
		esubsede = Estandar.labelGris("Ingrese la sede:");
		Izquierda.add(esubsede);
		
		JPanel panelAuxsede = new JPanel(new BorderLayout());
		panelAuxsede.setAlignmentX(LEFT_ALIGNMENT); 
		panelAuxsede.setMaximumSize(new Dimension(250, 30)); 
		lista_sedes = new JComboBox<String>();
		ListadeSedes listaSedes = new ListadeSedes();
		for (Sede sede : listaSedes.getListadeSedes()) {
			lista_sedes.addItem(sede.getNombre());
		}
		lista_sedes.setFont(new Font("Arial", Font.PLAIN, 13));
		lista_sedes.setForeground(new Color(92,92,102));
		lista_sedes.setActionCommand("LISTAsedes");
		panelAuxsede.add(lista_sedes, BorderLayout.CENTER);
		Izquierda.add(panelAuxsede);
		Izquierda.add(Estandar.Espacio());
		
		Derecha.add(Estandar.Espacio(1, 95));
		eusuario = Estandar.labelNegro("Usuario");
		Derecha.add(eusuario);
		esubusuario = Estandar.labelGris("Ingrese un nombre de usuario (alias):");
		Derecha.add(esubusuario);
		
		JPanel panelAuxTusuario = new JPanel(new BorderLayout()); 
		panelAuxTusuario.setMaximumSize(new Dimension(600, 30)); 
        tusuario = Estandar.campoTexto(); 
        panelAuxTusuario.add(tusuario, BorderLayout.CENTER);
        Derecha.add(panelAuxTusuario);
        Derecha.add(Estandar.Separador());
        
        ecorreo = Estandar.labelNegro("Correo"); 
		Derecha.add(ecorreo);
		esubcorreo = Estandar.labelGris("Ingrese su correo electronico:");
		Derecha.add(esubcorreo);
		
		JPanel panelAuxTcorreo = new JPanel(new BorderLayout()); 
		panelAuxTcorreo.setMaximumSize(new Dimension(600, 30)); 
		tcorreo = Estandar.campoTexto();
		panelAuxTcorreo.add(tcorreo, BorderLayout.CENTER);
		Derecha.add(panelAuxTcorreo);
		Derecha.add(Estandar.Separador());

        ecredito = Estandar.labelNegro("Asignar de su credito"); 
		Derecha.add(ecredito);
		esubcredito = Estandar.labelGris("Ingrese la cantidad de dinero ($):");
		Derecha.add(esubcredito);
		
		JPanel panelAuxTcredito = new JPanel(new BorderLayout()); 
		panelAuxTcredito.setMaximumSize(new Dimension(600, 30)); 
		tcredito = Estandar.campoTexto();
		panelAuxTcredito.add(tcredito, BorderLayout.CENTER);
		Derecha.add(panelAuxTcredito);
		Derecha.add(Estandar.Separador());
		
		eclave = Estandar.labelNegro("Clave"); 
		Izquierda.add(eclave);
		esubclave = Estandar.labelGris("Ingrese una clave:");
		Izquierda.add(esubclave);
		
		JPanel panelAuxTclave = new JPanel(new BorderLayout()); 
		panelAuxTclave.setMaximumSize(new Dimension(600, 30)); 
        tclave = Estandar.campoClave();
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
        trepetir = Estandar.campoClave();
        panelAuxTrepetir.add(trepetir, BorderLayout.CENTER);
        Derecha.add(panelAuxTrepetir);
        Derecha.add(Estandar.Separador());
		
		
		Derecha.add(Estandar.Espacio(1, 50));
		bsiguiente = Estandar.boton("Siguiente ->");
		bsiguiente.setActionCommand("bSiguiente");
		Derecha.add(bsiguiente);
		
		
		bregresar = Estandar.botonSinFondo("<- Regresar"); 
		bregresar.setActionCommand("bREGRESARpareja");
		Izquierda.add(bregresar);
		
		add(Izquierda);
		add(Derecha);
		
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
		return bsiguiente;
	}

	public void setBregistrar(JButton bregistrar) {
		this.bsiguiente = bregistrar;
	}

	public JLabel getEcredito() {
		return ecredito;
	}

	public void setEcredito(JLabel ecredito) {
		this.ecredito = ecredito;
	}

	public JLabel getEsubcredito() {
		return esubcredito;
	}

	public void setEsubcredito(JLabel esubcredito) {
		this.esubcredito = esubcredito;
	}

	public JLabel getEsede() {
		return esede;
	}

	public void setEsede(JLabel esede) {
		this.esede = esede;
	}

	public JLabel getEsubsede() {
		return esubsede;
	}

	public void setEsubsede(JLabel esubsede) {
		this.esubsede = esubsede;
	}

	public JComboBox<String> getLista_sedes() {
		return lista_sedes;
	}

	public void setLista_sedes(JComboBox<String> lista_sedes) {
		this.lista_sedes = lista_sedes;
	}

	public JTextField getTcredito() {
		return tcredito;
	}

	public void setTcredito(JTextField tcredito) {
		this.tcredito = tcredito;
	}

	public JButton getBregresar() {
		return bregresar;
	}

	public void setBregresar(JButton bregresar) {
		this.bregresar = bregresar;
	}
	
}
