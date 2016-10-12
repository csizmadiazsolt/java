package com.ezsocsi.fizzbuzz.integrationtest;


import com.ezsocsi.fizzbuzz.Main;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class MainTest {
    private ByteArrayOutputStream stdout = new ByteArrayOutputStream();
    private ByteArrayOutputStream stderr = new ByteArrayOutputStream();

    @Before
    public void setup() {
        System.setOut(new PrintStream(stdout));
        System.setErr(new PrintStream(stderr));
    }

    @After
    public void teardown() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void successful_fizz_buzz_execution() {
        Main.main("4", "7");

        assertEquals("4, Buzz, Fizz, 7" + System.lineSeparator(), stdout.toString());
        assertEquals("", stderr.toString());
    }

    @Test
    public void unsuccessful_fizz_buzz_execution_due_to_wrong_arguments() {
        Main.main("4");

        assertEquals("", stdout.toString());
        assertEquals("ERROR: unable to parse arguments, expected: <int> <int>." + System.lineSeparator(), stderr.toString());
    }
}
