package com.ezsocsi.inheritance;


import java.util.ArrayList;
import java.util.List;

abstract class Employee {
    private String name;
    private Double salary;
    private List<Employee> superiors;

    Employee(String name, Double salary) {
        this.name = name;
        this.salary = salary;
        this.superiors = new ArrayList<>();
    }

    String getName() {
        return name;
    }

    Double getSalary() {
        return salary;
    }

    void addSuperior(Employee superior) {
        superiors.add(superior);
    }

    List<Employee> getSuperiors() {
        return this.superiors;
    }

    public abstract String doTheJob();
}
