package com.innowise.ballsorter.sorter.impl;

import com.innowise.ballsorter.sorter.Sorter;

import java.util.Comparator;
import java.util.List;

/**
 * Implements a sorting algorithm using the odd-even sort algorithm.
 */
public class OddEvenSorter implements Sorter {

    /**
     * Sorts a given list using the odd-even sort algorithm.
     *
     * @param list       the list to be sorted
     * @param comparator the comparator to be used for sorting
     * @param <T>        the type of the elements in the list
     */
    @Override
    public <T> void sort(List<T> list, Comparator<T> comparator) {
        int size = list.size();
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < size - 1; i += 2) {
                isSorted = swapIfUnsorted(list, comparator, isSorted, i);
            }
            for (int i = 1; i < size - 1; i += 2) {
                isSorted = swapIfUnsorted(list, comparator, isSorted, i);
            }
        }
    }

    private <T> boolean swapIfUnsorted(List<T> list, Comparator<T> comparator, boolean isSorted, int i) {
        T left = list.get(i);
        T right = list.get(i + 1);
        if (comparator.compare(left, right) > 0) {
            list.set(i, right);
            list.set(i + 1, left);
            isSorted = false;
        }
        return isSorted;
    }
}
