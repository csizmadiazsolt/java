package com.ezsocsi.inheritance;


class Developer extends Employee {
    private DeveloperTypes employeeType;

    Developer(String name, Double salary, DeveloperTypes employeeType) {
        super(name, salary);
        this.employeeType = employeeType;
    }

    @Override
    public String doTheJob() {
        if (employeeType.equals(DeveloperTypes.JAVA_DEVELOPER)) {
            return this.getName() + " develops JAVA.";
        } else {
            return this.getName() + " develops C++.";
        }
    }
}
