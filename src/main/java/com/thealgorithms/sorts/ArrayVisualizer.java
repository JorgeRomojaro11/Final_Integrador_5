package com.thealgorithms.sorts;

import javax.swing.*;
import java.awt.*;

public class ArrayVisualizer<T extends Comparable<T>> extends JPanel {
    private T[] array;

    public ArrayVisualizer(T[] array) {
        this.array = array;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (array != null) {
            int columnWidth = getWidth() / array.length;
            for (int i = 0; i < array.length; i++) {
                int height = array[i].compareTo(array[0]) * getHeight() / array.length;
                g.fillRect(i * columnWidth, getHeight() - height, columnWidth, height);
            }
        }
    }

    public void setArray(T[] array) {
        this.array = array;
        repaint();
    }
}
