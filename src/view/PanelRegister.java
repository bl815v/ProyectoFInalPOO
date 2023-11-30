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

/**
 * La clase PanelRegister representa un panel de registro que permite a los
 * usuarios crear una nueva cuenta. Contiene campos para ingresar información
 * personal, como nombres, género, correo electrónico, nombre de usuario y
 * contraseña. Además, proporciona botones para el registro y para iniciar
 * sesión si ya se tiene una cuenta.
 * 
 * @author Esteban Arevalo
 */
public class PanelRegister extends JPanel {

	private JLabel etitulo, esubtitulo, enombre, esubnombre, egenero, esubgenero, ecorreo, esubcorreo;
	private JLabel eusuario, esubusuario, eclave, esubclave, erepetir, esubrepetir, eyatienes;
	private JComboBox<String> lista_genero;
	private JTextField tnombre, tcorreo, tusuario;
	private JPasswordField tclave, trepetir;
	private JButton bregistrar, blogin;

	/**
	 * Constructor para PanelRegister. Inicializa el diseño, tamaño y componentes
	 * del panel de registro. Además, realiza la configuración de revisión de campos
	 * de texto mediante el método revisarTextField.
	 */
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

	/**
	 * Inicializa los componentes de la interfaz gráfica y los organiza en el panel.
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

		JSeparator espacio = Estandar.Espacio(1, 50);
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
		lista_genero.setForeground(new Color(92, 92, 102));
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

	/**
	 * Obtiene la etiqueta del título.
	 * 
	 * @return La etiqueta del título.
	 */
	public JLabel getEtitulo() {
		return etitulo;
	}

	/**
	 * Establece la etiqueta del título.
	 * 
	 * @param etitulo La nueva etiqueta del título.
	 */
	public void setEtitulo(JLabel etitulo) {
		this.etitulo = etitulo;
	}

	/**
	 * Obtiene la etiqueta del subtitulo.
	 * 
	 * @return La etiqueta del subtitulo.
	 */
	public JLabel getEsubtitulo() {
		return esubtitulo;
	}

	/**
	 * Establece la etiqueta del subtitulo.
	 * 
	 * @param esubtitulo La nueva etiqueta del subtitulo.
	 */
	public void setEsubtitulo(JLabel esubtitulo) {
		this.esubtitulo = esubtitulo;
	}

	/**
	 * Obtiene la etiqueta para el nombre.
	 * 
	 * @return La etiqueta para el nombre.
	 */
	public JLabel getEnombre() {
		return enombre;
	}

	/**
	 * Establece la etiqueta para el nombre.
	 * 
	 * @param enombre La nueva etiqueta para el nombre.
	 */
	public void setEnombre(JLabel enombre) {
		this.enombre = enombre;
	}

	/**
	 * Obtiene la etiqueta secundaria para el nombre.
	 * 
	 * @return La etiqueta secundaria para el nombre.
	 */
	public JLabel getEsubnombre() {
		return esubnombre;
	}

	/**
	 * Establece la etiqueta secundaria para el nombre.
	 * 
	 * @param esubnombre La nueva etiqueta secundaria para el nombre.
	 */
	public void setEsubnombre(JLabel esubnombre) {
		this.esubnombre = esubnombre;
	}

	/**
	 * Obtiene la etiqueta para el género.
	 * 
	 * @return La etiqueta para el género.
	 */
	public JLabel getEgenero() {
		return egenero;
	}

	/**
	 * Establece la etiqueta para el género.
	 * 
	 * @param egenero La nueva etiqueta para el género.
	 */
	public void setEgenero(JLabel egenero) {
		this.egenero = egenero;
	}

	/**
	 * Obtiene la etiqueta secundaria para el género.
	 * 
	 * @return La etiqueta secundaria para el género.
	 */
	public JLabel getEsubgenero() {
		return esubgenero;
	}

	/**
	 * Establece la etiqueta secundaria para el género.
	 * 
	 * @param esubgenero La nueva etiqueta secundaria para el género.
	 */
	public void setEsubgenero(JLabel esubgenero) {
		this.esubgenero = esubgenero;
	}

	/**
	 * Obtiene la etiqueta para el correo.
	 * 
	 * @return La etiqueta para el correo.
	 */
	public JLabel getEcorreo() {
		return ecorreo;
	}

	/**
	 * Establece la etiqueta para el correo.
	 * 
	 * @param ecorreo La nueva etiqueta para el correo.
	 */
	public void setEcorreo(JLabel ecorreo) {
		this.ecorreo = ecorreo;
	}

	/**
	 * Obtiene la etiqueta secundaria para el correo.
	 * 
	 * @return La etiqueta secundaria para el correo.
	 */
	public JLabel getEsubcorreo() {
		return esubcorreo;
	}

	/**
	 * Establece la etiqueta secundaria para el correo.
	 * 
	 * @param esubcorreo La nueva etiqueta secundaria para el correo.
	 */
	public void setEsubcorreo(JLabel esubcorreo) {
		this.esubcorreo = esubcorreo;
	}

	/**
	 * Obtiene la etiqueta para el usuario.
	 * 
	 * @return La etiqueta para el usuario.
	 */
	public JLabel getEusuario() {
		return eusuario;
	}

	/**
	 * Establece la etiqueta para el usuario.
	 * 
	 * @param eusuario La nueva etiqueta para el usuario.
	 */
	public void setEusuario(JLabel eusuario) {
		this.eusuario = eusuario;
	}

	/**
	 * Obtiene la etiqueta secundaria para el usuario.
	 * 
	 * @return La etiqueta secundaria para el usuario.
	 */
	public JLabel getEsubusuario() {
		return esubusuario;
	}

	/**
	 * Establece la etiqueta secundaria para el usuario.
	 * 
	 * @param esubusuario La nueva etiqueta secundaria para el usuario.
	 */
	public void setEsubusuario(JLabel esubusuario) {
		this.esubusuario = esubusuario;
	}

	/**
	 * Obtiene la etiqueta para la clave.
	 * 
	 * @return La etiqueta para la clave.
	 */
	public JLabel getEclave() {
		return eclave;
	}

	/**
	 * Establece la etiqueta para la clave.
	 * 
	 * @param eclave La nueva etiqueta para la clave.
	 */
	public void setEclave(JLabel eclave) {
		this.eclave = eclave;
	}

	/**
	 * Obtiene la etiqueta secundaria para la clave.
	 * 
	 * @return La etiqueta secundaria para la clave.
	 */
	public JLabel getEsubclave() {
		return esubclave;
	}

	/**
	 * Establece la etiqueta secundaria para la clave.
	 * 
	 * @param esubclave La nueva etiqueta secundaria para la clave.
	 */
	public void setEsubclave(JLabel esubclave) {
		this.esubclave = esubclave;
	}

	/**
	 * Obtiene la etiqueta para repetir la clave.
	 * 
	 * @return La etiqueta para repetir la clave.
	 */
	public JLabel getErepetir() {
		return erepetir;
	}

	/**
	 * Establece la etiqueta para repetir la clave.
	 * 
	 * @param erepetir La nueva etiqueta para repetir la clave.
	 */
	public void setErepetir(JLabel erepetir) {
		this.erepetir = erepetir;
	}

	/**
	 * Obtiene la etiqueta secundaria para repetir la clave.
	 * 
	 * @return La etiqueta secundaria para repetir la clave.
	 */
	public JLabel getEsubrepetir() {
		return esubrepetir;
	}

	/**
	 * Establece la etiqueta secundaria para repetir la clave.
	 * 
	 * @param esubrepetir La nueva etiqueta secundaria para repetir la clave.
	 */
	public void setEsubrepetir(JLabel esubrepetir) {
		this.esubrepetir = esubrepetir;
	}

	/**
	 * Obtiene la etiqueta para el mensaje "Ya tienes una cuenta?".
	 * 
	 * @return La etiqueta para el mensaje "Ya tienes una cuenta?".
	 */
	public JLabel getEyatienes() {
		return eyatienes;
	}

	/**
	 * Establece la etiqueta para el mensaje "Ya tienes una cuenta?".
	 * 
	 * @param eyatienes La nueva etiqueta para el mensaje "Ya tienes una cuenta?".
	 */
	public void setEyatienes(JLabel eyatienes) {
		this.eyatienes = eyatienes;
	}

	/**
	 * Obtiene la lista desplegable para el género.
	 * 
	 * @return La lista desplegable para el género.
	 */
	public JComboBox<String> getLista_genero() {
		return lista_genero;
	}

	/**
	 * Establece la lista desplegable para el género.
	 * 
	 * @param lista_genero La nueva lista desplegable para el género.
	 */
	public void setLista_genero(JComboBox<String> lista_genero) {
		this.lista_genero = lista_genero;
	}

	/**
	 * Obtiene el campo de texto para el nombre.
	 * 
	 * @return El campo de texto para el nombre.
	 */
	public JTextField getTnombre() {
		return tnombre;
	}

	/**
	 * Establece el campo de texto para el nombre.
	 * 
	 * @param tnombre El nuevo campo de texto para el nombre.
	 */
	public void setTnombre(JTextField tnombre) {
		this.tnombre = tnombre;
	}

	/**
	 * Obtiene el campo de texto para el correo.
	 * 
	 * @return El campo de texto para el correo.
	 */
	public JTextField getTcorreo() {
		return tcorreo;
	}

	/**
	 * Establece el campo de texto para el correo.
	 * 
	 * @param tcorreo El nuevo campo de texto para el correo.
	 */
	public void setTcorreo(JTextField tcorreo) {
		this.tcorreo = tcorreo;
	}

	/**
	 * Obtiene el campo de texto para el usuario.
	 * 
	 * @return El campo de texto para el usuario.
	 */
	public JTextField getTusuario() {
		return tusuario;
	}

	/**
	 * Establece el campo de texto para el usuario.
	 * 
	 * @param tusuario El nuevo campo de texto para el usuario.
	 */
	public void setTusuario(JTextField tusuario) {
		this.tusuario = tusuario;
	}

	/**
	 * Obtiene el campo de contraseña.
	 * 
	 * @return El campo de contraseña.
	 */
	public JPasswordField getTclave() {
		return tclave;
	}

	/**
	 * Establece el campo de contraseña.
	 * 
	 * @param tclave El nuevo campo de contraseña.
	 */
	public void setTclave(JPasswordField tclave) {
		this.tclave = tclave;
	}

	/**
	 * Obtiene el campo de contraseña para repetir.
	 * 
	 * @return El campo de contraseña para repetir.
	 */
	public JPasswordField getTrepetir() {
		return trepetir;
	}

	/**
	 * Establece el campo de contraseña para repetir.
	 * 
	 * @param trepetir El nuevo campo de contraseña para repetir.
	 */
	public void setTrepetir(JPasswordField trepetir) {
		this.trepetir = trepetir;
	}

	/**
	 * Obtiene el botón de registrar.
	 * 
	 * @return El botón de registrar.
	 */
	public JButton getBregistrar() {
		return bregistrar;
	}

	/**
	 * Establece el botón de registrar.
	 * 
	 * @param bregistrar El nuevo botón de registrar.
	 */
	public void setBregistrar(JButton bregistrar) {
		this.bregistrar = bregistrar;
	}

	/**
	 * Obtiene el botón de iniciar sesión.
	 * 
	 * @return El botón de iniciar sesión.
	 */
	public JButton getBlogin() {
		return blogin;
	}

	/**
	 * Establece el botón de iniciar sesión.
	 * 
	 * @param blogin El nuevo botón de iniciar sesión.
	 */
	public void setBlogin(JButton blogin) {
		this.blogin = blogin;
	}

}