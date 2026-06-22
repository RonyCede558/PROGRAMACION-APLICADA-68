package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.ViewBank; 

public class LogicViewBank implements ActionListener {
    
    private ViewBank vb;
    private mgAcount mga;
    private subprocessAcounts hilo1;

    public LogicViewBank(ViewBank vb) {
        this.vb = vb;
        this.vb.btn_cuentas.addActionListener(this);
        this.vb.btn_depositos.addActionListener(this);
        this.vb.btn_pagos.addActionListener(this);
        // Inicializamos el controlador de cuentas aquí
        this.mga = new mgAcount();
    }

    public void iniciar() {
        vb.setTitle("Bank");
        vb.setLocationRelativeTo(null);
        vb.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vb.btn_cuentas) {
            // Pasamos la misma instancia de mga al hilo
            hilo1 = new subprocessAcounts(mga);
            hilo1.start();
        }
        
        if (e.getSource() == vb.btn_depositos) {
            System.out.println("Botón Depósitos presionado");
        }
        
        if (e.getSource() == vb.btn_pagos) {
            System.out.println("Botón Pagos presionado");
        }
    }
}