package com.ezsocsi.fizzbuzz.unittest;


import com.ezsocsi.fizzbuzz.ArgParser;
import com.ezsocsi.utility.ArgUtility;
import com.ezsocsi.utility.ConverterUtility;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;

public class ArgParserTest {
    private ArgParser argParser;
    private ArgUtility argUtility;
    private ConverterUtility converterUtility;

    private static final int NUMBER_OF_ARGS = 2;
    private final static String[] ARGUMENTS_1 = {"1", "2", "3"};
    private final static String[] ARGUMENTS_2 = {"Not a number", "2"};
    private final static String[] ARGUMENTS_3 = {"4", "7"};


    @Before
    public void setup() {
        argUtility = mock(ArgUtility.class);
        converterUtility = mock(ConverterUtility.class);
        argParser = new ArgParser(argUtility, converterUtility);

        when(argUtility.checkNumberOfArgs(NUMBER_OF_ARGS, ARGUMENTS_1)).thenReturn(false);
        when(argUtility.checkNumberOfArgs(NUMBER_OF_ARGS, ARGUMENTS_2)).thenReturn(true);
        when(argUtility.checkNumberOfArgs(NUMBER_OF_ARGS, ARGUMENTS_3)).thenReturn(true);

        when(argUtility.getArgument(0, ARGUMENTS_2)).thenReturn(Optional.of("Not a number"));
        when(argUtility.getArgument(1, ARGUMENTS_2)).thenReturn(Optional.of("2"));

        when(argUtility.getArgument(0, ARGUMENTS_3)).thenReturn(Optional.of("4"));
        when(argUtility.getArgument(1, ARGUMENTS_3)).thenReturn(Optional.of("7"));

        when(converterUtility.stringToInteger("Not a number")).thenReturn(Optional.empty());
        when(converterUtility.stringToInteger("2")).thenReturn(Optional.of(2));
        when(converterUtility.stringToInteger("4")).thenReturn(Optional.of(4));
        when(converterUtility.stringToInteger("7")).thenReturn(Optional.of(7));
    }

    @Test
    public void returns_false_because_of_too_much_arguments() {
        assertFalse(argParser.parseArgs(ARGUMENTS_1));
    }

    @Test
    public void returns_false_because_the_argument_is_not_numeral() {
        assertFalse(argParser.parseArgs(ARGUMENTS_2));
    }

    @Test
    public void returns_true_because_arguments_are_parsed_successfully() {
        assertTrue(argParser.parseArgs(ARGUMENTS_3));
        assertEquals(Integer.valueOf(4), argParser.getLowerLimit().get());
        assertEquals(Integer.valueOf(7), argParser.getUpperLimit().get());
    }
}
