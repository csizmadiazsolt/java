package com.ezsocsi.quicksort;


import com.ezsocsi.utils.ListUtils;

import java.util.List;

class QuickSort {
    private ListUtils listUtils;

    QuickSort(ListUtils listUtils) {
        this.listUtils = listUtils;
    }

    List<Integer> quickSort(List<Integer> list) {
        quickSort(list, 0, list.size() - 1);

        return list;
    }

    private void quickSort(List<Integer> listToSort, int lowerLimit, int upperLimit) {
        int pivot;

        if (lowerLimit < upperLimit) {
            pivot = partition(listToSort, lowerLimit, upperLimit);
            quickSort(listToSort, lowerLimit, pivot - 1);
            quickSort(listToSort, pivot + 1, upperLimit);
        }
    }

    private int partition(List<Integer> listToSort, int lowerLimit, int upperLimit) {
        int pivot = listToSort.get(upperLimit);
        int i = lowerLimit;
        int j = lowerLimit;

        for (Integer element : listToSort.subList(lowerLimit, upperLimit)) {
            if (element < pivot) {
                listUtils.swap(listToSort, i, j);
                i++;
            }
            j++;
        }

        listUtils.swap(listToSort, i, upperLimit);

        return i;
    }
}
