package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Numeros.HerramientasDeAnalisisNumerico;
import ADN.AnalisisGenomico;
import InformacionCientifica.OrganizadorDeDocumentos;
import InformacionCientifica.BuscadorEnTextos;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class VentanaPrincipal extends JFrame {
    private Integer[] array = {3, 4, 1, 5, 2}; // Array de elementos para ordenar

    public VentanaPrincipal() {
        setTitle("Ventana Principal");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        getContentPane().add(panel);

        JButton botonOrdenar = new JButton("Ordenar");
        botonOrdenar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crea una nueva instancia de SortingVisualizer para la animación
                SortingVisualizer sortingVisualizer = new SortingVisualizer();

                // Crea una nueva ventana para la animación
                JFrame animationFrame = new JFrame();
                animationFrame.setSize(800, 600);
                animationFrame.setLocationRelativeTo(null);
                animationFrame.add(sortingVisualizer);
                animationFrame.setVisible(true);
            }
        });
        panel.add(botonOrdenar);

        JButton botonNumeros = new JButton("Numeros");
        botonNumeros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread(() -> {
                    // Tu código existente
                }).start();
            }
        });
        panel.add(botonNumeros);

        JButton botonADN = new JButton("ADN");
        botonADN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread(() -> {
                    // Tu código existente
                }).start();
            }
        });
        panel.add(botonADN);

        JButton botonInformacionCientifica = new JButton("Informacion Cientifica");
        botonInformacionCientifica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread(() -> {
                    // Tu código existente
                }).start();
            }
        });
        panel.add(botonInformacionCientifica);
    }
}