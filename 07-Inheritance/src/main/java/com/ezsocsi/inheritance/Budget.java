package com.ezsocsi.inheritance;


import com.ezsocsi.utils.ConsoleUtils;

class Budget {
    private Organization organization;
    private ConsoleUtils consoleUtils;

    Budget(Organization organization, ConsoleUtils consoleUtils) {
        this.organization = organization;
        this.consoleUtils = consoleUtils;
    }

    void printBudget() {
        consoleUtils.println("Manpower costs: " + calculate().toString());
    }

    private Double calculate() {
        Double sum = organization.getCeo().getSalary();
        sum += organization.getManagers().stream().map(Employee::getSalary).mapToDouble(Double::doubleValue).sum();
        sum += organization.getSecretaries().stream().map(Employee::getSalary).mapToDouble(Double::doubleValue).sum();
        sum += organization.getJavaDevelopers().stream().map(Employee::getSalary).mapToDouble(Double::doubleValue).sum();
        sum += organization.getCppDevelopers().stream().map(Employee::getSalary).mapToDouble(Double::doubleValue).sum();

        return sum;
    }
}
