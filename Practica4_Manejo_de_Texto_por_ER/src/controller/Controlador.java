package controller;

import model.ArchivoModel;
import view.View_form;
import java.awt.event.*;
import java.util.List;

public class Controlador {

    // ── REFERENCIAS AL MODEL Y LA VIEW ──
    private ArchivoModel modelo;
    private View_form vista;

    public Controlador(ArchivoModel modelo, View_form vista) {
        this.modelo = modelo;
        this.vista = vista;
        initEventos();
    }

    private void initEventos() {

        // ── BOTÓN GUARDAR ──
        vista.getBtnGuardar().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String texto = vista.getTxtAreaTexto().getText().trim();
                    
                    if (texto.isEmpty()) {
                        vista.mostrarMensaje("Por favor escribe algo en el área de texto.");
                        return;
                    }
                    
                    modelo.guardarArchivo(texto);
                    vista.mostrarMensaje("Archivo guardado correctamente.");
                    
                } catch (Exception ex) {
                    vista.mostrarMensaje("Error al guardar: " + ex.getMessage());
                }
            }
        });

        // ── BOTÓN BUSCAR ──
        vista.getBtnBuscar().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String regex = vista.getTxtRegex().getText().trim();
                    
                    if (regex.isEmpty()) {
                        vista.mostrarMensaje("Por favor escribe una expresión regular.");
                        return;
                    }
                    
                    List<String> resultados = modelo.buscarPalabras(regex);
                    vista.mostrarResultados(resultados);
                    
                    if (resultados.isEmpty()) {
                        vista.mostrarMensaje("No se encontraron coincidencias.");
                    }
                    
                } catch (Exception ex) {
                    vista.mostrarMensaje("Error al buscar: " + ex.getMessage());
                }
            }
        });
    }
}