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

    PrintStream out;

    @Before
    public void setup() {
        out = mock(PrintStream.class);
        System.setOut(out);
    }

    @Test
    public void console_prints_concatenated_list() {
        Console console = new Console();
        String separator = ", ";
        List<String> inputList = Arrays.asList("1", "2", "3", "4", "789");
        String expectedOutput = "1, 2, 3, 4, 789";

        console.printlnList(inputList, separator);

        verify(out).println(expectedOutput);
    }
}