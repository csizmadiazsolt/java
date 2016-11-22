package com.ezsocsi.inheritance;


class EmployeeFactory {
    Employee getCEO(String name, Double salary) {
        return new CEO(name, salary);
    }

    Employee getManager(String name, Double salary) {
        return new Manager(name, salary);
    }

    Employee getSecretary(String name, Double salary) {
        return new Secretary(name, salary);
    }

    Employee getJavaDeveloper(String name, Double salary) {
        return new Developer(name, salary, DeveloperTypes.JAVA_DEVELOPER);
    }

    Employee getCppDeveloper(String name, Double salary) {
        return new Developer(name, salary, DeveloperTypes.CPP_DEVELOPER);
    }
}
