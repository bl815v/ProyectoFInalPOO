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

import model.ListadeCompras;
import model.ListadeParejas;
import model.ListadeProductos;
import model.Pareja;

/**
 * La clase PanelHistorialComprasPareja representa la interfaz gráfica
 * para mostrar el historial de compras de una pareja en particular.
 * Contiene etiquetas, botones y una tabla para mostrar la información.
 * Esta clase es utilizada en la interfaz gráfica del sistema.
 * 
 * @author Bedoya Lautero
 * @version 1.0
 */
public class PanelHistorialComprasPareja extends JPanel {

    /**
     * La etiqueta que muestra el título del panel.
     */
    private JLabel etitulo;

    /**
     * El botón para regresar a la pantalla anterior.
     */
    private JButton bvolver;

    /**
     * La tabla que muestra el historial de compras.
     */
    private JTable tablacompras;

    /**
     * El modelo de la tabla que almacena los datos.
     */
    private DefaultTableModel model;

    /**
     * Constructor para la clase PanelHistorialComprasPareja.
     */
    public PanelHistorialComprasPareja() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(680, 520));

        inicializarComponentes();
        setVisible(true);
    }

    /**
     * Inicializa los componentes del panel.
     */
    public void inicializarComponentes() {
        // North
        JPanel norte = new JPanel();
        norte.setLayout(new BoxLayout(norte, BoxLayout.Y_AXIS));

        etitulo = Estandar.labelNegro("Tus compras");
        norte.add(etitulo);

        add(norte, BorderLayout.NORTH);

        // Center
        JPanel centro = new JPanel();
        centro.setLayout(new BorderLayout());
        String[] columnas = { "Nombre", "Precio", "Hora", "Fecha", "Sede" };
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

        // South
        JPanel sur = new JPanel();
        sur.setLayout(new BorderLayout());
        bvolver = Estandar.botonSinFondo("<- Regresar");
        bvolver.setActionCommand("bVOLVERVERHISTORIALCOMPRASpareja");
        sur.add(Estandar.Espacio(), BorderLayout.NORTH);
        sur.add(bvolver, BorderLayout.WEST);
        add(sur, BorderLayout.SOUTH);
    }

    /**
     * Obtiene la etiqueta que muestra el título del panel.
     * 
     * @return La etiqueta del título.
     */
    public JLabel getEtitulo() {
        return etitulo;
    }

    /**
     * Establece la etiqueta que muestra el título del panel.
     * 
     * @param etitulo La nueva etiqueta del título.
     */
    public void setEtitulo(JLabel etitulo) {
        this.etitulo = etitulo;
    }

    /**
     * Obtiene el botón para regresar a la pantalla anterior.
     * 
     * @return El botón de regresar.
     */
    public JButton getBvolver() {
        return bvolver;
    }

    /**
     * Establece el botón para regresar a la pantalla anterior.
     * 
     * @param bvolver El nuevo botón de regresar.
     */
    public void setBvolver(JButton bvolver) {
        this.bvolver = bvolver;
    }

    /**
     * Obtiene la tabla que muestra el historial de compras.
     * 
     * @return La tabla de historial de compras.
     */
    public JTable getTablacompras() {
        return tablacompras;
    }

    /**
     * Establece la tabla que muestra el historial de compras.
     * 
     * @param tablacompras La nueva tabla de historial de compras.
     */
    public void setTablacompras(JTable tablacompras) {
        this.tablacompras = tablacompras;
    }

    /**
     * Obtiene el modelo de la tabla que almacena los datos.
     * 
     * @return El modelo de la tabla.
     */
    public DefaultTableModel getModel() {
        return model;
    }

    /**
     * Establece el modelo de la tabla que almacena los datos.
     * 
     * @param model El nuevo modelo de la tabla.
     */
    public void setModel(DefaultTableModel model) {
        this.model = model;
    }
}
