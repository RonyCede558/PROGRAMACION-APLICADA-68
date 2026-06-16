 package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import view.view_lienzo;

public class logic_view_lienza implements ActionListener, KeyListener {
    private subprocessMoveObject hilo1;
    private view_lienzo vl;
    
    public logic_view_lienza(view_lienzo vl) {
        this.vl = vl;
        this.vl.btn_start.addActionListener(this);
        this.vl.btn_stop.addActionListener(this);
        this.vl.btn_resumen.addActionListener(this);
        this.vl.addKeyListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == vl.btn_start) {
            
            if(hilo1 == null || !hilo1.isAlive()) {
                vl.pn_lienzo.reiniciarJuego(); // Por seguridad, asegura el estado en 0
                hilo1 = new subprocessMoveObject(vl);
                hilo1.start();
            }
            
        } else if(e.getSource() == vl.btn_stop) {
            
            // Alterna entre Pausa y Play si el juego está en curso
            if(hilo1 != null && !vl.pn_lienzo.isGameOver()) {
                if (hilo1.isPaused()) {
                    hilo1.reanudar();
                } else {
                    hilo1.pausar();
                }
            }
            
        } else if(e.getSource() == vl.btn_resumen) {
            
            // Lógica de "Reiniciar" el juego (incluso si ya perdiste o estás a la mitad)
            if (hilo1 != null) {
                hilo1.setFlag(false); // Detenemos el hilo viejo
                if (hilo1.isPaused()) {
                    hilo1.reanudar(); // Lo despertamos por si estaba dormido para que pueda morir en paz
                }
            }
            
            vl.pn_lienzo.reiniciarJuego(); // Reiniciamos lienzo a estado de fábrica
            
            hilo1 = new subprocessMoveObject(vl); // Creamos un hilo nuevo
            hilo1.start();
        }
        
        vl.requestFocus();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(hilo1 == null || hilo1.isPaused() || vl.pn_lienzo.isGameOver()) return;
        
        int velocidad = 10;
        
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            vl.pn_lienzo.setJugadorY(-velocidad);
        } else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            vl.pn_lienzo.setJugadorY(velocidad);
        } else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            vl.pn_lienzo.setJugadorX(-velocidad);
        } else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            vl.pn_lienzo.setJugadorX(velocidad);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}