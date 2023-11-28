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
	private JButton binformes, busuarios, bparejas, bsolicitudes, bsedes, bcerrar;
	private JTable tablaUsuarios;
	
	private ListadodeUsuarios listauser;
	
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
		
		bparejas = Estandar.boton("Parejas");
		bparejas.setActionCommand("BPAREJAS_ADMIN");
		Auxbotones.add(bparejas);
		
		bsolicitudes = Estandar.boton("Solicitudes");
		bsolicitudes.setActionCommand("BSOLICITUDES_ADMIN");
		Auxbotones.add(bsolicitudes);
		
		bsedes = Estandar.boton("Sedes");
		bsedes.setActionCommand("BSEDES_ADMIN");
		Auxbotones.add(bsedes);

		add(Auxbotones, BorderLayout.NORTH);
		
		// Center
		JPanel centro = new JPanel();
		centro.setLayout(new BorderLayout());
		 String[] columnas = {"Nombre", "Usuario", "Rol", "Correo", "Género", "Crédito", "Deuda"};
	        DefaultTableModel model = new DefaultTableModel(null, columnas);
	        tablaUsuarios = new JTable(model);

	        for (Usuario usuario : listauser.getListadeUsuarios()) {
	            Object[] fila = {
	                    usuario.getNombre(),
	                    usuario.getUser(),
	                    usuario.getRol(),
	                    usuario.getCorreo(),
	                    usuario.getGenero(),
	                    usuario.getCredito(),
	                    usuario.getDeuda()
	            };
	            model.addRow(fila);
	        }

	        JScrollPane scrollPane = new JScrollPane(tablaUsuarios);
	        centro.add(scrollPane, BorderLayout.CENTER);
		add(centro, BorderLayout.CENTER);
				
		// South
		JPanel sur = new JPanel();
		sur.setLayout(new BorderLayout());
		
		bcerrar = Estandar.botonSinFondo("Cerrar sesion");
		bcerrar.setActionCommand("bCERRARSESIONADMIN");
		sur.add(Estandar.Espacio(), BorderLayout.NORTH);
		sur.add(bcerrar, BorderLayout.WEST);
		add(sur, BorderLayout.SOUTH);
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

	public JButton getBparejas() {
		return bparejas;
	}

	public void setBparejas(JButton bparejas) {
		this.bparejas = bparejas;
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

	public JTable getTablaUsuarios() {
		return tablaUsuarios;
	}

	public void setTablaUsuarios(JTable tablaUsuarios) {
		this.tablaUsuarios = tablaUsuarios;
	}

	public ListadodeUsuarios getListauser() {
		return listauser;
	}

	public void setListauser(ListadodeUsuarios listauser) {
		this.listauser = listauser;
	}
	
}
