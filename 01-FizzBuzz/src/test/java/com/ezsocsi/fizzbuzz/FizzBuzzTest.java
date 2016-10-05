package com.ezsocsi.fizzbuzz;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FizzBuzzTest {

    @Test
    public void fizz_buzz_generator_returns_correct_list_between_1_and_15() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        List<String> expectedOutput = Arrays.asList("1", "2", "Fizz", "4", "Buzz", "Fizz",
                "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz");

        assertEquals(expectedOutput, fizzBuzz.generateFizzBuzzList(1, 15));
    }

    @Test
    public void fizz_buzz_generator_returns_correct_list_between_4_and_7() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        List<String> expectedOutput = Arrays.asList("4", "Buzz", "Fizz", "7");

        assertEquals(expectedOutput, fizzBuzz.generateFizzBuzzList(4, 7));
    }

    @Test
    public void fizz_buzz_generator_returns_correct_list_between_5_and_5() {
        FizzBuzz fizzBuzz = new FizzBuzz();
        List<String> expectedOutput = Arrays.asList("Buzz");

        assertEquals(expectedOutput, fizzBuzz.generateFizzBuzzList(5, 5));
    }
}
