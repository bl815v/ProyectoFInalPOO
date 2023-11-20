package controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.VentanaIncial;

public class Controller implements ActionListener{

	private VentanaIncial vista;
	
	public Controller() {
		vista = new VentanaIncial();
		asignarOyentes();
	}
	
	public void asignarOyentes() {
		vista.getPl().getBentrar().addActionListener(this);
		vista.getPl().getBregistrate().addActionListener(this);
		vista.getPr().getBregistrar().addActionListener(this);
		vista.getPr().getBlogin().addActionListener(this);
		vista.getPr().getLista_genero().addActionListener(this);
		vista.getPr().getLista_rol().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		if(comando.equals("bLOGIN")) {
			if(vista.getPl().getTusuario().getText().equals("")) {
				MensajeError("El usuario ingresado es inexistente");
			}else if (vista.getPl().getTclave().getPassword().length == 0) {
				MensajeError("La clave ingresada es incorrecta");
			}else {
				System.out.println("Incio sesion exitosamente");
			}
		}
		
		if (comando.equals("bREGISTRATE")) {
			vista.getPl().setVisible(false);
			vista.getPr().setVisible(true);
			vista.setTitle("Registrese");
			vista.getLayeredPane().remove(vista.getPl());
			vista.getLayeredPane().add(vista.getPr(), Integer.valueOf(1));
			vista.adaptarPanel(vista.getPr());
			vista.setSize(710, 695);
			vista.setMinimumSize(new Dimension(675, 580));
		}
		
		if(comando.equals("bREGISTRAR")) {
			boolean valido = false;
			if(vista.getPr().getTnombre().getText().equals("")) {
				MensajeError("Debe ingresar su nombre y apellido");
				valido = false;
			}else {
				valido = true;
			}
			if(vista.getPr().getTusuario().getText().equals("")) {
				MensajeError("Debe ingresar un nombre de usuario");
				valido = false;
			}else {
				valido = true;
			}
			if(vista.getPr().getLista_genero().getItemAt(0).equals(" ")) {
				MensajeError("Debe seleccionar su genero");
				valido = false;
			}else {
				valido = true;
			}
			if(vista.getPr().getLista_rol().getItemAt(0).equals(" ")) {
				MensajeError("Debe seleccionar su rol");
				valido = false;
			}else {
				valido = true;
			}
			if (vista.getPr().getTclave().getPassword().length == 0) {
				MensajeError("Debe ingresar una clave");
				valido = false;
			}else {
				valido = true;
			}      // corregir validacion de claves //
			if (vista.getPr().getTclave().getPassword() != vista.getPr().getTrepetir().getPassword()) {
				MensajeError("Las claves no coinciden");
				valido = false;
			}else {
				valido = true;
			}
			
			if(vista.getPr().getTcorreo().getText().equals("")) {
				MensajeError("Debe ingresar un correo valido");
				valido = false;
			}else {
				valido = true;
			}
			if(valido){
				System.out.println("Se registro exitosamente");
			}
		}
		
		if(comando.equals("bmenuLOGIN")) {
			vista.getPl().setVisible(true);
			vista.getPr().setVisible(false);
			vista.setTitle("Incie sesion");
			vista.getLayeredPane().remove(vista.getPr());
			vista.getLayeredPane().add(vista.getPl(), Integer.valueOf(1));
			vista.adaptarPanel(vista.getPl());
			vista.setMinimumSize(new Dimension(280, 470));
		}
		
		if(comando.equals("LISTAgenero")) {
			vista.getPr().getLista_genero().removeItem(" ");
		}
		
		if(comando.equals("LISTArol")) {
			vista.getPr().getLista_rol().removeItem(" ");
		}
	}
	
	public void MensajeError(String texto) {
		JOptionPane.showMessageDialog(null, texto, "Error", JOptionPane.ERROR_MESSAGE);	

	}
	
	
}
