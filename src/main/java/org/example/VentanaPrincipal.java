package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Numeros.HerramientasDeAnalisisNumerico;
import ADN.AnalisisGenomico;
import InformacionCientifica.OrganizadorDeDocumentos;
import InformacionCientifica.BuscadorEnTextos;
import com.thealgorithms.sorts.Quicksort;
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

        JButton botonNumeros = new JButton("Numeros");
        botonNumeros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread(() -> {
                    String input = JOptionPane.showInputDialog("Introduce un número natural:");
                    int numero = Integer.parseInt(input);
                    int suma = HerramientasDeAnalisisNumerico.sumaNumerosNaturales(numero);
                    JOptionPane.showMessageDialog(null, "La suma de los primeros " + numero + " números naturales es: " + suma);
                }).start();
            }
        });
        panel.add(botonNumeros);

        JButton botonADN = new JButton("ADN");
        botonADN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread(() -> {
                    String adn = JOptionPane.showInputDialog("Introduce una cadena de ADN:");
                    int cuenta = AnalisisGenomico.cuentaGenes(adn);
                    JOptionPane.showMessageDialog(null, "La cantidad de genes en la cadena de ADN es: " + cuenta);

                    String input = JOptionPane.showInputDialog("Introduce un número para calcular las combinaciones genéticas:");
                    int numero = Integer.parseInt(input);
                    int combinaciones = AnalisisGenomico.calculaCombinacionesGeneticas(numero);
                    JOptionPane.showMessageDialog(null, "El número de combinaciones genéticas posibles es: " + combinaciones);
                }).start();
            }
        });
        panel.add(botonADN);

        JButton botonInformacionCientifica = new JButton("Informacion Cientifica");
        botonInformacionCientifica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread(() -> {
                    try {
                        JFileChooser fileChooser = new JFileChooser();
                        int returnValue = fileChooser.showOpenDialog(null);
                        if (returnValue == JFileChooser.APPROVE_OPTION) {
                            File selectedFile = fileChooser.getSelectedFile();
                            String contenido = new String(Files.readAllBytes(Paths.get(selectedFile.getAbsolutePath())));

                            VentanaDeTexto ventanaDeTexto = new VentanaDeTexto(selectedFile, contenido);
                            ventanaDeTexto.setVisible(true);
                        }
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, "Ha ocurrido un error: " + ex.getMessage());
                    }
                }).start();
            }
        });
        panel.add(botonInformacionCientifica);

        JButton botonOrdenar = new JButton("Ordenar");
        botonOrdenar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Quicksort quickSort = new Quicksort();
                array = quickSort.sort(array);

                // Muestra los resultados
                for (int i : array) {
                    System.out.print(i + " ");
                }
            }
        });
        panel.add(botonOrdenar);
    }
}
