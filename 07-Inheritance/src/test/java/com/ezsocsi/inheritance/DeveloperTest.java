package com.ezsocsi.inheritance;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeveloperTest {
    private Developer javaDeveloper;
    private Developer cppDeveloper;

    @Before
    public void setup() {
        javaDeveloper = new Developer("JavaDeveloper", 3.0, DeveloperTypes.JAVA_DEVELOPER);
        cppDeveloper = new Developer("CppDeveloper", 3.0, DeveloperTypes.CPP_DEVELOPER);
    }

    @Test
    public void verify_java_and_cpp_developers_do_their_correct_occupations() {
        assertEquals("JavaDeveloper develops JAVA.", javaDeveloper.doTheJob());
        assertEquals("CppDeveloper develops C++.", cppDeveloper.doTheJob());
    }

    @Test
    public void get_name_returns_correct_names() {
        assertEquals("JavaDeveloper", javaDeveloper.getName());
        assertEquals("CppDeveloper", cppDeveloper.getName());
    }

    @Test
    public void get_salary_returns_correct_salary() {
        assertEquals(Double.valueOf(3.0), javaDeveloper.getSalary());
        assertEquals(Double.valueOf(3.0), cppDeveloper.getSalary());
    }

    @Test
    public void get_superiors_returns_correct_amount_of_superiors() {
        CEO ceo = new CEO("CEO", 5.0);

        javaDeveloper.addSuperior(ceo);
        cppDeveloper.addSuperior(ceo);

        assertEquals(1, javaDeveloper.getSuperiors().size());
        assertEquals(1, cppDeveloper.getSuperiors().size());
    }
}
