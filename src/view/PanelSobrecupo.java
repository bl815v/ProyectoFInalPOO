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
 * Clase que representa un panel para solicitar sobrecupo.
 * Extiende JPanel.
 * @author Esteban Arevalo
 */
public class PanelSobrecupo extends JPanel{
	
	private JLabel etitulo, ecupoDisponible, eDinerodisponible, eingrese, edinero, epesos;
	private JTextField tmonto;
	private JButton bsolicitar, bcerrar;
	
	public PanelSobrecupo() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(580, 280));

		inicializarComponentes();
		setVisible(false);
		
		Estandar.revisarTextField(tmonto, eingrese, "Ingrese cuanto sobrecupo solicita:");	
	}
	/**
	 * Inicializa los componentes gráficos del panel.
	 */
	public void inicializarComponentes() {
		etitulo = Estandar.HideSeek();
		add(etitulo);
		add(Estandar.Espacio());
		
		ecupoDisponible = Estandar.labelGris("Cupo Disponible:");
		add(ecupoDisponible);
		
		eDinerodisponible = Estandar.labelNegro("$ 1000000 pesos");
		add(eDinerodisponible);
		
		add(Estandar.Espacio());
		
		eingrese = Estandar.labelNegro("Ingrese cuanto sobrecupo solicita:");
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
		auxBotones.setLayout(new GridLayout(1,2, 20, 25));
		bsolicitar = Estandar.boton("Solicitar");
		bsolicitar.setActionCommand("bSOLICITAR");
		auxBotones.add(bsolicitar);
						
		bcerrar = Estandar.boton("Cancelar");
		bcerrar.setActionCommand("bCANCELARSOBRECUPO");
		auxBotones.add(bcerrar);
		add(auxBotones);	
	
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
 * Devuelve el objeto JLabel asociado al cupo disponible.
 * @return El objeto JLabel del cupo disponible.
 */
public JLabel getEcupoDisponible() {
    return ecupoDisponible;
}

/**
 * Establece el objeto JLabel asociado al cupo disponible.
 * @param ecupoDisponible El nuevo objeto JLabel para el cupo disponible.
 */
public void setEcupoDisponible(JLabel ecupoDisponible) {
    this.ecupoDisponible = ecupoDisponible;
}

/**
 * Devuelve el objeto JLabel asociado al dinero disponible.
 * @return El objeto JLabel del dinero disponible.
 */
public JLabel geteDinerodisponible() {
    return eDinerodisponible;
}

/**
 * Establece el objeto JLabel asociado al dinero disponible.
 * @param eDinerodisponible El nuevo objeto JLabel para el dinero disponible.
 */
public void seteDinerodisponible(JLabel eDinerodisponible) {
    this.eDinerodisponible = eDinerodisponible;
}

/**
 * Devuelve el objeto JLabel asociado al mensaje "Ingrese cuanto sobrecupo solicita:".
 * @return El objeto JLabel del mensaje de ingreso.
 */
public JLabel getEingrese() {
    return eingrese;
}

/**
 * Establece el objeto JLabel asociado al mensaje "Ingrese cuanto sobrecupo solicita:".
 * @param eingrese El nuevo objeto JLabel para el mensaje de ingreso.
 */
public void setEingrese(JLabel eingrese) {
    this.eingrese = eingrese;
}

/**
 * Devuelve el objeto JLabel asociado al texto "$ ".
 * @return El objeto JLabel del símbolo de dinero.
 */
public JLabel getEdinero() {
    return edinero;
}

/**
 * Establece el objeto JLabel asociado al texto "$ ".
 * @param edinero El nuevo objeto JLabel para el símbolo de dinero.
 */
public void setEdinero(JLabel edinero) {
    this.edinero = edinero;
}

/**
 * Devuelve el objeto JLabel asociado al texto " pesos".
 * @return El objeto JLabel del texto "pesos".
 */
public JLabel getEpesos() {
    return epesos;
}

/**
 * Establece el objeto JLabel asociado al texto " pesos".
 * @param epesos El nuevo objeto JLabel para el texto "pesos".
 */
public void setEpesos(JLabel epesos) {
    this.epesos = epesos;
}

/**
 * Devuelve el objeto JTextField asociado al monto.
 * @return El objeto JTextField del monto.
 */
public JTextField getTmonto() {
    return tmonto;
}

/**
 * Establece el objeto JTextField asociado al monto.
 * @param tmonto El nuevo objeto JTextField para el monto.
 */
public void setTmonto(JTextField tmonto) {
    this.tmonto = tmonto;
}

/**
 * Devuelve el objeto JButton asociado al botón de solicitar.
 * @return El objeto JButton del botón de solicitar.
 */
public JButton getBsolicitar() {
    return bsolicitar;
}

/**
 * Establece el objeto JButton asociado al botón de solicitar.
 * @param bsolicitar El nuevo objeto JButton para el botón de solicitar.
 */
public void setBsolicitar(JButton bsolicitar) {
    this.bsolicitar = bsolicitar;
}

/**
 * Devuelve el objeto JButton asociado al botón de cerrar.
 * @return El objeto JButton del botón de cerrar.
 */
public JButton getBcerrar() {
    return bcerrar;
}

/**
 * Establece el objeto JButton asociado al botón de cerrar.
 * @param bcerrar El nuevo objeto JButton para el botón de cerrar.
 */
public void setBcerrar(JButton bcerrar) {
    this.bcerrar = bcerrar;
}
		
}