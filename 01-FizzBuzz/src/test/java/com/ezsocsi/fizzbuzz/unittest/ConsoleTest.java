package com.ezsocsi.fizzbuzz.unittest;


import com.ezsocsi.fizzbuzz.Console;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ConsoleTest {
    Console console;
    PrintStream printStream;

    @Before
    public void setup() {
        printStream = mock(PrintStream.class);
    }

    @Test
    public void console_prints_concatenated_list() {
        console = new Console();
        String separator = ", ";
        List<String> inputList = Arrays.asList("1", "2", "3", "4", "789");
        String expectedOutput = "1, 2, 3, 4, 789";

        System.setOut(printStream);
        console.printlnList(inputList, separator);

        verify(printStream).println(expectedOutput);
    }

    @Test
    public void console_prints_error_message() {
        console = new Console();

        System.setErr(printStream);
        console.printlnError("error message");

        verify(printStream).println("ERROR: error message");
    }
}