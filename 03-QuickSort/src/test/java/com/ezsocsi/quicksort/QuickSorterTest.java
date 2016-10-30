package com.ezsocsi.quicksort;


import com.ezsocsi.utils.ConsoleUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class QuickSorterTest {
    private ArgParser argParser;
    private ConsoleUtils consoleUtils;
    private QuickSorter quickSorter;

    private static final String INPUT_TEXT = "1 56 78 88 23";
    private static final List<Integer> INPUT_ELEMENTS = Arrays.asList(1, 56, 78, 88, 23);
    private static final List<Integer> EXPECTED_ELEMENTS = Arrays.asList(1, 23, 56, 78, 88);
    private static final String EXPECTED_ERROR_MESSAGE = "unable to parse arguments, " +
            "expected: \"<num> <num> <num> ...\".";

    @Before
    public void setup() {
        QuickSort quickSort = mock(QuickSort.class);
        argParser = mock(ArgParser.class);
        consoleUtils = mock(ConsoleUtils.class);
        quickSorter = new QuickSorter(quickSort, consoleUtils, argParser);

        when(argParser.getInputList()).thenReturn(INPUT_ELEMENTS);
        when(quickSort.quickSort(INPUT_ELEMENTS)).thenReturn(EXPECTED_ELEMENTS);
    }

    @Test
    public void prints_correctly_sorted_list() {
        when(argParser.parseArgs(INPUT_TEXT)).thenReturn(true);

        quickSorter.sort(INPUT_TEXT);

        verify(consoleUtils).printlnList(EXPECTED_ELEMENTS, " ");
    }

    @Test
    public void prints_parse_error_when_arguments_are_wrong() {
        when(argParser.parseArgs(INPUT_TEXT)).thenReturn(false);

        quickSorter.sort(INPUT_TEXT);

        verify(consoleUtils).printlnError(EXPECTED_ERROR_MESSAGE);
    }
}
