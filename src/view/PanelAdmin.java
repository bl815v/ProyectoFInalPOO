package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.ListadodeUsuarios;
import model.Usuario;

public class PanelAdmin extends JPanel{
	
	private JLabel etitulo, enombre;
	private JButton binformes, busuarios, bsolicitudes, bsedes, bcerrar, baceptarsolicitud, beliminaruser, beliminarsede, bagregarsede;
	private ListadodeUsuarios listauser;
	
	private JPanel cuadroUsuarios, cuadroInformes, cuadroSolicitudes, cuadroSedes;
    DefaultTableModel modelU, modelSol, modelSed;
    JTable tablaSolicitudes,tablaUsuarios, tablaSedes;

	public PanelAdmin() {
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(680, 520));
		listauser = new ListadodeUsuarios();
		
		inicializarComponentes();
		setVisible(true);
		
	}

	public void inicializarComponentes() {
		// North
		JPanel Auxbotones = new JPanel(new GridLayout(1, 5, 10, 0));
		binformes = Estandar.boton("Informes");
		binformes.setActionCommand("BINFORMES_ADMIN");
		Auxbotones.add(binformes);
		
		busuarios = Estandar.boton("Usuarios");
		busuarios.setActionCommand("BUSUARIOS_ADMIN");
		Auxbotones.add(busuarios);
		
		bsolicitudes = Estandar.boton("Solicitudes");
		bsolicitudes.setActionCommand("BSOLICITUDES_ADMIN");
		Auxbotones.add(bsolicitudes);
		
		bsedes = Estandar.boton("Sedes");
		bsedes.setActionCommand("BSEDES_ADMIN");
		Auxbotones.add(bsedes);

		add(Auxbotones, BorderLayout.NORTH);
		
		// Center
				
				
		// South
		JPanel sur = new JPanel();
		sur.setLayout(new BorderLayout());
		
		bcerrar = Estandar.botonSinFondo("Cerrar sesion");
		bcerrar.setActionCommand("bCERRARSESIONADMIN");
		sur.add(Estandar.Espacio(), BorderLayout.NORTH);
		sur.add(bcerrar, BorderLayout.WEST);
		add(sur, BorderLayout.SOUTH);
	}
	
	public void verInformes() {
	    if (cuadroInformes == null) {
	        cuadroInformes = new JPanel(new BorderLayout());
	        cuadroInformes.add(Estandar.labelGris("Generando informes estadisticos"));
	        add(cuadroInformes, BorderLayout.CENTER);
	    }

	    cuadroInformes.setVisible(true);
	    revalidate();
	    repaint();
	}
	
	public void verUsuarios() {
	    if (cuadroUsuarios == null) {
	        cuadroUsuarios = new JPanel(new BorderLayout());
	        String[] columnas = {"Nombre", "Usuario", "Rol", "Correo", "Genero", "Credito", "Deuda"};
	        modelU = new DefaultTableModel(null, columnas) {
	            @Override
	            public boolean isCellEditable(int row, int column) {
	                return false;
	            }
	        };
	        tablaUsuarios = new JTable(modelU);
	        JScrollPane scrollPane = new JScrollPane(tablaUsuarios);
	        cuadroUsuarios.add(scrollPane, BorderLayout.CENTER);
	        JPanel auxUser = new JPanel(new BorderLayout());
	        beliminaruser = Estandar.boton("Eliminar usuario");
	        beliminaruser.setActionCommand("BeliminaruserADMIN");
	        auxUser.add(beliminaruser, BorderLayout.NORTH);
	        cuadroUsuarios.add(auxUser, BorderLayout.EAST);
	        add(cuadroUsuarios, BorderLayout.CENTER);
	    }

	    cuadroUsuarios.setVisible(true);
	    revalidate();
	    repaint();
	}
	
	public void verSolicitudes() {
	    if (cuadroSolicitudes == null) {
	        cuadroSolicitudes = new JPanel(new BorderLayout());
	        String[] columnas = {"Nombre", "Usuario", "Correo", "Credito", "Deuda", "Solicitud"};
	        modelSol = new DefaultTableModel(null, columnas) {
	            @Override
	            public boolean isCellEditable(int row, int column) {
	                return false;
	            }
	        };
	        tablaSolicitudes = new JTable(modelSol);
	        JScrollPane scrollPane = new JScrollPane(tablaSolicitudes);
	        cuadroSolicitudes.add(scrollPane, BorderLayout.CENTER);
	        JPanel auxSolic = new JPanel(new BorderLayout());
	        baceptarsolicitud = Estandar.boton("Aceptar Solicitud");
	        baceptarsolicitud.setActionCommand("AceptSolicitADMIN");
	        auxSolic.add(baceptarsolicitud, BorderLayout.NORTH);
	        cuadroSolicitudes.add(auxSolic, BorderLayout.EAST);
	        add(cuadroSolicitudes, BorderLayout.CENTER);
	    }

	    cuadroSolicitudes.setVisible(true);
	    revalidate();
	    repaint();
	}
	
	public void verSedes() {
	    if (cuadroSedes == null) {
	        cuadroSedes = new JPanel(new BorderLayout());
	        String[] columnas = {"Nombre", "Direccion"};
	        modelSed = new DefaultTableModel(null, columnas) {
	            @Override
	            public boolean isCellEditable(int row, int column) {
	                return false;
	            }
	        };
	        tablaSedes = new JTable(modelSed);
	        JScrollPane scrollPane = new JScrollPane(tablaSedes);
	        cuadroSedes.add(scrollPane, BorderLayout.CENTER);
	        JPanel auxSede = new JPanel(new BorderLayout());
	        JPanel auxBotonsede = new JPanel();
	        auxBotonsede.setLayout(new BoxLayout(auxBotonsede, BoxLayout.Y_AXIS));
	        beliminarsede = Estandar.boton("Eliminar sede");
	        beliminarsede.setActionCommand("EliminarSedeADMIN");
	        auxBotonsede.add(beliminarsede);

	        bagregarsede = Estandar.boton("Agregar sede");
	        bagregarsede.setActionCommand("AgregarSedeADMIN");
	        auxBotonsede.add(bagregarsede);

	        auxSede.add(auxBotonsede, BorderLayout.NORTH);
	        cuadroSedes.add(auxSede, BorderLayout.EAST);
	        add(cuadroSedes, BorderLayout.CENTER);
	    }

	    cuadroSedes.setVisible(true);
	    revalidate();
	    repaint();
	}
	
	public void limpiarVista() {
	    if (cuadroInformes != null) {
	        cuadroInformes.setVisible(false);
	    }

	    if (cuadroUsuarios != null) {
	        cuadroUsuarios.setVisible(false);
	    }

	    if (cuadroSolicitudes != null) {
	        cuadroSolicitudes.setVisible(false);
	    }

	    if (cuadroSedes != null) {
	        cuadroSedes.setVisible(false);
	    }

	    revalidate();
	    repaint();
	}

	public JLabel getEtitulo() {
		return etitulo;
	}

	public void setEtitulo(JLabel etitulo) {
		this.etitulo = etitulo;
	}

	public JLabel getEnombre() {
		return enombre;
	}

	public void setEnombre(JLabel enombre) {
		this.enombre = enombre;
	}

	public JButton getBinformes() {
		return binformes;
	}

	public void setBinformes(JButton binformes) {
		this.binformes = binformes;
	}

	public JButton getBusuarios() {
		return busuarios;
	}

	public void setBusuarios(JButton busuarios) {
		this.busuarios = busuarios;
	}

	public JButton getBsolicitudes() {
		return bsolicitudes;
	}

	public void setBsolicitudes(JButton bsolicitudes) {
		this.bsolicitudes = bsolicitudes;
	}

	public JButton getBsedes() {
		return bsedes;
	}

	public void setBsedes(JButton bsedes) {
		this.bsedes = bsedes;
	}

	public JButton getBcerrar() {
		return bcerrar;
	}

	public void setBcerrar(JButton bcerrar) {
		this.bcerrar = bcerrar;
	}

	public JButton getBaceptarsolicitud() {
		return baceptarsolicitud;
	}

	public void setBaceptarsolicitud(JButton baceptarsolicitud) {
		this.baceptarsolicitud = baceptarsolicitud;
	}

	public JButton getBeliminaruser() {
		return beliminaruser;
	}

	public void setBeliminaruser(JButton beliminaruser) {
		this.beliminaruser = beliminaruser;
	}

	public JButton getBeliminarsede() {
		return beliminarsede;
	}

	public void setBeliminarsede(JButton beliminarsede) {
		this.beliminarsede = beliminarsede;
	}
	
	public JButton getBagregarsede() {
		return bagregarsede;
	}

	public void setBagregarsede(JButton bagregarsede) {
		this.bagregarsede = bagregarsede;
	}

	public ListadodeUsuarios getListauser() {
		return listauser;
	}

	public void setListauser(ListadodeUsuarios listauser) {
		this.listauser = listauser;
	}

	public JPanel getCuadroUsuarios() {
		return cuadroUsuarios;
	}

	public void setCuadroUsuarios(JPanel cuadroUsuarios) {
		this.cuadroUsuarios = cuadroUsuarios;
	}

	public JPanel getCuadroInformes() {
		return cuadroInformes;
	}

	public void setCuadroInformes(JPanel cuadroInformes) {
		this.cuadroInformes = cuadroInformes;
	}

	public JPanel getCuadroSolicitudes() {
		return cuadroSolicitudes;
	}

	public void setCuadroSolicitudes(JPanel cuadroSolicitudes) {
		this.cuadroSolicitudes = cuadroSolicitudes;
	}

	public JPanel getCuadroSedes() {
		return cuadroSedes;
	}

	public void setCuadroSedes(JPanel cuadroSedes) {
		this.cuadroSedes = cuadroSedes;
	}

	public DefaultTableModel getModelU() {
		return modelU;
	}

	public void setModelU(DefaultTableModel modelU) {
		this.modelU = modelU;
	}

	public DefaultTableModel getModelSol() {
		return modelSol;
	}

	public void setModelSol(DefaultTableModel modelSol) {
		this.modelSol = modelSol;
	}

	public DefaultTableModel getModelSed() {
		return modelSed;
	}

	public void setModelSed(DefaultTableModel modelSed) {
		this.modelSed = modelSed;
	}

	public JTable getTablaSolicitudes() {
		return tablaSolicitudes;
	}

	public void setTablaSolicitudes(JTable tablaSolicitudes) {
		this.tablaSolicitudes = tablaSolicitudes;
	}

	public JTable getTablaUsuarios() {
		return tablaUsuarios;
	}

	public void setTablaUsuarios(JTable tablaUsuarios) {
		this.tablaUsuarios = tablaUsuarios;
	}

	public JTable getTablaSedes() {
		return tablaSedes;
	}

	public void setTablaSedes(JTable tablaSedes) {
		this.tablaSedes = tablaSedes;
	}

}
