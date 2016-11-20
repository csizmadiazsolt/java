package com.ezsocsi.inheritance;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CEOTest {
    private CEO ceo;

    @Before
    public void setup() {
        ceo = new CEO("CEO", 5.0);
    }

    @Test
    public void do_the_job_returns_correct_occupation() {
        assertEquals("CEO tells the vision.", ceo.doTheJob());
    }

    @Test
    public void get_name_returns_correct_name() {
        assertEquals("CEO", ceo.getName());
    }

    @Test
    public void get_salary_returns_correct_salary() {
        assertEquals(Double.valueOf(5.0), ceo.getSalary());
    }

    @Test
    public void get_superiors_returns_correct_amount_of_superiors() {
        assertEquals(0, ceo.getSuperiors().size());
    }
}
