package controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
			System.out.println("Inicio sesion exitosamente");
		}
		else if (comando.equals("bREGISTRATE")) {
			vista.getPl().setVisible(false);
			vista.getPr().setVisible(true);
			vista.setTitle("Registrese");
			vista.getLayeredPane().remove(vista.getPl());
			vista.getLayeredPane().add(vista.getPr(), Integer.valueOf(1));
			vista.adaptarPanel(vista.getPr());
			vista.setSize(710, 695);
			vista.setMinimumSize(new Dimension(675, 580));
		}
		else if(comando.equals("bREGISTRAR")) {
			System.out.println("Registrado exitosamente");
		}
		else if(comando.equals("bmenuLOGIN")) {
			vista.getPl().setVisible(true);
			vista.getPr().setVisible(false);
			vista.setTitle("Incie sesion");
			vista.getLayeredPane().remove(vista.getPr());
			vista.getLayeredPane().add(vista.getPl(), Integer.valueOf(1));
			vista.adaptarPanel(vista.getPl());
			vista.setMinimumSize(new Dimension(280, 470));
		}
		else if(comando.equals("LISTAgenero")) {
			vista.getPr().getLista_genero().removeItem(" ");
		}
		else if(comando.equals("LISTArol")) {
			vista.getPr().getLista_rol().removeItem(" ");
		}
	}
	
	
	
}
