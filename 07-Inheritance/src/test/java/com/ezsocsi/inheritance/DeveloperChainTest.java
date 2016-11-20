package com.ezsocsi.inheritance;


import com.ezsocsi.utils.ConsoleUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class DeveloperChainTest {
    private DeveloperChain developerChain;
    private ConsoleUtils consoleUtils;

    @Before
    public void setup() {
        Organization organization = mock(Organization.class);
        consoleUtils = mock(ConsoleUtils.class);
        developerChain = new DeveloperChain(organization, consoleUtils);

        Employee ceo = new CEO("TestCEO", 5.0);
        Manager manager = new Manager("TestManager", 4.0);

        List<Employee> javaDevelopers = Collections.singletonList(new Developer("javaDeveloper", 3.0, DeveloperTypes.JAVA_DEVELOPER));
        List<Employee> cppDevelopers = Collections.singletonList(new Developer("cppDeveloper", 3.0, DeveloperTypes.CPP_DEVELOPER));

        javaDevelopers.get(0).addSuperior(ceo);
        cppDevelopers.get(0).addSuperior(manager);

        when(organization.getJavaDevelopers()).thenReturn(javaDevelopers);
        when(organization.getCppDevelopers()).thenReturn(cppDevelopers);
    }

    @Test
    public void verify_correct_developer_chain_is_printed() {
        developerChain.printDeveloperChain();
        verify(consoleUtils).println("javaDeveloper <-- TestCEO");
        verify(consoleUtils).println("cppDeveloper <-- TestManager");
    }
}
