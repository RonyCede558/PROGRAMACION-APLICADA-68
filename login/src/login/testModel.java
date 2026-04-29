package login;

import java.io.IOException;

public class testModel {
	public static void main(String args[]) {
		userDao udao=new userDao();
		try {
			user u=udao.getDataUser();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
