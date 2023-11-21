package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class VentanaIncial extends JFrame{

	private PanelLogin pl;
	private PanelRegister pr;
	private JLabel fondoImagen;
	private Image fondoEscalado;
	private JLayeredPane layeredPane;

	
	public VentanaIncial() {
		setTitle("Incie sesion");
		setSize(400, 540);
		setMinimumSize(new Dimension(280, 500));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		inicializarComponentes();
		
		SeleccionarFondo("/image/fondoInterfaz.png");
		setResizable(true);
		setLocationRelativeTo(null);
		setVisible(true);

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
            	adaptarPanel(pl);
            	adaptarPanel(pr);
            }
        });
       
	}
	
	public void inicializarComponentes() {
		layeredPane = new JLayeredPane();
		getContentPane().add(layeredPane, BorderLayout.CENTER);
		pl = new PanelLogin();
		pr = new PanelRegister();
		layeredPane.add(pl, Integer.valueOf(1));	
	
		fondoImagen = new JLabel();
		fondoImagen.setBounds(0, 0, getWidth(), getHeight());
		layeredPane.add(fondoImagen, Integer.valueOf(0));
    	adaptarPanel(pl);
	}
	
	
	public void SeleccionarFondo(String elemento) {
        if (!elemento.equals("")) {
        	ImageIcon Fotografia = new ImageIcon(getClass().getResource(elemento));
            Image img = Fotografia.getImage();
            fondoEscalado = img.getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
            ImageIcon fondoFinal = new ImageIcon(fondoEscalado);
            fondoImagen.setIcon(fondoFinal);
        } else {
        	fondoImagen.setIcon(null);
        }
    }
    
    public void adaptarPanel(PanelLogin pl) {
		pl.setBounds((getWidth() - pl.getPreferredSize().width)/2, (getHeight() - pl.getPreferredSize().height)/2, pl.getPreferredSize().width, pl.getPreferredSize().height);	
    }

    public void adaptarPanel(PanelRegister pr) {
        pr.setBounds((getWidth() - pr.getPreferredSize().width)/2, (getHeight() - pr.getPreferredSize().height)/2, pr.getPreferredSize().width, pr.getPreferredSize().height);
	}

	
        
    
	public PanelRegister getPr() {
		return pr;
	}

	public void setPr(PanelRegister pr) {
		this.pr = pr;
	}

	public PanelLogin getPl() {
		return pl;
	}

	public void setPl(PanelLogin pl) {
		this.pl = pl;
	}

	public JLabel getFondoImagen() {
		return fondoImagen;
	}

	public void setFondoImagen(JLabel fondoImagen) {
		this.fondoImagen = fondoImagen;
	}

	public Image getFondoEscalado() {
		return fondoEscalado;
	}

	public void setFondoEscalado(Image fondoEscalado) {
		this.fondoEscalado = fondoEscalado;
	}

	public JLayeredPane getLayeredPane() {
		return layeredPane;
	}

	public void setLayeredPane(JLayeredPane layeredPane) {
		this.layeredPane = layeredPane;
	}
    
    
	
}
