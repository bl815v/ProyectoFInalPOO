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
	private JButton binformes, busuarios, bsolicitudes, bsedes, bcerrar, baceptarsolicitud;
	private ListadodeUsuarios listauser;
	
	private JPanel cuadroUsuarios, cuadroInformes, cuadroSolicitudes, cuadroSedes;
    DefaultTableModel modelU, modelSol, modedlSed;

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
		JPanel cuadroInformes = new JPanel(new BorderLayout());
		cuadroInformes.add(Estandar.labelGris("Generando informes estadisticos"));
		cuadroInformes.setVisible(false);
		add(cuadroInformes, BorderLayout.CENTER);
		cuadroInformes.setVisible(true);
	}
	
	public void verUsuarios() {
		JPanel cuadroUsuarios = new JPanel(new BorderLayout());
		String[] columnas = {"Nombre", "Usuario", "Rol", "Correo", "Genero", "Credito", "Deuda"};
	    modelU = new DefaultTableModel(null, columnas) {
        	@Override
        	public boolean isCellEditable(int row, int column) {
            	return false;
        	}
    	};
	    JTable tablaUsuarios = new JTable(modelU);
	    JScrollPane scrollPane = new JScrollPane(tablaUsuarios);
        cuadroUsuarios.add(scrollPane, BorderLayout.CENTER);
        cuadroUsuarios.setVisible(false);
		add(cuadroUsuarios, BorderLayout.CENTER);
		cuadroUsuarios.setVisible(true); 
	}
	
	public void verSolicitudes() {
	    JPanel cuadroSolicitudes = new JPanel(new BorderLayout());
	    String[] columnas = {"Nombre", "Usuario", "Correo", "Credito", "Deuda", "Solicitud"};
	    modelSol = new DefaultTableModel(null, columnas) {
	        @Override
	        public boolean isCellEditable(int row, int column) {
	            return false;
	        }
	    };
	    JTable tablaSolicitudes = new JTable(modelSol);
	    JScrollPane scrollPane = new JScrollPane(tablaSolicitudes);
	    cuadroSolicitudes.add(scrollPane, BorderLayout.CENTER);
	    baceptarsolicitud =Estandar.boton("Aceptar\nSolicitud");
	    baceptarsolicitud.setActionCommand("AceptSolicitADMIN");
	    cuadroSolicitudes.add(baceptarsolicitud,BorderLayout.EAST);
	    add(cuadroSolicitudes, BorderLayout.CENTER);
	}
	
	public void limpiarVista() {
		try {
			remove(cuadroInformes);
			remove(cuadroUsuarios);
			remove(cuadroSedes);
			remove(cuadroSolicitudes);
	        revalidate();
	        repaint();
		}catch (NullPointerException e) {
			
		}
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

	public DefaultTableModel getModedlSed() {
		return modedlSed;
	}

	public void setModedlSed(DefaultTableModel modedlSed) {
		this.modedlSed = modedlSed;
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
	
}
