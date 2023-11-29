package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import model.ListadeSedes;
import model.Sede;

public class PanelRegisterHorario extends JPanel{

	private JLabel ebienvenido, esubbienvenido;
	private JLabel e9_10, e10_11, e11_12, e1_2, e2_3, e3_4,e4_5;
	private JLabel elunes, emartes, emiercoles, ejueves, eviernes, esabado, edomingo;
	private JButton bregistrar, bregresar; 
	private ArrayList<JButton> franjaHorario;
	
	public PanelRegisterHorario() {
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(700, 500));
	
		inicializarComponentes();
		setVisible(true);
		
	}
	
	public void inicializarComponentes() {
		 franjaHorario = new ArrayList<>();
		 
		JPanel panelAuxTitulos = new JPanel();
		panelAuxTitulos.setLayout(new BoxLayout(panelAuxTitulos, BoxLayout.Y_AXIS));
		ebienvenido = Estandar.labelNegro("Asignar horario a ");
		panelAuxTitulos.add(ebienvenido);
		esubbienvenido = Estandar.labelGris("Haz clic en la franja de horario en la que prodra ir:"); 
		panelAuxTitulos.add(esubbienvenido);
        add(panelAuxTitulos, BorderLayout.NORTH);
        
        JPanel centro = new JPanel(new BorderLayout());

        JPanel dias = new JPanel(new GridLayout(1, 9));
        dias.add(Estandar.Espacio(170, 1));
        elunes = Estandar.labelNegro("Lunes");
        dias.add(elunes);
        emartes = Estandar.labelNegro("Martes");
        dias.add(emartes);
        emiercoles = Estandar.labelNegro("Miercoles");
        dias.add(emiercoles);
        ejueves = Estandar.labelNegro("Jueves");
        dias.add(ejueves);
        eviernes = Estandar.labelNegro("Viernes");
        dias.add(eviernes);
        esabado = Estandar.labelNegro("Sabado");
        dias.add(esabado);
        edomingo = Estandar.labelNegro("Domingo");
        dias.add(edomingo);
        centro.add(dias, BorderLayout.NORTH);
        
        JPanel horas = new JPanel(new GridLayout(7, 1));
        e9_10 = Estandar.labelNegro("9am-10am");
        horas.add(e9_10);
        e10_11 = Estandar.labelNegro("10am-11am");
        horas.add(e10_11);
        e11_12 = Estandar.labelNegro("11am-12pm");
        horas.add(e11_12);
        e1_2 = Estandar.labelNegro("1pm-2pm");
        horas.add(e1_2);
        e2_3 = Estandar.labelNegro("2pm-3pm");
        horas.add(e2_3);
        e3_4 = Estandar.labelNegro("3pm-4pm");
        horas.add(e3_4);
        e4_5 = Estandar.labelNegro("4pm-5pm");
        horas.add(e4_5);
        centro.add(horas, BorderLayout.WEST);
        
        JPanel horarios = new JPanel(new GridLayout(7, 7, 5, 5));
        for (int i = 0; i < 49; i++) { 
            JButton bhorario = new JButton();
            bhorario.setBackground(new Color(171, 245, 169)); 
            bhorario.setBorder(null);
            horarios.add(bhorario); 
            bhorario.setActionCommand("bhorario" + i);
            bhorario.setName("b"+i);
            franjaHorario.add(bhorario);
        }
        horarios.setPreferredSize(new Dimension(400, 400));
        centro.add(horarios, BorderLayout.CENTER);
        
        add(centro, BorderLayout.CENTER);
        
        
        JPanel panelAuxSur = new JPanel();
        panelAuxSur.setLayout(new GridLayout(1,4));
		bregresar = Estandar.botonSinFondo("<- Regresar"); 
		bregresar.setActionCommand("bREGRESARhorario");
		panelAuxSur.add(bregresar);
		panelAuxSur.add(Estandar.Espacio(100, 1));
		panelAuxSur.add(Estandar.Espacio(100, 1));
		bregistrar = Estandar.boton("Registrar");
		bregistrar.setActionCommand("bRegistrarpareja");
		panelAuxSur.add(bregistrar);
		add(panelAuxSur, BorderLayout.SOUTH);
        
	}
	
	public JButton buscarboton(String nombre) {
		JButton encontrada = null;
		for(JButton x : franjaHorario) {
			if(x.getName().equals(nombre)) {
				encontrada = x;
			}
		}
		return encontrada;
	}

	public JLabel getEbienvenido() {
		return ebienvenido;
	}

	public void setEbienvenido(JLabel ebienvenido) {
		this.ebienvenido = ebienvenido;
	}

	public JLabel getEsubbienvenido() {
		return esubbienvenido;
	}

	public void setEsubbienvenido(JLabel esubbienvenido) {
		this.esubbienvenido = esubbienvenido;
	}

	public JLabel getE9_10() {
		return e9_10;
	}

	public void setE9_10(JLabel e9_10) {
		this.e9_10 = e9_10;
	}

	public JLabel getE10_11() {
		return e10_11;
	}

	public void setE10_11(JLabel e10_11) {
		this.e10_11 = e10_11;
	}

	public JLabel getE11_12() {
		return e11_12;
	}

	public void setE11_12(JLabel e11_12) {
		this.e11_12 = e11_12;
	}

	public JLabel getE1_2() {
		return e1_2;
	}

	public void setE1_2(JLabel e1_2) {
		this.e1_2 = e1_2;
	}

	public JLabel getE2_3() {
		return e2_3;
	}

	public void setE2_3(JLabel e2_3) {
		this.e2_3 = e2_3;
	}

	public JLabel getE4_5() {
		return e4_5;
	}

	public JLabel getE3_4() {
		return e3_4;
	}

	public void setE3_4(JLabel e3_4) {
		this.e3_4 = e3_4;
	}

	public void setE4_5(JLabel e4_5) {
		this.e4_5 = e4_5;
	}

	public JLabel getElunes() {
		return elunes;
	}

	public void setElunes(JLabel elunes) {
		this.elunes = elunes;
	}

	public JLabel getEmartes() {
		return emartes;
	}

	public void setEmartes(JLabel emartes) {
		this.emartes = emartes;
	}

	public JLabel getEmiercoles() {
		return emiercoles;
	}

	public void setEmiercoles(JLabel emiercoles) {
		this.emiercoles = emiercoles;
	}

	public JLabel getEjueves() {
		return ejueves;
	}

	public void setEjueves(JLabel ejueves) {
		this.ejueves = ejueves;
	}

	public JLabel getEviernes() {
		return eviernes;
	}

	public void setEviernes(JLabel eviernes) {
		this.eviernes = eviernes;
	}

	public JLabel getEsabado() {
		return esabado;
	}

	public void setEsabado(JLabel esabado) {
		this.esabado = esabado;
	}

	public JLabel getEdomingo() {
		return edomingo;
	}

	public void setEdomingo(JLabel edomingo) {
		this.edomingo = edomingo;
	}

	public JButton getBregistrar() {
		return bregistrar;
	}

	public void setBregistrar(JButton bregistrar) {
		this.bregistrar = bregistrar;
	}

	public JButton getBregresar() {
		return bregresar;
	}

	public void setBregresar(JButton bregresar) {
		this.bregresar = bregresar;
	}
	
	public ArrayList<JButton> getFranjaHorario() {
		return franjaHorario;
	}

	public void setFranjaHorario(ArrayList<JButton> franjaHorario) {
		this.franjaHorario = franjaHorario;
	}
	
}
