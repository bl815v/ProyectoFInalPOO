package view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public abstract class Estandar {
	
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
	
    public static void adaptarPanel(JFrame v, JPanel p) {
        p.setBounds((v.getWidth() - p.getPreferredSize().width)/2, (v.getHeight() - p.getPreferredSize().height)/2, p.getPreferredSize().width, p.getPreferredSize().height);
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
