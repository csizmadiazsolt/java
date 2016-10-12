package com.ezsocsi.textmunger.unittest;


import com.ezsocsi.textmunger.ArgParser;
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
        String[] arguments = {"1", "2"};
        assertFalse(argParser.parseArgs(arguments));
    }


    @Test
    public void returns_true_because_arguments_are_parsed_successfully() {
        String[] arguments = {"This a valid argument."};
        assertTrue(argParser.parseArgs(arguments));
        assertEquals("This a valid argument.", argParser.getInputText());
    }
}
