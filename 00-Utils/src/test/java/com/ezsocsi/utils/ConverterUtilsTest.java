package com.ezsocsi.utils;


import org.junit.Before;
import org.junit.Test;

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
}
