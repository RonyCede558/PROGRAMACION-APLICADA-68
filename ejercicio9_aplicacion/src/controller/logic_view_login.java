package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import model.user;
import model.userDao;
import view.ViewBank;
import view.view_local;

public class logic_view_login implements ActionListener{
	private view_local vl;

	public logic_view_login(view_local vl) {
		super();
		this.vl = vl;
		this.vl.btn_ok.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == vl.btn_ok) {
			validate(
					vl.txt_user.getText(), getEchoPSW()
					);
		}
	}
	
	/**
	 * Metodo para validar las credenciales de usuario
	 * @return
	 */
	private String getEchoPSW() {
		String psw = "";
		for(char c : vl.txt_psw.getPassword()) {
			psw += String.valueOf(c);
		}
		return psw;
	}
	
	private boolean validate(String... c) {
		try {
			String usernameIngresado = c[0];
			String passwordIngresada = c[1];
			
			// Le pedimos al DAO que busque específicamente a este usuario
			user u = new userDao().getDataUser(usernameIngresado);
			
			// Verificamos que 'u' no sea null (es decir, que el usuario sí exista en el txt)
			// y luego verificamos que la contraseña sea igual
			if(u != null && u.getPsw().equals(passwordIngresada)) {
				vl.setVisible(false);
				JOptionPane.showMessageDialog(vl, "¡Bienvenido!!!", "LOGIN", JOptionPane.INFORMATION_MESSAGE);
				ViewBank vb = new ViewBank();
				vb.setVisible(true);
				return true;
			}
			
			JOptionPane.showMessageDialog(vl, "Credenciales Incorrectas", "LOGIN", JOptionPane.WARNING_MESSAGE);			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(vl, "Fuente desconocida o archivo no encontrado", "LOGIN", JOptionPane.ERROR_MESSAGE);
		}
		return false;
	}
}