package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelAbono extends JPanel{
	
	private JLabel etitulo, esaldoPendiente, eDineropendiente, eingrese, edinero, epesos;
	private JTextField tmonto;
	private JButton babonar, bcerrar;
	
	public PanelAbono() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(580, 280));

		inicializarComponentes();
		setVisible(false);
		
		Estandar.revisarTextField(tmonto, eingrese, "Ingrese la cantidad de dinero a abonar:");	
	}
	
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
		auxBotones.setLayout(new GridLayout(1,2, 20, 25));
		babonar = Estandar.boton("Abonar");
		babonar.setActionCommand("bABONAR");
		auxBotones.add(babonar);
						
		bcerrar = Estandar.boton("Cancelar");
		bcerrar.setActionCommand("bCANCELAR");
		auxBotones.add(bcerrar);
		add(auxBotones);	
	
	}

	
	public JLabel getEtitulo() {
		return etitulo;
	}

	public void setEtitulo(JLabel etitulo) {
		this.etitulo = etitulo;
	}

	public JLabel getEsaldoPendiente() {
		return esaldoPendiente;
	}

	public void setEsaldoPendiente(JLabel esaldoPendiente) {
		this.esaldoPendiente = esaldoPendiente;
	}

	public JLabel geteDineropendiente() {
		return eDineropendiente;
	}

	public void seteDineropendiente(JLabel eDineropendiente) {
		this.eDineropendiente = eDineropendiente;
	}

	public JLabel getEingrese() {
		return eingrese;
	}

	public void setEingrese(JLabel eingrese) {
		this.eingrese = eingrese;
	}

	public JLabel getEdinero() {
		return edinero;
	}

	public void setEdinero(JLabel edinero) {
		this.edinero = edinero;
	}

	public JLabel getEpesos() {
		return epesos;
	}

	public void setEpesos(JLabel epesos) {
		this.epesos = epesos;
	}

	public JTextField getTmonto() {
		return tmonto;
	}

	public void setTmonto(JTextField tmonto) {
		this.tmonto = tmonto;
	}

	public JButton getBabonar() {
		return babonar;
	}

	public void setBabonar(JButton babonar) {
		this.babonar = babonar;
	}

	public JButton getBcerrar() {
		return bcerrar;
	}

	public void setBcerrar(JButton bcerrar) {
		this.bcerrar = bcerrar;
	}
		
}
