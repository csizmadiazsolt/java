package com.ezsocsi.inheritance;


import com.ezsocsi.utils.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class Organization {
    private RandomUtils randomUtils;
    private EmployeeFactory employeeFactory;

    private Employee ceo;
    private List<Employee> managers;
    private List<Employee> secretaries;
    private List<Employee> javaDevelopers;
    private List<Employee> cppDevelopers;

    Organization(EmployeeFactory employeeFactory, RandomUtils randomUtils) {
        this.randomUtils = randomUtils;
        this.employeeFactory = employeeFactory;

        managers = new ArrayList<>();
        secretaries = new ArrayList<>();
        javaDevelopers = new ArrayList<>();
        cppDevelopers = new ArrayList<>();
    }

    void generate() {
        int maxNumberOfManager = 10;
        int maxNumberOfSecretaries = 2;
        int maxNumberOfJavaDevelopers = 4;
        int maxNumberOfCppDevelopers = 5;

        ceo = employeeFactory.getCEO("CEO", 1000000.0);
        IntStream.range(0, randomUtils.generateRandomInRange(1, maxNumberOfManager))
                .forEach(i -> managers.add(employeeFactory.getManager("Manager-" + i, 500000.0)));

        IntStream.range(0, randomUtils.generateRandomInRange(1, maxNumberOfSecretaries))
                .forEach(i -> secretaries.add(employeeFactory.getSecretary("Secretary-" + i, 250000.0)));

        IntStream.range(0, randomUtils.generateRandomInRange(1, maxNumberOfJavaDevelopers))
                .forEach(i -> javaDevelopers.add(employeeFactory.getJavaDeveloper("Java Developer-" + i, 700000.0)));

        IntStream.range(0, randomUtils.generateRandomInRange(1, maxNumberOfCppDevelopers))
                .forEach(i -> cppDevelopers.add(employeeFactory.getCppDeveloper("CPP Developer-" + i, 650000.0)));
    }

    Employee getCeo() {
        return ceo;
    }

    List<Employee> getManagers() {
        return managers;
    }

    List<Employee> getSecretaries() {
        return secretaries;
    }

    List<Employee> getJavaDevelopers() {
        return javaDevelopers;
    }

    List<Employee> getCppDevelopers() {
        return cppDevelopers;
    }
}
