package main;

import controller.Controlador;
import model.ArchivoModel;
import view.View_form;

public class Main {
    public static void main(String[] args) {
        ArchivoModel modelo = new ArchivoModel();
        View_form vista = new View_form();
        Controlador controlador = new Controlador(modelo, vista);
        vista.setVisible(true);
    }
}