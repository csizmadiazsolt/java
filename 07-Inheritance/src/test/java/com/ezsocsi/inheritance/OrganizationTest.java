package com.ezsocsi.inheritance;


import com.ezsocsi.utils.RandomUtils;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class OrganizationTest {
    private Organization organization;
    private RandomUtils randomUtils;
    private EmployeeFactory employeeFactory;

    @Before
    public void setup() {
        randomUtils = mock(RandomUtils.class);
        employeeFactory = mock(EmployeeFactory.class);
        organization = new Organization(employeeFactory, randomUtils);

        when(randomUtils.generateRandomInRange(1, 10)).thenReturn(2);
        when(randomUtils.generateRandomInRange(1, 2)).thenReturn(1);
        when(randomUtils.generateRandomInRange(1, 4)).thenReturn(1);
        when(randomUtils.generateRandomInRange(1, 5)).thenReturn(1);

        Employee ceo = new CEO("CEO", 1000000.0);
        Employee manager0 = new Manager("Manager-0", 500000.0);
        Employee manager1 = new Manager("Manager-1", 500000.0);
        Employee secretary = new Secretary("Secretary-0", 250000.0);
        Employee javaDeveloper = new Developer("Java Developer-0", 700000.0, DeveloperTypes.JAVA_DEVELOPER);
        Employee cppDeveloper = new Developer("CPP Developer-0", 650000.0, DeveloperTypes.CPP_DEVELOPER);

        when(employeeFactory.getCEO("CEO", 1000000.0)).thenReturn(ceo);
        when(employeeFactory.getManager("Manager-0", 500000.0)).thenReturn(manager0);
        when(employeeFactory.getManager("Manager-1", 500000.0)).thenReturn(manager1);
        when(employeeFactory.getSecretary("Secretary-0", 250000.0)).thenReturn(secretary);
        when(employeeFactory.getJavaDeveloper("Java Developer-0", 700000.0)).thenReturn(javaDeveloper);
        when(employeeFactory.getCppDeveloper("CPP Developer-0", 650000.0)).thenReturn(cppDeveloper);
    }

    @Test
    public void verify_correct_organization_generation() {
        organization.generate();

        verify(randomUtils).generateRandomInRange(1, 10);
        verify(randomUtils).generateRandomInRange(1, 2);
        verify(randomUtils).generateRandomInRange(1, 4);
        verify(randomUtils).generateRandomInRange(1, 5);

        verify(employeeFactory).getCEO("CEO", 1000000.0);
        verify(employeeFactory).getManager("Manager-0", 500000.0);
        verify(employeeFactory).getManager("Manager-1", 500000.0);
        verify(employeeFactory).getSecretary("Secretary-0", 250000.0);
        verify(employeeFactory).getJavaDeveloper("Java Developer-0", 700000.0);
        verify(employeeFactory).getCppDeveloper("CPP Developer-0", 650000.0);
    }

    @Test
    public void returns_correct_ceo_after_generation() {
        organization.generate();

        assertEquals("CEO", organization.getCeo().getName());
        assertEquals(Double.valueOf(1000000.0), organization.getCeo().getSalary());
    }

    @Test
    public void returns_correct_manager_list_after_generation() {
        organization.generate();

        assertEquals("Manager-0", organization.getManagers().get(0).getName());
        assertEquals("Manager-1", organization.getManagers().get(1).getName());
        assertEquals(Double.valueOf(500000.0), organization.getManagers().get(0).getSalary());
        assertEquals(Double.valueOf(500000.0), organization.getManagers().get(0).getSalary());
    }

    @Test
    public void returns_correct_secretary_after_generation() {
        organization.generate();

        assertEquals("Secretary-0", organization.getSecretaries().get(0).getName());
        assertEquals(Double.valueOf(250000.0), organization.getSecretaries().get(0).getSalary());
    }

    @Test
    public void returns_correct_java_developer_after_generation() {
        organization.generate();

        assertEquals("Java Developer-0", organization.getJavaDevelopers().get(0).getName());
        assertEquals(Double.valueOf(700000.0), organization.getJavaDevelopers().get(0).getSalary());
    }

    @Test
    public void returns_correct_cpp_developer_after_generation() {
        organization.generate();

        assertEquals("CPP Developer-0", organization.getCppDevelopers().get(0).getName());
        assertEquals(Double.valueOf(650000.0), organization.getCppDevelopers().get(0).getSalary());
    }
}
