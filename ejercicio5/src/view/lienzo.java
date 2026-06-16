package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class lienzo extends JPanel {
    private Point jugador = new Point(10, 90);
    private Point[] enemigos = new Point[] {
        new Point(50, 30),
        new Point(150, 80),
        new Point(250, 130)
    };
    
    private int vidas = 3;
    private int tiempoSegundos = 0; 
    private boolean gameOver = false;

    public lienzo() {
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); 
        
        ImageIcon img = new ImageIcon("src/img/pika.png");
        g.drawImage(img.getImage(), 0, 0, getWidth(), getHeight(), null);
        
        if (gameOver) {
            g.setColor(new Color(231, 76, 60)); 
            g.setFont(new Font("Segoe UI", Font.BOLD, 36));
            g.drawString("GAME OVER", getWidth() / 2 - 110, getHeight() / 2 - 10);
            
            g.setColor(Color.BLACK);
            g.setFont(new Font("Segoe UI", Font.BOLD, 18));
            g.drawString("Sobreviviste: " + tiempoSegundos + " segundos", getWidth() / 2 - 110, getHeight() / 2 + 30);
            return; 
        }
        
        for (Point enemigo : enemigos) {
            g.setColor(new Color(41, 128, 185));
            g.drawRect(enemigo.x, enemigo.y, 45, 45);
            g.setColor(new Color(231, 76, 60));  
            g.fillRect(enemigo.x + 4, enemigo.y + 4, 37, 37);
        }
        
        g.setColor(new Color(44, 62, 80));
        g.fillOval(jugador.x, jugador.y, 30, 30);
        
        g.setColor(Color.GREEN);
        g.drawOval(10, 140, 50, 50);
        int[] xTriangulo = {35, 50, 20};
        int[] yTriangulo = {145, 180, 180};
        g.setColor(Color.CYAN);
        g.fillPolygon(xTriangulo, yTriangulo, 3);
        
        g.setColor(Color.BLACK); 
        g.setFont(new Font("Segoe UI", Font.BOLD, 14));
        g.drawString("Vidas: " + vidas, 10, 20);
        g.drawString("Tiempo: " + tiempoSegundos + "s", 10, 40);
    }

    public void setJugadorX(int x) {
        if (gameOver) return;
        this.jugador.x += x;
        verificarColisiones();
        repaint();
    }

    public void setJugadorY(int y) {
        if (gameOver) return;
        this.jugador.y += y;
        verificarColisiones();
        repaint();
    }
    
    public void setEnemigoPosicion(int indice, int x, int y) {
        if (gameOver) return;
        if (indice >= 0 && indice < enemigos.length) {
            enemigos[indice].setLocation(x, y);
            verificarColisiones();
            repaint();
        }
    }
    
    public void incrementarTiempo() {
        if (gameOver) return;
        this.tiempoSegundos++;
        repaint();
    }
    
    public void verificarColisiones() {
        if (gameOver) return;
        
        Rectangle rJugador = new Rectangle(jugador.x, jugador.y, 30, 30);
        
        for (Point enemigo : enemigos) {
            Rectangle rEnemigo = new Rectangle(enemigo.x, enemigo.y, 45, 45);
            
            if (rJugador.intersects(rEnemigo)) {
                vidas--;
                if (vidas <= 0) {
                    gameOver = true;
                } else {
                    enemigo.setLocation(-100, -100);
                }
                break; 
            }
        }
    }
    
    public boolean isGameOver() {
        return gameOver;
    }

    // NUEVO MÉTODO: Resetea todas las variables a su estado inicial
    public void reiniciarJuego() {
        this.vidas = 3;
        this.tiempoSegundos = 0;
        this.gameOver = false;
        
        this.jugador.setLocation(10, 90);
        this.enemigos[0].setLocation(50, 30);
        this.enemigos[1].setLocation(150, 80);
        this.enemigos[2].setLocation(250, 130);
        
        repaint();
    }
}