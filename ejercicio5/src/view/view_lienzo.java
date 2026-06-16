package view;

import controller.*;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

public class view_lienzo extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    public JButton btn_start;
    public JButton btn_stop;
    public JButton btn_resumen;
    public lienzo pn_lienzo;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    view_lienzo frame = new view_lienzo();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public view_lienzo() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 440, 360);
        setResizable(false);
        setTitle("Evita los Enemigos — 3X Edition");
        
        contentPane = new JPanel();
        contentPane.setBackground(new Color(44, 62, 80));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel pn_control = new JPanel();
        pn_control.setBackground(new Color(52, 73, 94));
        pn_control.setBounds(12, 20, 400, 40);
        contentPane.add(pn_control);
        pn_control.setLayout(null);
        
        btn_start = new JButton("Start");
        btn_start.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btn_start.setBackground(new Color(46, 204, 113));
        btn_start.setForeground(Color.WHITE);
        btn_start.setFocusPainted(false);
        btn_start.setBounds(10, 7, 90, 25);
        pn_control.add(btn_start);
        
        // El botón STOP ahora es Pausa / Play
        btn_stop = new JButton("Pausa / Play");
        btn_stop.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btn_stop.setBackground(new Color(243, 156, 18)); // Naranja plano
        btn_stop.setForeground(Color.WHITE);
        btn_stop.setFocusPainted(false);
        btn_stop.setBounds(110, 7, 120, 25);
        pn_control.add(btn_stop);
        
        // El botón RESUME ahora es Reiniciar
        btn_resumen = new JButton("Reiniciar");
        btn_resumen.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btn_resumen.setBackground(new Color(52, 152, 219));
        btn_resumen.setForeground(Color.WHITE);
        btn_resumen.setFocusPainted(false);
        btn_resumen.setBounds(240, 7, 100, 25);
        pn_control.add(btn_resumen);
        
        pn_lienzo = new lienzo();
        pn_lienzo.setBounds(12, 80, 400, 220);
        contentPane.add(pn_lienzo);
        
        new logic_view_lienza(this);
        
        this.setFocusable(true);
        this.requestFocus();
    }
}