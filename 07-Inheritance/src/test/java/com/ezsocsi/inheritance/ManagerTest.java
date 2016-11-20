package com.ezsocsi.inheritance;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ManagerTest {
    private Manager manager;

    @Before
    public void setup() {
        manager = new Manager("Manager", 4.0);
    }

    @Test
    public void do_the_job_returns_correct_occupation() {
        assertEquals("Manager tells the direction.", manager.doTheJob());
    }

    @Test
    public void get_name_returns_correct_names() {
        assertEquals("Manager", manager.getName());
    }

    @Test
    public void get_salary_returns_correct_salary() {
        assertEquals(Double.valueOf(4.0), manager.getSalary());
    }

    @Test
    public void get_superiors_returns_correct_amount_of_superiors() {
        CEO ceo = new CEO("CEO", 5.0);

        manager.addSuperior(ceo);

        assertEquals(1, manager.getSuperiors().size());
    }
}
