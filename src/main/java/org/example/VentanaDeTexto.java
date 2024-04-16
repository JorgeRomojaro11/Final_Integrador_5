package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import InformacionCientifica.BuscadorEnTextos;
import InformacionCientifica.BuscadorEnTextos.ResultadoBusqueda;
import java.io.File;
import java.io.IOException;

public class VentanaDeTexto extends JFrame {
    private JTextArea textArea;
    private File file;

    public VentanaDeTexto(File file, String contenido) {
        this.file = file;
        setTitle("Documento");
        setSize(500, 400);
        setLocationRelativeTo(null);

        textArea = new JTextArea(contenido);
        JScrollPane scrollPane = new JScrollPane(textArea);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        JButton botonBuscar = new JButton("Buscar palabra");
        botonBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String palabra = JOptionPane.showInputDialog("Introduce la palabra a buscar:");
                try {
                    ResultadoBusqueda resultado = BuscadorEnTextos.buscarPalabraLineal(file.getAbsolutePath(), palabra);
                    JOptionPane.showMessageDialog(null, "La palabra aparece " + resultado.conteo + " veces en las líneas " + resultado.lineas);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error: " + ex.getMessage());
                }
            }
        });
        getContentPane().add(botonBuscar, BorderLayout.SOUTH);
    }
}