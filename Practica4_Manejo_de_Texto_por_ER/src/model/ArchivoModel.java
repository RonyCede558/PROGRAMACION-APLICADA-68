package model;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class ArchivoModel {
    
    // Ruta fija del archivo según el enunciado
    private static final String RUTA = "src/practica06/archivo.txt";
    
    // ── MÉTODO 1: Guardar texto en el archivo ──
    public void guardarArchivo(String texto) throws IOException {
        // Escribe el texto en el archivo (lo sobreescribe cada vez)
        BufferedWriter writer = new BufferedWriter(new FileWriter(RUTA));
        writer.write(texto);
        writer.close();
    }
    
    // ── MÉTODO 2: Buscar coincidencias con regex ──
    public List<String> buscarPalabras(String regex) throws IOException {
        List<String> coincidencias = new ArrayList<>();
        
        // Lee el archivo completo
        BufferedReader reader = new BufferedReader(new FileReader(RUTA));
        StringBuilder contenido = new StringBuilder();
        String linea;
        while ((linea = reader.readLine()) != null) {
            contenido.append(linea).append(" ");
        }
        reader.close();
        
        Pattern patron = Pattern.compile(regex);
        Matcher buscador = patron.matcher(contenido.toString());
        while (buscador.find()) {
            coincidencias.add(buscador.group());
        }
        
        return coincidencias;
    }
}