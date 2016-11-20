package com.ezsocsi.inheritance;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SecretaryTest {
    private Secretary secretary;

    @Before
    public void setup() {
        secretary = new Secretary("Secretary", 2.0);
    }

    @Test
    public void do_the_job_returns_correct_occupation() {
        assertEquals("Secretary orders stuff.", secretary.doTheJob());
    }

    @Test
    public void get_name_returns_correct_names() {
        assertEquals("Secretary", secretary.getName());
    }

    @Test
    public void get_salary_returns_correct_salary() {
        assertEquals(Double.valueOf(2.0), secretary.getSalary());
    }

    @Test
    public void get_superiors_returns_correct_amount_of_superiors() {
        CEO ceo = new CEO("CEO", 5.0);

        secretary.addSuperior(ceo);

        assertEquals(1, secretary.getSuperiors().size());
    }
}
