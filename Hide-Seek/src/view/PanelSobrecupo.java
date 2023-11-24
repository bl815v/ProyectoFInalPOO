package view;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
	
	
	public JLabel getEtitulo() {
		return etitulo;
	}

	public void setEtitulo(JLabel etitulo) {
		this.etitulo = etitulo;
	}

	public JLabel getEcupoDisponible() {
		return ecupoDisponible;
	}

	public void setEcupoDisponible(JLabel ecupoDisponible) {
		this.ecupoDisponible = ecupoDisponible;
	}

	public JLabel geteDinerodisponible() {
		return eDinerodisponible;
	}

	public void seteDinerodisponible(JLabel eDinerodisponible) {
		this.eDinerodisponible = eDinerodisponible;
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

	public JButton getBsolicitar() {
		return bsolicitar;
	}

	public void setBsolicitar(JButton bsolicitar) {
		this.bsolicitar = bsolicitar;
	}

	public JButton getBcerrar() {
		return bcerrar;
	}

	public void setBcerrar(JButton bcerrar) {
		this.bcerrar = bcerrar;
	}
		
}
