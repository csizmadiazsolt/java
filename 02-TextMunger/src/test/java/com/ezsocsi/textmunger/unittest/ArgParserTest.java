package com.ezsocsi.textmunger.unittest;


import com.ezsocsi.textmunger.ArgParser;
import com.ezsocsi.utility.ArgUtility;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ArgParserTest {
    private ArgParser argParser;
    private ArgUtility argUtility;

    private static final int NUMBER_OF_ARGS = 1;
    private final static String[] ARGUMENTS_1 = {"1", "2"};
    private final static String[] ARGUMENTS_2 = {"This a valid argument."};

    @Before
    public void setup() {
        argUtility = mock(ArgUtility.class);
        argParser = new ArgParser(argUtility);

        when(argUtility.checkNumberOfArgs(NUMBER_OF_ARGS, ARGUMENTS_1)).thenReturn(false);
        when(argUtility.checkNumberOfArgs(NUMBER_OF_ARGS, ARGUMENTS_2)).thenReturn(true);

        when(argUtility.getArgument(0, ARGUMENTS_2)).thenReturn(Optional.of("This a valid argument."));
    }

    @Test
    public void returns_false_because_of_too_much_arguments() {
        assertFalse(argParser.parseArgs(ARGUMENTS_1));
    }


    @Test
    public void returns_true_because_arguments_are_parsed_successfully() {
        assertTrue(argParser.parseArgs(ARGUMENTS_2));
        assertEquals("This a valid argument.", argParser.getInputText());
    }
}
