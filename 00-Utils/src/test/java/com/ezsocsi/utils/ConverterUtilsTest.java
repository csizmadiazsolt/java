package com.ezsocsi.utils;


import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class ConverterUtilsTest {
    private ConverterUtils converterUtils;

    @Before
    public void setup() {
        converterUtils = new ConverterUtils();
    }

    @Test
    public void successful_string_to_integer_transformation() {
        assertEquals(Optional.of(1678), converterUtils.stringToInteger("1678"));
    }

    @Test
    public void unsuccessful_string_to_integer_transformation() {
        assertEquals(Optional.empty(), converterUtils.stringToInteger("Not a valid input"));
    }

    @Test
    public void successful_complete_string_list_to_integer_list_transformation() {
        List<String> input = Arrays.asList("1", "2", "3", "6");
        List<Integer> expected = Arrays.asList(1, 2, 3, 6);

        assertEquals(expected, converterUtils.stringListToIntegerList(input));
    }

    @Test
    public void successful_partial_string_list_to_integer_list_transformation() {
        List<String> input = Arrays.asList("1", "2", "3", "6", "somethingelse", "9");
        List<Integer> expected = Arrays.asList(1, 2, 3, 6, 9);

        assertEquals(expected, converterUtils.stringListToIntegerList(input));
    }
}
