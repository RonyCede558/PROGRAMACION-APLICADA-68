package controller;

import java.io.IOException;
import java.util.Date;
import model.acount;
import model.acountDAO;

public class mgAcount {
    
    private int getRandom() {
        return (int) (Math.random() * 10);
    }
    
    public synchronized void createAcount() {
        String numberAcount = "12";
        for(int i = 0; i <= 7; i++) {
            numberAcount += getRandom();
        }
        
        acountDAO adao = new acountDAO(
                new acount(
                    Integer.parseInt(numberAcount),
                    200.0, 
                    0,     
                    0.0,   
                    new Date()
                )
        );
                
        try {
            adao.writerAcount();
            System.out.println("Archivo generado exitosamente: " + numberAcount + ".txt");
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo: " + e.getMessage());
            e.printStackTrace();
        }
    } 
}