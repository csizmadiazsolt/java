package com.ezsocsi.inheritance;


import com.ezsocsi.utils.ConsoleUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BudgetTest {
    private Budget budget;
    private ConsoleUtils consoleUtils;

    @Before
    public void setup() {
        Organization organization = mock(Organization.class);
        consoleUtils = mock(ConsoleUtils.class);
        budget = new Budget(organization, consoleUtils);

        Employee ceo = new CEO("TestCEO", 5.0);
        List<Employee> managers = Collections.singletonList(new Manager("Manager", 2.0));
        List<Employee> secretaries = Collections.singletonList(new Secretary("Secretary", 1.0));
        List<Employee> javaDevelopers = Collections.singletonList(new Developer("JavaDeveloper", 3.0, DeveloperTypes.JAVA_DEVELOPER));
        List<Employee> cppDevelopers = Collections.singletonList(new Developer("CppDeveloper", 3.0, DeveloperTypes.CPP_DEVELOPER));

        when(organization.getCeo()).thenReturn(ceo);
        when(organization.getManagers()).thenReturn(managers);
        when(organization.getSecretaries()).thenReturn(secretaries);
        when(organization.getJavaDevelopers()).thenReturn(javaDevelopers);
        when(organization.getCppDevelopers()).thenReturn(cppDevelopers);
    }

    @Test
    public void verify_correct_budget_calculation() {
        budget.printBudget();
        verify(consoleUtils).println("Manpower costs: 14.0");
    }
}
