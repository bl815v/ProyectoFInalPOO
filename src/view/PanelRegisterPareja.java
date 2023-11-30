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

 /*PanelRegisterPareja es una clase que extiende JPanel y representa el panel de registro para la pareja.
 * Contiene campos y controles para que el usuario ingrese información sobre su pareja.
 *@author Esteban Arevalo
 */
public class PanelRegisterPareja extends JPanel{

	private JLabel etitulo, esubtitulo, enombre, esubnombre, egenero, esubgenero, ecorreo, esubcorreo;
	private JLabel eusuario, esubusuario, eclave, esubclave, erepetir, esubrepetir, ecredito, esubcredito, esede, esubsede;
	private JComboBox<String> lista_genero, lista_sedes;
	private JTextField tnombre, tcorreo, tusuario, tcredito;
	private JPasswordField tclave, trepetir;
	private JButton bsiguiente, bregresar; 
    /**
     * Constructor de la clase. Inicializa el diseño y los componentes del panel.
     */
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
    /**
     * Inicializa y organiza los componentes del panel.
     */
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
	

	/**
 * Devuelve el objeto JLabel asociado al título.
 * @return El objeto JLabel del título.
 */
public JLabel getEtitulo() {
    return etitulo;
}

/**
 * Establece el objeto JLabel asociado al título.
 * @param etitulo El nuevo objeto JLabel para el título.
 */
public void setEtitulo(JLabel etitulo) {
    this.etitulo = etitulo;
}

/**
 * Devuelve el objeto JLabel asociado al subtítulo.
 * @return El objeto JLabel del subtítulo.
 */
public JLabel getEsubtitulo() {
    return esubtitulo;
}

/**
 * Establece el objeto JLabel asociado al subtítulo.
 * @param esubtitulo El nuevo objeto JLabel para el subtítulo.
 */
public void setEsubtitulo(JLabel esubtitulo) {
    this.esubtitulo = esubtitulo;
}

/**
 * Devuelve el objeto JLabel asociado al nombre.
 * @return El objeto JLabel del nombre.
 */
public JLabel getEnombre() {
    return enombre;
}

/**
 * Establece el objeto JLabel asociado al nombre.
 * @param enombre El nuevo objeto JLabel para el nombre.
 */
public void setEnombre(JLabel enombre) {
    this.enombre = enombre;
}

/**
 * Devuelve el objeto JLabel asociado al subnombre.
 * @return El objeto JLabel del subnombre.
 */
public JLabel getEsubnombre() {
    return esubnombre;
}
	/**
 * Establece el objeto JLabel asociado al subnombre.
 * @param esubnombre El nuevo objeto JLabel para el subnombre.
 */
public void setEsubnombre(JLabel esubnombre) {
    this.esubnombre = esubnombre;
}

/**
 * Devuelve el objeto JLabel asociado al género.
 * @return El objeto JLabel del género.
 */
public JLabel getEgenero() {
    return egenero;
}

/**
 * Establece el objeto JLabel asociado al género.
 * @param egenero El nuevo objeto JLabel para el género.
 */
public void setEgenero(JLabel egenero) {
    this.egenero = egenero;
}

/**
 * Devuelve el objeto JLabel asociado al subgénero.
 * @return El objeto JLabel del subgénero.
 */
public JLabel getEsubgenero() {
    return esubgenero;
}

/**
 * Establece el objeto JLabel asociado al subgénero.
 * @param esubgenero El nuevo objeto JLabel para el subgénero.
 */
public void setEsubgenero(JLabel esubgenero) {
    this.esubgenero = esubgenero;
}

/**
 * Devuelve el objeto JLabel asociado al correo.
 * @return El objeto JLabel del correo.
 */
public JLabel getEcorreo() {
    return ecorreo;
}

/**
 * Establece el objeto JLabel asociado al correo.
 * @param ecorreo El nuevo objeto JLabel para el correo.
 */
public void setEcorreo(JLabel ecorreo) {
    this.ecorreo = ecorreo;
}

/**
 * Devuelve el objeto JLabel asociado al subcorreo.
 * @return El objeto JLabel del subcorreo.
 */
public JLabel getEsubcorreo() {
    return esubcorreo;
}

/**
 * Establece el objeto JLabel asociado al subcorreo.
 * @param esubcorreo El nuevo objeto JLabel para el subcorreo.
 */
public void setEsubcorreo(JLabel esubcorreo) {
    this.esubcorreo = esubcorreo;
}

/**
 * Devuelve el objeto JLabel asociado al usuario.
 * @return El objeto JLabel del usuario.
 */
public JLabel getEusuario() {
    return eusuario;
}

/**
 * Establece el objeto JLabel asociado a Eusuario
 * @param eusuario El nuevo objeto JLabel para la eiqueta usuario
 */
public void setEusuario(JLabel eusuario) {
		this.eusuario = eusuario;
}

	/**
 * Establece el objeto JLabel asociado al subusuario.
 * @param esubusuario El nuevo objeto JLabel para el subusuario.
 */
public void setEsubusuario(JLabel esubusuario) {
    this.esubusuario = esubusuario;
}

/**
 * Devuelve el objeto JLabel asociado al subusuario.
 * @return El objeto JLabel del subusuario.
 */
public JLabel getEsubusuario() {
    return esubusuario;
}

/**
 * Establece el objeto JLabel asociado a la clave.
 * @param eclave El nuevo objeto JLabel para la clave.
 */
public void setEclave(JLabel eclave) {
    this.eclave = eclave;
}

/**
 * Devuelve el objeto JLabel asociado a la clave.
 * @return El objeto JLabel de la clave.
 */
public JLabel getEclave() {
    return eclave;
}

/**
 * Establece el objeto JLabel asociado al subclave.
 * @param esubclave El nuevo objeto JLabel para el subclave.
 */
public void setEsubclave(JLabel esubclave) {
    this.esubclave = esubclave;
}

/**
 * Devuelve el objeto JLabel asociado al subclave.
 * @return El objeto JLabel del subclave.
 */
public JLabel getEsubclave() {
    return esubclave;
}

/**
 * Establece el objeto JLabel asociado a repetir.
 * @param erepetir El nuevo objeto JLabel para repetir.
 */
public void setErepetir(JLabel erepetir) {
    this.erepetir = erepetir;
}

/**
 * Devuelve el objeto JLabel asociado a repetir.
 * @return El objeto JLabel de repetir.
 */
public JLabel getErepetir() {
    return erepetir;
}

/**
 * Establece el objeto JLabel asociado al subrepetir.
 * @param esubrepetir El nuevo objeto JLabel para el subrepetir.
 */
public void setEsubrepetir(JLabel esubrepetir) {
    this.esubrepetir = esubrepetir;
}

/**
 * Devuelve el objeto JLabel asociado al subrepetir.
 * @return El objeto JLabel del subrepetir.
 */
public JLabel getEsubrepetir() {
    return esubrepetir;
}

/**
 * Devuelve el objeto JComboBox asociado a la lista de género.
 * @return El objeto JComboBox de la lista de género.
 */
public JComboBox<String> getLista_genero() {
    return lista_genero;
}

/**
 * Establece el objeto JComboBox asociado a la lista de género.
 * @param lista_genero El nuevo objeto JComboBox para la lista de género.
 */
public void setLista_genero(JComboBox<String> lista_genero) {
    this.lista_genero = lista_genero;
}

/**
 * Devuelve el objeto JTextField asociado al nombre.
 * @return El objeto JTextField del nombre.
 */
public JTextField getTnombre() {
    return tnombre;
}

/**
 * Establece el objeto JTextField asociado al nombre.
 * @param tnombre El nuevo objeto JTextField para el nombre.
 */
public void setTnombre(JTextField tnombre) {
    this.tnombre = tnombre;
}

/**
 * Devuelve el objeto JTextField asociado al correo.
 * @return El objeto JTextField del correo.
 */
public JTextField getTcorreo() {
    return tcorreo;
}

/**
 * Establece el objeto JTextField asociado al correo.
 * @param tcorreo El nuevo objeto JTextField para el correo.
 */
public void setTcorreo(JTextField tcorreo) {
    this.tcorreo = tcorreo;
}

/**
 * Devuelve el objeto JTextField asociado al usuario.
 * @return El objeto JTextField del usuario.
 */
public JTextField getTusuario() {
    return tusuario;
}

/**
 * Establece el objeto JTextField asociado al usuario.
 * @param tusuario El nuevo objeto JTextField para el usuario.
 */
public void setTusuario(JTextField tusuario) {
    this.tusuario = tusuario;
}

/**
 * Devuelve el objeto JPasswordField asociado a la clave.
 * @return El objeto JPasswordField de la clave.
 */
public JPasswordField getTclave() {
    return tclave;
}

/**
 * Establece el objeto JPasswordField asociado a la clave.
 * @param tclave El nuevo objeto JPasswordField para la clave.
 */
public void setTclave(JPasswordField tclave) {
    this.tclave = tclave;
}

/**
 * Devuelve el objeto JPasswordField asociado a repetir.
 * @return El objeto JPasswordField de repetir.
 */
public JPasswordField getTrepetir() {
    return trepetir;
}

/**
 * Establece el objeto JPasswordField asociado a repetir.
 * @param trepetir El nuevo objeto JPasswordField para repetir.
 */
public void setTrepetir(JPasswordField trepetir) {
    this.trepetir = trepetir;
}

/**
 * Devuelve el objeto JButton asociado al botón de registrar.
 * @return El objeto JButton del botón de registrar.
 */
public JButton getBregistrar() {
    return bsiguiente;
}

/**
 * Establece el objeto JButton asociado al botón de registrar.
 * @param bregistrar El nuevo objeto JButton para el botón de registrar.
 */
public void setBregistrar(JButton bregistrar) {
    this.bsiguiente = bregistrar;
}


	/**
 * Devuelve el objeto JLabel asociado al crédito.
 * @return El objeto JLabel del crédito.
 */
public JLabel getEcredito() {
    return ecredito;
}

/**
 * Establece el objeto JLabel asociado al crédito.
 * @param ecredito El nuevo objeto JLabel para el crédito.
 */
public void setEcredito(JLabel ecredito) {
    this.ecredito = ecredito;
}

/**
 * Devuelve el objeto JLabel asociado al subcrédito.
 * @return El objeto JLabel del subcrédito.
 */
public JLabel getEsubcredito() {
    return esubcredito;
}

/**
 * Establece el objeto JLabel asociado al subcrédito.
 * @param esubcredito El nuevo objeto JLabel para el subcrédito.
 */
public void setEsubcredito(JLabel esubcredito) {
    this.esubcredito = esubcredito;
}

/**
 * Devuelve el objeto JLabel asociado a la sede.
 * @return El objeto JLabel de la sede.
 */
public JLabel getEsede() {
    return esede;
}

/**
 * Establece el objeto JLabel asociado a la sede.
 * @param esede El nuevo objeto JLabel para la sede.
 */
public void setEsede(JLabel esede) {
    this.esede = esede;
}

/**
 * Devuelve el objeto JLabel asociado al subsede.
 * @return El objeto JLabel del subsede.
 */
public JLabel getEsubsede() {
    return esubsede;
}

/**
 * Establece el objeto JLabel asociado al subsede.
 * @param esubsede El nuevo objeto JLabel para el subsede.
 */
public void setEsubsede(JLabel esubsede) {
    this.esubsede = esubsede;
}

/**
 * Devuelve el objeto JComboBox asociado a la lista de sedes.
 * @return El objeto JComboBox de la lista de sedes.
 */
public JComboBox<String> getLista_sedes() {
    return lista_sedes;
}

/**
 * Establece el objeto JComboBox asociado a la lista de sedes.
 * @param lista_sedes El nuevo objeto JComboBox para la lista de sedes.
 */
public void setLista_sedes(JComboBox<String> lista_sedes) {
    this.lista_sedes = lista_sedes;
}

/**
 * Devuelve el objeto JTextField asociado al crédito.
 * @return El objeto JTextField del crédito.
 */
public JTextField getTcredito() {
    return tcredito;
}

/**
 * Establece el objeto JTextField asociado al crédito.
 * @param tcredito El nuevo objeto JTextField para el crédito.
 */
public void setTcredito(JTextField tcredito) {
    this.tcredito = tcredito;
}

/**
 * Devuelve el objeto JButton asociado al botón de regresar.
 * @return El objeto JButton del botón de regresar.
 */
public JButton getBregresar() {
    return bregresar;
}

/**
 * Establece el objeto JButton asociado al botón de regresar.
 * @param bregresar El nuevo objeto JButton para el botón de regresar.
 */
public void setBregresar(JButton bregresar) {
    this.bregresar = bregresar;
}

	
}