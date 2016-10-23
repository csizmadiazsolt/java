package com.ezsocsi.quicksort;


import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

public class Main {

    public static void main(String... args) {
        List<Integer> myList = new ArrayList<>(Arrays.asList(3, 7, 8, 5, 2, 1, 9, 5, 4));
        QuickSort alma = new QuickSort();

        alma.quickSort(myList);

        System.out.println(myList);
    }


}