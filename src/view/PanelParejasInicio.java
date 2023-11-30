package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelParejasInicio extends JPanel{
	
	private JLabel eblanco, etitulo, enombre, ecupoDisponible, esaldoPendiente, eDinerodisponible, eDineropendiente;
	private JButton bcomprar, babonar, bhorario, bhistorial, bcerrar;

	public PanelParejasInicio() {
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(680, 520));

		inicializarComponentes();
		setVisible(true);
		
	}

	public void inicializarComponentes() {
		// North
		JPanel norte = new JPanel();
		norte.setLayout(new BoxLayout(norte, BoxLayout.Y_AXIS));
		
		etitulo = Estandar.HideSeek();
		norte.add(etitulo);

		norte.add(Estandar.Espacio(1,10));

		enombre = Estandar.labelNegro("Bienvenido, "); 
		norte.add(enombre);
		
		add(norte, BorderLayout.NORTH);
		
		// Center
		JPanel centro = new JPanel();
		centro.setLayout(new BorderLayout());
		
		JPanel arriba = new JPanel();
		arriba.setLayout(new GridLayout(8,2));

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
		bcomprar.setActionCommand("bCOMPRARMENUpareja");
		arriba.add(bcomprar);
		
		eblanco = new JLabel();
		arriba.add(eblanco);
		eblanco = new JLabel();
		arriba.add(eblanco);
		
		esaldoPendiente =Estandar.labelGris("Saldo Pendiente:");
		arriba.add(esaldoPendiente);
		
		eblanco = new JLabel();
		arriba.add(eblanco);
		
		eDineropendiente = Estandar.labelNegro("$ 1000000 pesos");
		arriba.add(eDineropendiente);

		babonar = Estandar.boton("Abonar");
		babonar.setActionCommand("bABONARMENUpareja");
		arriba.add(babonar);
		
		centro.add(arriba, BorderLayout.NORTH);
		
		JPanel abajo = new JPanel();
		abajo.setLayout(new GridLayout(1,2, 16, 16));
		
		bhistorial = Estandar.boton("Historial de compras");
		bhistorial.setActionCommand("bHISTORIALpareja");
		abajo.add(bhistorial);

		bhorario = Estandar.boton("Tu horario");
		bhorario.setActionCommand("bVerHorarioPareja");
		abajo.add(bhorario);
		
		centro.add(abajo, BorderLayout.SOUTH);
		
		add(centro, BorderLayout.CENTER);
				
		// South
		JPanel sur = new JPanel();
		sur.setLayout(new BorderLayout());
		
		bcerrar = Estandar.botonSinFondo("Cerrar sesion");
		bcerrar.setActionCommand("bCERRARSESIONpareja");
		sur.add(Estandar.Espacio(), BorderLayout.NORTH);
		sur.add(bcerrar, BorderLayout.WEST);
		add(sur, BorderLayout.SOUTH);
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

	public JLabel getEnombre() {
		return enombre;
	}

	public void setEnombre(JLabel enombre) {
		this.enombre = enombre;
	}

	public JLabel getEcupoDisponible() {
		return ecupoDisponible;
	}

	public void setEcupoDisponible(JLabel ecupoDisponible) {
		this.ecupoDisponible = ecupoDisponible;
	}

	public JLabel getEsaldoPendiente() {
		return esaldoPendiente;
	}

	public void setEsaldoPendiente(JLabel esaldoPendiente) {
		this.esaldoPendiente = esaldoPendiente;
	}

	public JLabel geteDinerodisponible() {
		return eDinerodisponible;
	}

	public void seteDinerodisponible(JLabel eDinerodisponible) {
		this.eDinerodisponible = eDinerodisponible;
	}

	public JLabel geteDineropendiente() {
		return eDineropendiente;
	}

	public void seteDineropendiente(JLabel eDineropendiente) {
		this.eDineropendiente = eDineropendiente;
	}

	public JButton getBcomprar() {
		return bcomprar;
	}

	public void setBcomprar(JButton bcomprar) {
		this.bcomprar = bcomprar;
	}

	public JButton getBabonar() {
		return babonar;
	}

	public void setBabonar(JButton babonar) {
		this.babonar = babonar;
	}

	public JButton getBhorario() {
		return bhorario;
	}

	public void setBhorario(JButton bhorario) {
		this.bhorario = bhorario;
	}

	public JButton getBhistorial() {
		return bhistorial;
	}

	public void setBhistorial(JButton bhistorial) {
		this.bhistorial = bhistorial;
	}

	public JButton getBcerrar() {
		return bcerrar;
	}

	public void setBcerrar(JButton bcerrar) {
		this.bcerrar = bcerrar;
	}
	
}
