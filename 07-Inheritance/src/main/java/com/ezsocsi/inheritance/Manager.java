package com.ezsocsi.inheritance;


class Manager extends Employee {
    Manager(String name, Double salary) {
        super(name, salary);
    }

    @Override
    public String doTheJob() {
        return this.getName() + " tells the direction.";
    }
}
