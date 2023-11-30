package controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Admin;
import model.Compra;
import model.Correo;
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
import view.VentanaAdmin;
import view.VentanaAgregarSede;
import view.VentanaCliente;
import view.VentanaCompra;
import view.VentanaComprapareja;
import view.VentanaInicial;
import view.VentanaPareja;


public class Controller implements ActionListener{

	private VentanaInicial vInicial;
	private VentanaCliente vCliente;
	private VentanaPareja vParejaInicio;
	private VentanaCompra vCompra;
	private VentanaComprapareja vComprapareja;
	private VentanaAdmin vAdmin;
	private ListadeCompras listadecompra;	
	private ListadodeUsuarios lista;
	private ListadeParejas listapareja;
	private ListadeSedes listaSedes; 
	private Correo correos;
	private Usuario usuario;
	private Admin admin;
	private Pareja pareja;
	private VentanaAgregarSede vAgregarSede;
	
	public Controller() { 
		vInicial = new VentanaInicial();
		lista = new ListadodeUsuarios();
		listapareja = new ListadeParejas(); 
		correos = new Correo();
		admin = new Admin("ADMIN", "Admin", "0000");
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
	
	public void oyentesVpareja() {
		vParejaInicio.getPpi().getBcomprar().addActionListener(this);
		vParejaInicio.getPpi().getBabonar().addActionListener(this);
		vParejaInicio.getPpi().getBhistorial().addActionListener(this);
		vParejaInicio.getPpi().getBcerrar().addActionListener(this);
	}
	
	int[][] horarioPareja = Horarios.nuevoHorario();
	
	public void oyentesVcompra() {
		
		ListadeProductos listaProductos = new ListadeProductos();
		for (Producto producto : listaProductos.getListadeProductos()) {
			vCompra.getPt().buscarBoton("b"+producto.getNombre()).addActionListener(this);
		}
		vCompra.getPt().getBcerrar().addActionListener(this);
		vCompra.getPt().getLista_sedes().addActionListener(this);
	}

	public void oyentesVcomprapareja() {
		
		ListadeProductos listaProductos = new ListadeProductos();
		for (Producto producto : listaProductos.getListadeProductos()) {
			vComprapareja.getPtp().buscarBoton("bp"+producto.getNombre()).addActionListener(this);
		}
		vComprapareja.getPtp().getBcerrar().addActionListener(this);
		vComprapareja.getPtp().getLista_sedes().addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		// Menu LOGIN
		
		if(comando.equals("bLOGIN")) {
			String eusuario = vInicial.getPl().getTusuario().getText();
			char[] clave = vInicial.getPl().getTclave().getPassword();
			String stringclave = new String(clave);
			if(eusuario.equals("ADMIN")) {
				if (clave.length == 0 || !stringclave.equals(admin.getClave().toString())) {
					vInicial.getPl().getEsubclave().setText("La clave ingresada es incorrecta");
					vInicial.getPl().getEsubclave().setForeground(Color.RED);
				}else {
					vInicial.setVisible(false);
					vAdmin = new VentanaAdmin();
					vAdmin.setVisible(true);
					Estandar.adaptarPanelCentro(vAdmin, vAdmin.getPa());	
					vAdmin.getPa().getBinformes().addActionListener(this);
					vAdmin.getPa().getBusuarios().addActionListener(this);
					vAdmin.getPa().getBsolicitudes().addActionListener(this);
					vAdmin.getPa().getBsedes().addActionListener(this);
					vAdmin.getPa().getBcerrar().addActionListener(this);
				}
			}
			try {
				pareja = listapareja.buscarParejas(eusuario);
				if(eusuario.equals("") || !eusuario.equals(pareja.getUser())) {
					vInicial.getPl().getEsubusuario().setText("El usuario ingresado es inexistente");
					vInicial.getPl().getEsubusuario().setForeground(Color.RED);
				}else if (clave.length == 0 || !stringclave.equals(pareja.getClave().toString())) {
					vInicial.getPl().getEsubclave().setText("La clave ingresada es incorrecta");
					vInicial.getPl().getEsubclave().setForeground(Color.RED);
				}else {
					vInicial.setVisible(false);
					vParejaInicio = new VentanaPareja();
					vParejaInicio.setVisible(true);
					Estandar.adaptarPanelCentro(vParejaInicio, vParejaInicio.getPpi());	
					vParejaInicio.getPpi().getEnombre().setText("Bienvenido, " + pareja.getNombre());
					vParejaInicio.getPpi().geteDinerodisponible().setText("$ " + pareja.getCredito() + " pesos");
					vParejaInicio.getPpi().geteDineropendiente().setText("$ " + pareja.getDeuda() + " pesos");

					oyentesVpareja();
			}
			}catch (NullPointerException xd) {
				
			}
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
		
		// COMANDOS ADMIN
		if(comando.equals("BINFORMES_ADMIN")) {
			vAdmin.getPa().limpiarVista();
			vAdmin.getPa().verInformes();
		}
		
		if (comando.equals("BUSUARIOS_ADMIN")) {
		    vAdmin.getPa().limpiarVista();
		    vAdmin.getPa().verUsuarios();
		    vAdmin.getPa().getBeliminaruser().addActionListener(this);
		    try {
		        vAdmin.getPa().getBaceptarsolicitud().removeActionListener(this);
		    } catch (NullPointerException ex) {
		    }
		    try {
		        vAdmin.getPa().getBeliminarsede().removeActionListener(this);
		        vAdmin.getPa().getBagregarsede().removeActionListener(this);
		    } catch (NullPointerException xee) {
		    }

		    DefaultTableModel modelU = vAdmin.getPa().getModelU();
		    Set<String> usuariosAgregados = new HashSet<>();
		    int rowCount = modelU.getRowCount();
		    for (int i = 0; i < rowCount; i++) {
		        String userName = modelU.getValueAt(i, 1).toString(); 
		        usuariosAgregados.add(userName);
		    }

		    for (Usuario usuario : lista.getListadeUsuarios()) {
		        String userName = usuario.getUser();
		        if (!usuariosAgregados.contains(userName)) {
		            Object[] fila = {
		                    usuario.getNombre(),
		                    userName,
		                    usuario.getRol(),
		                    usuario.getCorreo(),
		                    usuario.getGenero(),
		                    usuario.getCredito(),
		                    usuario.getDeuda()
		            };
		            modelU.addRow(fila);
		            usuariosAgregados.add(userName); 
		        }
		    }
		}

		
		if(comando.equals("BeliminaruserADMIN")) {
		    JTable tablaUsuarios = vAdmin.getPa().getTablaUsuarios();
		    int filaSeleccionada = tablaUsuarios.getSelectedRow();

		    if (filaSeleccionada != -1) {
		        String usuario = tablaUsuarios.getValueAt(filaSeleccionada, 1).toString();
		        Usuario usuarioSeleccionado = null;
		        for (Usuario u : lista.getListadeUsuarios()) {
		            if (u.getUser().equals(usuario)) {
		                usuarioSeleccionado = u;
		                break;
		            }
		        }
		        
		        if (usuarioSeleccionado != null) {
		        	Object[] opciones = {"Sí", "No"}; 
					int confirmar = JOptionPane.showOptionDialog(null, "Desea elminar a " + usuarioSeleccionado.getNombre(), "Confirmar eliminacion", 
							JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, opciones, opciones[1]);
					if (confirmar == JOptionPane.YES_OPTION) {
			        	lista.getListadeUsuarios().remove(usuarioSeleccionado);
			            DefaultTableModel modelU = vAdmin.getPa().getModelU();
			            modelU.removeRow(filaSeleccionada);
					    vAdmin.getPa().limpiarVista();
					    Estandar.MensajeInformacion("Usuario eliminado exitosamente", "Usuario eliminado");
					}
		        }
		    }
		}

		if (comando.equals("BSOLICITUDES_ADMIN")) {
		    vAdmin.getPa().limpiarVista();
		    vAdmin.getPa().verSolicitudes();
		    try {
		        vAdmin.getPa().getBeliminaruser().removeActionListener(this);
		    } catch (NullPointerException xe) {
		    }
		    try {
		        vAdmin.getPa().getBeliminarsede().removeActionListener(this);
		        vAdmin.getPa().getBagregarsede().removeActionListener(this);
		    } catch (NullPointerException xee) {
		    }
		    vAdmin.getPa().getBaceptarsolicitud().addActionListener(this);

		    DefaultTableModel modelSol = vAdmin.getPa().getModelSol();
		    Set<String> usuariosAgregados = new HashSet<>();
		    int rowCount = modelSol.getRowCount();

		    for (int i = 0; i < rowCount; i++) {
		        String userName = modelSol.getValueAt(i, 1).toString(); 
		        usuariosAgregados.add(userName);
		    }

		    List<Usuario> usuariosExistentes = lista.getListadeUsuarios();
		    for (int i = rowCount - 1; i >= 0; i--) {
		        String userName = modelSol.getValueAt(i, 1).toString();
		        if (!usuariosExistentes.stream().anyMatch(u -> u.getUser().equals(userName))) {
		            modelSol.removeRow(i);
		        }
		    }

		    for (Usuario usuario : usuariosExistentes) {
		        if (usuario.getSobrecupo() > 0) {
		            String userName = usuario.getUser();
		            if (!usuariosAgregados.contains(userName)) {
		                Object[] fila = {
		                        usuario.getNombre(),
		                        userName,
		                        usuario.getCorreo(),
		                        usuario.getCredito(),
		                        usuario.getDeuda(),
		                        usuario.getSobrecupo()
		                };
		                modelSol.addRow(fila);
		                usuariosAgregados.add(userName);
		            }
		        }
		    }
		}
		
		if (comando.equals("AceptSolicitADMIN")) {
		    JTable tablaSolicitudes = vAdmin.getPa().getTablaSolicitudes();
		    int filaSeleccionada = tablaSolicitudes.getSelectedRow();

		    if (filaSeleccionada != -1) {
		        String usuario = tablaSolicitudes.getValueAt(filaSeleccionada, 1).toString();
		        Usuario usuarioSeleccionado = null;
		        for (Usuario u : lista.getListadeUsuarios()) {
		            if (u.getUser().equals(usuario)) {
		                usuarioSeleccionado = u;
		                break;
		            }
		        }

		        if (usuarioSeleccionado != null) {
		            int sobrecupo = Integer.parseInt(tablaSolicitudes.getValueAt(filaSeleccionada, 5).toString());

		            int creditoActual = usuarioSeleccionado.getCredito();
		            usuarioSeleccionado.setCredito(creditoActual + sobrecupo);
		            usuarioSeleccionado.setSobrecupo(0);
		            
		            DefaultTableModel modelSol = vAdmin.getPa().getModelSol();
		            modelSol.removeRow(filaSeleccionada);

				    vAdmin.getPa().limpiarVista();
				    Estandar.MensajeInformacion("Sobrecupo aceptado exitosamente", "Sobrecupo aceptado");
		        }
		    }
		}
		
		if (comando.equals("BSEDES_ADMIN")) {
		    vAdmin.getPa().limpiarVista();
		    vAdmin.getPa().verSedes();
		    vAdmin.getPa().getBeliminarsede().addActionListener(this);
		    vAdmin.getPa().getBagregarsede().addActionListener(this);
		    try {
		        vAdmin.getPa().getBeliminaruser().removeActionListener(this);
		    } catch (NullPointerException xe) {
		    }
		    try {
		        vAdmin.getPa().getBaceptarsolicitud().removeActionListener(this);
		    } catch (NullPointerException xee) {
		    }

		    DefaultTableModel modelSed = vAdmin.getPa().getModelSed();
		    Set<String> sedesAgregadas = new HashSet<>();
		    int rowCount = modelSed.getRowCount();
		    for (int i = 0; i < rowCount; i++) {
		        String sedeNombre = modelSed.getValueAt(i, 0).toString();
		        sedesAgregadas.add(sedeNombre);
		    }

		    for (Sede sede : listaSedes.getListadeSedes()) {
		        String sedeNombre = sede.getNombre();
		        if (!sedesAgregadas.contains(sedeNombre)) {
		            Object[] fila = {
		                    sedeNombre,
		                    sede.getDireccion()
		            };
		            modelSed.addRow(fila);
		            sedesAgregadas.add(sedeNombre); 
		        }
		    }
		}
		
		if (comando.equals("EliminarSedeADMIN")) {
		    JTable tablaSedes = vAdmin.getPa().getTablaSedes();
		    int filaSeleccionada = tablaSedes.getSelectedRow();

		    if (filaSeleccionada != -1) {
		        String sede = tablaSedes.getValueAt(filaSeleccionada, 0).toString();
		        Sede sedeSelec = null;
		        for (Sede u : listaSedes.getListadeSedes()) {
		            if (u.getNombre().equals(sede)) {
		            	sedeSelec = u;
		                break;
		            }
		        }

		        if (sedeSelec != null) {
		            Object[] opciones = {"Sí", "No"}; 
					int confirmar = JOptionPane.showOptionDialog(null, "Desea elminar la " + sedeSelec.getNombre(), "Confirmar eliminacion", 
							JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, opciones, opciones[1]);
					if (confirmar == JOptionPane.YES_OPTION) {
			        	listaSedes.getListadeSedes().remove(sedeSelec);
			            DefaultTableModel modelSed = vAdmin.getPa().getModelSed();
			            modelSed.removeRow(filaSeleccionada);
					    vAdmin.getPa().limpiarVista();
					    Estandar.MensajeInformacion("Sede eliminada exitosamente", "Sede eliminada");
					}
					
		        }
		    }
		}
		
		if(comando.equals("AgregarSedeADMIN")) {
			vAgregarSede = new VentanaAgregarSede();
			vAgregarSede.getBagregar().addActionListener(this);
			vAgregarSede.getBcancelar().addActionListener(this);
			vAgregarSede.setVisible(true);
			vAdmin.setVisible(false);
		}
		
		if(comando.equals("bCancelarSEDE")) {
			vAgregarSede.setVisible(false);
			vAdmin.setVisible(true);
		}
		
		if(comando.equals("bAGREGARSEDE")) {
			boolean vnombre, vdireccion;
			if(vAgregarSede.getTnombre().getText().equals("")) {
				vAgregarSede.getEnombre().setForeground(Color.RED);
				vnombre = false;
			}else {
				vnombre = true;
			}
			if(vAgregarSede.getTdireccion().getText().equals("")) {
				vAgregarSede.getEdireccion().setForeground(Color.RED);
				vdireccion = false;
			}else {
				vdireccion = true;
			}
			if(vnombre && vdireccion){
				String nombresede = vAgregarSede.getTnombre().getText();
				String direccionsede = vAgregarSede.getTdireccion().getText();
				Sede sede = new Sede(direccionsede, nombresede);
				boolean respuesta = listaSedes.agregarSede(sede);
				if (respuesta) {
					Estandar.MensajeInformacion("Se ha creado la sede exitosamente!", "Sede creada");
					vAgregarSede.getTdireccion().setText("");
					vAgregarSede.getTnombre().setText("");
					vAgregarSede.setVisible(false);
					vAdmin.setVisible(true);
					vAdmin.getPa().limpiarVista();
				}else {
					Estandar.MensajeError("Fallo al registrar");
				}
				listaSedes.agregarSede(sede);
			}
		}		
		
		if(comando.equals("bCERRARSESIONADMIN")) {
			vAdmin.setVisible(false);
			vInicial.getLayeredPane().add(Estandar.getFondoImagen(), Integer.valueOf(0));
			vInicial.setVisible(true);
			vInicial.getPl().getTclave().setText(null);
			vInicial.getPl().getTusuario().setText(null);
			vInicial.getPl().getEsubusuario().setText("Ingrese su nombre de usuario (alias):");
			vInicial.getPl().getEsubusuario().setForeground(new Color(92,92,102));
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
					String genero = vInicial.getPr().getLista_genero().getSelectedItem().toString();
					String clavefinal = new String(vInicial.getPr().getTclave().getPassword());
					Random random = new Random();	
					int randomNumber = random.nextInt(2500001) + 500000;
					int cupo = randomNumber;
					
					usuario = new Usuario(nombre, alias, "Usuario", clavefinal, correo, genero, cupo, 0, 0);
					boolean respuesta = lista.agregarUsuario(usuario);
					if (respuesta) {
						volver();
						Estandar.MensajeInformacion("Se ha registrado exitosamente!\n\nSe le ha asignado un cupo de $" + cupo + " pesos", "Registro exitoso");
					}else {
						Estandar.MensajeError("Fallo al registrar");
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
				Estandar.MensajeError("No es posible abonar, no cuenta con una deuda");
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
				Estandar.MensajeInformacion("Ha abonado $" + vCliente.getPa().getTmonto().getText() + " pesos", "Abono exitoso");
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
					vCliente.setMinimumSize(new Dimension(700, 580));
					if(700 > vCliente.getSize().height) {
						vCliente.setSize(700, 600);
					}
					
				}
			}
		}
		if(comando.equals("bRegistrarpareja")) {
			String nombre = vCliente.getPrp().getTnombre().getText();
			String alias = vCliente.getPrp().getTusuario().getText();
			String correo = vCliente.getPrp().getTcorreo().getText();
			String genero = vCliente.getPrp().getLista_genero().getSelectedItem().toString();
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
				usuario.setCredito(usuario.getCredito()-credito);
				pareja = new Pareja(nombre, alias, "Pareja", clavefinal, correo, genero, credito, 0, horarioPareja, sedeSelec, usuario);
				boolean respuesta = listapareja.agregarParejas(pareja);
				if (respuesta) {
					Estandar.MensajeInformacion("Se ha registrado la pareja exitosamente!", "Registro exitoso");
					vCliente.setTitle("Menu principal - HIDE&SEEK");
					vCliente.getPc().geteDinerodisponible().setText("$ " + usuario.getCredito() + " pesos");
					vCliente.setMinimumSize(new Dimension(675, 580));
					try {
						vCliente.getPrp().setVisible(false);
						vCliente.getPrh().setVisible(false);
						vCliente.getPc().setVisible(true);
						vCliente.getLayeredPane().remove(vCliente.getPrp());
						vCliente.getLayeredPane().add(vCliente.getPc(), Integer.valueOf(1));
					}catch (IllegalArgumentException hp) {
						vCliente.getPrp().setVisible(false);
						vCliente.getPrh().setVisible(false);
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
				}else {
					Estandar.MensajeError("Fallo al registrar");
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
			vCliente.getPc().setVisible(false);
			vCliente.getPvp().setVisible(true);

			vCliente.getPvp().getBvolver().addActionListener(this);
			
			vCliente.getLayeredPane().remove(vCliente.getPc());
			vCliente.getLayeredPane().add(vCliente.getPvp(), Integer.valueOf(1));
			vCliente.setLocationRelativeTo(null);

	        try {
		        for (Pareja pareja : listapareja.getListadeParejas()) {
		            Object[] fila = {
		            		pareja.getNombre(),
		            		pareja.getUser(),
		            		pareja.getCorreo(),
		            		pareja.getGenero(),
		            		pareja.getCredito(),
		            		pareja.getDeuda()
		            };
		            vCliente.getPvp().getModel().addRow(fila);
		        }
	        }catch (NullPointerException nulo) {
				
			}

		}

		// Comandos parejas actuales
		if(comando.equals("bVOLVERVERPAREJAS")) {
			try {
				vCliente.getPvp().setVisible(false);
				vCliente.getPc().setVisible(true);
				vCliente.getLayeredPane().remove(vCliente.getPvp());
				vCliente.getLayeredPane().add(vCliente.getPc(), Integer.valueOf(1));
			}catch (IllegalArgumentException hp) {
				vCliente.getPvp().setVisible(false);
				vCliente.getPc().setVisible(true);
				vCliente.getLayeredPane().add(vCliente.getPc(), Integer.valueOf(1));
			}
		}
		
		// Menu CLIENTE
		
		if(comando.equals("bHISTORIAL")){
			vCliente.setTitle("Historial de compras");
			vCliente.getPc().setVisible(false);
			vCliente.getPhc().getBvolver().addActionListener(this);
			vCliente.getPhc().setVisible(true);
			vCliente.getLayeredPane().remove(vCliente.getPc());
			vCliente.getLayeredPane().add(vCliente.getPhc(), Integer.valueOf(1));
			try {
				for (Compra compra : listadecompra.getListadeCompras()) {
		            Object[] fila = {
		            		compra.getNombre(),
		            		compra.getPrecio(),
		            		compra.getHora(),
		            		compra.getFecha(),
		            		compra.getSededondesecompra().getNombre()
		            };
		            vCliente.getPhc().getModel().addRow(fila);
		        }
	        }catch (NullPointerException nulo) {
				
			}
		}
		// Comandos historial compras
		if(comando.equals("bVOLVERVERHISTORIALCOMPRAS")) {
			try {
				vCliente.getPhc().setVisible(false);
				vCliente.getPc().setVisible(true);
				vCliente.getLayeredPane().remove(vCliente.getPhc());
				vCliente.getLayeredPane().add(vCliente.getPc(), Integer.valueOf(1));
			}catch (IllegalArgumentException hp) {
				vCliente.getPhc().setVisible(false);
				vCliente.getPc().setVisible(true);
				vCliente.getLayeredPane().add(vCliente.getPc(), Integer.valueOf(1));
			}
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
			int monto = 0;
			try {
			monto = Integer.parseInt(vCliente.getPs().getTmonto().getText());
			}catch(NumberFormatException n) {
				
			}
			if(vCliente.getPs().getTmonto().getText().equals("") || monto <= 0) {
				vCliente.getPs().getEingrese().setText("Ingrese cuanto sobrecupo solicita:");
				vCliente.getPs().getEingrese().setForeground(Color.RED);
				vCliente.getPs().getTmonto().setText("");
			}else {
				Estandar.MensajeInformacion("Ha solicitado un sobrecupo de $" + monto + " pesos", "Sobrecupo solicitado");
				usuario.setSobrecupo(monto);
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
							Compra x = new Compra(producto.getNombre(), producto.getImg(), producto.getPrecio(), usuario, sedecompra);
							for (int i = 0; i < cantidad; i++) {
								listadecompra.agregarCompra(x);
							}
							
						}else {
							Estandar.MensajeError("Usted no cuenta con el credito suficiente para hacer la compra");
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
		
		//comandos ventana pareja
		if(comando.equals("bCERRARSESIONpareja")) {
			vParejaInicio.setVisible(false);
			vInicial.getLayeredPane().add(Estandar.getFondoImagen(), Integer.valueOf(0));
			vInicial.setVisible(true);
			vInicial.getPl().getTclave().setText(null);
			vInicial.getPl().getTusuario().setText(null);
		}
		
		if(comando.equals("bVerHorarioPareja")) {
			
		}		
		
		if(comando.equals("bHISTORIALpareja")) {
			vParejaInicio.setTitle("Historial de compras");
			vParejaInicio.getPpi().setVisible(false);
			vParejaInicio.getPhcp().getBvolver().addActionListener(this);
			vParejaInicio.getPhcp().setVisible(true);
			vParejaInicio.getLayeredPane().remove(vParejaInicio.getPpi());
			vParejaInicio.getLayeredPane().add(vParejaInicio.getPhcp(), Integer.valueOf(1));
			try {
				for (Compra compra : listadecompra.getListadeCompras()) {
		            Object[] fila = {
		            		compra.getNombre(),
		            		compra.getPrecio(),
		            		compra.getHora(),
		            		compra.getFecha(),
		            		compra.getSededondesecompra().getNombre()
		            };
		            vParejaInicio.getPhcp().getModel().addRow(fila);
		        }
	        }catch (NullPointerException nulo) {
				
			}
		}
		
		if(comando.equals("bVOLVERVERHISTORIALCOMPRASpareja")) {
			try {
				vParejaInicio.getPhcp().setVisible(false);
				vParejaInicio.getPpi().setVisible(true);
				vParejaInicio.getLayeredPane().remove(vParejaInicio.getPhcp());
				vParejaInicio.getLayeredPane().add(vParejaInicio.getPpi(), Integer.valueOf(1));
			}catch (IllegalArgumentException hp) {
				vParejaInicio.getPhcp().setVisible(false);
				vParejaInicio.getPpi().setVisible(true);
				vParejaInicio.getLayeredPane().add(vParejaInicio.getPpi(), Integer.valueOf(1));
			}
		}
		
		if(comando.equals("bABONARMENUpareja")){
			if(pareja.getDeuda() == 0) {
				Estandar.MensajeError("No es posible abonar, no cuenta con una deuda");
			}else {
				vParejaInicio.setTitle("Abono de credito");
				vParejaInicio.getPap().geteDineropendiente().setText("$ " + String.valueOf(pareja.getDeuda() + " pesos"));
				vParejaInicio.getPap().getEingrese().setText("Ingrese la cantidad de dinero a abonar:");
				vParejaInicio.getPap().getEingrese().setForeground(new Color(92,92,102));
				vParejaInicio.getPpi().setVisible(false);
				vParejaInicio.getPap().getBabonar().addActionListener(this);
				vParejaInicio.getPap().getBcerrar().addActionListener(this);
				vParejaInicio.getPap().setVisible(true);
				vParejaInicio.getPap().getTmonto().setText(null);
				vParejaInicio.getLayeredPane().remove(vParejaInicio.getPpi());
				vParejaInicio.getLayeredPane().add(vParejaInicio.getPap(), Integer.valueOf(1));
			}
		}
		
		if(comando.equals("bABONARpareja")) {
			long monto = 0;
			try {
			monto = Integer.parseInt(vParejaInicio.getPap().getTmonto().getText());
			}catch(NumberFormatException n) {
				
			}
			if(vParejaInicio.getPap().getTmonto().getText().equals("") ||  monto <= 0 || monto > pareja.getDeuda()) {
				vParejaInicio.getPap().getEingrese().setText("Ingrese la cantidad de dinero a abonar:");
				vParejaInicio.getPap().getEingrese().setForeground(Color.RED);
				vParejaInicio.getPap().getTmonto().setText("");
			}else {
				Estandar.MensajeInformacion("Ha abonado $" + vParejaInicio.getPap().getTmonto().getText() + " pesos", "Abono exitoso");
				pareja.setDeuda(pareja.getDeuda()-Integer.parseInt(vParejaInicio.getPap().getTmonto().getText()));
				vParejaInicio.getPpi().geteDineropendiente().setText("$ " + pareja.getDeuda() + " pesos");
				pareja.setCredito(pareja.getCredito()+Integer.parseInt(vParejaInicio.getPap().getTmonto().getText()));
				vParejaInicio.getPpi().geteDinerodisponible().setText("$ " + pareja.getCredito() + " pesos");
				vParejaInicio.getPap().setVisible(false);
				vParejaInicio.getPpi().setVisible(true);
				vParejaInicio.getLayeredPane().remove(vParejaInicio.getPap());
				vParejaInicio.getLayeredPane().add(vParejaInicio.getPpi(), Integer.valueOf(1));
				vParejaInicio.getPap().geteDineropendiente().setText("$ " + String.valueOf(pareja.getDeuda() + " pesos"));
				vParejaInicio.getPap().getTmonto().setText("");
			}
		}
		if(comando.equals("bCANCELARABONOpareja")) {
			try {
				vParejaInicio.getPap().setVisible(false);
				vParejaInicio.getPpi().setVisible(true);
				vParejaInicio.getLayeredPane().remove(vParejaInicio.getPap());
				vParejaInicio.getLayeredPane().add(vParejaInicio.getPpi(), Integer.valueOf(1));
			}catch (IllegalArgumentException hp) {
				vParejaInicio.getPap().setVisible(false);
				vParejaInicio.getPpi().setVisible(true);
				vParejaInicio.getLayeredPane().add(vParejaInicio.getPpi(), Integer.valueOf(1));
			}
		}
		
		if(comando.equals("bCOMPRARMENUpareja")){
			vParejaInicio.setVisible(false);
			vComprapareja = new VentanaComprapareja();
			Estandar.adaptarPanelCentro(vComprapareja, vComprapareja.getPtp());
			vComprapareja.getPtp().getEsedes().setForeground(new Color(92,92,102));
			vComprapareja.getPtp().getLista_sedes().addItem(" ");
			vComprapareja.getPtp().getLista_sedes().setSelectedItem(" ");

			for (Sede sede : listaSedes.getListadeSedes()) {
				vComprapareja.getPtp().getLista_sedes().addItem(sede.getNombre());
			}
			oyentesVcomprapareja();
		}
		
		if(comando.equals("LISTASEDESpareja")) {
			vComprapareja.getPtp().getLista_sedes().removeItem(" ");
			vComprapareja.getPtp().getEsedes().setForeground(new Color(92,92,102));
			
		}
		
		for (Producto producto : listaProductos.getListadeProductos()) {
			if(comando.equals("bp"+producto.getNombre())) {
				int totalCompra = 0;
				int cantidad = (int) vComprapareja.getPtp().buscarSpinner("spp"+producto.getNombre()).getValue();
				boolean vSede = false, vCantidad = false;
				if(!vComprapareja.getPtp().getLista_sedes().getSelectedItem().equals(" ")) {
					vSede = true;
				}else {
					vComprapareja.getPtp().getEsedes().setForeground(Color.RED);
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
						if(totalCompra < pareja.getCredito()) {
							JOptionPane.showMessageDialog(null, "Usted ha comprado " + cantidad + " " +producto.getNombre() 
							+ "\nTotal: " + totalCompra + " pesos");
							pareja.setCredito(pareja.getCredito() - totalCompra);
							pareja.setDeuda(pareja.getDeuda() + totalCompra);
							vParejaInicio.getPpi().geteDineropendiente().setText("$ " + pareja.getDeuda() + " pesos");
							vComprapareja.getPtp().buscarSpinner("spp"+producto.getNombre()).setValue(0);
							Sede sedecompra = null;
							for (Sede sede : listaSedes.getListadeSedes()) {
								if(vComprapareja.getPtp().getLista_sedes().getSelectedItem().equals(sede.getNombre())) {
									sedecompra = sede;	
								}
								
							}
							Compra x = new Compra(producto.getNombre(), producto.getImg(), producto.getPrecio(), pareja, sedecompra);
							for (int i = 0; i < cantidad; i++) {
								listadecompra.agregarCompra(x);
							}
							
						}else {
							Estandar.MensajeError("Usted no cuenta con el credito suficiente para hacer la compra");
						}
					}
				}
			}
		}
		
		if(comando.equals("bREGRESARVentanaPareja")){
			vParejaInicio.getPpi().geteDinerodisponible().setText("$ " + pareja.getCredito() + " pesos");
			vParejaInicio.setVisible(true);
			vComprapareja.setVisible(false);
		}
		
	}
	

	
	private void volver() {
		vInicial.getPl().getEsubusuario().setText("Ingrese su nombre de  (alias):");
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
	
}
