package com.ezsocsi.utility;


import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class ConverterUtilityTest {
    private ConverterUtility converterUtility;

    @Before
    public void setup() {
        converterUtility = new ConverterUtility();
    }

    @Test
    public void successful_string_to_integer_transformation() {
        assertEquals(Optional.of(1678), converterUtility.stringToInteger("1678"));
    }

    @Test
    public void unsuccessful_string_to_integer_transformation() {
        assertEquals(Optional.empty(), converterUtility.stringToInteger("Not a valid input"));
    }
}
