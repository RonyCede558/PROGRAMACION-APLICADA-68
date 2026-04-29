package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import login.user;
import login.userDao;
import view.view_local;

public class logic_view_login implements ActionListener{
	private view_local vl;

	public logic_view_login(view_local vl) {
		super();
		this.vl = vl;
		this.vl.btn_ok.addActionListener(this);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==vl.btn_ok) {
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
		String psw="";
		for(char c:vl.txt_psw.getPassword()) {
			psw+=String.valueOf(c);
		}
		return psw;
	}
	
	
	private boolean validate(String...c) {
		try {
			user u=new userDao().getDataUser();
			if(u.getUser().equals(c[0])){
				if(u.getPsw().equals(c[1])) {
					JOptionPane.showMessageDialog(vl, "bienvenido!!!","LOGIN",JOptionPane.INFORMATION_MESSAGE);
					return true;
				}
			}
			JOptionPane.showMessageDialog(vl,"Credenciales Incorrectas","LOGIN",JOptionPane.WARNING_MESSAGE);			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(vl,"Fuente desconocida","LOGIN",JOptionPane.ERROR_MESSAGE);
		}
		return false;
	}


}

