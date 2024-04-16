package com.thealgorithms.sorts;

import com.thealgorithms.sorts.SortAlgorithms;
import static com.thealgorithms.sorts.SortUtils.*;

public class AnimatedQuicksort implements SortAlgorithms {
    private ArrayVisualizer arrayVisualizer;

    public AnimatedQuicksort(ArrayVisualizer arrayVisualizer) {
        this.arrayVisualizer = arrayVisualizer;
    }

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        doSort(array, 0, array.length - 1);
        return array;
    }

    private <T extends Comparable<T>> void doSort(T[] array, int left, int right) {
        if (left < right) {
            int pivot = randomPartition(array, left, right);
            doSort(array, left, pivot - 1);
            doSort(array, pivot, right);
        }
    }

    private <T extends Comparable<T>> int randomPartition(T[] array, int left, int right) {
        int randomIndex = left + (int) (Math.random() * (right - left + 1));
        swap(array, randomIndex, right);
        return partition(array, left, right);
    }

    private <T extends Comparable<T>> int partition(T[] array, int left, int right) {
        int mid = (left + right) >>> 1;
        T pivot = array[mid];

        while (left <= right) {
            while (less(array[left], pivot)) {
                ++left;
            }
            while (less(pivot, array[right])) {
                --right;
            }
            if (left <= right) {
                swap(array, left, right);
                ++left;
                --right;

                // Actualiza la visualización y pausa la ejecución
                arrayVisualizer.setArray(array);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        return left;
    }
}