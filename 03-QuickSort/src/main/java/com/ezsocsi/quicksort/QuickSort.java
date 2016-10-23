package com.ezsocsi.quicksort;


import java.util.Collections;
import java.util.List;

public class QuickSort {
    public void quickSort(List<Integer> list) {
        quickSort(list, 0, list.size()-1);
    }

    private void quickSort(List<Integer> list, int low, int high) {
        if (low < high) {
            int p = partition(list, low, high);
            quickSort(list, low, p - 1);
            quickSort(list, p + 1, high);
        }
    }

    private int partition(List<Integer> list, int low, int high) {
        int pivot = list.get(high);
        Integer i = low;

        for (int j = low; j < high; j++) {
            if (list.get(j) < pivot) {
                Collections.swap(list, i, j);
                i++;
            }
        }
        Collections.swap(list, i, high);

        return i;
    }
}
