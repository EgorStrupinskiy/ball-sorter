package com.innowise.ballsorter.sorter.impl;

import com.innowise.ballsorter.sorter.Sorter;

import java.util.Comparator;
import java.util.List;

/**
 * Implements a sorting algorithm using the heap sort algorithm.
 */
public class HeapSorter implements Sorter {

    /**
     * Sorts a given list using the heap sort algorithm.
     *
     * @param list       the list to be sorted
     * @param comparator the comparator to be used for sorting
     * @param <T>        the type of the elements in the list
     */
    @Override
    public <T> void sort(List<T> list, Comparator<T> comparator) {
        int n = list.size();

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(list, n, i, comparator);
        }

        for (int i = n - 1; i >= 0; i--) {
            T temp = list.get(0);
            list.set(0, list.get(i));
            list.set(i, temp);
            heapify(list, i, 0, comparator);
        }
    }

    private static <T> void heapify(List<T> list, int n, int i, Comparator<T> comparator) {
        int largest = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        if (leftChild < n && comparator.compare(list.get(leftChild), list.get(largest)) > 0) {
            largest = leftChild;
        }

        if (rightChild < n && comparator.compare(list.get(rightChild), list.get(largest)) > 0) {
            largest = rightChild;
        }

        if (largest != i) {
            T swap = list.get(i);
            list.set(i, list.get(largest));
            list.set(largest, swap);
            heapify(list, n, largest, comparator);
        }
    }

}
