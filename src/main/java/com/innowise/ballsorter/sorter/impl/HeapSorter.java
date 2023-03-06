package com.innowise.ballsorter.sorter.impl;

import com.innowise.ballsorter.sorter.Sorter;

import java.util.Comparator;
import java.util.List;

public class HeapSorter implements Sorter {
    @Override
    public <T> void sort(List<T> list, Comparator<T> comparator) {
        int n = list.size();

        for (int i = n / 2 - 1; i >= 0; i--){
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
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && comparator.compare(list.get(l), list.get(largest)) > 0)
            largest = l;

        if (r < n && comparator.compare(list.get(r), list.get(largest)) > 0)
            largest = r;

        if (largest != i) {
            T swap = list.get(i);
            list.set(i, list.get(largest));
            list.set(largest, swap);
            heapify(list, n, largest, comparator);
        }
    }

}
