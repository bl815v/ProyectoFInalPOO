package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * Estandar tiene los metodos que se usan normalmente en la interfaz grafica.
 * Titulos, subtitulos, botones, separadores, fondo y demas funciones utiles en
 * las ventanas y paneles.
 * 
 * @author Bedoya Lautero
 * 
 */
public abstract class Estandar {
	private Color colorAzulado = new Color(84, 160, 227);
	private static JLabel fondoImagen = new JLabel();

	public static void MensajeError(String texto) {
		JOptionPane.showMessageDialog(null, texto, "Error", JOptionPane.ERROR_MESSAGE);
	}

	public static void MensajeInformacion(String texto, String titulo) {
		JOptionPane.showMessageDialog(null, texto, titulo, JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Crea un JLabel con el texto HIDE&SEEK. Fuente Arial, en negrilla, 22px.
	 * 
	 * @return JLabel HIDE&SEEK
	 */
	public static JLabel HideSeek() {
		JLabel etitulo = new JLabel("HIDE&SEEK");
		etitulo.setFont(new Font("Arial", Font.BOLD, 22));
		return etitulo;
	}

	/**
	 * Crea un JLabel gris (16px). Fuente Arial, 16px.
	 * 
	 * @param nombre Texto que tiene el JLabel
	 * @return JLabel gris con el texto ingresado
	 */
	public static JLabel labelGris(String nombre) {
		JLabel subtitulo = new JLabel(nombre);
		subtitulo.setFont(new Font("Arial", Font.PLAIN, 16));
		subtitulo.setForeground(new Color(92, 92, 102));
		return subtitulo;
	}

	/**
	 * Crea un JLabel negro (18px). Fuente Arial, 18px.
	 * 
	 * @param nombre Texto que tiene el JLabel
	 * @return JLabel negro con el texto ingresado
	 */
	public static JLabel labelNegro(String nombre) {
		JLabel titulo = new JLabel(nombre);
		titulo.setFont(new Font("Arial", Font.PLAIN, 18));
		;
		return titulo;
	}

	/**
	 * Previene que se cierre la ventana por error. Advierte que se perderan todos
	 * los datos si se cierra el programa en una ventana emergente si/no.
	 * 
	 * @param frame Ventana que tendra la alerta antes de cerrarse
	 */
	public static void alertaCerrarVentana(JFrame frame) {
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Object[] opciones = { "Sí", "No" };
				int confirmar = JOptionPane.showOptionDialog(null,
						"Esta seguro que desea cerrar la ventana? \n\nSe perderan todos los datos del programa",
						"Cerrar todo el programa", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null,
						opciones, opciones[1]);
				if (confirmar == JOptionPane.YES_OPTION) {
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} else {
					frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}
		});
	}

	/**
	 * Crea un JButton azul. Boton color azul casi celeste, texto blanco, fuente
	 * Arial a 18px.
	 * 
	 * @param nombre Texto que tiene el boton
	 * @return Boton azul con el texto blanco
	 */
	public static JButton boton(String nombre) {
		JButton boton = new JButton(nombre);
		boton.setBackground(new Color(84, 160, 227));
		boton.setFont(new Font("Arial", Font.PLAIN, 18));
		boton.setForeground(new Color(255, 255, 255));

		boton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				boton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		return boton;
	}

	/**
	 * Crea un JButton sin fondo. Boton sin fondo y sin bordes, texto color azul
	 * casi celeste, fuente Arial a 14px.
	 * 
	 * @param nombre Texto que tiene el boton
	 * @return Boton sin fondo con texto azul
	 */
	public static JButton botonSinFondo(String nombre) {
		JButton boton = new JButton(nombre);
		boton.setBackground(null);
		boton.setBorder(null);
		boton.setFont(new Font("Arial", Font.PLAIN, 14));
		boton.setForeground(new Color(84, 160, 227));

		boton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				boton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		return boton;
	}

	/**
	 * Crea un JSeparator blanco. Tamaño: 1px ancho, 30px de largo.
	 * 
	 * @return JSeparator blanco (1px ancho, 30px largo)
	 */
	public static JSeparator Espacio() {
		JSeparator espacio = new JSeparator();
		espacio.setForeground(Color.white);
		espacio.setPreferredSize(new Dimension(1, 30));
		espacio.setMaximumSize(new Dimension(1, 30));
		return espacio;
	}

	/**
	 * Crea un JSeparator blanco del tamaño ingresado.
	 * 
	 * @param x Ancho en pixeles que tendra el JSeparator
	 * @param y Largo en pixeles que tendra el JSeparator
	 * @return JSeparator blanco, tamaño (x ancho, y largo)
	 */
	public static JSeparator Espacio(int x, int y) {
		JSeparator espacio = new JSeparator();
		espacio.setForeground(Color.white);
		espacio.setPreferredSize(new Dimension(x, y));
		espacio.setMaximumSize(new Dimension(x, y));
		return espacio;
	}

	/**
	 * Crea un JSeparator azul comunmente usado debajo de los JTextField
	 * transparentes. Tamaño: 500px ancho, 30px largo. Color azul casi celeste.
	 * 
	 * @return JSeparator azul (500px ancho, 30px largo)
	 */
	public static JSeparator Separador() {
		JSeparator separador = new JSeparator();
		separador.setPreferredSize(new Dimension(500, 30));
		separador.setMaximumSize(new Dimension(500, 30));
		separador.setForeground(new Color(84, 160, 227));
		return separador;
	}

	/**
	 * Crea un JSeparator azul comunmente usado debajo de los JTextField
	 * transparentes, del tamaño ingresado.
	 * 
	 * @param x Ancho en pixeles que tendra el JSeparator
	 * @param y Largo en pixeles que tendra el JSeparator
	 * @return JSeparator azul, tamaño (x ancho, y largo)
	 */
	public static JSeparator Separador(int x, int y) {
		JSeparator separador = new JSeparator();
		separador.setPreferredSize(new Dimension(x, y));
		separador.setMaximumSize(new Dimension(x, y));
		separador.setForeground(new Color(84, 160, 227));
		return separador;
	}

	/**
	 * Crea un JTextField sin fondo ni marco, usado para que el usuario ingrese
	 * datos escritos. Fuente Arial, 13px. Tamaño preferido: 300px ancho, 30px
	 * largo.
	 * 
	 * @return JTextField sin fondo.
	 */
	public static JTextField campoTexto() {
		JTextField campo = new JTextField();
		campo.setBorder(null);
		campo.setBackground(null);
		campo.setFont(new Font("Arial", Font.PLAIN, 13));
		campo.setForeground(new Color(92, 92, 102));
		campo.setPreferredSize(new Dimension(300, 30));
		return campo;
	}

	/**
	 * Crea un JPasswordField sin fondo ni marco, usado para que el usuario ingrese
	 * claves. Fuente Arial, 13px. Tamaño preferido: 300px ancho, 30px largo.
	 * 
	 * @return JPasswordField sin fondo.
	 */
	public static JPasswordField campoClave() {
		JPasswordField campo = new JPasswordField();
		campo.setBorder(null);
		campo.setBackground(null);
		campo.setFont(new Font("Arial", Font.PLAIN, 13));
		campo.setForeground(new Color(92, 92, 102));
		campo.setPreferredSize(new Dimension(300, 30));
		return campo;
	}

	/**
	 * Genera el fondo de la ventana.
	 * 
	 * @param v           Ventana o JFrame que tendrá el fondo.
	 * @param rutaArchivo Ruta donde esta ubicada la imagen que será el fondo.
	 */
	public static void SeleccionarFondo(JFrame v, String rutaArchivo) {
		Image fondoEscalado;
		if (!rutaArchivo.equals("")) {
			ImageIcon Fotografia = new ImageIcon(v.getClass().getResource(rutaArchivo));
			Image img = Fotografia.getImage();
			fondoEscalado = img.getScaledInstance(v.getWidth(), v.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon fondoFinal = new ImageIcon(fondoEscalado);

			fondoImagen.setIcon(fondoFinal);
		} else {
			fondoImagen.setIcon(null);
		}
	}

	/**
	 * Hace que el panel ingresado siempre se encuentre en el centro de la ventana
	 * ingresada. El panel estará ubicado en el centro aunque se cambie el tamaño de
	 * la ventana
	 * 
	 * @param ventana Ventana o JFrame en la que se encuentra el panel
	 * @param panel   JPanel que se quiere mantener en el centro de la ventana
	 */
	public static void adaptarPanelCentro(JFrame ventana, JPanel panel) {
		int x = (ventana.getWidth() - panel.getPreferredSize().width) / 2;
		int y = (ventana.getHeight() - panel.getPreferredSize().height) / 2;
		panel.setBounds(x, y, panel.getPreferredSize().width, panel.getPreferredSize().height);
	}

	/**
	 * Espera a que el JTextField ingresado deje de estar vacio. Vuelve al color y
	 * texto original del JLabel ingresado cuando el JTexTField deje de estar vacio.
	 * 
	 * @param campo JTextField que se revisa
	 * @param esub  JLabel con el texto que indica lo que se debe ingresar en el
	 *              JTextField
	 * @param texto Texto que tiene el JLabel que indica lo que se debe ingresar en
	 *              el JTextField
	 */
	public static void revisarTextField(JTextField campo, JLabel esub, String texto) {
		campo.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				if (!campo.getText().isEmpty()) {
					esub.setText(texto);
					esub.setForeground(new Color(92, 92, 102));
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
			}
		});
	}

	/**
	 * Espera a que el JComboBox ingresado deje de tener la opcion vacia
	 * seleccionada. Vuelve al color y texto original del JLabel ingresado cuando el
	 * JComboBox deje de tener la opcion vacia seleccionada.
	 * 
	 * @param comboBox JComboBox que se revisa
	 * @param esub     JLabel con el texto que indica lo que se debe ingresar en el
	 *                 JComboBox
	 * @param texto    Texto que tiene el JLabel que indica lo que se debe ingresar
	 *                 en el JComboBox
	 */
	public static void revisarJComboBoxString(JComboBox<String> comboBox, JLabel esub, String texto) {
		if (!comboBox.getSelectedItem().equals(" ")) {
			esub.setText(texto);
			esub.setForeground(new Color(92, 92, 102));
		}
	}

	/**
	 * Obtiene el color principal de la clase Estandar. Por defecto es un color azul
	 * moderadamente claro, casi celeste, con matices suaves. RGB(84, 160, 227)
	 * HEX(ffbae5).
	 * 
	 * @return Color que comparten la mayoria de metodos de la clase Estandar
	 */
	public Color getColorAzulado() {
		return colorAzulado;
	}

	/**
	 * Cambia el color principal de la clase Estandar. Este es el color que
	 * comparten la mayoria de metodos de la clase Estandar.
	 * 
	 * @param colorAzulado Nuevo Color por el que desea cambiarse
	 */
	public void setColorAzulado(Color colorAzulado) {
		this.colorAzulado = colorAzulado;
	}

	/**
	 * Obtiene el JLabel del fondo de las ventanas de la interfaz grafica.
	 * Previamente se debe seleccionar el fondo en el metodo SeleccionarFondo() de
	 * esta misma clase.
	 * 
	 * @return JLabel que contiene el fondo
	 */
	public static JLabel getFondoImagen() {
		return fondoImagen;
	}

	/**
	 * Cambia el JLabel del fondo de las ventanas de la interfaz grafica por otro.
	 * Una alternativa ruda al metodo SeleccionarFondo() si es que el JLabel
	 * ingresado ya tiene un Icon.
	 * 
	 * @param fondoImagen JLabel por el que se desea cambiar al original
	 */
	public static void setFondoImagen(JLabel fondoImagen) {
		Estandar.fondoImagen = fondoImagen;
	}

}
