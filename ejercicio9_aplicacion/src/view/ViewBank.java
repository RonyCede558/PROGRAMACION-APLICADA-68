package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ViewBank extends JFrame {

    // Componentes públicos para la pasarela con el Controller
    public JButton btn_cuentas;
    public JButton btn_depositos;
    public JButton btn_pagos; // El que guardaba relación con "Pages" en el boceto
    public JTable tb_cuentas;
    public DefaultTableModel modeloTabla; // Para manipular las filas fácilmente

    public ViewBank() {
        // 1. Configuración básica de la ventana (view_bank)
    	setResizable(false);
    	setTitle("Bank");
        setSize(750, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(15, 15)); // Espaciado entre paneles

        // 2. Panel Izquierdo: Columna de Botones
        JPanel panelBotones = new JPanel();
        // Usamos GridLayout para que los botones queden en una sola columna alineados
        panelBotones.setLayout(new GridLayout(3, 1, 0, 15)); 
        panelBotones.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 10));

        btn_cuentas = new JButton("Cuentas");
        btn_depositos = new JButton("Depósitos");
        btn_pagos = new JButton("Pagos");

        // Ajustar un tamaño preferido para la barra lateral de botones
        Dimension tamanoBoton = new Dimension(130, 40);
        btn_cuentas.setPreferredSize(tamanoBoton);
        btn_depositos.setPreferredSize(tamanoBoton);
        btn_pagos.setPreferredSize(tamanoBoton);

        panelBotones.add(btn_cuentas);
        panelBotones.add(btn_depositos);
        panelBotones.add(btn_pagos);

        // 3. Panel Central/Derecho: Tabla (tb_cuentas)
        JPanel panelTabla = new JPanel();
        panelTabla.setLayout(new BorderLayout());
        panelTabla.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 20));

        // Cabeceras exactas de tu dibujo
        String[] columnas = {"Cuenta", "Depósito", "Retiros", "Saldo"};
        
        // Inicializamos el modelo con las columnas y 0 filas iniciales
        modeloTabla = new DefaultTableModel(columnas, 0);
        tb_cuentas = new JTable(modeloTabla);
        
        // JScrollPane es indispensable para que se vean las cabeceras de la tabla
        JScrollPane scrollTabla = new JScrollPane(tb_cuentas);
        panelTabla.add(scrollTabla, BorderLayout.CENTER);

        // 4. Agregar los bloques principales al JFrame
        add(panelBotones, BorderLayout.WEST);  // Botones a la izquierda
        add(panelTabla, BorderLayout.CENTER);   // Tabla al lado de la columna
    }
}