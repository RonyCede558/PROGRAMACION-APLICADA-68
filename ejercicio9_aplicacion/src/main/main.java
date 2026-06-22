package main;

import view.ViewBank;
import view.view_local;

import java.awt.EventQueue;

import controller.LogicViewBank;

public class main {
    public static void main(String[] args) {
//        ViewBank vista = new ViewBank();
//        LogicViewBank controlador = new LogicViewBank(vista);
//        controlador.iniciar();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					view_local frame = new view_local();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }
}