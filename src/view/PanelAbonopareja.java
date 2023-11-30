package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * PanelAbono es el panel para que el usuario pueda abonar a su deuda desde la
 * interfaz grafica. Contiene todos los componentes necesarios para que el
 * usuario logre hacer esta actividad.
 * 
 * @author Bedoya Lautero
 * 
 */
public class PanelAbonopareja extends JPanel {

	private JLabel etitulo, esaldoPendiente, eDineropendiente, eingrese, edinero, epesos;
	private JTextField tmonto;
	private JButton babonar, bcerrar;

	/**
	 * Crea el panel e inicializa sus componentes. 580px ancho, 280px largo,
	 * BoxLayout en el eje Y, por defecto no es visible.
	 */
	public PanelAbonopareja() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(580, 280));

		inicializarComponentes();
		setVisible(false);

		Estandar.revisarTextField(tmonto, eingrese, "Ingrese la cantidad de dinero a abonar:");
	}

	/**
	 * Inicializa los componentes del panel. Relacionados al saldo pendiente, la
	 * cantidad de dinero a abonar, botones abonar y cancelar.
	 */
	public void inicializarComponentes() {
		etitulo = Estandar.HideSeek();
		add(etitulo);
		add(Estandar.Espacio());

		esaldoPendiente = Estandar.labelGris("Saldo Pendiente:");
		add(esaldoPendiente);

		eDineropendiente = Estandar.labelNegro("$ 1000000 pesos");
		add(eDineropendiente);

		add(Estandar.Espacio());

		eingrese = Estandar.labelNegro("Ingrese la cantidad de dinero a abonar:");
		add(eingrese);

		add(Estandar.Espacio());

		JPanel auxIngrese = new JPanel();
		auxIngrese.setLayout(new BoxLayout(auxIngrese, BoxLayout.X_AXIS));
		auxIngrese.add(Estandar.Espacio(150, 1));

		edinero = Estandar.labelNegro("$ ");
		auxIngrese.add(edinero);

		tmonto = new JTextField();
		tmonto.setFont(new Font("Arial", Font.PLAIN, 18));
		tmonto.setMaximumSize(new Dimension(400, 35));

		auxIngrese.add(tmonto);

		epesos = Estandar.labelNegro(" pesos");
		auxIngrese.add(epesos);
		add(auxIngrese);

		add(Estandar.Espacio(1, 60));

		JPanel auxBotones = new JPanel();
		auxBotones.setLayout(new GridLayout(1, 2, 20, 25));
		babonar = Estandar.boton("Abonar");
		babonar.setActionCommand("bABONARpareja");
		auxBotones.add(babonar);

		bcerrar = Estandar.boton("Cancelar");
		bcerrar.setActionCommand("bCANCELARABONOpareja");
		auxBotones.add(bcerrar);
		add(auxBotones);

	}

	/**
	 * Obtiene el JLabel con el titulo, es lo primero que aparece en el panel. Texto
	 * por defecto: "HIDE&SEEK".
	 * 
	 * @return JLabel con el titulo
	 */
	public JLabel getEtitulo() {
		return etitulo;
	}

	/**
	 * Cambia el JLabel con el titulo por otro JLabel, es lo primero que aparece en
	 * el panel. Texto por defecto: "HIDE&SEEK".
	 * 
	 * @param etitulo JLabel por el que se desea cambiar
	 */
	public void setEtitulo(JLabel etitulo) {
		this.etitulo = etitulo;
	}

	/**
	 * Obtiene el JLabel que funciona como un titulo antes de indicar el dinero que
	 * debe. Estandar.labelGris(). Texto por defecto: "Saldo Pendiente:".
	 * 
	 * @return JLabel que aparece arriba de indicar el dinero que debe
	 */
	public JLabel getEsaldoPendiente() {
		return esaldoPendiente;
	}

	/**
	 * Cambia el JLabel que funciona como un titulo antes de indicar el dinero que
	 * debe.
	 * 
	 * @param esaldoPendiente JLabel por el que se desea cambiar
	 */
	public void setEsaldoPendiente(JLabel esaldoPendiente) {
		this.esaldoPendiente = esaldoPendiente;
	}

	/**
	 * Obtiene el JLabel que indica el dinero que debe. Estandar.labelNegro(). Texto
	 * por defecto: "$ 1000000 pesos".
	 * 
	 * @return JLabel que indica el dinero que debe.
	 */
	public JLabel geteDineropendiente() {
		return eDineropendiente;
	}

	/**
	 * Cambia el JLabel que indica el dinero que debe.
	 * 
	 * @param eDineropendiente JLabel por el que se desea cambiar
	 */
	public void seteDineropendiente(JLabel eDineropendiente) {
		this.eDineropendiente = eDineropendiente;
	}

	/**
	 * Obtiene el JLabel que funciona como un titulo antes de indicar el dinero a
	 * abonar. Estandar.labelNegro(). Texto por defecto: "Ingrese la cantidad de
	 * dinero a abonar:".
	 * 
	 * @return JLabel que aparece arriba del JTextField en el que el usuario ingresa
	 *         el valor a abonar.
	 */
	public JLabel getEingrese() {
		return eingrese;
	}

	/**
	 * Cambia el JLabel que funciona como un titulo antes de indicar el dinero a
	 * abonar.
	 * 
	 * @param eingrese JLabel por el que se desea cambiar
	 */
	public void setEingrese(JLabel eingrese) {
		this.eingrese = eingrese;
	}

	/**
	 * Obtiene el JLabel auxiliar que está antes del JTextField en el que el usuario
	 * ingresa el valor a abonar. Estandar.labelNegro(). Texto por defecto: "$ "
	 * 
	 * @return JLabel antes del JTextField para ingresar el valor a abonar.
	 */
	public JLabel getEdinero() {
		return edinero;
	}

	/**
	 * Cambia el JLabel auxiliar que está antes del JTextField en el que el usuario
	 * ingresa el valor a abonar.
	 * 
	 * @param edinero JLabel por el que se desea cambiar
	 */
	public void setEdinero(JLabel edinero) {
		this.edinero = edinero;
	}

	/**
	 * Obtiene el JLabel auxiliar que está después del JTextField en el que el
	 * usuario ingresa el valor a abonar. Estandar.labelNegro(). Texto por defecto:
	 * " pesos".
	 * 
	 * @return JLabel después del JTextField para ingresar el valor a abonar.
	 */
	public JLabel getEpesos() {
		return epesos;
	}

	/**
	 * Cambia el JLabel auxiliar que está después del JTextField en el que el
	 * usuario ingresa el valor a abonar.
	 * 
	 * @param epesos JLabel por el que se desea cambiar
	 */
	public void setEpesos(JLabel epesos) {
		this.epesos = epesos;
	}

	/**
	 * Obtiene el JTextField en el que el usuario ingresa el valor a abonar. Por
	 * defecto es de 400px ancho, 35px largo, fuente Arial a 18px.
	 * 
	 * @return JTextField en el que el usuario ingresa el valor a abonar
	 */
	public JTextField getTmonto() {
		return tmonto;
	}

	/**
	 * Cambia el JTextField en el que el usuario ingresa el valor a abonar.
	 * 
	 * @param tmonto JTextField por el que se desea cambiar
	 */
	public void setTmonto(JTextField tmonto) {
		this.tmonto = tmonto;
	}

	/**
	 * Obtiene el JButton para abonar el valor que el usuario ingreso en el
	 * JTextField. Estandar.boton("Abonar"). Comando de acción: "bABONAR".
	 * 
	 * @return JButton para abonar el valor ingresado en el JTextField
	 */
	public JButton getBabonar() {
		return babonar;
	}

	/**
	 * Cambia el JButton para abonar el valor que el usuario ingreso en el
	 * JTextField.
	 * 
	 * @param babonar JButton por el que se desea cambiar
	 */
	public void setBabonar(JButton babonar) {
		this.babonar = babonar;
	}

	/**
	 * Obtiene el JButton para salir del panel. Estandar.boton("Cancelar"). Comando
	 * de acción: "bCANCELARABONO".
	 * 
	 * @return JButton para salir del panel
	 */
	public JButton getBcerrar() {
		return bcerrar;
	}

	/**
	 * Cambia el JButton para salir del panel.
	 * 
	 * @param bcerrar Jbutton por el que se desea cambiar
	 */
	public void setBcerrar(JButton bcerrar) {
		this.bcerrar = bcerrar;
	}

}
