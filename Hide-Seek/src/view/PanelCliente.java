package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelCliente extends JPanel{
	
	private JLabel eblanco, etitulo, enombre, ecupoDisponible, esaldoPendiente, eDinerodisponible, eDineropendiente;
	private JButton bcomprar, babonar, bnuevaPareja, bparejasActuales, bverHorarios, bpedirSobrecupo, bcerrar;
	
	public PanelCliente() {
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(680, 520));

		inicializarComponentes();
		setVisible(true);
		
	}
	
	public void inicializarComponentes() {
		// North
		JPanel norte = new JPanel();
		norte.setLayout(new BoxLayout(norte, BoxLayout.Y_AXIS));
		
		etitulo = new JLabel("HIDE&SEEK");
		etitulo.setFont(new Font("Arial", Font.BOLD, 22));
		norte.add(etitulo);

		norte.add(Estandar.Espacio(1,10));

		enombre = new JLabel("Bienvenido, "); 
		enombre.setFont(new Font("Arial", Font.PLAIN, 18));
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
		
		ecupoDisponible = new JLabel("Cupo Disponible:");
		ecupoDisponible.setFont(new Font("Arial", Font.PLAIN, 16));
		ecupoDisponible.setForeground(new Color(92,92,102));
		arriba.add(ecupoDisponible);
		
		eblanco = new JLabel();
		arriba.add(eblanco);
		
		eDinerodisponible = new JLabel("$ 1000000 pesos");
		eDinerodisponible.setFont(new Font("Arial", Font.PLAIN, 18));
		arriba.add(eDinerodisponible);
		
		bcomprar = new JButton("Comprar");
		bcomprar.setBackground(new Color(84, 160, 227));
		bcomprar.setFont(new Font("Arial", Font.PLAIN, 18));
		bcomprar.setForeground(new Color(255, 255, 255));
		bcomprar.setActionCommand("bCOMPRARMENU");
		arriba.add(bcomprar);
		
		eblanco = new JLabel();
		arriba.add(eblanco);
		eblanco = new JLabel();
		arriba.add(eblanco);
		
		esaldoPendiente = new JLabel("Saldo Pendiente:");
		esaldoPendiente.setFont(new Font("Arial", Font.PLAIN, 16));
		esaldoPendiente.setForeground(new Color(92,92,102));
		arriba.add(esaldoPendiente);
		
		eblanco = new JLabel();
		arriba.add(eblanco);
		
		eDineropendiente = new JLabel("$ 1000000 pesos");
		eDineropendiente.setFont(new Font("Arial", Font.PLAIN, 18));
		arriba.add(eDineropendiente);

		babonar = new JButton("Abonar");
		babonar.setBackground(new Color(84, 160, 227));
		babonar.setFont(new Font("Arial", Font.PLAIN, 18));
		babonar.setForeground(new Color(255, 255, 255));
		babonar.setActionCommand("bABONARMENU");
		arriba.add(babonar);
		
		centro.add(arriba, BorderLayout.NORTH);
		
		JPanel abajo = new JPanel();
		abajo.setLayout(new GridLayout(2,2, 16, 16));
		
		bnuevaPareja = new JButton("Nueva Pareja");
		bnuevaPareja.setBackground(new Color(84, 160, 227));
		bnuevaPareja.setFont(new Font("Arial", Font.PLAIN, 18));
		bnuevaPareja.setForeground(new Color(255, 255, 255));
		bnuevaPareja.setActionCommand("bNUEVAPAREJA");
		abajo.add(bnuevaPareja);
		
		bparejasActuales = new JButton("Parejas actuales");
		bparejasActuales.setBackground(new Color(84, 160, 227));
		bparejasActuales.setFont(new Font("Arial", Font.PLAIN, 18));
		bparejasActuales.setForeground(new Color(255, 255, 255));
		bparejasActuales.setActionCommand("bPAREJASACTUALES");
		abajo.add(bparejasActuales);

		bverHorarios = new JButton("Ver Horarios");
		bverHorarios.setBackground(new Color(84, 160, 227));
		bverHorarios.setFont(new Font("Arial", Font.PLAIN, 18));
		bverHorarios.setForeground(new Color(255, 255, 255));
		bverHorarios.setActionCommand("bVERHORARIOS");
		abajo.add(bverHorarios);
		
		bpedirSobrecupo = new JButton("Pedir Sobrecupo");
		bpedirSobrecupo.setBackground(new Color(84, 160, 227));
		bpedirSobrecupo.setFont(new Font("Arial", Font.PLAIN, 18));
		bpedirSobrecupo.setForeground(new Color(255, 255, 255));
		bpedirSobrecupo.setActionCommand("bPEDIRSOBRECUPO");
		abajo.add(bpedirSobrecupo);
		
		centro.add(abajo, BorderLayout.SOUTH);
		
		add(centro, BorderLayout.CENTER);
				
		// South
		JPanel sur = new JPanel();
		sur.setLayout(new BoxLayout(sur, BoxLayout.Y_AXIS));
		sur.add(Estandar.Espacio(1, 100));
		JPanel espaciosur = new JPanel();
		espaciosur.setLayout(new BoxLayout(espaciosur, BoxLayout.X_AXIS));
		bcerrar = new JButton("Cerrar sesion");
		bcerrar.setBackground(null);
		bcerrar.setBorder(null);
		bcerrar.setFont(new Font("Arial", Font.PLAIN, 14));
		bcerrar.setForeground(new Color(84, 160, 227));
		bcerrar.setActionCommand("bCERRARSESION");
		espaciosur.add(bcerrar);
		eblanco = new JLabel(" ");
		espaciosur.add(eblanco);
		sur.add(espaciosur, BorderLayout.SOUTH);
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

	public JButton getBnuevaPareja() {
		return bnuevaPareja;
	}

	public void setBnuevaPareja(JButton bnuevaPareja) {
		this.bnuevaPareja = bnuevaPareja;
	}

	public JButton getBparejasActuales() {
		return bparejasActuales;
	}

	public void setBparejasActuales(JButton bparejasActuales) {
		this.bparejasActuales = bparejasActuales;
	}

	public JButton getBverHorarios() {
		return bverHorarios;
	}

	public void setBverHorarios(JButton bverHorarios) {
		this.bverHorarios = bverHorarios;
	}

	public JButton getBpedirSobrecupo() {
		return bpedirSobrecupo;
	}

	public void setBpedirSobrecupo(JButton bpedirSobrecupo) {
		this.bpedirSobrecupo = bpedirSobrecupo;
	}

	public JButton getBcerrar() {
		return bcerrar;
	}

	public void setBcerrar(JButton bcerrar) {
		this.bcerrar = bcerrar;
	}
	
	
}
