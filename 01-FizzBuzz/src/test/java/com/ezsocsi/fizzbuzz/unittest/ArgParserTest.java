package com.ezsocsi.fizzbuzz.unittest;

import com.ezsocsi.fizzbuzz.ArgParser;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArgParserTest {
    ArgParser argParser;

    @Test
    public void returns_false_because_of_too_much_arguments() {
        argParser = new ArgParser();
        String[] arguments = {"1", "2", "3"};

        assertEquals(false, argParser.parseArgs(arguments));
    }

    @Test
    public void returns_false_because_the_argument_is_not_numeral() {
        argParser = new ArgParser();
        String[] arguments = {"Not a number", "2"};

        assertEquals(false, argParser.parseArgs(arguments));
    }

    @Test
    public void returns_true_because_arguments_are_parsed_successfully() {
        argParser = new ArgParser();
        String[] arguments = {"4", "7"};

        assertEquals(true, argParser.parseArgs(arguments));
        assertEquals(Integer.valueOf(4), argParser.getLowerLimit().get());
        assertEquals(Integer.valueOf(7), argParser.getUpperLimit().get());
    }
}
