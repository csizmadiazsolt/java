package com.ezsocsi.utility;


import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ConsoleUtilityTest {
    private ConsoleUtility consoleUtility;
    private PrintStream printStream;

    @Before
    public void setup() {
        printStream = mock(PrintStream.class);
        consoleUtility = new ConsoleUtility();
    }

    @Test
    public void console_print_text() {
        System.setOut(printStream);
        consoleUtility.print("some text to the output");

        verify(printStream).print("some text to the output");
    }

    @Test
    public void console_println_text() {
        System.setOut(printStream);
        consoleUtility.println("some text to the output");

        verify(printStream).println("some text to the output");
    }

    @Test
    public void console_print_concatenated_list() {
        String separator = ", ";
        List<String> inputList = Arrays.asList("1", "2", "3", "4", "789");
        String expectedOutput = "1, 2, 3, 4, 789";

        System.setOut(printStream);
        consoleUtility.printList(inputList, separator);

        verify(printStream).print(expectedOutput);
    }

    @Test
    public void console_println_concatenated_list() {
        String separator = ", ";
        List<String> inputList = Arrays.asList("1", "2", "3", "4", "789");
        String expectedOutput = "1, 2, 3, 4, 789";

        System.setOut(printStream);
        consoleUtility.printlnList(inputList, separator);

        verify(printStream).println(expectedOutput);
    }

    @Test
    public void console_print_error_message() {
        System.setErr(printStream);
        consoleUtility.printError("error message");

        verify(printStream).print("ERROR: error message");
    }

    @Test
    public void console_println_error_message() {
        System.setErr(printStream);
        consoleUtility.printlnError("error message");

        verify(printStream).println("ERROR: error message");
    }
}