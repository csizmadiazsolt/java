package com.ezsocsi.fizzbuzz.unittest;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.ezsocsi.fizzbuzz.ArgParser;
import com.ezsocsi.fizzbuzz.Console;
import com.ezsocsi.fizzbuzz.FizzBuzz;
import com.ezsocsi.fizzbuzz.FizzBuzzGenerator;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class FizzBuzzTest {
    private ArgParser argParser;
    private FizzBuzzGenerator fizzBuzzGenerator;
    private Console console;

    @Before
    public void setup() {
        argParser = mock(ArgParser.class);
        fizzBuzzGenerator = mock(FizzBuzzGenerator.class);
        console = mock(Console.class);

        Optional<Integer> lowerLimit = Optional.of(Integer.valueOf(4));
        Optional<Integer> upperLimit = Optional.of(Integer.valueOf(7));
        List<String> generatedList = Arrays.asList("4", "Buzz", "Fizz", "7");

        when(argParser.getLowerLimit()).thenReturn(lowerLimit);
        when(argParser.getUpperLimit()).thenReturn(upperLimit);
        when(fizzBuzzGenerator.generate(lowerLimit.get(), upperLimit.get())).thenReturn(generatedList);
    }

    @Test
    public void returns_correct_fizz_buzz_list() {
        FizzBuzz fizzBuzz = new FizzBuzz(argParser, fizzBuzzGenerator, console);
        List<String> generatedList = Arrays.asList("4", "Buzz", "Fizz", "7");
        when(argParser.parseArgs("4", "7")).thenReturn(true);

        fizzBuzz.fizzBuzz("4", "7");

        verify(console).printlnList(generatedList, ", ");
    }

    @Test
    public void returns_argument_parse_error() {
        FizzBuzz fizzBuzz = new FizzBuzz(argParser, fizzBuzzGenerator, console);
        when(argParser.parseArgs("4", "7")).thenReturn(false);

        fizzBuzz.fizzBuzz("4", "7");

        verify(console).printlnError("unable to parse arguments, expected: <int> <int>.");
    }
}
