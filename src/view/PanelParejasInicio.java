package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * La clase PanelParejasInicio representa la interfaz gráfica
 * para la pantalla de inicio de sesión de parejas.
 * Contiene etiquetas, botones y paneles para mostrar la información.
 * Esta clase es utilizada en la interfaz gráfica del sistema.
 * 
 * @author Bedoya Lautero
 * @version 1.0
 */
public class PanelParejasInicio extends JPanel {

    /**
     * La etiqueta que muestra el título del panel.
     */
    private JLabel eblanco, etitulo, enombre, ecupoDisponible, esaldoPendiente, eDinerodisponible, eDineropendiente;

    /**
     * Los botones para realizar acciones como comprar, abonar, ver historial y cerrar sesión.
     */
    private JButton bcomprar, babonar, bhorario, bhistorial, bcerrar;

    /**
     * Constructor para la clase PanelParejasInicio.
     */
    public PanelParejasInicio() {
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

        etitulo = Estandar.HideSeek();
        norte.add(etitulo);

        norte.add(Estandar.Espacio(1, 10));

        enombre = Estandar.labelNegro("Bienvenido, ");
        norte.add(enombre);

        add(norte, BorderLayout.NORTH);

        // Center
        JPanel centro = new JPanel();
        centro.setLayout(new BorderLayout());

        JPanel arriba = new JPanel();
        arriba.setLayout(new GridLayout(8, 2));

        eblanco = new JLabel();
        arriba.add(eblanco);
        eblanco = new JLabel();
        arriba.add(eblanco);

        ecupoDisponible = Estandar.labelGris("Cupo Disponible:");
        arriba.add(ecupoDisponible);

        eblanco = new JLabel();
        arriba.add(eblanco);

        eDinerodisponible = Estandar.labelNegro("$ 1000000 pesos");
        arriba.add(eDinerodisponible);

        bcomprar = Estandar.boton("Comprar");
        bcomprar.setActionCommand("bCOMPRARMENUpareja");
        arriba.add(bcomprar);

        eblanco = new JLabel();
        arriba.add(eblanco);
        eblanco = new JLabel();
        arriba.add(eblanco);

        esaldoPendiente = Estandar.labelGris("Saldo Pendiente:");
        arriba.add(esaldoPendiente);

        eblanco = new JLabel();
        arriba.add(eblanco);

        eDineropendiente = Estandar.labelNegro("$ 1000000 pesos");
        arriba.add(eDineropendiente);

        babonar = Estandar.boton("Abonar");
        babonar.setActionCommand("bABONARMENUpareja");
        arriba.add(babonar);

        centro.add(arriba, BorderLayout.NORTH);

        JPanel abajo = new JPanel();
        abajo.setLayout(new GridLayout(1, 2, 16, 16));

        bhistorial = Estandar.boton("Historial de compras");
        bhistorial.setActionCommand("bHISTORIALpareja");
        abajo.add(bhistorial);

        centro.add(abajo, BorderLayout.SOUTH);

        add(centro, BorderLayout.CENTER);

        // South
        JPanel sur = new JPanel();
        sur.setLayout(new BorderLayout());

        bcerrar = Estandar.botonSinFondo("Cerrar sesion");
        bcerrar.setActionCommand("bCERRARSESIONpareja");
        sur.add(Estandar.Espacio(), BorderLayout.NORTH);
        sur.add(bcerrar, BorderLayout.WEST);
        add(sur, BorderLayout.SOUTH);
    }

    // Métodos de obtención y establecimiento para los componentes relevantes

    /**
     * Obtiene la etiqueta en blanco.
     * 
     * @return La etiqueta en blanco.
     */
    public JLabel getEblanco() {
        return eblanco;
    }

    /**
     * Establece la etiqueta en blanco.
     * 
     * @param eblanco La nueva etiqueta en blanco.
     */
    public void setEblanco(JLabel eblanco) {
        this.eblanco = eblanco;
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
     * Obtiene la etiqueta que muestra el nombre del usuario.
     * 
     * @return La etiqueta del nombre del usuario.
     */
    public JLabel getEnombre() {
        return enombre;
    }

    /**
     * Establece la etiqueta que muestra el nombre del usuario.
     * 
     * @param enombre La nueva etiqueta del nombre del usuario.
     */
    public void setEnombre(JLabel enombre) {
        this.enombre = enombre;
    }

    /**
     * Obtiene la etiqueta que muestra el cupo disponible.
     * 
     * @return La etiqueta del cupo disponible.
     */
    public JLabel getEcupoDisponible() {
        return ecupoDisponible;
    }

    /**
     * Establece la etiqueta que muestra el cupo disponible.
     * 
     * @param ecupoDisponible La nueva etiqueta del cupo disponible.
     */
    public void setEcupoDisponible(JLabel ecupoDisponible) {
        this.ecupoDisponible = ecupoDisponible;
    }

    /**
     * Obtiene la etiqueta que muestra el saldo pendiente.
     * 
     * @return La etiqueta del saldo pendiente.
     */
    public JLabel getEsaldoPendiente() {
        return esaldoPendiente;
    }

    /**
     * Establece la etiqueta que muestra el saldo pendiente.
     * 
     * @param esaldoPendiente La nueva etiqueta del saldo pendiente.
     */
    public void setEsaldoPendiente(JLabel esaldoPendiente) {
        this.esaldoPendiente = esaldoPendiente;
    }

    /**
     * Obtiene la etiqueta que muestra el dinero disponible.
     * 
     * @return La etiqueta del dinero disponible.
     */
    public JLabel geteDinerodisponible() {
        return eDinerodisponible;
    }

    /**
     * Establece la etiqueta que muestra el dinero disponible.
     * 
     * @param eDinerodisponible La nueva etiqueta del dinero disponible.
     */
    public void seteDinerodisponible(JLabel eDinerodisponible) {
        this.eDinerodisponible = eDinerodisponible;
    }

    /**
     * Obtiene la etiqueta que muestra el dinero pendiente.
     * 
     * @return La etiqueta del dinero pendiente.
     */
    public JLabel geteDineropendiente() {
        return eDineropendiente;
    }

    /**
     * Establece la etiqueta que muestra el dinero pendiente.
     * 
     * @param eDineropendiente La nueva etiqueta del dinero pendiente.
     */
    public void seteDineropendiente(JLabel eDineropendiente) {
        this.eDineropendiente = eDineropendiente;
    }

    /**
     * Obtiene el botón para realizar compras.
     * 
     * @return El botón de compras.
     */
    public JButton getBcomprar() {
        return bcomprar;
    }

    /**
     * Establece el botón para realizar compras.
     * 
     * @param bcomprar El nuevo botón de compras.
     */
    public void setBcomprar(JButton bcomprar) {
        this.bcomprar = bcomprar;
    }

    /**
     * Obtiene el botón para realizar abonos.
     * 
     * @return El botón de abonos.
     */
    public JButton getBabonar() {
        return babonar;
    }

    /**
     * Establece el botón para realizar abonos.
     * 
     * @param babonar El nuevo botón de abonos.
     */
    public void setBabonar(JButton babonar) {
        this.babonar = babonar;
    }

    /**
     * Obtiene el botón para ver el historial de compras.
     * 
     * @return El botón de historial de compras.
     */
    public JButton getBhistorial() {
        return bhistorial;
    }

    /**
     * Establece el botón para ver el historial de compras.
     * 
     * @param bhistorial El nuevo botón de historial de compras.
     */
    public void setBhistorial(JButton bhistorial) {
        this.bhistorial = bhistorial;
    }

    /**
     * Obtiene el botón para cerrar sesión.
     * 
     * @return El botón de cerrar sesión.
     */
    public JButton getBcerrar() {
        return bcerrar;
    }

    /**
     * Establece el botón para cerrar sesión.
     * 
     * @param bcerrar El nuevo botón de cerrar sesión.
     */
    public void setBcerrar(JButton bcerrar) {
        this.bcerrar = bcerrar;
    }
}
