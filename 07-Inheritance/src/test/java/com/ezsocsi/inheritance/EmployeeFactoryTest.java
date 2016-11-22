package com.ezsocsi.inheritance;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class EmployeeFactoryTest {
    private EmployeeFactory employeeFactory;

    @Before
    public void setup() {
        employeeFactory = new EmployeeFactory();
    }

    @Test
    public void verify_that_the_right_ceo_is_created() {
        assertTrue(employeeFactory.getCEO("CEO", 5.0) instanceof CEO);
    }

    @Test
    public void verify_that_the_right_secretary_is_created() {
        assertTrue(employeeFactory.getSecretary("Secretary", 2.0) instanceof Secretary);
    }

    @Test
    public void verify_that_the_right_manager_is_created() {
        assertTrue(employeeFactory.getManager("Manager", 4.0) instanceof Manager);
    }

    @Test
    public void verify_that_the_right_cpp_developer_is_created() {
        assertTrue(employeeFactory.getCppDeveloper("CppDeveloper", 3.0) instanceof Developer);
    }

    @Test
    public void verify_that_the_right_java_developer_is_created() {
        assertTrue(employeeFactory.getJavaDeveloper("JavaDeveloper", 3.0) instanceof Developer);
    }
}
