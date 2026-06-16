package controller;

import view.view_lienzo;

public class subprocessMoveObject extends Thread {
    private view_lienzo vl;
    private boolean flag = true;
    private boolean isPaused = false; 
    
    public subprocessMoveObject(view_lienzo vl_) {
        this.vl = vl_;
    }
    
    private int getRandomX(){
        return (int)(Math.random() * (vl.pn_lienzo.getWidth() - 50));
    }
    
    private int getRandomY() {
        return (int)(Math.random() * (vl.pn_lienzo.getHeight() - 50));
    }
    
    @Override
    public void run() {
        int ciclos = 0; 
        
        while(flag && !vl.pn_lienzo.isGameOver()) {
            
            synchronized(this) {
                while (isPaused) {
                    try {
                        wait(); 
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            
            try {
                sleep(1000); 
                
                if (!isPaused && !vl.pn_lienzo.isGameOver()) {
                    vl.pn_lienzo.incrementarTiempo();
                    ciclos++;
                    
                    if (ciclos >= 2) {
                        for (int i = 0; i < 3; i++) {
                            vl.pn_lienzo.setEnemigoPosicion(i, getRandomX(), getRandomY());
                        }
                        ciclos = 0; 
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public synchronized void pausar() {
        this.isPaused = true;
    }
    
    public synchronized void reanudar() {
        this.isPaused = false;
        notify(); 
    }
    
    public boolean isPaused() {
        return isPaused;
    }
}