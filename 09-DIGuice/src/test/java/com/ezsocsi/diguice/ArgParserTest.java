package com.ezsocsi.diguice;


import com.ezsocsi.utils.ArgUtils;
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

    private static final int NUMBER_OF_ARGS = 1;
    private final static String[] ARGUMENTS_1 = {"1", "2"};
    private final static String[] ARGUMENTS_2 = {"This a valid argument."};

    @Before
    public void setup() {
        ArgUtils argUtils = mock(ArgUtils.class);
        argParser = new ArgParser(argUtils);

        when(argUtils.checkNumberOfArgs(NUMBER_OF_ARGS, ARGUMENTS_1)).thenReturn(false);
        when(argUtils.checkNumberOfArgs(NUMBER_OF_ARGS, ARGUMENTS_2)).thenReturn(true);

        when(argUtils.getArgument(0, ARGUMENTS_2)).thenReturn(Optional.of("This a valid argument."));
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
