package com.ezsocsi.inheritance;


import com.ezsocsi.utils.ConsoleUtils;
import com.ezsocsi.utils.ListUtils;
import com.ezsocsi.utils.RandomUtils;

public class Main { // NOSONAR squid:S1118
    public static void main(String... args) {
        ListUtils listUtils = new ListUtils();
        RandomUtils randomUtils = new RandomUtils();
        ConsoleUtils consoleUtils = new ConsoleUtils(listUtils);
        EmployeeFactory employeeFactory = new EmployeeFactory();
        Organization organization = new Organization(employeeFactory, randomUtils);
        Hierarchy hierarchy = new Hierarchy(organization, randomUtils);
        Budget budget = new Budget(organization, consoleUtils);
        Occupation occupation = new Occupation(organization, consoleUtils);
        DeveloperChain developerChain = new DeveloperChain(organization, consoleUtils);

        organization.generate();
        hierarchy.build();
        budget.printBudget();
        occupation.printOccupations();
        developerChain.printDeveloperChain();
    }
}
