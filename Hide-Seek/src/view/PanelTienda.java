package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import model.ListadeProductos;
import model.Producto;

public class PanelTienda extends JPanel{
	
	private JLabel etitulo, esubtitulo, etotal;
	private JButton bcerrar;
	private ArrayList<JButton> botones;
	private ArrayList<JSpinner> spinners;
	
	public PanelTienda() {
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(730, 520));

		inicializarComponentes();
		setVisible(true);
	}
	
	public void inicializarComponentes() {
		// North
		JPanel norte = new JPanel();
		norte.setLayout(new BoxLayout(norte, BoxLayout.Y_AXIS));
		
		etitulo = new JLabel("Catalogo de Productos");
		etitulo.setFont(new Font("Arial", Font.BOLD, 22));
		norte.add(etitulo);

		norte.add(Estandar.Espacio(1,10));

		esubtitulo = Estandar.labelGris("Selecciona la cantidad de productos a comprar "); 
		norte.add(esubtitulo);
		
		add(norte, BorderLayout.NORTH);
		
		//Center
        JPanel panelMercancia = new JPanel();
    	ListadeProductos listaProductos = new ListadeProductos();
        panelMercancia.setLayout(new GridLayout(0, 3, 20, 10));
        botones = new ArrayList<JButton>();
        spinners = new ArrayList<JSpinner>();
        for (Producto producto : listaProductos.getListadeProductos()) {
            JPanel panelProducto = new JPanel(new GridLayout(2, 1));
           
            ImageIcon iconoOriginal = new ImageIcon(getClass().getResource(producto.getImg()));
            Image imagenOriginal = iconoOriginal.getImage();
            Image imagenEscalada = imagenOriginal.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            ImageIcon imagenEscaladaIcon = new ImageIcon(imagenEscalada);
            JLabel etiquetaImagen = new JLabel(imagenEscaladaIcon);
            panelProducto.add(etiquetaImagen);
            
            JPanel panelInfoProducto = new JPanel(new GridLayout(5, 1));
            JLabel nombreProducto = Estandar.labelNegro(producto.getNombre());
            panelInfoProducto.add(nombreProducto);
            
            JLabel precio = Estandar.labelGris("Precio: $" + String.valueOf((int)producto.getPrecio() + " pesos"));
            panelInfoProducto.add(precio);

            JPanel panelBotonCantidad = new JPanel(new GridLayout(1, 2));
            
            JButton botonComprar = Estandar.boton("Comprar");
            botonComprar.setActionCommand("b"+ producto.getNombre());
            botones.add(botonComprar);
            panelBotonCantidad.add(botonComprar);
            JSpinner spCantidad = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
            panelBotonCantidad.add(spCantidad);
            spCantidad.setName("sp"+producto.getNombre());
            spinners.add(spCantidad);
            panelInfoProducto.add(panelBotonCantidad);

            JLabel precioTotal = new JLabel();
            panelInfoProducto.add(precioTotal);
            
            
            spCantidad.addChangeListener(e -> {
                int cantidad = (int) spCantidad.getValue();
                if(cantidad == 0) {
                	precioTotal.setText(" ");
                }else {
                    int totalprod = (int) (cantidad*producto.getPrecio());
                    precioTotal.setText("Precio total: $" + totalprod + " pesos");	
                }
            });

            panelProducto.add(panelInfoProducto);
            panelMercancia.add(panelProducto);
        }

		JScrollPane centro = new JScrollPane(panelMercancia);
		centro.getVerticalScrollBar().setUnitIncrement(25);
		centro.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		centro.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	    add(centro, BorderLayout.CENTER);
		
		// South
		JPanel sur = new JPanel();
		sur.setLayout(new BorderLayout());
		
		bcerrar = Estandar.botonSinFondo("<- Regresar");
		bcerrar.setActionCommand("bREGRESAR");
		sur.add(bcerrar, BorderLayout.WEST);
		add(sur, BorderLayout.SOUTH);
	}

	public JButton buscarBoton(String nombre) {
		JButton encontrada = null;
		for(JButton x : botones) {
			if(x.getActionCommand().equals(nombre)) {
				encontrada = x;
			}
		}
		return encontrada;
	}
	
	public JSpinner buscarSpinner(String nombre) {
		JSpinner encontrada = null;
		for(JSpinner x : spinners) {
			if(x.getName().equals(nombre)) {
				encontrada = x;
			}
		}
		return encontrada;
	}
	
	public JLabel getEtitulo() {
		return etitulo;
	}

	public void setEtitulo(JLabel etitulo) {
		this.etitulo = etitulo;
	}

	public JLabel getEsubtitulo() {
		return esubtitulo;
	}

	public void setEsubtitulo(JLabel esubtitulo) {
		this.esubtitulo = esubtitulo;
	}

	public JLabel getEtotal() {
		return etotal;
	}

	public void setEtotal(JLabel etotal) {
		this.etotal = etotal;
	}

	public JButton getBcerrar() {
		return bcerrar;
	}

	public void setBcerrar(JButton bcerrar) {
		this.bcerrar = bcerrar;
	}

	public ArrayList<JButton> getBotones() {
		return botones;
	}

	public void setBotones(ArrayList<JButton> botones) {
		this.botones = botones;
	}
	
	public ArrayList<JSpinner> getSpinners() {
		return spinners;
	}

	public void setSpinners(ArrayList<JSpinner> spinners) {
		this.spinners = spinners;
	}

    
}
