package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.ListadodeUsuarios;

/**
 * PanelAdmin es el panel para que el admin pueda crear Informes,gestionar
 * usuarios,sedes y solicituddes
 * 
 * @author Esteban Arevalo
 */
public class PanelAdmin extends JPanel {

	private JLabel etitulo, enombre;
	private JButton binformes, busuarios, bsolicitudes, bsedes, bcerrar, baceptarsolicitud, beliminaruser,
			beliminarsede, bagregarsede;
	private ListadodeUsuarios listauser;

	private JPanel cuadroUsuarios, cuadroInformes, cuadroSolicitudes, cuadroSedes;
	private DefaultTableModel modelU, modelSol, modelSed;
	private JTable tablaSolicitudes, tablaUsuarios, tablaSedes;

	/**
	 * Crea el pane e inicializa sus componentes 680px ancho,520px largo,
	 */
	public PanelAdmin() {
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(680, 520));
		listauser = new ListadodeUsuarios();

		inicializarComponentes();
		setVisible(true);

	}

	/**
	 * Inicializa los componentes del panel Relacionados al
	 * Informe,usuarios,solicitudes y sedes
	 */
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
		JPanel sur = new JPanel();
		sur.setLayout(new BorderLayout());

		bcerrar = Estandar.botonSinFondo("Cerrar sesion");
		bcerrar.setActionCommand("bCERRARSESIONADMIN");
		sur.add(Estandar.Espacio(), BorderLayout.NORTH);
		sur.add(bcerrar, BorderLayout.WEST);
		add(sur, BorderLayout.SOUTH);
	}

	/**
	 * Inicializa el panel para ver los informes Relacionados a el informe en
	 * formato PDF y sus estadisticas
	 */
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

	/**
	 * Inicializa el panel para ver los usuarios Relacionados a la gestion de los
	 * usuarios existentes
	 */
	public void verUsuarios() {
		if (cuadroUsuarios == null) {
			cuadroUsuarios = new JPanel(new BorderLayout());
			String[] columnas = { "Nombre", "Usuario", "Rol", "Correo", "Genero", "Credito", "Deuda" };
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

	/**
	 * Inicializa el panel para ver las Solicitudes Relarcionados a la solicitudes
	 * echas y su gestion
	 */
	public void verSolicitudes() {
		if (cuadroSolicitudes == null) {
			cuadroSolicitudes = new JPanel(new BorderLayout());
			String[] columnas = { "Nombre", "Usuario", "Correo", "Credito", "Deuda", "Solicitud" };
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

	/**
	 * Innicializa el panel de sedes Relacionado a las sedes existentes y su
	 * gestion(agregar y eliminar)
	 *
	 */
	public void verSedes() {
		if (cuadroSedes == null) {
			cuadroSedes = new JPanel(new BorderLayout());
			String[] columnas = { "Nombre", "Direccion" };
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

	/**
	 * Oculta todo los paneles
	 */
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

	/**
	 * Obtiene el JLabel con el titulo, es lo primero que aparece en el panel.
	 * 
	 * @return JLabel con el titulo
	 */
	public JLabel getEtitulo() {
		return etitulo;
	}

	/**
	 * Cambia el JLabe con el titulo por otro JLabel,es lo primero que aparece en el
	 * pane
	 * 
	 * @param titulo JLabel por el que se desea cambiar.
	 */
	public void setEtitulo(JLabel etitulo) {
		this.etitulo = etitulo;
	}

	/**
	 * Obtiene el JLabel que contiene el nombre de la etiqueta
	 * 
	 * @return JLabel que indica el nombre de la etiqueta
	 */
	public JLabel getEnombre() {
		return enombre;
	}

	/**
	 * Cambia el JLabe con el nombre de la etiqueta
	 * 
	 * @param enombre JLbel que aparece para indicar el nombre
	 */
	public void setEnombre(JLabel enombre) {
		this.enombre = enombre;
	}

	/**
	 * Obtiene el JButton para generar informes segun las estadisticas
	 * 
	 * @return JButton para generar un informe
	 */
	public JButton getBinformes() {
		return binformes;
	}

	/**
	 * Cambie el JButton para generar informes
	 * 
	 * @param binformes JButton por el que se desea cambiar
	 */
	public void setBinformes(JButton binformes) {
		this.binformes = binformes;
	}

	/**
	 * Obtiene el JButton para gestionar usuarios
	 * 
	 * @return JButton para gestionar usuarios
	 */
	public JButton getBusuarios() {
		return busuarios;
	}

	/**
	 * Cambie el JButton para gestionar usuarios
	 * 
	 * @param busuarios JButon por el que se desea cambiar
	 */
	public void setBusuarios(JButton busuarios) {
		this.busuarios = busuarios;
	}

	/**
	 * Obtiene el JButton para gestionar las solicitudes existentes
	 * 
	 * @return JButton para gestionar Solicitudes
	 */
	public JButton getBsolicitudes() {
		return bsolicitudes;
	}

	/**
	 * Cambiar el JButton para gestionar las solicitudes
	 * 
	 * @param bsolicitudes JButton por el que se desea cambiar
	 */
	public void setBsolicitudes(JButton bsolicitudes) {
		this.bsolicitudes = bsolicitudes;
	}

	/**
	 * Obtiene el JButton para visualizar y gestionar las seedes
	 * 
	 * @return JButton para visualizar y gestionar sedes
	 */
	public JButton getBsedes() {
		return bsedes;
	}

	/**
	 * Cambia el JButton para visualizar y gestionar sedes
	 * 
	 * @param bsedes JButton por el que se desea cambiar
	 */
	public void setBsedes(JButton bsedes) {
		this.bsedes = bsedes;
	}

	/**
	 * Obtiene el JButton para cerrar el panel
	 * 
	 * @return JButton para cerrar el panel
	 */
	public JButton getBcerrar() {
		return bcerrar;
	}

	/**
	 * Cambia el JButton para salir del panel
	 * 
	 * @param bcerrar JButton por el que se desea cambiar
	 */
	public void setBcerrar(JButton bcerrar) {
		this.bcerrar = bcerrar;
	}

	/**
	 * Obtiene el JButton para aceptar una solicitud
	 * 
	 * @return JButton para aceptar solicitudes
	 */
	public JButton getBaceptarsolicitud() {
		return baceptarsolicitud;
	}

	/**
	 * Cambia el JButton para aceptar solicitudes
	 * 
	 * @param baceptarsolicitud JButton por el que se desea cambiar
	 */
	public void setBaceptarsolicitud(JButton baceptarsolicitud) {
		this.baceptarsolicitud = baceptarsolicitud;
	}

	/**
	 * Obtiene el JButton para eliminar un usuario
	 * 
	 * @return JButton para eliminar un usuario
	 */
	public JButton getBeliminaruser() {
		return beliminaruser;
	}

	/**
	 * Cambia el JButton para eliminar un usuario
	 * 
	 * @param beliminaruser JButton por el que se desea cambiar
	 */
	public void setBeliminaruser(JButton beliminaruser) {
		this.beliminaruser = beliminaruser;
	}

	/**
	 * Obtiene JButton para eliminar una sede de las existentes
	 * 
	 * @return JButton para eliminar una sede
	 */
	public JButton getBeliminarsede() {
		return beliminarsede;
	}

	/**
	 * Cambia el JButton para eliminar una sede existente
	 * 
	 * @param beliminarsede JButton por el que se desea cambiar
	 */
	public void setBeliminarsede(JButton beliminarsede) {
		this.beliminarsede = beliminarsede;
	}

	/**
	 * Obtiene el JButton para agregar una sede
	 * 
	 * @return JButton para agregar una sede
	 */
	public JButton getBagregarsede() {
		return bagregarsede;
	}

	/**
	 * Cambia el JButto para agregar una sede
	 * 
	 * @param bagregarsede JButton por el que se desea cambiar
	 */
	public void setBagregarsede(JButton bagregarsede) {
		this.bagregarsede = bagregarsede;
	}

	/**
	 * Método de obtención para listauser (lista de usuarios).
	 * 
	 * @return La lista de usuarios.
	 */
	public ListadodeUsuarios getListauser() {
		return listauser;
	}

	/**
	 * Método de establecimiento para listauser (lista de usuarios).
	 * 
	 * @param listauser La lista de usuarios a establecer.
	 */
	public void setListauser(ListadodeUsuarios listauser) {
		this.listauser = listauser;
	}

	/**
	 * Método de obtención para cuadroUsuarios (panel de información de usuarios).
	 * 
	 * @return El panel de información de usuarios.
	 */
	public JPanel getCuadroUsuarios() {
		return cuadroUsuarios;
	}

	/**
	 * Método de establecimiento para cuadroUsuarios (panel de información de
	 * usuarios).
	 * 
	 * @param cuadroUsuarios El panel de información de usuarios a establecer.
	 */
	public void setCuadroUsuarios(JPanel cuadroUsuarios) {
		this.cuadroUsuarios = cuadroUsuarios;
	}

	/**
	 * Método de obtención para cuadroInformes (panel de información de informes).
	 * 
	 * @return El panel de información de informes.
	 */
	public JPanel getCuadroInformes() {
		return cuadroInformes;
	}

	/**
	 * Método de establecimiento para cuadroInformes (panel de información de
	 * informes).
	 * 
	 * @param cuadroInformes El panel de información de informes a establecer.
	 */
	public void setCuadroInformes(JPanel cuadroInformes) {
		this.cuadroInformes = cuadroInformes;
	}

	/**
	 * Método de obtención para cuadroSolicitudes (panel de información de
	 * solicitudes).
	 * 
	 * @return El panel de información de solicitudes.
	 */
	public JPanel getCuadroSolicitudes() {
		return cuadroSolicitudes;
	}

	/**
	 * Método de establecimiento para cuadroSolicitudes (panel de información de
	 * solicitudes).
	 * 
	 * @param cuadroSolicitudes El panel de información de solicitudes a establecer.
	 */
	public void setCuadroSolicitudes(JPanel cuadroSolicitudes) {
		this.cuadroSolicitudes = cuadroSolicitudes;
	}

	/**
	 * Método de obtención para cuadroSedes (panel de información de sedes).
	 * 
	 * @return El panel de información de sedes.
	 */
	public JPanel getCuadroSedes() {
		return cuadroSedes;
	}

	/**
	 * Método de establecimiento para cuadroSedes (panel de información de sedes).
	 * 
	 * @param cuadroSedes El panel de información de sedes a establecer.
	 */
	public void setCuadroSedes(JPanel cuadroSedes) {
		this.cuadroSedes = cuadroSedes;
	}

	/**
	 * Método de obtención para modelU (modelo de tabla para usuarios).
	 * 
	 * @return El modelo de tabla para usuarios.
	 */
	public DefaultTableModel getModelU() {
		return modelU;
	}

	/**
	 * Método de establecimiento para modelU (modelo de tabla para usuarios).
	 * 
	 * @param modelU El modelo de tabla para usuarios a establecer.
	 */
	public void setModelU(DefaultTableModel modelU) {
		this.modelU = modelU;
	}

	/**
	 * Método de obtención para modelSol (modelo de tabla para solicitudes).
	 * 
	 * @return El modelo de tabla para solicitudes.
	 */
	public DefaultTableModel getModelSol() {
		return modelSol;
	}

	/**
	 * Método de establecimiento para modelSol (modelo de tabla para solicitudes).
	 * 
	 * @param modelSol El modelo de tabla para solicitudes a establecer.
	 */
	public void setModelSol(DefaultTableModel modelSol) {
		this.modelSol = modelSol;
	}

	/**
	 * Método de obtención para modelSed (modelo de tabla para sedes).
	 * 
	 * @return El modelo de tabla para sedes.
	 */
	public DefaultTableModel getModelSed() {
		return modelSed;
	}

	/**
	 * Método de establecimiento para modelSed (modelo de tabla para sedes).
	 * 
	 * @param modelSed El modelo de tabla para sedes a establecer.
	 */
	public void setModelSed(DefaultTableModel modelSed) {
		this.modelSed = modelSed;
	}

	/**
	 * Método de obtención para tablaSolicitudes (tabla de solicitudes).
	 * 
	 * @return La tabla de solicitudes.
	 */
	public JTable getTablaSolicitudes() {
		return tablaSolicitudes;
	}

	/**
	 * Método de establecimiento para tablaSolicitudes (tabla de solicitudes).
	 * 
	 * @param tablaSolicitudes La tabla de solicitudes a establecer.
	 */
	public void setTablaSolicitudes(JTable tablaSolicitudes) {
		this.tablaSolicitudes = tablaSolicitudes;
	}

	/**
	 * Método de obtención para tablaUsuarios (tabla de usuarios).
	 * 
	 * @return La tabla de usuarios.
	 */
	public JTable getTablaUsuarios() {
		return tablaUsuarios;
	}

	/**
	 * Método de establecimiento para tablaUsuarios (tabla de usuarios).
	 * 
	 * @param tablaUsuarios La tabla de usuarios a establecer.
	 */
	public void setTablaUsuarios(JTable tablaUsuarios) {
		this.tablaUsuarios = tablaUsuarios;
	}

	/**
	 * Método de obtención para tablaSedes (tabla de sedes).
	 * 
	 * @return La tabla de sedes.
	 */
	public JTable getTablaSedes() {
		return tablaSedes;
	}

	/**
	 * Método de establecimiento para tablaSedes (tabla de sedes).
	 * 
	 * @param tablaSedes La tabla de sedes a establecer.
	 */
	public void setTablaSedes(JTable tablaSedes) {
		this.tablaSedes = tablaSedes;
	}

}