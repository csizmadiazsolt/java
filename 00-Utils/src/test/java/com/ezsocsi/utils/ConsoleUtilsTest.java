package com.ezsocsi.utils;


import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ConsoleUtilsTest {
    private ConsoleUtils consoleUtils;
    private PrintStream printStream;
    private ListUtils listUtils;

    @Before
    public void setup() {
        printStream = mock(PrintStream.class);
        listUtils = mock(ListUtils.class);
        consoleUtils = new ConsoleUtils(listUtils);
    }

    @Test
    public void console_print_text() {
        System.setOut(printStream);
        consoleUtils.print("some text to the output");

        verify(printStream).print("some text to the output");
    }

    @Test
    public void console_println_text() {
        System.setOut(printStream);
        consoleUtils.println("some text to the output");

        verify(printStream).println("some text to the output");
    }

    @Test
    public void console_print_concatenated_list() {
        String separator = ", ";
        List<String> inputList = Arrays.asList("1", "2", "3", "4", "789");
        String expectedOutput = "1, 2, 3, 4, 789";

        when(listUtils.concatenateList(inputList, separator)).thenReturn("1, 2, 3, 4, 789");

        System.setOut(printStream);
        consoleUtils.printList(inputList, separator);

        verify(printStream).print(expectedOutput);
    }

    @Test
    public void console_println_concatenated_list() {
        String separator = ", ";
        List<String> inputList = Arrays.asList("1", "2", "3", "4", "789");
        String expectedOutput = "1, 2, 3, 4, 789";

        when(listUtils.concatenateList(inputList, separator)).thenReturn("1, 2, 3, 4, 789");

        System.setOut(printStream);
        consoleUtils.printlnList(inputList, separator);

        verify(printStream).println(expectedOutput);
    }

    @Test
    public void console_print_error_message() {
        System.setErr(printStream);
        consoleUtils.printError("error message");

        verify(printStream).print("ERROR: error message");
    }

    @Test
    public void console_println_error_message() {
        System.setErr(printStream);
        consoleUtils.printlnError("error message");

        verify(printStream).println("ERROR: error message");
    }
}