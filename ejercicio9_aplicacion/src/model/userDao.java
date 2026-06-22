package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class userDao {
	private user u;
	
	public userDao() {
		this.u = new user();
	}
	
	public userDao(user u) {
		super();
		this.u = u;
	}
	
	// Ahora recibe el usuario que ingresaste en el login para buscarlo
	public user getDataUser(String usernameBuscado) throws IOException {
		// try-with-resources para cerrar el BufferedReader automáticamente
		try (BufferedReader in = new BufferedReader(new FileReader("src/doc/user"))) {
			String line;
			
			// Leemos línea por línea
			while ((line = in.readLine()) != null) {
				String[] partes = line.split(",");
				
				// Verificamos que la línea tenga al menos usuario y clave separados por coma
				if (partes.length >= 2) {
					String nombreArchivo = partes[0];
					String claveArchivo = partes[1];
					
					// Si la línea actual es del usuario que intenta entrar, guardamos y retornamos
					if (nombreArchivo.equals(usernameBuscado)) {
						u.setUser(nombreArchivo);
						u.setPSW(claveArchivo);
						return u;
					}
				}
			}
		}
		// Si termina de leer el archivo y no encontró al usuario, retorna null
		return null;
	}
}