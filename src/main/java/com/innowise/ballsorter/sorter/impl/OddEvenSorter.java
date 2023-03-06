package com.innowise.ballsorter.sorter.impl;

import com.innowise.ballsorter.sorter.Sorter;

import java.util.Comparator;
import java.util.List;

public class OddEvenSorter implements Sorter {

    @Override
    public  <T> void sort(List<T> list, Comparator<T> comparator) {
        int size = list.size();
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < size - 1; i += 2) {
                isSorted = isSorted(list, comparator, isSorted, i);
            }
            for (int i = 1; i < size - 1; i += 2) {
                isSorted = isSorted(list, comparator, isSorted, i);
            }
        }
    }

    private <T> boolean isSorted(List<T> list, Comparator<T> comparator, boolean isSorted, int i) {
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
