package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import model.ListadeSedes;
import model.Sede;

/**
 * La clase PanelRegisterHorario representa la interfaz gráfica
 * para el registro de horarios de una pareja.
 * Permite asignar franjas horarias para los diferentes días de la semana.
 * Esta clase es utilizada en la interfaz gráfica del sistema.
 * 
 * @author Bedoya Lautero
 * @version 1.0
 */
public class PanelRegisterHorario extends JPanel {

    /**
     * Las etiquetas para mostrar información sobre el registro de horarios.
     */
    private JLabel ebienvenido, esubbienvenido, e9_10, e10_11, e11_12, e1_2, e2_3, e3_4, e4_5, elunes, emartes, emiercoles, ejueves, eviernes, esabado, edomingo;

    /**
     * Los botones para registrar y regresar.
     */
    private JButton bregistrar, bregresar;

    /**
     * La lista de botones que representan las franjas horarias.
     */
    private ArrayList<JButton> franjaHorario;

    /**
     * Constructor para la clase PanelRegisterHorario.
     */
    public PanelRegisterHorario() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(700, 500));

        inicializarComponentes();
        setVisible(true);
    }

    /**
     * Inicializa los componentes del panel.
     */
    public void inicializarComponentes() {
        franjaHorario = new ArrayList<>();

        JPanel panelAuxTitulos = new JPanel();
        panelAuxTitulos.setLayout(new BoxLayout(panelAuxTitulos, BoxLayout.Y_AXIS));
        ebienvenido = Estandar.labelNegro("Asignar horario a ");
        panelAuxTitulos.add(ebienvenido);
        esubbienvenido = Estandar.labelGris("Haz clic en la franja de horario en la que prodra ir:");
        panelAuxTitulos.add(esubbienvenido);
        add(panelAuxTitulos, BorderLayout.NORTH);

        JPanel centro = new JPanel(new BorderLayout());

        JPanel dias = new JPanel(new GridLayout(1, 9));
        dias.add(Estandar.Espacio(170, 1));
        elunes = Estandar.labelNegro("Lunes");
        dias.add(elunes);
        emartes = Estandar.labelNegro("Martes");
        dias.add(emartes);
        emiercoles = Estandar.labelNegro("Miercoles");
        dias.add(emiercoles);
        ejueves = Estandar.labelNegro("Jueves");
        dias.add(ejueves);
        eviernes = Estandar.labelNegro("Viernes");
        dias.add(eviernes);
        esabado = Estandar.labelNegro("Sabado");
        dias.add(esabado);
        edomingo = Estandar.labelNegro("Domingo");
        dias.add(edomingo);
        centro.add(dias, BorderLayout.NORTH);

        JPanel horas = new JPanel(new GridLayout(7, 1));
        e9_10 = Estandar.labelNegro("9am-10am");
        horas.add(e9_10);
        e10_11 = Estandar.labelNegro("10am-11am");
        horas.add(e10_11);
        e11_12 = Estandar.labelNegro("11am-12pm");
        horas.add(e11_12);
        e1_2 = Estandar.labelNegro("1pm-2pm");
        horas.add(e1_2);
        e2_3 = Estandar.labelNegro("2pm-3pm");
        horas.add(e2_3);
        e3_4 = Estandar.labelNegro("3pm-4pm");
        horas.add(e3_4);
        e4_5 = Estandar.labelNegro("4pm-5pm");
        horas.add(e4_5);
        centro.add(horas, BorderLayout.WEST);

        JPanel horarios = new JPanel(new GridLayout(7, 7, 5, 5));
        for (int i = 0; i < 49; i++) {
            JButton bhorario = new JButton();
            bhorario.setBackground(new Color(171, 245, 169));
            bhorario.setBorder(null);
            horarios.add(bhorario);
            bhorario.setActionCommand("bhorario" + i);
            bhorario.setName("b" + i);
            franjaHorario.add(bhorario);
        }
        horarios.setPreferredSize(new Dimension(400, 400));
        centro.add(horarios, BorderLayout.CENTER);

        add(centro, BorderLayout.CENTER);

        JPanel panelAuxSur = new JPanel();
        panelAuxSur.setLayout(new GridLayout(1, 4));
        bregresar = Estandar.botonSinFondo("<- Regresar");
        bregresar.setActionCommand("bREGRESARhorario");
        panelAuxSur.add(bregresar);
        panelAuxSur.add(Estandar.Espacio(100, 1));
        panelAuxSur.add(Estandar.Espacio(100, 1));
        bregistrar = Estandar.boton("Registrar");
        bregistrar.setActionCommand("bRegistrarpareja");
        panelAuxSur.add(bregistrar);
        add(panelAuxSur, BorderLayout.SOUTH);
    }

    /**
     * Busca un botón en la lista de botones por su nombre.
     * 
     * @param nombre El nombre del botón a buscar.
     * @return El botón encontrado o null si no se encontró.
     */
    public JButton buscarboton(String nombre) {
        JButton encontrada = null;
        for (JButton x : franjaHorario) {
            if (x.getName().equals(nombre)) {
                encontrada = x;
            }
        }
        return encontrada;
    }

    // Métodos getter y setter para los componentes del panel

    // ...
}
