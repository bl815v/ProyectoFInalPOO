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
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public abstract class Estandar {
	
	public static void alertaCerrarVentana(JFrame frame) {
		frame.addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent e) {
		        Object[] opciones = {"Sí", "No"}; 
				int confirmar = JOptionPane.showOptionDialog(null, "Esta seguro que desea cerrar la ventana? \nSe perderan todos los datos del programa", "Cerrar todo el programa", 
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, opciones, opciones[1]);
				if (confirmar == JOptionPane.YES_OPTION) {
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} else {
		            frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		        }
		    }
		});
	}
	
	public static JButton boton(String nombre) {
        JButton boton = new JButton(nombre);
        boton.setBackground(new Color(84, 160, 227));
        boton.setFont(new Font("Arial", Font.PLAIN, 18));
        boton.setForeground(new Color(255, 255, 255));
        
        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	boton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cambia el cursor cuando el mouse entra al botón
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	boton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // Cambia el cursor cuando el mouse sale del botón
            }
        });
        return boton;
    }
	
	public static JButton botonSinFondo(String nombre) {
        JButton boton = new JButton(nombre);
        boton.setBackground(null);
        boton.setBorder(null);
        boton.setFont(new Font("Arial", Font.PLAIN, 14));
        boton.setForeground(new Color(84, 160, 227));
        
        boton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
            	boton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cambia el cursor cuando el mouse entra al botón
            }

            @Override
            public void mouseExited(MouseEvent e) {
            	boton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); // Cambia el cursor cuando el mouse sale del botón
            }
        });
        return boton;
    }

	
	
	public static JSeparator Espacio() {
        JSeparator espacio = new JSeparator();
		espacio.setPreferredSize(new Dimension(1, 30));
		espacio.setMaximumSize(new Dimension(1, 30));
		return espacio;
	}
	
	public static JSeparator Espacio(int x, int y) {
        JSeparator espacio = new JSeparator();
		espacio.setPreferredSize(new Dimension(x, y));
		espacio.setMaximumSize(new Dimension(x, y));
		return espacio;
	}
	
	public static JSeparator Separador(){
        JSeparator separador = new JSeparator();
        separador.setPreferredSize(new Dimension(500, 30));
		separador.setMaximumSize(new Dimension(500, 30));
		separador.setForeground(new Color(84, 160, 227));
		return separador;
	}
	
	public static JSeparator Separador(int x, int y){
        JSeparator separador = new JSeparator();
        separador.setPreferredSize(new Dimension(x, y));
		separador.setMaximumSize(new Dimension(x, y));
		separador.setForeground(new Color(84, 160, 227));
		return separador;
	}
	
	public static JLabel fondoImagen = new JLabel();
	public static void SeleccionarFondo(JFrame v,String elemento) {
    	Image fondoEscalado;
		if (!elemento.equals("")) {
        	ImageIcon Fotografia = new ImageIcon(v.getClass().getResource(elemento));
            Image img = Fotografia.getImage();
            fondoEscalado = img.getScaledInstance(v.getWidth(), v.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon fondoFinal = new ImageIcon(fondoEscalado);
            fondoImagen.setIcon(fondoFinal);
        } else {
        	fondoImagen.setIcon(null);
        }
    }
	
    public static void adaptarPanelCentro(JFrame v, JPanel p) {
    	int x = (v.getWidth() - p.getPreferredSize().width)/2;
    	int y = (v.getHeight() - p.getPreferredSize().height)/2;
        p.setBounds(x, y, p.getPreferredSize().width, p.getPreferredSize().height);
	}
	
	public static void revisarTextField(JTextField campo, JLabel esub, String texto) {
        campo.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
            	if(!campo.getText().isEmpty()) {
            		esub.setText(texto);
            		esub.setForeground(new Color(92,92,102));
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
	
	public static void revisarJComboBoxString(JComboBox<String> a, JLabel esub, String texto) {
		if (!a.getSelectedItem().equals(" ")) {
			esub.setText(texto);
    		esub.setForeground(new Color(92,92,102));
		}
	}
	
	
}
