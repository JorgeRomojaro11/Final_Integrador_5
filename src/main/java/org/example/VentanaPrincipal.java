package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Numeros.HerramientasDeAnalisisNumerico;
import ADN.AnalisisGenomico;
import com.thealgorithms.sorts.Quicksort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

public class VentanaPrincipal extends JFrame {

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
                new Thread(() -> {
                    JDialog dialogo = new JDialog(VentanaPrincipal.this, "Ordenar números", true);
                    dialogo.setLayout(new GridLayout(8, 2));

                    JTextField[] campos = new JTextField[6];
                    for (int i = 0; i < 6; i++) {
                        campos[i] = new JTextField();
                        dialogo.add(new JLabel("Número " + (i + 1) + ":"));
                        dialogo.add(campos[i]);
                    }

                    JButton enviar = new JButton("Enviar");
                    enviar.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            Integer[] numeros = new Integer[6];
                            for (int i = 0; i < 6; i++) {
                                numeros[i] = Integer.parseInt(campos[i].getText());
                            }

                            // Crear una nueva ventana para mostrar los pasos
                            JDialog dialogoPasos = new JDialog(VentanaPrincipal.this, "Pasos del algoritmo Quicksort", true);
                            dialogoPasos.setLayout(new BorderLayout());

                            JTextArea resultado = new JTextArea();
                            resultado.setEditable(false);
                            dialogoPasos.add(new JScrollPane(resultado), BorderLayout.CENTER);

                            dialogoPasos.setSize(300, 200);
                            dialogoPasos.setLocationRelativeTo(null);

                            quicksortPasoAPaso(numeros, 0, numeros.length - 1, resultado);

                            dialogoPasos.setVisible(true);
                        }
                    });
                    dialogo.add(enviar);

                    dialogo.pack();
                    dialogo.setVisible(true);
                }).start();
            }
        });
        panel.add(botonOrdenar);

        JButton botonOperaciones = new JButton("Operaciones");
        botonOperaciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog dialogoOperaciones = new JDialog(VentanaPrincipal.this, "Operaciones", true);
                dialogoOperaciones.setLayout(new FlowLayout());

                JButton botonPotencia = new JButton("Potencia");
                botonPotencia.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new Thread(() -> {
                            JDialog dialogoPotencia = new JDialog(dialogoOperaciones, "Calcular Potencia", true);
                            dialogoPotencia.setLayout(new GridLayout(4, 2));

                            JTextField campoBase = new JTextField();
                            dialogoPotencia.add(new JLabel("Base:"));
                            dialogoPotencia.add(campoBase);

                            JTextField campoExponente = new JTextField();
                            dialogoPotencia.add(new JLabel("Exponente:"));
                            dialogoPotencia.add(campoExponente);

                            JTextArea resultado = new JTextArea();
                            resultado.setEditable(false);
                            dialogoPotencia.add(new JLabel("Resultado:"));
                            dialogoPotencia.add(resultado);

                            JButton enviar = new JButton("Calcular");
                            enviar.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    int base = Integer.parseInt(campoBase.getText());
                                    int exponente = Integer.parseInt(campoExponente.getText());
                                    int resultadoPotencia = HerramientasDeAnalisisNumerico.potencia(base, exponente);
                                    resultado.setText(Integer.toString(resultadoPotencia));
                                }
                            });
                            dialogoPotencia.add(enviar);

                            dialogoPotencia.pack();
                            dialogoPotencia.setVisible(true);
                        }).start();
                    }
                });
                dialogoOperaciones.add(botonPotencia);

                JButton botonSuma = new JButton("Suma");
                botonSuma.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new Thread(() -> {
                            JDialog dialogoSuma = new JDialog(dialogoOperaciones, "Sumar Números", true);
                            dialogoSuma.setLayout(new GridLayout(4, 2));

                            JTextField campoNumeros = new JTextField();
                            dialogoSuma.add(new JLabel("Números (separados por comas):"));
                            dialogoSuma.add(campoNumeros);

                            JTextArea resultado = new JTextArea();
                            resultado.setEditable(false);
                            dialogoSuma.add(new JLabel("Resultado:"));
                            dialogoSuma.add(resultado);

                            JButton enviar = new JButton("Calcular");
                            enviar.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    String[] numerosStr = campoNumeros.getText().split(",");
                                    int[] numeros = new int[numerosStr.length];
                                    for (int i = 0; i < numerosStr.length; i++) {
                                        numeros[i] = Integer.parseInt(numerosStr[i].trim());
                                    }
                                    int suma = HerramientasDeAnalisisNumerico.sumaNumeros(numeros);
                                    resultado.setText(Integer.toString(suma));
                                }
                            });
                            dialogoSuma.add(enviar);

                            dialogoSuma.pack();
                            dialogoSuma.setVisible(true);
                        }).start();
                    }
                });
                dialogoOperaciones.add(botonSuma);

                JButton botonMaximo = new JButton("Máximo");
                botonMaximo.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new Thread(() -> {
                            JDialog dialogoMaximo = new JDialog(dialogoOperaciones, "Encontrar Máximo", true);
                            dialogoMaximo.setLayout(new GridLayout(4, 2));

                            JTextField campoNumeros = new JTextField();
                            dialogoMaximo.add(new JLabel("Números (separados por comas):"));
                            dialogoMaximo.add(campoNumeros);

                            JTextArea resultado = new JTextArea();
                            resultado.setEditable(false);
                            dialogoMaximo.add(new JLabel("Resultado:"));
                            dialogoMaximo.add(resultado);

                            JButton enviar = new JButton("Calcular");
                            enviar.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    String[] numerosStr = campoNumeros.getText().split(",");
                                    int[] numeros = new int[numerosStr.length];
                                    for (int i = 0; i < numerosStr.length; i++) {
                                        numeros[i] = Integer.parseInt(numerosStr[i].trim());
                                    }
                                    int maximo = HerramientasDeAnalisisNumerico.encuentraMaximo(numeros);
                                    resultado.setText(Integer.toString(maximo));
                                }
                            });
                            dialogoMaximo.add(enviar);

                            dialogoMaximo.pack();
                            dialogoMaximo.setVisible(true);
                        }).start();
                    }
                });
                dialogoOperaciones.add(botonMaximo);
                dialogoOperaciones.pack();
                dialogoOperaciones.setVisible(true);
            }
        });
        panel.add(botonOperaciones);

        JButton botonADN = new JButton("ADN");
        botonADN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog dialogoADN = new JDialog(VentanaPrincipal.this, "ADN", true);
                dialogoADN.setLayout(new FlowLayout());

                JButton botonConteoGenes = new JButton("Conteo de genes");
                botonConteoGenes.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new Thread(() -> {
                            JDialog dialogoConteoGenes = new JDialog(dialogoADN, "Conteo de genes", true);
                            dialogoConteoGenes.setLayout(new GridLayout(4, 2));

                            JTextField campoADN = new JTextField();
                            dialogoConteoGenes.add(new JLabel("Cadena de ADN:"));
                            dialogoConteoGenes.add(campoADN);

                            JTextArea resultado = new JTextArea();
                            resultado.setEditable(false);
                            dialogoConteoGenes.add(new JLabel("Resultado:"));
                            dialogoConteoGenes.add(resultado);

                            JButton enviar = new JButton("Calcular");
                            enviar.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    String adn = campoADN.getText();
                                    int cuenta = AnalisisGenomico.cuentaGenes(adn);
                                    resultado.setText(Integer.toString(cuenta));
                                }
                            });
                            dialogoConteoGenes.add(enviar);

                            dialogoConteoGenes.pack();
                            dialogoConteoGenes.setVisible(true);
                        }).start();
                    }
                });
                dialogoADN.add(botonConteoGenes);

                JButton botonCombinaciones = new JButton("Combinaciones");
                botonCombinaciones.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        new Thread(() -> {
                            JDialog dialogoCombinaciones = new JDialog(dialogoADN, "Combinaciones genéticas", true);
                            dialogoCombinaciones.setLayout(new GridLayout(4, 2));

                            JTextField campoN = new JTextField();
                            dialogoCombinaciones.add(new JLabel("Número de genes:"));
                            dialogoCombinaciones.add(campoN);

                            JTextArea resultado = new JTextArea();
                            resultado.setEditable(false);
                            dialogoCombinaciones.add(new JLabel("Resultado:"));
                            dialogoCombinaciones.add(resultado);

                            JButton enviar = new JButton("Calcular");
                            enviar.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    int n = Integer.parseInt(campoN.getText());
                                    int combinaciones = AnalisisGenomico.calculaCombinacionesGeneticas(n);
                                    resultado.setText(Integer.toString(combinaciones));
                                }
                            });
                            dialogoCombinaciones.add(enviar);

                            dialogoCombinaciones.pack();
                            dialogoCombinaciones.setVisible(true);
                        }).start();
                    }
                });
                dialogoADN.add(botonCombinaciones);

                dialogoADN.pack();
                dialogoADN.setVisible(true);
            }
        });
        panel.add(botonADN);

        JButton botonGestionInformacion = new JButton("Gestion de Informacion");
        botonGestionInformacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JDialog dialogoGestionInformacion = new JDialog(VentanaPrincipal.this, "Gestion de Informacion", true);
                dialogoGestionInformacion.setLayout(new FlowLayout());

                JButton botonOrdenarAlfabeticamente = new JButton("Ordenar alfabéticamente");
                botonOrdenarAlfabeticamente.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFileChooser fileChooser = new JFileChooser();
                        int returnValue = fileChooser.showOpenDialog(null);
                        if (returnValue == JFileChooser.APPROVE_OPTION) {
                            File selectedFile = fileChooser.getSelectedFile();
                            try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                                String originalContent = reader.lines().collect(Collectors.joining("\n"));
                                JOptionPane.showMessageDialog(null, "Contenido original:\n" + originalContent);
                            } catch (IOException ioException) {
                                ioException.printStackTrace();
                            }
                            try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                                String sortedContent = reader.lines().sorted().collect(Collectors.joining("\n"));
                                JOptionPane.showMessageDialog(null, "Contenido ordenado:\n" + sortedContent);
                            } catch (IOException ioException) {
                                ioException.printStackTrace();
                            }
                        }
                    }
                });
                dialogoGestionInformacion.add(botonOrdenarAlfabeticamente);

                JButton botonBusquedaPalabras = new JButton("Búsqueda de palabras");
                botonBusquedaPalabras.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFileChooser fileChooser = new JFileChooser();
                        int returnValue = fileChooser.showOpenDialog(null);
                        if (returnValue == JFileChooser.APPROVE_OPTION) {
                            File selectedFile = fileChooser.getSelectedFile();
                            try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                                String originalContent = reader.lines().collect(Collectors.joining("\n"));
                                JOptionPane.showMessageDialog(null, "Contenido original:\n" + originalContent);
                            } catch (IOException ioException) {
                                ioException.printStackTrace();
                            }
                            String word = JOptionPane.showInputDialog("Ingrese la palabra que desea buscar:");
                            try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                                int count = 0;
                                String line;
                                int lineCount = 0;
                                StringBuilder lines = new StringBuilder();
                                while ((line = reader.readLine()) != null) {
                                    lineCount++;
                                    if (line.contains(word)) {
                                        count++;
                                        lines.append("Line ").append(lineCount).append(": ").append(line).append("\n");
                                    }
                                }
                                String message = "La palabra '" + word + "' aparece " + count + " veces en las siguientes líneas:\n" + lines;
                                JOptionPane.showMessageDialog(null, message);
                            } catch (IOException ioException) {
                                ioException.printStackTrace();
                            }
                        }
                    }
                });
                dialogoGestionInformacion.add(botonBusquedaPalabras);

                JButton botonFechas = new JButton("Fechas");
                botonFechas.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String input = JOptionPane.showInputDialog("Ingrese las fechas separadas por comas (formato dd/MM/yyyy):");
                        String[] dateStrings = input.split(",");
                        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                        try {
                            Date[] dates = new Date[dateStrings.length];
                            for (int i = 0; i < dateStrings.length; i++) {
                                dates[i] = format.parse(dateStrings[i].trim());
                            }
                            Arrays.sort(dates);
                            String sortedDates = Arrays.stream(dates).map(format::format).collect(Collectors.joining("\n"));
                            JOptionPane.showMessageDialog(null, sortedDates);
                        } catch (ParseException parseException) {
                            parseException.printStackTrace();
                        }
                    }
                });
                dialogoGestionInformacion.add(botonFechas);

                dialogoGestionInformacion.pack();
                dialogoGestionInformacion.setVisible(true);
            }
        });
        panel.add(botonGestionInformacion);
    }
    public void mostrarArray(Integer[] array, JTextArea textArea) {
        textArea.append(Arrays.toString(array) + "\n");
    }
    public void quicksortPasoAPaso(Integer[] array, int inicio, int fin, JTextArea textArea) {
        if (inicio < fin) {
            int pivote = partition(array, inicio, fin, textArea);
            quicksortPasoAPaso(array, inicio, pivote - 1, textArea);
            quicksortPasoAPaso(array, pivote + 1, fin, textArea);
        }
    }
    public int partition(Integer[] array, int inicio, int fin, JTextArea textArea) {
        int pivote = array[fin];
        int i = inicio - 1;
        for (int j = inicio; j < fin; j++) {
            if (array[j] < pivote) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                mostrarArray(array, textArea); // Mostrar el estado del array después de cada intercambio
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[fin];
        array[fin] = temp;
        mostrarArray(array, textArea); // Mostrar el estado del array después de mover el pivote
        return i + 1;
    }
    public void mostrarArray(Integer[] array) {
        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setText(Arrays.toString(array));

        JDialog dialog = new JDialog();
        dialog.setTitle("Estado del array");
        dialog.setModal(true);
        dialog.getContentPane().add(new JScrollPane(textArea), BorderLayout.CENTER);
        dialog.setSize(300, 200);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VentanaPrincipal().setVisible(true);
        });
    }
};