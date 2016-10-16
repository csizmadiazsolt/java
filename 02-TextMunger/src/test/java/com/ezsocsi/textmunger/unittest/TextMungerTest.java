package com.ezsocsi.textmunger.unittest;


import com.ezsocsi.textmunger.ArgParser;
import com.ezsocsi.textmunger.Munger;
import com.ezsocsi.textmunger.TextMunger;
import com.ezsocsi.utility.ConsoleUtility;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TextMungerTest {
    private ArgParser argParser;
    private ConsoleUtility console;
    private TextMunger textMunger;

    private static final String INPUT_TEXT = "some text for example";
    private static final String EXPECTED_TEXT = "smoe txet for eaxmple";
    private static final String EXPECTED_ERROR_MESSAGE = "unable to parse arguments, expected: <string>.";

    @Before
    public void setup() {
        argParser = mock(ArgParser.class);
        Munger munger = mock(Munger.class);
        console = mock(ConsoleUtility.class);
        textMunger = new TextMunger(munger, console, argParser);

        when(argParser.getInputText()).thenReturn(INPUT_TEXT);
        when(munger.munge(INPUT_TEXT)).thenReturn(EXPECTED_TEXT);
    }

    @Test
    public void returns_correctly_munged_text() {
        when(argParser.parseArgs(INPUT_TEXT)).thenReturn(true);

        textMunger.mungeText(INPUT_TEXT);

        verify(console).println(EXPECTED_TEXT);
    }

    @Test
    public void returns_argument_parse_error() {
        when(argParser.parseArgs(INPUT_TEXT)).thenReturn(false);

        textMunger.mungeText(INPUT_TEXT);

        verify(console).printlnError(EXPECTED_ERROR_MESSAGE);
    }
}
