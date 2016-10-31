package com.ezsocsi.quicksort;


import com.ezsocsi.utils.ConsoleUtils;

import java.util.List;

class QuickSorter {
    private final QuickSort quickSort;
    private final ConsoleUtils consoleUtils;
    private final ArgParser argParser;

    QuickSorter(QuickSort quickSort, ConsoleUtils consoleUtils, ArgParser argParser) {
        this.quickSort = quickSort;
        this.consoleUtils = consoleUtils;
        this.argParser = argParser;
    }

    void sort(String... args) {
        if (argParser.parseArgs(args)) {
            List<Integer> listToSort = argParser.getInputList();

            List<Integer> sortedList = quickSort.quickSort(listToSort);

            consoleUtils.printlnList(sortedList, " ");
        } else {
            consoleUtils.printlnError("unable to parse arguments, expected: \"<num> <num> <num> ...\".");
        }
    }
}
