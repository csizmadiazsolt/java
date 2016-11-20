package com.ezsocsi.quicksort;


import com.ezsocsi.utils.ListUtils;

import java.util.List;

class QuickSort {
    private ListUtils listUtils;
    private List<Integer> listToSort;

    QuickSort(ListUtils listUtils) {
        this.listUtils = listUtils;
    }

    List<Integer> quickSort(List<Integer> list) {
        listToSort = list;

        quickSort(0, list.size() - 1);

        return listToSort;
    }

    private void quickSort(int lowerLimit, int upperLimit) {
        int pivot;

        if (lowerLimit < upperLimit) {
            pivot = partition(lowerLimit, upperLimit);
            quickSort(lowerLimit, pivot - 1);
            quickSort(pivot + 1, upperLimit);
        }
    }

    private int partition(int lowerLimit, int upperLimit) {
        int pivot = listToSort.get(upperLimit);
        int i = lowerLimit;
        int j = lowerLimit;

        for (Integer element : listToSort.subList(lowerLimit, upperLimit)) {
            if (element < pivot) {
                listToSort = listUtils.swap(listToSort, i, j);
                i++;
            }
            j++;
        }

        listToSort = listUtils.swap(listToSort, i, upperLimit);

        return i;
    }
}
