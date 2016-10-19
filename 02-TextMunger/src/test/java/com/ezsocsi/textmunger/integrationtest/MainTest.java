package com.ezsocsi.textmunger.integrationtest;


import com.ezsocsi.textmunger.Main;

import com.ezsocsi.utils.IntegrationTestUtils;
import org.junit.Test;

import java.util.regex.Pattern;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

public class MainTest extends IntegrationTestUtils {
    @Test
    public void prints_error_when_no_arguments() {
        Main.main();

        assertEquals("", stdout.toString());
        assertEquals("ERROR: unable to parse arguments, expected: <string>." + System.lineSeparator(),
                stderr.toString());
    }

    @Test
    public void prints_these_are_a_few_words() {
        String pattern = "t.*e a.*e a f.*w w.*s" + System.lineSeparator();
        String input = "these are a few words";

        Main.main(input);

        assertTrue(Pattern.matches(pattern, stdout.toString()));
    }

    @Test
    public void prints_a_long_and_complex_sentence() {
        String pattern = "T.*s is a n.*l s.*e a.*d my e.*n is to h.*e a d.*t o.*t, i.*n't it a n.*e e.*n?"
                + System.lineSeparator();
        String input = "This is a normal sentence and my expectation is" +
                " to have a decent output, isn't it a nice expectation?";

        Main.main(input);

        assertTrue(Pattern.matches(pattern, stdout.toString()));
    }
}
