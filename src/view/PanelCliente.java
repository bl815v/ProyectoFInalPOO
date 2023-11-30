package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * PanelCliente es el panel con el menu principal del cliente en la interfaz
 * grafica. Contiene todos los componentes necesarios para que el cliente pueda
 * ver su cupo disponible, su saldo pendiente, botones para comprar, ver sus
 * parejas, su historial de compras y pedir un sobrecupo.
 * 
 * @author Bedoya Lautero
 * 
 */
public class PanelCliente extends JPanel {

	private JLabel eblanco, etitulo, enombre, ecupoDisponible, esaldoPendiente, eDinerodisponible, eDineropendiente;
	private JButton bcomprar, babonar, bnuevaPareja, bparejasActuales, bhistorial, bpedirSobrecupo, bcerrar;

	/**
	 * Crea el panel e inicializa sus componentes. 680px ancho, 520px largo,
	 * BorderLayout, por defecto es visible.
	 */
	public PanelCliente() {
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(680, 520));

		inicializarComponentes();
		setVisible(true);

	}

	/**
	 * Inicializa los componentes del panel. Relacionados al cupo disponible, saldo
	 * pendiente, botones comprar, ver parejas, historial de compras y pedir
	 * sobrecupo.
	 */
	public void inicializarComponentes() {
		// North
		JPanel norte = new JPanel();
		norte.setLayout(new BoxLayout(norte, BoxLayout.Y_AXIS));

		etitulo = Estandar.HideSeek();
		norte.add(etitulo);

		norte.add(Estandar.Espacio(1, 10));

		enombre = Estandar.labelNegro("Bienvenido, ");
		norte.add(enombre);

		add(norte, BorderLayout.NORTH);

		// Center
		JPanel centro = new JPanel();
		centro.setLayout(new BorderLayout());

		JPanel arriba = new JPanel();
		arriba.setLayout(new GridLayout(8, 2));

		eblanco = new JLabel();
		arriba.add(eblanco);
		eblanco = new JLabel();
		arriba.add(eblanco);

		ecupoDisponible = Estandar.labelGris("Cupo Disponible:");
		arriba.add(ecupoDisponible);

		eblanco = new JLabel();
		arriba.add(eblanco);

		eDinerodisponible = Estandar.labelNegro("$ 1000000 pesos");
		arriba.add(eDinerodisponible);

		bcomprar = Estandar.boton("Comprar");
		bcomprar.setActionCommand("bCOMPRARMENU");
		arriba.add(bcomprar);

		eblanco = new JLabel();
		arriba.add(eblanco);
		eblanco = new JLabel();
		arriba.add(eblanco);

		esaldoPendiente = Estandar.labelGris("Saldo Pendiente:");
		arriba.add(esaldoPendiente);

		eblanco = new JLabel();
		arriba.add(eblanco);

		eDineropendiente = Estandar.labelNegro("$ 1000000 pesos");
		arriba.add(eDineropendiente);

		babonar = Estandar.boton("Abonar");
		babonar.setActionCommand("bABONARMENU");
		arriba.add(babonar);

		centro.add(arriba, BorderLayout.NORTH);

		JPanel abajo = new JPanel();
		abajo.setLayout(new GridLayout(2, 2, 16, 16));

		bnuevaPareja = Estandar.boton("Nueva Pareja");
		bnuevaPareja.setActionCommand("bNUEVAPAREJA");
		abajo.add(bnuevaPareja);

		bparejasActuales = Estandar.boton("Parejas actuales");
		bparejasActuales.setActionCommand("bPAREJASACTUALES");
		abajo.add(bparejasActuales);

		bhistorial = Estandar.boton("Historial de compras");
		bhistorial.setActionCommand("bHISTORIAL");
		abajo.add(bhistorial);

		bpedirSobrecupo = Estandar.boton("Pedir Sobrecupo");
		bpedirSobrecupo.setActionCommand("bPEDIRSOBRECUPO");
		abajo.add(bpedirSobrecupo);

		centro.add(abajo, BorderLayout.SOUTH);

		add(centro, BorderLayout.CENTER);

		// South
		JPanel sur = new JPanel();
		sur.setLayout(new BorderLayout());

		bcerrar = Estandar.botonSinFondo("Cerrar sesion");
		bcerrar.setActionCommand("bCERRARSESION");
		sur.add(Estandar.Espacio(), BorderLayout.NORTH);
		sur.add(bcerrar, BorderLayout.WEST);
		add(sur, BorderLayout.SOUTH);
	}

	/**
	 * Obtiene un JLabel vacio. Util para generar espacios en blanco en la interfaz
	 * grafica facilmente. Texto por defecto: " ".
	 * 
	 * @return JLabel en blanco
	 */
	public JLabel getEblanco() {
		return eblanco;
	}

	/**
	 * Cambia el JLabel vacio. NO RECOMENDABLE, porque su funcion es generar
	 * espacios en blanco en la interfaz grafica facilmente.
	 * 
	 * @param eblanco JLabel por el que se desea cambiar
	 */
	public void setEblanco(JLabel eblanco) {
		this.eblanco = eblanco;
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
	 * Obtiene el JLabel que funciona como un titulo para saludar al usuario.
	 * Estandar.labelNegro(). Texto por defecto: "Bienvenido, ". Recomendado cambiar
	 * el texto para agregarle el nombre del usuario que inicio sesion.
	 * 
	 * @return JLabel para saludar al usuario
	 */
	public JLabel getEnombre() {
		return enombre;
	}

	/**
	 * Cambia el JLabel que funciona como un titulo para saludar al usuario.
	 * 
	 * @param enombre JLabel por el que se desea cambiar
	 */
	public void setEnombre(JLabel enombre) {
		this.enombre = enombre;
	}

	/**
	 * Obtiene el JLabel que funciona como un titulo para indicar al usuario que lo
	 * siguiente será su cupo disponible. Estandar.labelGris(). Texto por defecto:
	 * "Cupo Disponible:".
	 * 
	 * @return JLabel titulo del cupo disponible
	 */
	public JLabel getEcupoDisponible() {
		return ecupoDisponible;
	}

	/**
	 * Cambia el JLabel que funciona como un titulo para indicar al usuario que lo
	 * siguiente será su cupo disponible.
	 * 
	 * @param ecupoDisponible JLabel por el que se desea cambiar
	 */
	public void setEcupoDisponible(JLabel ecupoDisponible) {
		this.ecupoDisponible = ecupoDisponible;
	}

	/**
	 * Obtiene el JLabel que funciona como un titulo para indicar al usuario que lo
	 * siguiente será su saldo Pendiente. Estandar.labelGris(). Texto por defecto:
	 * "Saldo Pendiente:".
	 * 
	 * @return JLabel titulo del saldo pendiente
	 */
	public JLabel getEsaldoPendiente() {
		return esaldoPendiente;
	}

	/**
	 * Cambia el JLabel que funciona como un titulo para indicar al usuario que lo
	 * siguiente será su saldo Pendiente.
	 * 
	 * @param esaldoPendiente JLabel por el que se desea cambiar
	 */
	public void setEsaldoPendiente(JLabel esaldoPendiente) {
		this.esaldoPendiente = esaldoPendiente;
	}

	/**
	 * Obtiene el JLabel que indica el cupo disponible del usuario.
	 * Estandar.labelNegro(). Texto por defecto: "$ 1000000 pesos".
	 * 
	 * @return JLabel del cupo disponible
	 */
	public JLabel geteDinerodisponible() {
		return eDinerodisponible;
	}

	/**
	 * Cambia el JLabel que indica el cupo disponible del usuario.
	 * 
	 * @param eDinerodisponible JLabel por el que se desea cambiar
	 */
	public void seteDinerodisponible(JLabel eDinerodisponible) {
		this.eDinerodisponible = eDinerodisponible;
	}

	/**
	 * Obtiene el JLabel que indica el saldo pendiente del usuario.
	 * Estandar.labelNegro(). Texto por defecto: "$ 1000000 pesos".
	 * 
	 * @return JLabel del saldo pendiente
	 */
	public JLabel geteDineropendiente() {
		return eDineropendiente;
	}

	/**
	 * Cambia el JLabel que indica el saldo pendiente del usuario.
	 * 
	 * @param eDineropendiente JLabel por el que se desea cambiar
	 */
	public void seteDineropendiente(JLabel eDineropendiente) {
		this.eDineropendiente = eDineropendiente;
	}

	/**
	 * Obtiene el JButton que abre la ventana para comprar.
	 * Estandar.boton("Comprar"). Comando de acción: "bCOMPRARMENU".
	 * 
	 * @return JButton para comprar
	 */
	public JButton getBcomprar() {
		return bcomprar;
	}

	/**
	 * Cambia el JButton que abre la ventana para comprar.
	 * 
	 * @param bcomprar JButton por el que se desea cambiar
	 */
	public void setBcomprar(JButton bcomprar) {
		this.bcomprar = bcomprar;
	}

	/**
	 * Obtiene el JButton que muestra el panel para abonar.
	 * Estandar.boton("Abonar"). Comando de acción: "bABONARMENU".
	 * 
	 * @return JButton para abonar
	 */
	public JButton getBabonar() {
		return babonar;
	}

	/**
	 * Cambia el JButton que muestra el panel para abonar.
	 * 
	 * @param babonar JButton por el que se desea cambiar
	 */
	public void setBabonar(JButton babonar) {
		this.babonar = babonar;
	}

	/**
	 * Obtiene el JButton que muestra el panel para agregar una nueva pareja.
	 * Estandar.boton("Nueva pareja"). Comando de acción: "bNUEVAPAREJA".
	 * 
	 * @return JButton para agregar una nueva pareja
	 */
	public JButton getBnuevaPareja() {
		return bnuevaPareja;
	}

	/**
	 * Cambia el JButton que muestra el panel para agregar una nueva pareja.
	 * 
	 * @param bnuevaPareja JButton por el que se desea cambiar
	 */
	public void setBnuevaPareja(JButton bnuevaPareja) {
		this.bnuevaPareja = bnuevaPareja;
	}

	/**
	 * Obtiene el JButton que muestra el panel para ver las parejas actuales.
	 * Estandar.boton("Parejas Actuales"). Comando de acción: "bPAREJASACTUALES".
	 * 
	 * @return JButton para ver las parejas actuales
	 */
	public JButton getBparejasActuales() {
		return bparejasActuales;
	}

	/***
	 * Cambia el JButton que muestra el panel para ver las parejas actuales.
	 * 
	 * @param bparejasActuales JButton por el que se desea cambiar
	 */
	public void setBparejasActuales(JButton bparejasActuales) {
		this.bparejasActuales = bparejasActuales;
	}

	/**
	 * Obtiene el JButton que muestra el panel para ver el historial de compras.
	 * Estandar.boton("Historial de compras"). Comando de acción: "bHISTORIAL".
	 * 
	 * @return JButton para ver el historial de compras
	 */
	public JButton getBhistorial() {
		return bhistorial;
	}

	/**
	 * Cambia el JButton que muestra el panel para ver el historial de compras.
	 * 
	 * @param bverHorarios JButton por el que se desea cambiar
	 */
	public void setBhistorial(JButton bhistorial) {
		this.bhistorial = bhistorial;
	}

	/**
	 * Obtiene el JButton que muestra el panel para pedir sobrecupo.
	 * Estandar.boton("Pedir sobrecupo"). Comando de acción: "bPEDIRSOBRECUPO".
	 * 
	 * @return JButton para pedir sobrecupo
	 */
	public JButton getBpedirSobrecupo() {
		return bpedirSobrecupo;
	}

	/**
	 * Cambia el JButton que muestra el panel para pedir sobrecupo.
	 * 
	 * @param bpedirSobrecupo JButton por el que se desea cambiar
	 */
	public void setBpedirSobrecupo(JButton bpedirSobrecupo) {
		this.bpedirSobrecupo = bpedirSobrecupo;
	}

	/**
	 * Obtiene el JButton para cerrar sesion, salir de la ventana y volver a la
	 * ventana para iniciar sesion. Estandar.boton("Cerrar sesion"). Comando de
	 * acción: "bCERRARSESION".
	 * 
	 * @return JButton para cerrar sesion
	 */
	public JButton getBcerrar() {
		return bcerrar;
	}

	/**
	 * Cambia el JButton para cerrar sesion, salir de la ventana y volver a la
	 * ventana para iniciar sesion.
	 * 
	 * @param bcerrar JButton por el que se desea cambiar
	 */
	public void setBcerrar(JButton bcerrar) {
		this.bcerrar = bcerrar;
	}

}
