package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class SortingVisualizer extends JPanel {
    private static final int SIZE = 50;
    private int[] array = new int[SIZE];
    private int currentIndex = 0;
    private int compareIndex = 0;

    public SortingVisualizer() {
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            array[i] = random.nextInt(100);
        }

        Timer timer = new Timer(100, e -> {
            if (currentIndex < SIZE - 1) {
                if (compareIndex < SIZE - currentIndex - 1) {
                    if (array[compareIndex] > array[compareIndex + 1]) {
                        int temp = array[compareIndex];
                        array[compareIndex] = array[compareIndex + 1];
                        array[compareIndex + 1] = temp;
                    }
                    compareIndex++;
                } else {
                    currentIndex++;
                    compareIndex = 0;
                }
            } else {
                ((Timer) e.getSource()).stop();
            }
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth() / SIZE;
        for (int i = 0; i < SIZE; i++) {
            if (i == compareIndex) {
                g.setColor(Color.RED);
            } else if (i <= currentIndex) {
                g.setColor(Color.GREEN);
            } else {
                g.setColor(Color.BLACK);
            }
            int height = array[i] * getHeight() / 100;
            g.fillRect(i * width, getHeight() - height, width, height);
        }
    }
}