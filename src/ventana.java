import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ventana extends JFrame {
    private JTabbedPane pestanasPrincipal;
    private JPanel panel1;
    private JPanel panelMoldes;
    private JPanel panelEstructuras;
    private JComboBox<String> comboTipoMolde;
    private JTextArea areaListaMoldes;
    private JTextPane txtCodigoRollo;
    private JTextPane txtAnchoRollo;
    private JTextArea areaResultadoRollos;
    private JTextArea areaMayorMolde;
    private JComboBox<String> comboTipoConsulta;
    private JTextArea areaHistorial;
    private JButton buscarMayorMoldeButton;
    private JButton contarMoldesButton;
    private JButton verHistorialButton;
    private JButton agregarRolloButton;
    private JButton buscarRolloCodigoButton;
    private JButton ordenarRollosButton;
    private JSpinner spinnerCodigoMolde;
    private JTextField txtNombreMolde;
    private JTextField txtAreaMolde;
    private JButton agregarMoldeButton;
    private JTabbedPane tabbedPane2;

    private PilaAcciones historial;
    private GestionMoldes gestionMoldes;
    private GestionRollos gestionRollos;

    public ventana() {
        historial = new PilaAcciones();
        gestionMoldes = new GestionMoldes(historial);
        gestionRollos = new GestionRollos(historial);
        configurarVentana();
        inicializarCombos();
        actualizarListaMoldes();
        actualizarListaRollos();

        agregarMoldeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int codigo = (Integer) spinnerCodigoMolde.getValue();
                    String nombre = txtNombreMolde.getText().trim();
                    String tipo = comboTipoMolde.getSelectedItem().toString();
                    double area = Double.parseDouble(txtAreaMolde.getText().trim());

                    if (nombre.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "El nombre del molde no puede estar vacio.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    Molde nuevoMolde = new Molde(codigo, nombre, tipo, area);
                    if (gestionMoldes.agregarMolde(nuevoMolde)) {
                        JOptionPane.showMessageDialog(null, "Molde registrado con exito.", "Exito", JOptionPane.INFORMATION_MESSAGE);
                        actualizarListaMoldes();
                        txtNombreMolde.setText("");
                        txtAreaMolde.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "El codigo del molde ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese un area valida. Ejemplo: 540.5", "Error de formato", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        agregarRolloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int codigo = Integer.parseInt(txtCodigoRollo.getText().trim());
                    double ancho = Double.parseDouble(txtAnchoRollo.getText().trim());
                    RolloTela nuevoRollo = new RolloTela(codigo, "Algodon", ancho, 30.0);

                    if (gestionRollos.agregarRollo(nuevoRollo)) {
                        JOptionPane.showMessageDialog(null, "Rollo registrado con exito.", "Exito", JOptionPane.INFORMATION_MESSAGE);
                        actualizarListaRollos();
                        txtCodigoRollo.setText("");
                        txtAnchoRollo.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "El codigo del rollo ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese codigo y ancho validos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        buscarRolloCodigoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int codigo = Integer.parseInt(txtCodigoRollo.getText().trim());
                    RolloTela r = gestionRollos.buscarPorCodigoBinario(codigo);
                    if (r != null) {
                        areaResultadoRollos.setText("Rollo encontrado:\n" + r.toString());
                    } else {
                        areaResultadoRollos.setText("No se encontro el rollo con codigo: " + codigo);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese un codigo numerico.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        ordenarRollosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<RolloTela> listaOrdenada = gestionRollos.ordenarPorAnchoAscendente();
                StringBuilder sb = new StringBuilder();
                sb.append("--- ROLLOS ORDENADOS POR ANCHO ---\n");
                for (RolloTela r : listaOrdenada) {
                    sb.append(r.toString()).append("\n");
                }
                areaResultadoRollos.setText(sb.toString());
            }
        });

        buscarMayorMoldeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Molde mayor = gestionMoldes.buscarMayorAreaRecursivo(0);
                if (mayor != null) {
                    areaMayorMolde.setText("Molde con mayor area:\n" + mayor.toString());
                } else {
                    areaMayorMolde.setText("No hay moldes registrados.");
                }
            }
        });

        contarMoldesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboTipoConsulta.getSelectedItem() != null) {
                    String tipoSeleccionado = comboTipoConsulta.getSelectedItem().toString();
                    int cantidad = gestionMoldes.contarPorTipoRecursivo(tipoSeleccionado, 0);
                    areaHistorial.setText("Existen " + cantidad + " moldes del tipo: " + tipoSeleccionado);
                }
            }
        });

        verHistorialButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaHistorial.setText(historial.mostrarHistorial());
            }
        });
    }

    private void configurarVentana() {
        setContentPane(panel1);
        setTitle("TexOptiCut - Avance Progreso 2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(850, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void inicializarCombos() {
        String[] tipos = {"Camiseta", "Polo", "Pantalon", "Chompa", "Uniforme"};
        for (String t : tipos) {
            comboTipoMolde.addItem(t);
            comboTipoConsulta.addItem(t);
        }
    }

    private void actualizarListaMoldes() {
        ArrayList<Molde> lista = gestionMoldes.getMoldes();
        StringBuilder sb = new StringBuilder();
        sb.append("--- MOLDES REGISTRADOS ---\n");
        for (Molde m : lista) {
            sb.append(m.getCodigo()).append(" - ")
                    .append(m.getNombre()).append(" - ")
                    .append(m.getTipo()).append(" - area: ")
                    .append(m.getArea()).append("\n");
        }
        areaListaMoldes.setText(sb.toString());
    }

    private void actualizarListaRollos() {
        ArrayList<RolloTela> lista = gestionRollos.getRollos();
        StringBuilder sb = new StringBuilder();
        sb.append("--- ROLLOS REGISTRADOS ---\n");
        for (RolloTela r : lista) {
            sb.append(r.getCodigo()).append(" - ")
                    .append(r.getTipo()).append(" - ancho: ")
                    .append(r.getAncho()).append(" - largo: ")
                    .append(r.getLargo()).append("\n");
        }
        areaResultadoRollos.setText(sb.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ventana();
            }
        });
    }
}
