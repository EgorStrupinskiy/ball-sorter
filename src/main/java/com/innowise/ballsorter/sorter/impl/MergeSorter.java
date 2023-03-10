package com.innowise.ballsorter.sorter.impl;

import com.innowise.ballsorter.sorter.Sorter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeSorter implements Sorter {

    /**
     * Sorts the given list using the Merge sort algorithm.
     *
     * @param list       the list to be sorted
     * @param comparator the comparator to be used for sorting
     * @param <T>        the type of the elements in the list
     */
    @Override
    public <T> void sort(List<T> list, Comparator<T> comparator) {
        int n = list.size();
        if (n < 2) {
            return;
        }

        int mid = n / 2;
        List<T> leftList = new ArrayList<>(list.subList(0, mid));
        List<T> rightList = new ArrayList<>(list.subList(mid, n));

        sort(leftList, comparator);
        sort(rightList, comparator);

        merge(leftList, rightList, list, comparator);
    }

    private static <T> void merge(List<T> leftList, List<T> rightList, List<T> resultList, Comparator<T> comparator) {
        int leftSize = leftList.size();
        int rightSize = rightList.size();
        int i = 0, j = 0, k = 0;

        while (i < leftSize && j < rightSize) {
            if (comparator.compare(leftList.get(i), rightList.get(j)) <= 0) {
                resultList.set(k, leftList.get(i));
                i++;
            } else {
                resultList.set(k, rightList.get(j));
                j++;
            }
            k++;
        }

        while (i < leftSize) {
            resultList.set(k, leftList.get(i));
            i++;
            k++;
        }

        while (j < rightSize) {
            resultList.set(k, rightList.get(j));
            j++;
            k++;
        }
    }
}
