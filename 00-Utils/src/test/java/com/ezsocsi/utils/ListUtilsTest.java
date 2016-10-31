package com.ezsocsi.utils;


import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

public class ListUtilsTest {
    private ListUtils listUtils;

    @Before
    public void setup() {
        listUtils = new ListUtils();
    }

    @Test
    public void verify_correct_shuffle_behaviour() {
        List<Character> inputWord = TestUtils.stringToCharList("bronx");

        listUtils.shuffle(inputWord, 1, 3);

        int letterCounter = inputWord.indexOf('b') + inputWord.indexOf('r')
                + inputWord.indexOf('o') + inputWord.indexOf('n') + inputWord.indexOf('x');

        assertEquals(10, letterCounter);
    }

    @Test
    public void verify_correct_swap_behaviour() {
        List<Integer> input = Arrays.asList(1, 2, 3);
        List<Integer> expected = Arrays.asList(3, 2, 1);

        listUtils.swap(input, 0, 2);

        assertEquals(expected, input);
    }

    @Test
    public void returns_valid_concatenated_text() {
        List<String> input = Arrays.asList("this", "has", "to", "be", "Concatenated");
        String expected = "this has to be Concatenated";

        assertEquals(expected, listUtils.concatenateList(input, " "));
    }
}
