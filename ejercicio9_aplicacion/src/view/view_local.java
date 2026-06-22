package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.logic_view_login;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextField;

public class view_local extends JFrame {

	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JPasswordField txt_psw;
	public JButton btn_ok;
	public JTextField txt_user;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					view_local frame = new view_local();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public view_local() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 380, 191);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USUARIO:");
		lblNewLabel.setBounds(22, 29, 67, 14);
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(245, 16, 1, 1);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblClave = new JLabel("CLAVE:");
		lblClave.setVerticalAlignment(SwingConstants.BOTTOM);
		lblClave.setBounds(32, 57, 67, 14);
		contentPane.add(lblClave);
		
		txt_psw = new JPasswordField();
		txt_psw.setBounds(82, 54, 257, 20);
		contentPane.add(txt_psw);
		
		btn_ok = new JButton("INICIAR");
		btn_ok.setBounds(153, 103, 89, 23);
		contentPane.add(btn_ok);
		
		txt_user = new JTextField();
		txt_user.setBounds(82, 26, 257, 20);
		contentPane.add(txt_user);
		txt_user.setColumns(10);
		
		new logic_view_login(this);

	}
}
