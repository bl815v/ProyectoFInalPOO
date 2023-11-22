package controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JOptionPane;

import model.ListadodeUsuarios;
import model.Usuario;
import view.Estandar;
import view.VentanaCliente;
import view.VentanaInicial;

public class Controller implements ActionListener{

	private VentanaInicial vInicial;
	private VentanaCliente vCliente;
	private ListadodeUsuarios lista;
	
	public Controller() {
		vInicial = new VentanaInicial();
		lista = new ListadodeUsuarios();
		asignarOyentes();
	}
	
	public void asignarOyentes() {
		vInicial.getPl().getBentrar().addActionListener(this);
		vInicial.getPl().getBregistrate().addActionListener(this);
		vInicial.getPr().getBregistrar().addActionListener(this);
		vInicial.getPr().getBlogin().addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		// Menu LOGIN
		
		if(comando.equals("bLOGIN")) {
			String usuario = vInicial.getPl().getTusuario().getText();
			char[] clave = vInicial.getPl().getTclave().getPassword();
			String stringclave = new String(clave);
			try {
			String usuarioExist = lista.buscarUsuario(usuario).getUser();
			String claveUsuario = lista.buscarUsuario(usuario).getClave();
			if(usuario.equals("") || !usuario.equals(usuarioExist)) {
				vInicial.getPl().getEsubusuario().setText("El usuario ingresado es inexistente");
				vInicial.getPl().getEsubusuario().setForeground(Color.RED);
			}else if (clave.length == 0 || !stringclave.equals(claveUsuario.toString())) {
				vInicial.getPl().getEsubclave().setText("La clave ingresada es incorrecta");
				vInicial.getPl().getEsubclave().setForeground(Color.RED);
			}else {
				vInicial.setVisible(false);
				vCliente = new VentanaCliente();
				vCliente.getPc().getEnombre().setText("Bienvenido, " + lista.buscarUsuario(usuario).getNombre());
				vCliente.getPc().geteDinerodisponible().setText("$ " + lista.buscarUsuario(usuario).getCredito() + " pesos");
				vCliente.getPc().geteDineropendiente().setText("$ " + lista.buscarUsuario(usuario).getDeuda() + " pesos");
		
				oyentesVcliente();
				
			}
			}catch(NullPointerException n) {
				vInicial.getPl().getEsubusuario().setText("El usuario ingresado es inexistente");
				vInicial.getPl().getEsubusuario().setForeground(Color.RED);
			}
		}
		
		
		
		if (comando.equals("bREGISTRATE")) {
			vInicial.getPr().getEsubnombre().setText("Ingrese sus nombres y apellidos:");
			vInicial.getPr().getEsubnombre().setForeground(new Color(92,92,102));
			vInicial.getPr().getEsubusuario().setText("Ingrese su nombre de usuario (alias):");
			vInicial.getPr().getEsubusuario().setForeground(new Color(92,92,102));
			vInicial.getPr().getEsubcorreo().setText("Ingrese su correo electronico:");
			vInicial.getPr().getEsubcorreo().setForeground(new Color(92,92,102));
			vInicial.getPr().getEsubclave().setText("Ingrese su clave:");
			vInicial.getPr().getEsubclave().setForeground(new Color(92,92,102));
			vInicial.getPr().getEsubrepetir().setText("Ingrese la anterior clave:");
			vInicial.getPr().getEsubrepetir().setForeground(new Color(92,92,102));
			
			vInicial.getPr().getLista_genero().removeActionListener(this);;
			vInicial.getPl().setVisible(false);
			vInicial.getPl().getTusuario().setText(null);
			vInicial.getPl().getTclave().setText(null);
			vInicial.getPr().getLista_genero().addItem(" ");
			vInicial.getPr().getLista_genero().setSelectedItem(" ");
			vInicial.getPr().getLista_genero().addActionListener(this);
			vInicial.getPr().setVisible(true);
			vInicial.setTitle("Registrese");
			vInicial.getLayeredPane().remove(vInicial.getPl());
			vInicial.getLayeredPane().add(vInicial.getPr(), Integer.valueOf(1));
			Estandar.adaptarPanelCentro(vInicial, vInicial.getPr());
			vInicial.setMinimumSize(new Dimension(675, 580));
			if(695 > vInicial.getSize().height) {
				vInicial.setSize(710, 695);
			}
			vInicial.setLocationRelativeTo(null);
		}
		
		//Menu REGISTER
		
		if(comando.equals("bmenuLOGIN")) {
			volver();
		}
		
		
		
		if(comando.equals("bREGISTRAR")) {
			boolean vnombre, vusuario, vgenero, vcorreo, vclave,vcorreoR,vusuarioR;
			if(vInicial.getPr().getTnombre().getText().equals("")) {
				vInicial.getPr().getEsubnombre().setText("Debe ingresar un nombre");
				vInicial.getPr().getEsubnombre().setForeground(Color.RED);
				vnombre = false;
			}else {
				vnombre = true;
			}
			if(vInicial.getPr().getTusuario().getText().equals("")) {
				vInicial.getPr().getEsubusuario().setText("Ingrese un usuario valido");
				vInicial.getPr().getEsubusuario().setForeground(Color.RED);
				vusuario = false;
			}else {
				vusuario = true;
			}
			if(vInicial.getPr().getLista_genero().getSelectedItem().equals(" ")) {
				vInicial.getPr().getEsubgenero().setText("Debe seleccionar su genero");
				vInicial.getPr().getEsubgenero().setForeground(Color.RED);
				vgenero = false;
			}else {
				vgenero = true;
			}
			if(vInicial.getPr().getTcorreo().getText().equals("")) {
				vInicial.getPr().getEsubcorreo().setText("Debe ingresar un correo valido");
				vInicial.getPr().getEsubcorreo().setForeground(Color.RED);
				vcorreo = false;
			}else {
				vcorreo=true;
			}
			if (lista.correoRepetido(vInicial.getPr().getTcorreo().getText())) {
				vInicial.getPr().getEsubcorreo().setText("El correo ya existe");
				vInicial.getPr().getEsubcorreo().setForeground(Color.RED);
				vcorreoR = false;
			}else {
				vcorreoR = true;
			}
			if(lista.usuarioRepetido(vInicial.getPr().getTusuario().getText())) {
				vInicial.getPr().getEsubusuario().setText("El usuario ya existe");
				vInicial.getPr().getEsubusuario().setForeground(Color.RED);
				vusuarioR=false;
			}else {
				vusuarioR = true;
			}
			if (vInicial.getPr().getTclave().getPassword().length == 0) {
				vInicial.getPr().getEsubclave().setText("Debe ingresar una clave");
				vInicial.getPr().getEsubclave().setForeground(Color.RED);
				vclave = false;
			} else {
				vclave = true;
			}
			if(vnombre && vusuario && vgenero && vcorreo && vclave&&vcorreoR&&vusuarioR){
				char[] clave = vInicial.getPr().getTclave().getPassword();
				char[] repetir = vInicial.getPr().getTrepetir().getPassword();
				
				if (!Arrays.equals(clave, repetir)) {
					vInicial.getPr().getEsubrepetir().setText("Las claves no coinciden");
					vInicial.getPr().getEsubrepetir().setForeground(Color.RED);
				}else {
					String nombre = vInicial.getPr().getTnombre().getText();
					String alias = vInicial.getPr().getTusuario().getText();
					String correo = vInicial.getPr().getTcorreo().getText();
					String genero = vInicial.getPr().getLista_genero().getItemAt(0);
					String clavefinal = new String(vInicial.getPr().getTclave().getPassword());
					Random random = new Random();	
					int randomNumber = random.nextInt(2500001) + 500000;
					int cupo = randomNumber;
					
					Usuario usuario = new Usuario(nombre, alias, "Usuario", clavefinal, correo, genero, cupo, 0);
					boolean respuesta = lista.agregarUsuario(usuario);
					if (respuesta) {
						volver();
						JOptionPane.showMessageDialog(null, "Se ha registrado exitosamente!\n\nSe le ha asignado un cupo de $" + cupo + " pesos", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
					}else {
						MensajeError("Fallo al registrar");
					}
					lista.agregarUsuario(usuario);
				}
			}
			
			
		}
		if(comando.equals("LISTAgenero")) {
			vInicial.getPr().getLista_genero().removeItem(" ");
			Estandar.revisarJComboBoxString(vInicial.getPr().getLista_genero(), vInicial.getPr().getEsubgenero(), "Ingrese su genero:");
		}
		
		// Menu CLIENTE
		
		if(comando.equals("bCOMPRARMENU")){
			System.out.println("comprando");
		}
		
		if(comando.equals("bABONARMENU")){
			System.out.println("Abonando");
		}
		
		if(comando.equals("bNUEVAPAREJA")){
			System.out.println("Agregar nueva pareja");
		}

		if(comando.equals("bPAREJASACTUALES")){
			System.out.println("lista de parejas");
		}

		if(comando.equals("bVERHORARIOS")){
			System.out.println("horarios");
		}
		
		if(comando.equals("bPEDIRSOBRECUPO")){
			System.out.println("sobre cupo");
		}
		
		if(comando.equals("bCERRARSESION")){
			vCliente.setVisible(false);
			vInicial.setVisible(true);
			vInicial.getPl().getTclave().setText(null);
			vInicial.getPl().getTusuario().setText(null);
		}
	}
	
	private void volver() {
		vInicial.getPl().getEsubusuario().setText("Ingrese su nombre de usuario (alias):");
		vInicial.getPl().getEsubusuario().setForeground(new Color(92,92,102));
		vInicial.getPl().getEsubclave().setText("Ingrese su clave:");
		vInicial.getPl().getEsubclave().setForeground(new Color(92,92,102));
		
		vInicial.getPl().setVisible(true);
		vInicial.getPr().setVisible(false);
		try {
			vInicial.getPr().getLista_genero().removeItem(" ");
		}catch(ArrayIndexOutOfBoundsException a) {
			
		}
		vInicial.getPr().getTnombre().setText(null);
		vInicial.getPr().getTusuario().setText(null);
		vInicial.getPr().getTcorreo().setText(null);
		vInicial.getPr().getTclave().setText(null);
		vInicial.getPr().getTrepetir().setText(null);
		vInicial.setTitle("Incie sesion");
		vInicial.getLayeredPane().remove(vInicial.getPr());
		vInicial.getLayeredPane().add(vInicial.getPl(), Integer.valueOf(1));
		vInicial.setMinimumSize(new Dimension(280, 470));
		vInicial.setLocationRelativeTo(null);
	}
	
	public void MensajeError(String texto) {
		JOptionPane.showMessageDialog(null, texto, "Error", JOptionPane.ERROR_MESSAGE);	

	}
	
	private void oyentesVcliente() {
		vCliente.getPc().getBcomprar().addActionListener(this);
		vCliente.getPc().getBabonar().addActionListener(this);
		vCliente.getPc().getBparejasActuales().addActionListener(this);
		vCliente.getPc().getBnuevaPareja().addActionListener(this);
		vCliente.getPc().getBverHorarios().addActionListener(this);
		vCliente.getPc().getBpedirSobrecupo().addActionListener(this);
		vCliente.getPc().getBcerrar().addActionListener(this);
	}
	
	
}
