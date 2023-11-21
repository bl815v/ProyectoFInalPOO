package controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import view.Estandar;
import view.VentanaInicial;

public class Controller implements ActionListener{

	private VentanaInicial vista;
	
	public Controller() {
		vista = new VentanaInicial();
		asignarOyentes();
	}
	
	public void asignarOyentes() {
		vista.getPl().getBentrar().addActionListener(this);
		vista.getPl().getBregistrate().addActionListener(this);
		vista.getPr().getBregistrar().addActionListener(this);
		vista.getPr().getBlogin().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		if(comando.equals("bLOGIN")) {
			if(vista.getPl().getTusuario().getText().equals("")) {
				vista.getPl().getEsubusuario().setText("El usuario ingresado es inexistente");
				vista.getPl().getEsubusuario().setForeground(Color.RED);
			}else if (vista.getPl().getTclave().getPassword().length == 0) {
				vista.getPl().getEsubclave().setText("La clave ingresada es incorrecta");
				vista.getPl().getEsubclave().setForeground(Color.RED);
			}else {
				System.out.println("Incio sesion exitosamente");
			}
		}
		
		if (comando.equals("bREGISTRATE")) {
			vista.getPr().getEsubnombre().setText("Ingrese sus nombres y apellidos:");
			vista.getPr().getEsubnombre().setForeground(new Color(92,92,102));
			vista.getPr().getEsubusuario().setText("Ingrese su nombre de usuario (alias):");
			vista.getPr().getEsubusuario().setForeground(new Color(92,92,102));
			vista.getPr().getEsubcorreo().setText("Ingrese su correo electronico:");
			vista.getPr().getEsubcorreo().setForeground(new Color(92,92,102));
			vista.getPr().getEsubclave().setText("Ingrese su clave:");
			vista.getPr().getEsubclave().setForeground(new Color(92,92,102));
			vista.getPr().getEsubrepetir().setText("Ingrese la anterior clave:");
			vista.getPr().getEsubrepetir().setForeground(new Color(92,92,102));
			
			vista.getPr().getLista_genero().removeActionListener(this);;
			vista.getPl().setVisible(false);
			vista.getPl().getTusuario().setText(null);
			vista.getPl().getTclave().setText(null);
			vista.getPr().getLista_genero().addItem(" ");
			vista.getPr().getLista_genero().setSelectedItem(" ");
			vista.getPr().getLista_genero().addActionListener(this);
			vista.getPr().setVisible(true);
			vista.setTitle("Registrese");
			vista.getLayeredPane().remove(vista.getPl());
			vista.getLayeredPane().add(vista.getPr(), Integer.valueOf(1));
			Estandar.adaptarPanel(vista, vista.getPr());
			vista.setMinimumSize(new Dimension(675, 580));
			if(695 > vista.getSize().height) {
				vista.setSize(710, 695);
			}
		}
		
		if(comando.equals("bmenuLOGIN")) {
			vista.getPl().getEsubusuario().setText("Ingrese su nombre de usuario (alias):");
			vista.getPl().getEsubusuario().setForeground(new Color(92,92,102));
			vista.getPl().getEsubclave().setText("Ingrese su clave:");
			vista.getPl().getEsubclave().setForeground(new Color(92,92,102));
			
			vista.getPl().setVisible(true);
			vista.getPr().setVisible(false);
			try {
				vista.getPr().getLista_genero().removeItem(" ");
			}catch(ArrayIndexOutOfBoundsException a) {
				
			}
			vista.getPr().getTnombre().setText(null);
			vista.getPr().getTusuario().setText(null);
			vista.getPr().getTcorreo().setText(null);
			vista.getPr().getTclave().setText(null);
			vista.getPr().getTrepetir().setText(null);
			vista.setTitle("Incie sesion");
			vista.getLayeredPane().remove(vista.getPr());
			vista.getLayeredPane().add(vista.getPl(), Integer.valueOf(1));
			vista.setMinimumSize(new Dimension(280, 470));
		}
		
		if(comando.equals("bREGISTRAR")) {
			boolean vnombre, vusuario, vgenero, vcorreo, vclave;
			if(vista.getPr().getTnombre().getText().equals("")) {
				vista.getPr().getEsubnombre().setText("Debe ingresar su nombre y apellido");
				vista.getPr().getEsubnombre().setForeground(Color.RED);
				vnombre = false;
			}else {
				vnombre = true;
			}
			if(vista.getPr().getTusuario().getText().equals("")) {
				vista.getPr().getEsubusuario().setText("El usuario ingresado es inexistente");
				vista.getPr().getEsubusuario().setForeground(Color.RED);
				vusuario = false;
			}else {
				vusuario = true;
			}
			if(vista.getPr().getLista_genero().getSelectedItem().equals(" ")) {
				vista.getPr().getEsubgenero().setText("Debe seleccionar su genero");
				vista.getPr().getEsubgenero().setForeground(Color.RED);
				vgenero = false;
			}else {
				vgenero = true;
			}
			if(vista.getPr().getTcorreo().getText().equals("")) {
				vista.getPr().getEsubcorreo().setText("Debe ingresar un correo valido");
				vista.getPr().getEsubcorreo().setForeground(Color.RED);
				vcorreo = false;
			}else {
				vcorreo = true;
			}
			if (vista.getPr().getTclave().getPassword().length == 0) {
				vista.getPr().getEsubclave().setText("Debe ingresar una clave");
				vista.getPr().getEsubclave().setForeground(Color.RED);
				vclave = false;
			} else {
				vclave = true;
			}
			if(vnombre && vusuario && vgenero && vcorreo && vclave){
				char[] clave = vista.getPr().getTclave().getPassword();
				char[] repetir = vista.getPr().getTrepetir().getPassword();
				
				if (!Arrays.equals(clave, repetir)) {
					vista.getPr().getEsubrepetir().setText("Las claves no coinciden");
					vista.getPr().getEsubrepetir().setForeground(Color.RED);
				}else {
					System.out.println("Se registro exitosamente");
				}
			}
			
			
		}
		
		if(comando.equals("LISTAgenero")) {
			vista.getPr().getLista_genero().removeItem(" ");
			Estandar.revisarJComboBoxString(vista.getPr().getLista_genero(), vista.getPr().getEsubgenero(), "Ingrese su genero:");
		}
		
	}
	
	
}
