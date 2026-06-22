package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class acountDAO {
    
    private acount acount;
    // Ruta donde se guardarán los archivos
    private final String path = "src/resources/";
    
    public acountDAO() {
        super();
        this.acount = new acount();
    }
    
    public acountDAO(model.acount acount) {
        super();
        this.acount = acount;
    }
    
    public boolean writerAcount() throws IOException {
        File directorio = new File(path);
        if (!directorio.exists()) {
            directorio.mkdirs(); 
        }
        
        // Ahora sí, escribimos el archivo con seguridad
        try (FileWriter out = new FileWriter(path + acount.getNumeroCuenta() + ".txt", true)) {
            out.write(acount.toString());
            // Mostramos la ruta absoluta para que puedas darle clic o buscarla fácilmente
            System.out.println("Ruta exacta guardada: " + directorio.getAbsolutePath() + File.separator + acount.getNumeroCuenta() + ".txt");
        }
        return true;
    }
}