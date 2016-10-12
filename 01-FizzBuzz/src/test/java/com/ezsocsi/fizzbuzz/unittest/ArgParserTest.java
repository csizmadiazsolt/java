package com.ezsocsi.fizzbuzz.unittest;


import com.ezsocsi.fizzbuzz.ArgParser;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ArgParserTest {
    ArgParser argParser;

    @Before
    public void setup() {
        argParser = new ArgParser();
    }

    @Test
    public void returns_false_because_of_too_much_arguments() {
        String[] arguments = {"1", "2", "3"};
        assertFalse(argParser.parseArgs(arguments));
    }

    @Test
    public void returns_false_because_the_argument_is_not_numeral() {
        String[] arguments = {"Not a number", "2"};
        assertFalse(argParser.parseArgs(arguments));
    }

    @Test
    public void returns_true_because_arguments_are_parsed_successfully() {
        String[] arguments = {"4", "7"};
        assertTrue(argParser.parseArgs(arguments));
        assertEquals(Integer.valueOf(4), argParser.getLowerLimit().get());
        assertEquals(Integer.valueOf(7), argParser.getUpperLimit().get());
    }
}
