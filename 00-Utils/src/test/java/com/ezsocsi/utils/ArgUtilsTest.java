package com.ezsocsi.utils;


import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ArgUtilsTest {
    private ArgUtils argUtils;

    @Before
    public void setup() {
        argUtils = new ArgUtils();
    }

    @Test
    public void correct_number_of_arguments_found() {
        String[] arguments = {"1", "2"};
        int expectedNumberOfArguments = 2;

        assertTrue(argUtils.checkNumberOfArgs(expectedNumberOfArguments, arguments));
    }

    @Test
    public void incorrect_number_of_arguments_found() {
        String[] arguments = {"1", "2"};
        int expectedNumberOfArguments = 1;

        assertFalse(argUtils.checkNumberOfArgs(expectedNumberOfArguments, arguments));
    }

    @Test
    public void successful_argument_fetch() {
        String[] arguments = {"apfel", "schadlingbekampfungsmittel"};
        Optional<String> expectedArgument = Optional.of("schadlingbekampfungsmittel");

        assertEquals(expectedArgument, argUtils.getArgument(1, arguments));
    }

    @Test
    public void unsuccessful_argument_fetch() {
        String[] arguments = {"schadlingbekampfungsmittel"};
        Optional<String> expectedArgument = Optional.empty();

        assertEquals(expectedArgument, argUtils.getArgument(2, arguments));
    }
}
