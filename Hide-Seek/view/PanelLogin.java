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
/**
 * PanelLogin es el panel en el que se puede iniciar sesion.
 * Contiene todos los componentes necesarios para iniciar sesion con su usuario y clave.
 * @author Bedoya Lautero
 * 
 */
public class PanelLogin extends JPanel{

	private JLabel etitulo, esubtitulo, eusuario, esubusuario, eclave, esubclave, enotienes;
	private JTextField tusuario;
	private JPasswordField tclave;
	private JButton bentrar, bregistrate;
/**
 * Crea el panel e inicializa sus componentes.
 * 270px ancho, 400px largo, BoxLayout en el eje Y, por defecto es visible.
 */
	public PanelLogin() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(270, 400));

		inicializarComponentes();
		setVisible(true);
		
		Estandar.revisarTextField(tusuario, esubusuario, "Ingrese su nombre de usuario (alias):");
		Estandar.revisarTextField(tclave, esubclave, "Ingrese su clave:");
	}
/**
 * Inicializa los componentes del panel.
 * Relacionados a iniciar sesion con el usuario y clave
 */
	public void inicializarComponentes() {
		
		etitulo = Estandar.HideSeek();
		add(etitulo);
		
		esubtitulo = Estandar.labelGris("Incia sesion para continuar.");
		add(esubtitulo);
		
		add(Estandar.Espacio());
		
		eusuario = Estandar.labelNegro("Usuario");
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
        
        add(Estandar.Separador());
		
		eclave = Estandar.labelNegro("Clave"); 
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
       
        add(Estandar.Separador());
	
		bentrar = Estandar.boton("Entrar ->");
		bentrar.setActionCommand("bLOGIN");
		add(bentrar);
		
		add(Estandar.Espacio(1, 90));
		
		enotienes = new JLabel("No tienes una cuenta?"); 
		enotienes.setFont(new Font("Arial", Font.PLAIN, 14));
		enotienes.setForeground(new Color(92,92,102));
		add(enotienes);
		
		bregistrate = Estandar.botonSinFondo("Registrate"); 
		bregistrate.setActionCommand("bREGISTRATE");
		add(bregistrate);
	}

/**
 * Obtiene el JLabel que funciona como un subtitulo para indicar que se debe ingresar el usuario en el siguiente JTextField.
 * Fuente Arial a 14px. Texto por defecto: "Ingrese su nombre de usuario (alias):".
 * @return JLabel para indicar que debe ingresar el usuario
 */
	public JLabel getEsubusuario() {
		return esubusuario;
	}
/**
 * Cambia el JLabel que funciona como un subtitulo para indicar que se debe ingresar el usuario en el siguiente JTextField.
 * @param esubusuario JLabel por el que se desea cambiar
 */
	public void setEsubusuario(JLabel esubusuario) {
		this.esubusuario = esubusuario;
	}
/**
 * Obtiene el JLabel que funciona como un subtitulo para indicar que se debe ingresar la clave en el siguiente JTextField.
 * Fuente Arial a 14px. Texto por defecto: "Ingrese su clave:". 
 * @return JLabel para indicar que debe ingresar la clave
 */
	public JLabel getEsubclave() {
		return esubclave;
	}
/**
 * Cambia el JLabel que funciona como un subtitulo para indicar que se debe ingresar la clave en el siguiente JTextField.
 * @param esubclave JLabel por el que se desea cambiar
 */
	public void setEsubclave(JLabel esubclave) {
		this.esubclave = esubclave;
	}
/**
 * Obtiene el JLabel con el titulo, es lo primero que aparece en el panel.
 * Texto por defecto: "HIDE&SEEK".
 * @return JLabel con el titulo
 */
	public JLabel getEtitulo() {
		return etitulo;
	}
/**
 * Cambia el JLabel con el titulo por otro JLabel, es lo primero que aparece en el panel. 
 * Texto por defecto: "HIDE&SEEK".
 * @param etitulo JLabel por el que se desea cambiar
 */
	public void setEtitulo(JLabel etitulo) {
		this.etitulo = etitulo;
	}
/**
 * Obtiene el JLabel con el subtitulo, es lo segundo que aparece en el panel.
 * Estandar.labelGris(). Texto por defecto: "Incia sesion para continuar.".
 * @return JLabel con el subtitulo
 */
	public JLabel getEsubtitulo() {
		return esubtitulo;
	}
/**
 * Cambia el JLabel con el subtitulo, es lo segundo que aparece en el panel.
 * @param esubtitulo JLabel por el que se desea cambiar
 */
	public void setEsubtitulo(JLabel esubtitulo) {
		this.esubtitulo = esubtitulo;
	}
/**
 * Obtiene el JLabel que funciona como un titulo para indicar que se debe ingresar el usuario en el siguiente JTextField.
 * Estandar.labelNegro(). Texto por defecto: "Usuario".
 * @return JLabel para indicar que debe ingresar el usuario
 */
	public JLabel getEusuario() {
		return eusuario;
	}
/**
 * Cambia el JLabel que funciona como un titulo para indicar que se debe ingresar el usuario en el siguiente JTextField. 
 * @param eusuario JLabel por el que se desea cambiar
 */
	public void setEusuario(JLabel eusuario) {
		this.eusuario = eusuario;
	}
/**
 * Obtiene el JLabel que funciona como un titulo para indicar que se debe ingresar la clave en el siguiente JTextField.
 * Estandar.labelNegro(). Texto por defecto: "Clave". 
 * @return JLabel para indicar que debe ingresar la clave
 */
	public JLabel getEclave() {
		return eclave;
	}
/**
 * Obtiene el JLabel que funciona como un titulo para indicar que se debe ingresar la clave en el siguiente JTextField.
 * @param eclave JLabel por el que se desea cambiar
 */
	public void setEclave(JLabel eclave) {
		this.eclave = eclave;
	}
/**
 * Obtiene el JLabel que explica al boton para registrarse que se ubica debajo del JLabel.
 * Fuente Arial a 14px. Texto por defecto: "No tienes una cuenta?".
 * @return JLabel que explica al boton para registrarse
 */
	public JLabel getEnotienes() {
		return enotienes;
	}
/**
 * Cambia el JLabel que explica al boton para registrarse que se ubica debajo del JLabel.
 * @param enotienes JLabel por el que se desea cambiar
 */
	public void setEnotienes(JLabel enotienes) {
		this.enotienes = enotienes;
	}
/**
 * Obtiene el JTextField en el que el usuario ingresa su usuario.
 * Por defecto es de 300px ancho, 30px largo, fuente Arial a 13px.
 * @return JTextField para ingresar el usuario
 */
	public JTextField getTusuario() {
		return tusuario;
	}
/**
 * Cambia el JTextField en el que el usuario ingresa su usuario.
 * @param tusuario JTextField por el que se desea cambiar
 */
	public void setTusuario(JTextField tusuario) {
		this.tusuario = tusuario;
	}
/**
 * Obtiene el JPasswordField en el que el usuario ingresa su clave.
 * Por defecto es de 300px ancho, 30px largo, fuente Arial a 13px.
 * @return JPasswordField para ingresar la clave
 */
	public JPasswordField getTclave() {
		return tclave;
	}
/**
 * Cambia el JPasswordField en el que el usuario ingresa su clave.
 * @param tclave JPasswordField por el que se desea cambiar
 */
	public void setTclave(JPasswordField tclave) {
		this.tclave = tclave;
	}
/**
 * Obtiene el JButton para iniciar sesion y abrir la ventana cliente, administrador o pareja.
 * Estandar.boton("Entrar ->"). Comando de acción: "bLOGIN".
 * @return JButton para iniciar sesion
 */
	public JButton getBentrar() {
		return bentrar;
	}
/**
 * Cambia el JButton para iniciar sesion y abrir la ventana cliente, administrador o pareja.
 * @param bentrar JButton por el que se desea cambiar
 */
	public void setBentrar(JButton bentrar) {
		this.bentrar = bentrar;
	}
/**
 * Obtiene el JButton para abrir el panel de registro.
 * Estandar.boton("Registrate"). Comando de acción: "bREGISTRATE".
 * @return
 */
	public JButton getBregistrate() {
		return bregistrate;
	}
/**
 * Cambia el JButton para abrir el panel de registro.
 * @param bregistrate JButton por el que se desea cambiar
 */
	public void setBregistrate(JButton bregistrate) {
		this.bregistrate = bregistrate;
	}

}
