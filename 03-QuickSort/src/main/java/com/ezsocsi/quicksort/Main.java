package com.ezsocsi.quicksort;


import com.ezsocsi.utils.ArgUtils;
import com.ezsocsi.utils.ConsoleUtils;
import com.ezsocsi.utils.ConverterUtils;
import com.ezsocsi.utils.ListUtils;

public class Main {
    private Main() {
    }

    public static void main(String... args) {
        ListUtils listUtils = new ListUtils();
        QuickSort quickSort = new QuickSort(listUtils);
        ConsoleUtils consoleUtils = new ConsoleUtils(listUtils);
        ConverterUtils converterUtils = new ConverterUtils();
        ArgUtils argUtils = new ArgUtils();
        ArgParser argParser = new ArgParser(argUtils, converterUtils);
        QuickSorter quickSorter = new QuickSorter(quickSort, consoleUtils, argParser);

        quickSorter.sort(args);
    }
}