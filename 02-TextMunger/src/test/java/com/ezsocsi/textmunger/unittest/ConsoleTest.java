package com.ezsocsi.textmunger.unittest;


import com.ezsocsi.textmunger.Console;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

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
    public void console_prints_simple_text() {
        console = new Console();

        System.setOut(printStream);
        console.println("simple text");

        verify(printStream).println("simple text");
    }

    @Test
    public void console_prints_error_message() {
        console = new Console();

        System.setErr(printStream);
        console.printlnError("error message");

        verify(printStream).println("ERROR: error message");
    }
}
