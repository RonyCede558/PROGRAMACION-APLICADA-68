package view;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class View_form extends JFrame {

    // ── COMPONENTES DE LA VENTANA ──
    private JTextArea txtAreaTexto;
    private JButton btnGuardar;
    private JTextField txtRegex;
    private JButton btnBuscar;
    private JTextField txtNumPalabras;
    private JList<String> listaPalabras;
    private DefaultListModel<String> modeloLista;

    public View_form() {
        initComponents();
    }

    private void initComponents() {
        // Configuración básica de la ventana
        setTitle("Buscador de Palabras");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 550);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // ── PANEL SUPERIOR: área de texto + botón guardar ──
        JPanel panelSuperior = new JPanel(new BorderLayout(5, 5));
        panelSuperior.setBorder(BorderFactory.createTitledBorder("Archivo de texto"));

        txtAreaTexto = new JTextArea(8, 40);
        txtAreaTexto.setLineWrap(true);
        panelSuperior.add(new JScrollPane(txtAreaTexto), BorderLayout.CENTER);

        btnGuardar = new JButton("GUARDAR");
        JPanel panelBotonGuardar = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelBotonGuardar.add(btnGuardar);
        panelSuperior.add(panelBotonGuardar, BorderLayout.SOUTH);

        // ── PANEL INFERIOR: regex, resultados ──
        JPanel panelInferior = new JPanel(new GridBagLayout());
        panelInferior.setBorder(BorderFactory.createTitledBorder("Analizar datos"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Fila 1: Expresión regular
        gbc.gridx = 0; gbc.gridy = 0;
        panelInferior.add(new JLabel("EXPRESIÓN REGULAR"), gbc);

        txtRegex = new JTextField(20);
        gbc.gridx = 1; gbc.gridy = 0;
        panelInferior.add(txtRegex, gbc);

        btnBuscar = new JButton("...");
        gbc.gridx = 2; gbc.gridy = 0;
        panelInferior.add(btnBuscar, gbc);

        // Fila 2: Número de palabras
        gbc.gridx = 0; gbc.gridy = 1;
        panelInferior.add(new JLabel("Número de palabras encontradas"), gbc);

        txtNumPalabras = new JTextField(10);
        txtNumPalabras.setEditable(false);
        gbc.gridx = 1; gbc.gridy = 1;
        panelInferior.add(txtNumPalabras, gbc);

        // Fila 3: Listado de palabras con JList
        gbc.gridx = 0; gbc.gridy = 2;
        panelInferior.add(new JLabel("Listado de palabras:"), gbc);

        modeloLista = new DefaultListModel<>();
        listaPalabras = new JList<>(modeloLista);
        JScrollPane scrollLista = new JScrollPane(listaPalabras);
        scrollLista.setPreferredSize(new Dimension(200, 100));
        gbc.gridx = 1; gbc.gridy = 2;
        panelInferior.add(scrollLista, gbc);

        // ── AGREGAR PANELES A LA VENTANA ──
        add(panelSuperior, BorderLayout.NORTH);
        add(panelInferior, BorderLayout.CENTER);
    }

    // ── MÉTODOS GET: para que el Controller pueda acceder a los componentes ──
    public JTextArea getTxtAreaTexto() { return txtAreaTexto; }
    public JButton getBtnGuardar() { return btnGuardar; }
    public JTextField getTxtRegex() { return txtRegex; }
    public JButton getBtnBuscar() { return btnBuscar; }
    public JTextField getTxtNumPalabras() { return txtNumPalabras; }

    // ── MÉTODOS PARA MOSTRAR RESULTADOS ──
    public void mostrarResultados(List<String> palabras) {
        modeloLista.clear();
        for (String palabra : palabras) {
            modeloLista.addElement(palabra);
        }
        txtNumPalabras.setText(String.valueOf(palabras.size()));
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
}
