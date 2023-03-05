package com.innowise.ballsorter.sorter.impl;

import com.innowise.ballsorter.sorter.Sorter;

import java.util.Comparator;
import java.util.List;

public class HeapSorter implements Sorter {
    public <T> void sort(List<T> list, Comparator<T> comparator) {
        int n = list.size();

        // Построение кучи (перегруппируем массив)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(list, n, i, comparator);

        // Один за другим извлекаем элементы из кучи
        for (int i = n - 1; i >= 0; i--) {
            // Перемещаем текущий корень в конец
            T temp = list.get(0);
            list.set(0, list.get(i));
            list.set(i, temp);

            // вызываем процедуру heapify на уменьшенной куче
            heapify(list, i, 0, comparator);
        }
    }

//    @Override
//    public <T> void sortBySize(List<T> list, SizeComparator comparator) {
//        sort(list, comparator);
//    }

    // Функция для перевода поддерева i в кучу
    private static <T> void heapify(List<T> list, int n, int i, Comparator<T> comparator) {
        int largest = i;  // Инициализируем наибольший элемент как корень
        int l = 2 * i + 1;  // левый = 2*i + 1
        int r = 2 * i + 2;  // правый = 2*i + 2

        // Если левый дочерний элемент больше корня
        if (l < n && comparator.compare(list.get(l), list.get(largest)) > 0)
            largest = l;

        // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (r < n && comparator.compare(list.get(r), list.get(largest)) > 0)
            largest = r;

        // Если самый большой элемент не корень
        if (largest != i) {
            T swap = list.get(i);
            list.set(i, list.get(largest));
            list.set(largest, swap);

            // Рекурсивно heapify поддерево
            heapify(list, n, largest, comparator);
        }
    }

}
