package view;

import java.awt.BorderLayout;
import java.awt.Dimension;


import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



/**
 * La clase PanelHistorialCompras representa un JPanel para mostrar el historial de compras.
 * Incluye un título, una tabla para mostrar los detalles de las compras y un botón para volver atrás.
 * @author Esteban Arevalo
 */
public class PanelHistorialCompras extends JPanel {

   
    private JLabel etitulo;             
    private JButton bvolver;          
    private JTable tablacompras;         
    private DefaultTableModel model;    

    /**
     * Constructor para PanelHistorialCompras.
     * Inicializa el diseño, tamaño y componentes del panel.
     */
    public PanelHistorialCompras() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(680, 520));
        inicializarComponentes();
        setVisible(true);
    }

    /**
     * Inicializa los componentes de la interfaz gráfica y los organiza en el panel.
     */
    public void inicializarComponentes() {
       
        JPanel norte = new JPanel();
        norte.setLayout(new BoxLayout(norte, BoxLayout.Y_AXIS));

        etitulo = Estandar.labelNegro("Tus compras"); 
        norte.add(etitulo);

        add(norte, BorderLayout.NORTH);

        
        JPanel centro = new JPanel();
        centro.setLayout(new BorderLayout());

      
        String[] columnas = {"Nombre", "Precio", "Hora", "Fecha", "Sede"};

     
        model = new DefaultTableModel(null, columnas) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };

    
        tablacompras = new JTable(model);

      
        JScrollPane scrollPane = new JScrollPane(tablacompras);
        centro.add(scrollPane, BorderLayout.CENTER);

        add(centro, BorderLayout.CENTER);

        // Sur
        JPanel sur = new JPanel();
        sur.setLayout(new BorderLayout());

        bvolver = Estandar.botonSinFondo("<- Regresar");  // Botón de regreso
        bvolver.setActionCommand("bVOLVERVERHISTORIALCOMPRAS");
        sur.add(Estandar.Espacio(), BorderLayout.NORTH);
        sur.add(bvolver, BorderLayout.WEST);

        add(sur, BorderLayout.SOUTH);
    }

   

    /**
     * Método de obtención para etitulo (etiqueta del título).
     * @return La etiqueta del título.
     */
    public JLabel getEtitulo() {
        return etitulo;
    }

    /**
     * Método de establecimiento para etitulo (etiqueta del título).
     * @param etitulo La etiqueta del título a establecer.
     */
    public void setEtitulo(JLabel etitulo) {
        this.etitulo = etitulo;
    }

    /**
     * Método de obtención para bvolver (botón de regreso).
     * @return El botón de regreso.
     */
    public JButton getBvolver() {
        return bvolver;
    }

    /**
     * Método de establecimiento para bvolver (botón de regreso).
     * @param bvolver El botón de regreso a establecer.
     */
    public void setBvolver(JButton bvolver) {
        this.bvolver = bvolver;
    }

    /**
     * Método de obtención para tablacompras (tabla de historial de compras).
     * @return La tabla de historial de compras.
     */
    public JTable getTablacompras() {
        return tablacompras;
    }

    /**
     * Método de establecimiento para tablacompras (tabla de historial de compras).
     * @param tablacompras La tabla de historial de compras a establecer.
     */
    public void setTablacompras(JTable tablacompras) {
        this.tablacompras = tablacompras;
    }

    /**
     * Método de obtención para model (modelo de tabla).
     * @return El modelo de tabla.
     */
    public DefaultTableModel getModel() {
        return model;
    }

    /**
     * Método de establecimiento para model (modelo de tabla).
     * @param model El modelo de tabla a establecer.
     */
    public void setModel(DefaultTableModel model) {
        this.model = model;
    }
}