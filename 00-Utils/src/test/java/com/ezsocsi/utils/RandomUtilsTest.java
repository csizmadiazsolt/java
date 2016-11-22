package com.ezsocsi.utils;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RandomUtilsTest {
    private RandomUtils randomUtils;

    @Before
    public void setup() {
        randomUtils = new RandomUtils();
    }

    @Test
    public void successful_random_number_generation() {
        int rand = randomUtils.generateRandomInRange(7, 11);
        assertTrue(rand >= 7 && rand <= 11);
    }
}
