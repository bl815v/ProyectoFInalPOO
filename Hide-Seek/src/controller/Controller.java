package controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.IllegalComponentStateException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;

import model.Compra;
import model.Correo;
import model.Hora;
import model.Horarios;
import model.ListadeCompras;
import model.ListadeParejas;
import model.ListadeProductos;
import model.ListadeSedes;
import model.ListadodeUsuarios;
import model.Pareja;
import model.Producto;
import model.Sede;
import model.Usuario;
import view.Estandar;
import view.VentanaCliente;
import view.VentanaCompra;
import view.VentanaInicial;


public class Controller implements ActionListener{

	private VentanaInicial vInicial;
	private VentanaCliente vCliente;
	private VentanaCompra vCompra;
	private ListadeCompras listadecompra;	
	private ListadodeUsuarios lista;
	private ListadeParejas listapareja;
	private ListadeSedes listaSedes; 
	private Correo correos;
	private Usuario usuario;
	private Pareja pareja;
	
	public Controller() { 
		vInicial = new VentanaInicial();
		lista = new ListadodeUsuarios();
		listapareja = new ListadeParejas(); 
		correos = new Correo();
		listadecompra=new ListadeCompras();
		listaSedes = new ListadeSedes();
		asignarOyentes();

	}

	public void asignarOyentes() {
		vInicial.getPl().getBentrar().addActionListener(this);
		vInicial.getPl().getBregistrate().addActionListener(this);
		vInicial.getPr().getBregistrar().addActionListener(this);
		vInicial.getPr().getBlogin().addActionListener(this);
		
	}
	
	
	public void oyentesVcliente() {
		vCliente.getPc().getBcomprar().addActionListener(this);
		vCliente.getPc().getBabonar().addActionListener(this);
		vCliente.getPc().getBparejasActuales().addActionListener(this);
		vCliente.getPc().getBnuevaPareja().addActionListener(this);
		vCliente.getPc().getBhistorial().addActionListener(this);
		vCliente.getPc().getBpedirSobrecupo().addActionListener(this);
		vCliente.getPc().getBcerrar().addActionListener(this);

		vCliente.getPrp().getBregresar().addActionListener(this);
		vCliente.getPrp().getBregistrar().addActionListener(this);
		
	}
	
	public void oyentesVcompra() {
		
		ListadeProductos listaProductos = new ListadeProductos();
		for (Producto producto : listaProductos.getListadeProductos()) {
		vCompra.getPt().buscarBoton("b"+producto.getNombre()).addActionListener(this);
		}
		vCompra.getPt().getBcerrar().addActionListener(this);
		vCompra.getPt().getLista_sedes().addActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		// Menu LOGIN
		
		if(comando.equals("bLOGIN")) {
			String eusuario = vInicial.getPl().getTusuario().getText();
			char[] clave = vInicial.getPl().getTclave().getPassword();
			String stringclave = new String(clave);
			try {
			usuario = lista.buscarUsuario(eusuario);
			if(eusuario.equals("") || !eusuario.equals(usuario.getUser())) {
				vInicial.getPl().getEsubusuario().setText("El usuario ingresado es inexistente");
				vInicial.getPl().getEsubusuario().setForeground(Color.RED);
			}else if (clave.length == 0 || !stringclave.equals(usuario.getClave().toString())) {
				vInicial.getPl().getEsubclave().setText("La clave ingresada es incorrecta");
				vInicial.getPl().getEsubclave().setForeground(Color.RED);
			}else {
				vInicial.setVisible(false);
				vCliente = new VentanaCliente();
				vCliente.setVisible(true);
				Estandar.adaptarPanelCentro(vCliente, vCliente.getPc());	
				vCliente.getPc().getEnombre().setText("Bienvenido, " + usuario.getNombre());
				vCliente.getPc().geteDinerodisponible().setText("$ " + usuario.getCredito() + " pesos");
				vCliente.getPc().geteDineropendiente().setText("$ " + usuario.getDeuda() + " pesos");
		
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
			
			vInicial.getPr().getLista_genero().removeActionListener(this);
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
					
					usuario = new Usuario(nombre, alias, "Usuario", clavefinal, correo, genero, cupo, 0);
					boolean respuesta = lista.agregarUsuario(usuario);
					if (respuesta) {
						volver();
						MensajeInformacion("Se ha registrado exitosamente!\n\nSe le ha asignado un cupo de $" + cupo + " pesos", "Registro exitoso");
					}else {
						MensajeError("Fallo al registrar");
					}
					lista.agregarUsuario(usuario);
					correos.enviarCorreo(correo,alias,clavefinal);
					
				}
			}
			
			
		}
		if(comando.equals("LISTAgenero")) {
			vInicial.getPr().getLista_genero().removeItem(" ");
			Estandar.revisarJComboBoxString(vInicial.getPr().getLista_genero(), vInicial.getPr().getEsubgenero(), "Ingrese su genero:");
		}
		
		// Menu CLIENTE
		
		if(comando.equals("bCOMPRARMENU")){
			vCliente.setVisible(false);
			vCompra = new VentanaCompra();
			Estandar.adaptarPanelCentro(vCompra, vCompra.getPt());
			vCompra.getPt().getEsedes().setForeground(new Color(92,92,102));
			vCompra.getPt().getLista_sedes().addItem(" ");
			vCompra.getPt().getLista_sedes().setSelectedItem(" ");

			for (Sede sede : listaSedes.getListadeSedes()) {
				vCompra.getPt().getLista_sedes().addItem(sede.getNombre());
			}
			oyentesVcompra();
		}
		
		if(comando.equals("bABONARMENU")){
			if(usuario.getDeuda() == 0) {
				MensajeError("No es posible abonar, no cuenta con una deuda");
			}else {
				vCliente.setTitle("Abono de credito");
				vCliente.getPa().geteDineropendiente().setText("$ " + String.valueOf(usuario.getDeuda() + " pesos"));
				vCliente.getPa().getEingrese().setText("Ingrese la cantidad de dinero a abonar:");
				vCliente.getPa().getEingrese().setForeground(new Color(92,92,102));
				vCliente.getPc().setVisible(false);
				vCliente.getPa().getBabonar().addActionListener(this);
				vCliente.getPa().getBcerrar().addActionListener(this);
				vCliente.getPa().setVisible(true);
				vCliente.getPa().getTmonto().setText(null);
				vCliente.getLayeredPane().remove(vCliente.getPc());
				vCliente.getLayeredPane().add(vCliente.getPa(), Integer.valueOf(1));
			}
		}
		
		// Menu Abono
		if(comando.equals("bABONAR")) {
			long monto = 0;
			try {
			monto = Integer.parseInt(vCliente.getPa().getTmonto().getText());
			}catch(NumberFormatException n) {
				
			}
			if(vCliente.getPa().getTmonto().getText().equals("") ||  monto <= 0 || monto > usuario.getDeuda()) {
				vCliente.getPa().getEingrese().setText("Ingrese la cantidad de dinero a abonar:");
				vCliente.getPa().getEingrese().setForeground(Color.RED);
				vCliente.getPa().getTmonto().setText("");
			}else {
				MensajeInformacion("Ha abonado $" + vCliente.getPa().getTmonto().getText() + " pesos", "Abono exitoso");
				usuario.setDeuda(usuario.getDeuda()-Integer.parseInt(vCliente.getPa().getTmonto().getText()));
				vCliente.getPc().geteDineropendiente().setText("$ " + usuario.getDeuda() + " pesos");
				usuario.setCredito(usuario.getCredito()+Integer.parseInt(vCliente.getPa().getTmonto().getText()));
				vCliente.getPc().geteDinerodisponible().setText("$ " + usuario.getCredito() + " pesos");
				vCliente.getPa().setVisible(false);
				vCliente.getPc().setVisible(true);
				vCliente.getLayeredPane().remove(vCliente.getPa());
				vCliente.getLayeredPane().add(vCliente.getPc(), Integer.valueOf(1));
				vCliente.getPa().geteDineropendiente().setText("$ " + String.valueOf(usuario.getDeuda() + " pesos"));
				vCliente.getPa().getTmonto().setText("");
			}
		}
		if(comando.equals("bCANCELARABONO")) {
			try {
				vCliente.getPa().setVisible(false);
				vCliente.getPc().setVisible(true);
				vCliente.getLayeredPane().remove(vCliente.getPa());
				vCliente.getLayeredPane().add(vCliente.getPc(), Integer.valueOf(1));
			}catch (IllegalArgumentException hp) {
				vCliente.getPa().setVisible(false);
				vCliente.getPc().setVisible(true);
				vCliente.getLayeredPane().add(vCliente.getPc(), Integer.valueOf(1));
			}
		}
		
		// Menu CLIENTE
		
		if(comando.equals("bNUEVAPAREJA")){
			vCliente.setTitle("Agregar nueva pareja");
			vCliente.getPrp().getEsubnombre().setText("Ingrese sus nombres y apellidos:");
			vCliente.getPrp().getEsubnombre().setForeground(new Color(92,92,102));
			vCliente.getPrp().getEsubusuario().setText("Ingrese su nombre de usuario (alias):");
			vCliente.getPrp().getEsubusuario().setForeground(new Color(92,92,102));
			vCliente.getPrp().getEsubcorreo().setText("Ingrese su correo electronico:");
			vCliente.getPrp().getEsubcorreo().setForeground(new Color(92,92,102));
			vCliente.getPrp().getEsubcredito().setText("Ingrese la cantidad de dinero ($):");
			vCliente.getPrp().getEsubcredito().setForeground(new Color(92,92,102));
			vCliente.getPrp().getEsubclave().setText("Ingrese su clave:");
			vCliente.getPrp().getEsubclave().setForeground(new Color(92,92,102));
			vCliente.getPrp().getEsubrepetir().setText("Ingrese la anterior clave:");
			vCliente.getPrp().getEsubrepetir().setForeground(new Color(92,92,102));
			vCliente.getPrp().getEsubrepetir().setText("Ingrese la anterior clave:");
			vCliente.getPrp().getEsubrepetir().setForeground(new Color(92,92,102));
			
			vCliente.getPrp().getLista_genero().removeActionListener(this);
			vCliente.getPrp().getLista_sedes().removeActionListener(this);
			vCliente.getPc().setVisible(false);
			vCliente.getPrp().getLista_genero().addItem(" ");
			vCliente.getPrp().getLista_genero().setSelectedItem(" ");
			vCliente.getPrp().getLista_genero().addActionListener(this);
			vCliente.getPrp().getLista_sedes().addItem(" ");
			vCliente.getPrp().getLista_sedes().setSelectedItem(" ");
			vCliente.getPrp().getLista_sedes().addActionListener(this);
			vCliente.getPrp().setVisible(true);
			vCliente.getLayeredPane().remove(vCliente.getPc());
			vCliente.getLayeredPane().add(vCliente.getPrp(), Integer.valueOf(1));
			Estandar.adaptarPanelCentro(vCliente, vCliente.getPrp());
			vCliente.setMinimumSize(new Dimension(675, 580));
			if(695 > vCliente.getSize().height) {
				vCliente.setSize(720, 770);
			}
			vCliente.setLocationRelativeTo(null);
		}
		// Menu registrar pareja
		if(comando.equals("LISTAsedes")) {
			vCliente.getPrp().getLista_sedes().removeItem(" ");
			Estandar.revisarJComboBoxString(vCliente.getPrp().getLista_sedes(), vCliente.getPrp().getEsubsede(), "Ingrese la sede:");
		}
		

		if(comando.equals("LISTAgeneropareja")) {
			vCliente.getPrp().getLista_genero().removeItem(" ");
			Estandar.revisarJComboBoxString(vCliente.getPrp().getLista_genero(), vCliente.getPrp().getEsubgenero(), "Ingrese su genero:");
		}
		if(comando.equals("bSiguiente")) {
			boolean vnombre, vusuario, vgenero, vcorreo, vclave,vcorreoR,vusuarioR, vcredito, vsede;
			if(vCliente.getPrp().getTnombre().getText().equals("")) {
				vCliente.getPrp().getEsubnombre().setText("Debe ingresar un nombre");
				vCliente.getPrp().getEsubnombre().setForeground(Color.RED);
				vnombre = false;
			}else {
				vnombre = true;
			}
			if(vCliente.getPrp().getTusuario().getText().equals("")) {
				vCliente.getPrp().getEsubusuario().setText("Ingrese un usuario valido");
				vCliente.getPrp().getEsubusuario().setForeground(Color.RED);
				vusuario = false;
			}else {
				vusuario = true;
			}
			if(vCliente.getPrp().getLista_genero().getSelectedItem().equals(" ")) {
				vCliente.getPrp().getEsubgenero().setText("Debe seleccionar su genero");
				vCliente.getPrp().getEsubgenero().setForeground(Color.RED);
				vgenero = false;
			}else {
				vgenero = true;
			}
			if(vCliente.getPrp().getTcorreo().getText().equals("")) {
				vCliente.getPrp().getEsubcorreo().setText("Debe ingresar un correo valido");
				vCliente.getPrp().getEsubcorreo().setForeground(Color.RED);
				vcorreo = false;
			}else {
				vcorreo=true;
			}
			int credito = 0;
			try{
				credito = Integer.parseInt(vCliente.getPrp().getTcredito().getText());	
			}catch(NumberFormatException n) {
				vCliente.getPrp().getEsubcredito().setText("Debe ingresar un credito valido");
				vCliente.getPrp().getEsubcredito().setForeground(Color.RED);
				vcredito = false;
			}
			if(vCliente.getPrp().getTcredito().getText().equals("") || credito <= 0 || credito > usuario.getCredito()) {
				vCliente.getPrp().getEsubcredito().setText("Debe ingresar un credito valido");
				vCliente.getPrp().getEsubcredito().setForeground(Color.RED);
				vcredito = false;
			}else {
				vcredito=true;
			}
			if(vCliente.getPrp().getLista_sedes().getSelectedItem().equals(" ")) {
				vCliente.getPrp().getEsubsede().setText("Debe seleccionar una sede");
				vCliente.getPrp().getEsubsede().setForeground(Color.RED);
				vsede = false;
			}else {
				vsede = true;
			}
			
			if (lista.correoRepetido(vCliente.getPrp().getTcorreo().getText()) || listapareja.correoRepetido(vCliente.getPrp().getTcorreo().getText())) {
				vCliente.getPrp().getEsubcorreo().setText("El correo ya existe");
				vCliente.getPrp().getEsubcorreo().setForeground(Color.RED);
				vcorreoR = false;
			}else {
				vcorreoR = true;
			}
			if(lista.usuarioRepetido(vCliente.getPrp().getTusuario().getText()) || listapareja.usuarioRepetido(vCliente.getPrp().getTusuario().getText())) {
				vCliente.getPrp().getEsubusuario().setText("El usuario ya existe");
				vCliente.getPrp().getEsubusuario().setForeground(Color.RED);
				vusuarioR=false;
			}else {
				vusuarioR = true;
			}
			if (vCliente.getPrp().getTclave().getPassword().length == 0) {
				vCliente.getPrp().getEsubclave().setText("Debe ingresar una clave");
				vCliente.getPrp().getEsubclave().setForeground(Color.RED);
				vclave = false;
			} else {
				vclave = true;
			}
			if(vnombre && vusuario && vgenero && vcorreo && vclave && vcorreoR && vusuarioR &vsede & vcredito){
				char[] clave = vCliente.getPrp().getTclave().getPassword();
				char[] repetir = vCliente.getPrp().getTrepetir().getPassword();
				
				if (!Arrays.equals(clave, repetir)) {
					vCliente.getPrp().getEsubrepetir().setText("Las claves no coinciden");
					vCliente.getPrp().getEsubrepetir().setForeground(Color.RED);
				}else {
					
					vCliente.getPrh().getBregistrar().addActionListener(this);
					vCliente.getPrh().getBregresar().addActionListener(this);
					for (int i = 0; i < 49; i++) { 
						vCliente.getPrh().buscarboton("b"+i).addActionListener(this);
					}
					vCliente.getPrh().getEbienvenido().setText("Asignar horario a " + vCliente.getPrp().getTnombre().getText());
					vCliente.getPrh().getEsubbienvenido().setText("Haz clic en la franja de horario en la que prodra ir:");
					vCliente.getPrh().getEsubbienvenido().setForeground(new Color(92,92,102));
					vCliente.getPrp().setVisible(false);
					vCliente.getPrh().setVisible(true);
					vCliente.getLayeredPane().remove(vCliente.getPrp());
					vCliente.getLayeredPane().add(vCliente.getPrh(), Integer.valueOf(1));
					Estandar.adaptarPanelCentro(vCliente, vCliente.getPrp());
					vCliente.setMinimumSize(new Dimension(700, 800));
					if(700 > vCliente.getSize().height) {
						vCliente.setSize(700, 800);
					}
					
				}
			}
		}
		int[][] horarioPareja = Horarios.nuevoHorario();
		for (int i = 0; i < 49; i++) { 	
			final int j = i;
			JButton horarioselect = vCliente.getPrh().buscarboton("b"+i);
			horarioselect.addActionListener(et -> {
				int fila = j / 7;
				int columna = j % 7;
				if(horarioPareja[fila][columna] == 0) {
					horarioselect.setBackground(new Color(255, 122, 129));
					horarioPareja[fila][columna] = 1;
				}else if(horarioPareja[fila][columna] == 1){
					horarioselect.setBackground(new Color(171, 245, 169));
					horarioPareja[fila][columna] = 0;
				}
				System.out.println("Fila: " + fila + ", Columna: " + columna+" = " + horarioPareja[fila][columna]);
				
			});
		}
		if(comando.equals("bRegistrarpareja")) {
			String nombre = vCliente.getPrp().getTnombre().getText();
			String alias = vCliente.getPrp().getTusuario().getText();
			String correo = vCliente.getPrp().getTcorreo().getText();
			String genero = vCliente.getPrp().getLista_genero().getItemAt(0);
			String clavefinal = new String(vCliente.getPrp().getTclave().getPassword());
			for (int i = 0; i < horarioPareja.length; i++) {
	            for (int j = 0; j < horarioPareja[i].length; j++) {
	                System.out.print(horarioPareja[i][j] + "\t");
	            }
	            System.out.println();
	        }
			
			Sede sedeSelec = null;
			for (Sede sede : listaSedes.getListadeSedes()) {
				if(vCliente.getPrp().getLista_sedes().getSelectedItem().equals(sede.getNombre())) {
					 sedeSelec = sede;	
				}	
			}
			int credito = Integer.parseInt(vCliente.getPrp().getTcredito().getText());
			if(Horarios.validarHorario(horarioPareja)) {
				pareja = new Pareja(nombre, alias, "Pareja", clavefinal, correo, genero, credito, 0, horarioPareja, sedeSelec, usuario);
				boolean respuesta = listapareja.agregarParejas(pareja);
				if (respuesta) {
					MensajeInformacion("Se ha registrado la pareja exitosamente!", "Registro exitoso");
				}else {
					MensajeError("Fallo al registrar");
				}
				listapareja.agregarParejas(pareja);
				correos.enviarCorreo(correo,alias,clavefinal);
			}else {
				vCliente.getPrh().getEsubbienvenido().setForeground(Color.RED);
			}
		}
		
		if(comando.equals("bREGRESARhorario")) {
			try {
				vCliente.getPrh().setVisible(false);
				vCliente.getPrp().setVisible(true);
				vCliente.getLayeredPane().remove(vCliente.getPrh());
				vCliente.getLayeredPane().add(vCliente.getPrp(), Integer.valueOf(1));
			}catch (IllegalArgumentException hp) {
				vCliente.getPrh().setVisible(false);
				vCliente.getPrp().setVisible(true);
				vCliente.getLayeredPane().add(vCliente.getPrp(), Integer.valueOf(1));
			}
		}

		
		if(comando.equals("bREGRESARpareja")) {
			vCliente.setTitle("Menu principal - HIDE&SEEK");
			vCliente.setMinimumSize(new Dimension(675, 580));
			try {
				vCliente.getPrp().setVisible(false);
				vCliente.getPc().setVisible(true);
				vCliente.getLayeredPane().remove(vCliente.getPrp());
				vCliente.getLayeredPane().add(vCliente.getPc(), Integer.valueOf(1));
			}catch (IllegalArgumentException hp) {
				vCliente.getPrp().setVisible(false);
				vCliente.getPc().setVisible(true);
				vCliente.getLayeredPane().add(vCliente.getPc(), Integer.valueOf(1));
			}
			try {
				vCliente.getPrp().getLista_genero().removeItem(" ");
			}catch(ArrayIndexOutOfBoundsException a) {
				
			}
			try {
				vCliente.getPrp().getLista_sedes().removeItem(" ");
			}catch(ArrayIndexOutOfBoundsException a) {
				
			}
			vCliente.getPrp().getTnombre().setText(null);
			vCliente.getPrp().getTusuario().setText(null);
			vCliente.getPrp().getTcorreo().setText(null);
			vCliente.getPrp().getTclave().setText(null);
			vCliente.getPrp().getTrepetir().setText(null);
			vCliente.getPrp().getTcredito().setText(null);

		}		
		
		// Menu CLIENTE
		
		if(comando.equals("bPAREJASACTUALES")){
			vCliente.setTitle("Parejas actuales");
			System.out.println("lista de parejas");
		}
		
		// Menu CLIENTE
		
		if(comando.equals("bHISTORIAL")){
			vCliente.setTitle("Historial de compras");
			System.out.println("Historial");
		}
		
		// Menu CLIENTE
		
		if(comando.equals("bPEDIRSOBRECUPO")){
			vCliente.setTitle("Solicitud de sobrecupo");
			vCliente.getPs().geteDinerodisponible().setText("$ " + String.valueOf(usuario.getCredito() + " pesos"));
			vCliente.getPs().getEingrese().setText("Ingrese cuanto sobrecupo solicita:");
			vCliente.getPs().getEingrese().setForeground(new Color(92,92,102));
			vCliente.getPc().setVisible(false);
			vCliente.getPs().getBsolicitar().addActionListener(this);
			vCliente.getPs().getBcerrar().addActionListener(this);
			vCliente.getPs().setVisible(true);
			vCliente.getPs().getTmonto().setText(null);
			vCliente.getLayeredPane().remove(vCliente.getPc());
			vCliente.getLayeredPane().add(vCliente.getPs(), Integer.valueOf(1));
		}
		
		// Menu Sobrecupo
		if(comando.equals("bSOLICITAR")) {
			long monto = 0;
			try {
			monto = Integer.parseInt(vCliente.getPs().getTmonto().getText());
			}catch(NumberFormatException n) {
				
			}
			if(vCliente.getPs().getTmonto().getText().equals("") || monto <= 0) {
				vCliente.getPs().getEingrese().setText("Ingrese cuanto sobrecupo solicita:");
				vCliente.getPs().getEingrese().setForeground(Color.RED);
				vCliente.getPs().getTmonto().setText("");
			}else {
				MensajeInformacion("Ha solicitado un sobrecupo de $" + vCliente.getPs().getTmonto().getText() + " pesos", "Sobrecupo solicitado");
				vCliente.getPs().getTmonto().setText("");
				vCliente.getPs().setVisible(false);
				vCliente.getPc().setVisible(true);
				vCliente.getLayeredPane().remove(vCliente.getPs());
				vCliente.getLayeredPane().add(vCliente.getPc(), Integer.valueOf(1));
			}
		}
		if(comando.equals("bCANCELARSOBRECUPO")) {
			try {
				vCliente.getPs().setVisible(false);
				vCliente.getPc().setVisible(true);
				vCliente.getLayeredPane().remove(vCliente.getPs());
				vCliente.getLayeredPane().add(vCliente.getPc(), Integer.valueOf(1));
			}catch (IllegalArgumentException hp) {
				vCliente.getPs().setVisible(false);
				vCliente.getPc().setVisible(true);
				vCliente.getLayeredPane().add(vCliente.getPc(), Integer.valueOf(1));
			}
		}
		
		// Menu CLIENTE
		
		if(comando.equals("bCERRARSESION")){
			vCliente.setVisible(false);
			vInicial.getLayeredPane().add(Estandar.getFondoImagen(), Integer.valueOf(0));
			vInicial.setVisible(true);
			vInicial.getPl().getTclave().setText(null);
			vInicial.getPl().getTusuario().setText(null);
		}
		
		// COMANDOS COMPRAR
		ListadeProductos listaProductos = new ListadeProductos();
		if(comando.equals("LISTASEDES")) {
			vCompra.getPt().getLista_sedes().removeItem(" ");
			vCompra.getPt().getEsedes().setForeground(new Color(92,92,102));
			
		}
		
		for (Producto producto : listaProductos.getListadeProductos()) {
			if(comando.equals("b"+producto.getNombre())) {
				int totalCompra = 0;
				int cantidad = (int) vCompra.getPt().buscarSpinner("sp"+producto.getNombre()).getValue();
				boolean vSede = false, vCantidad = false;
				if(!vCompra.getPt().getLista_sedes().getSelectedItem().equals(" ")) {
					vSede = true;
				}else {
					vCompra.getPt().getEsedes().setForeground(Color.RED);
					vSede = false;
				}
				if( cantidad > 0){
					totalCompra =(int) (cantidad*producto.getPrecio());
					vCantidad = true;
				}else {
					vCantidad = false;
				}
				if(vSede && vCantidad) {
					Object[] opciones = {"Sí", "No"}; 
					int confirmar = JOptionPane.showOptionDialog(null, "Desea comprar "+cantidad+" "+producto.getNombre(), "Confirmar compra", 
							JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, opciones, opciones[1]);
					if (confirmar == JOptionPane.YES_OPTION) {
						if(totalCompra < usuario.getCredito()) {
							JOptionPane.showMessageDialog(null, "Usted ha comprado " + cantidad + " " +producto.getNombre() 
							+ "\nTotal: " + totalCompra + " pesos");
							usuario.setCredito(usuario.getCredito() - totalCompra);
							usuario.setDeuda(usuario.getDeuda() + totalCompra);
							vCliente.getPc().geteDineropendiente().setText("$ " + usuario.getDeuda() + " pesos");
							vCompra.getPt().buscarSpinner("sp"+producto.getNombre()).setValue(0);
							Sede sedecompra = null;
							for (Sede sede : listaSedes.getListadeSedes()) {
								if(vCompra.getPt().getLista_sedes().getSelectedItem().equals(sede.getNombre())) {
									sedecompra = sede;	
								}
								
							}
							Compra x = new Compra(producto.getNombre(), producto.getImg(), producto.getPrecio(), usuario, Hora.obtenerHoraExacta(), sedecompra);

							for (int i = 0; i < cantidad; i++) {
								listadecompra.agregarCompra(x);
							}
							
						}else {
							MensajeError("Usted no cuenta con el credito suficiente para hacer la compra");
						}
					}
				}
			}	
		}
	
		if(comando.equals("bREGRESAR")){
			vCliente.getPc().geteDinerodisponible().setText("$ " + usuario.getCredito() + " pesos");
			vCliente.setVisible(true);
			vCompra.setVisible(false);
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
	
	public void MensajeInformacion(String texto, String titulo) {
		JOptionPane.showMessageDialog(null, texto, titulo, JOptionPane.INFORMATION_MESSAGE);	
	}
	
}
