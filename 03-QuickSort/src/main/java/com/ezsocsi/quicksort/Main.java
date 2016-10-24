package com.ezsocsi.quicksort;


import com.ezsocsi.utils.ArgUtils;
import com.ezsocsi.utils.ConsoleUtils;
import com.ezsocsi.utils.ConverterUtils;

public class Main {
    public static void main(String... args) {
        QuickSort quickSort = new QuickSort();
        ConsoleUtils consoleUtils = new ConsoleUtils();
        ConverterUtils converterUtils = new ConverterUtils();
        ArgUtils argUtils = new ArgUtils();
        ArgParser argParser = new ArgParser(argUtils, converterUtils);
        QuickSorter quickSorter = new QuickSorter(quickSort, consoleUtils, argParser);

        quickSorter.sort(args);
    }
}