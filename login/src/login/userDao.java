package login;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class userDao {
	private user u;
	
	public userDao() {
		this.u=new user();
	}
	
	public userDao(user u) {
		super();
		this.u=u;
	}
	
	public user getDataUser() throws IOException {
		BufferedReader in=new BufferedReader(new FileReader("src/doc/user"));
		String texto="";//obtener los datos del archivo
		String line;
		while((line=in.readLine())!=null) {
			texto+=line;
			System.err.println(texto);
		}
		in.close();//cerrar la conexion con el archivo
		u.setUser(texto.split(",")[0]);
		u.setPSW(texto.split(",")[1]);
		return u;
	}
}
