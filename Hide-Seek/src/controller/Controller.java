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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;

import model.Compra;
import model.Correo;
import model.Hora;
import model.ListadeCompras;
import model.ListadeProductos;
import model.ListadodeUsuarios;
import model.Producto;
import model.Usuario;
import view.Estandar;
import view.VentanaCliente;
import view.VentanaCompra;
import view.VentanaInicial;


public class Controller implements ActionListener{

	private VentanaInicial vInicial;
	private VentanaCliente vCliente;
	private VentanaCompra vCompra;
	
	private ListadodeUsuarios lista;
	private Correo correos;
	
	private Usuario usuario;
	
	public Controller() {
		vInicial = new VentanaInicial();
		lista = new ListadodeUsuarios();
		correos = new Correo();
		
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
		vCliente.getPc().getBverHorarios().addActionListener(this);
		vCliente.getPc().getBpedirSobrecupo().addActionListener(this);
		vCliente.getPc().getBcerrar().addActionListener(this);
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
			System.out.println("Agregar nueva pareja");
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
							
							Compra x = new Compra(producto.getNombre(), producto.getImg(), producto.getPrecio(), usuario, Hora.obtenerHoraExacta());
							for (int i = 0; i < cantidad; i++) {
								ListadeCompras.add(x);
								
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
