package com.ezsocsi.projecteuler1;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    private Calculator calculator;

    @Before
    public void setup() {
        calculator = new Calculator();
    }

    @Test
    public void calculates_and_prints_23_for_10_as_input() {
        assertEquals(23, calculator.calculateProjectEuler1(10));
    }

    @Test
    public void calculates_and_prints_2318_for_100_as_input() {
        assertEquals(2318, calculator.calculateProjectEuler1(100));
    }

    @Test
    public void calculates_and_prints_23_for_1000_as_input() {
        assertEquals(233168, calculator.calculateProjectEuler1(1000));
    }
}
