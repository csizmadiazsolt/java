package com.ezsocsi.projecteuler1;


import com.ezsocsi.utils.ConsoleUtils;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ProjectEuler1Test {
    private ArgParser argParser;
    private ConsoleUtils consoleUtils;
    private ProjectEuler1 projectEuler1;

    private static final Integer INPUT = 10;
    private static final String INPUT_TEXT = "10";
    private static final Integer EXPECTED_VALUE = 23;
    private static final String EXPECTED_VALUE_TEXT = "23";
    private static final String EXPECTED_ERROR_MESSAGE = "unable to parse arguments, expected: <number>.";

    @Before
    public void setup() {
        Calculator calculator = mock(Calculator.class);
        argParser = mock(ArgParser.class);
        consoleUtils = mock(ConsoleUtils.class);
        projectEuler1 = new ProjectEuler1(calculator, consoleUtils, argParser);

        when(argParser.getInput()).thenReturn(INPUT);
        when(calculator.calculateProjectEuler1(INPUT)).thenReturn(EXPECTED_VALUE);
    }

    @Test
    public void prints_correctly_calculated_value() {
        when(argParser.parseArgs(INPUT_TEXT)).thenReturn(true);

        projectEuler1.calculate(INPUT_TEXT);

        verify(consoleUtils).println(EXPECTED_VALUE_TEXT);
    }

    @Test
    public void prints_parse_error_when_arguments_are_wrong() {
        when(argParser.parseArgs(INPUT_TEXT)).thenReturn(false);

        projectEuler1.calculate(INPUT_TEXT);

        verify(consoleUtils).printlnError(EXPECTED_ERROR_MESSAGE);
    }
}
