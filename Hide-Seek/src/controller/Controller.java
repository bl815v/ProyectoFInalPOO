package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.VentanaLogin;

public class Controller implements ActionListener{

	private VentanaLogin vista;
	
	
	public Controller() {
		vista = new VentanaLogin();
		asignarOyentes();
	}
	
	public void asignarOyentes() {
		vista.getPl().getBentrar().addActionListener(this);
		vista.getPl().getBregistrate().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		if(comando.equals("bLOGIN")) {
			System.out.println("si sirve login");
		}
		else if (comando.equals("bREGISTRAR")) {
			System.out.println("si sirve registrar");
		}
	}
	
	
	
}
