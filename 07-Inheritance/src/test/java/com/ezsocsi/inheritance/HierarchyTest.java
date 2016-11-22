package com.ezsocsi.inheritance;


import com.ezsocsi.utils.RandomUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

public class HierarchyTest {
    private Hierarchy hierarchy;
    private RandomUtils randomUtils;
    private Organization organization;

    @Before
    public void setup() {
        randomUtils = mock(RandomUtils.class);
        organization = mock(Organization.class);
        hierarchy = new Hierarchy(organization, randomUtils);

        Employee ceo = new CEO("TestCEO", 5.0);
        List<Employee> managers = Collections.singletonList(new Manager("Manager", 2.0));
        List<Employee> secretaries = Collections.singletonList(new Secretary("Secretary", 1.0));

        Employee javaDeveloper1 = new Developer("JavaDeveloper1", 3.0, DeveloperTypes.JAVA_DEVELOPER);
        Employee javaDeveloper2 = new Developer("JavaDeveloper2", 3.0, DeveloperTypes.JAVA_DEVELOPER);

        Employee cppDeveloper1 = new Developer("CppDeveloper1", 3.0, DeveloperTypes.CPP_DEVELOPER);
        Employee cppDeveloper2 = new Developer("CppDeveloper2", 3.0, DeveloperTypes.CPP_DEVELOPER);

        List<Employee> javaDevelopers = Arrays.asList(javaDeveloper1, javaDeveloper2);
        List<Employee> cppDevelopers = Arrays.asList(cppDeveloper1, cppDeveloper2);

        when(organization.getCeo()).thenReturn(ceo);
        when(organization.getManagers()).thenReturn(managers);
        when(organization.getSecretaries()).thenReturn(secretaries);
        when(organization.getJavaDevelopers()).thenReturn(javaDevelopers);
        when(organization.getCppDevelopers()).thenReturn(cppDevelopers);
    }

    @Test
    public void verify_correct_organization_build() {
        hierarchy.build();

        verify(organization, times(4)).getCeo();
        verify(organization, times(4)).getSecretaries();
        verify(organization, times(2)).getJavaDevelopers();
        verify(organization, times(2)).getCppDevelopers();
        verify(organization, times(6)).getManagers();
        verify(randomUtils, times(4)).generateRandomInRange(0, 0);
    }
}
