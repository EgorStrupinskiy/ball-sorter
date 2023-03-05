package com.innowise.ballsorter.sorter.impl;


import com.innowise.ballsorter.sorter.Sorter;

import java.util.Comparator;
import java.util.List;

public class MergeSorter implements Sorter {
    public <T> void sort(List<T> list, Comparator<T> comparator) {
        if (list.size() > 1) {
            int middle = list.size() / 2;
            List<T> leftList = list.subList(0, middle);
            List<T> rightList = list.subList(middle, list.size());
            sort(leftList, comparator);
            sort(rightList, comparator);
            merge(list, leftList, rightList, comparator);
        }
    }

    private static <T> void merge(List<T> list, List<T> leftList, List<T> rightList, Comparator<T> comparator) {
        int i = 0, j = 0, k = 0;
        while (i < leftList.size() && j < rightList.size()) {
            if (comparator.compare(leftList.get(i), rightList.get(j)) <= 0) {
                list.set(k++, leftList.get(i++));
            } else {
                list.set(k++, rightList.get(j++));
            }
        }
        while (i < leftList.size()) {
            list.set(k++, leftList.get(i++));
        }
        while (j < rightList.size()) {
            list.set(k++, rightList.get(j++));
        }
    }

}