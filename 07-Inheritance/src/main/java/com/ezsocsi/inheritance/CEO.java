package com.ezsocsi.inheritance;


class CEO extends Employee {
    CEO(String name, Double salary) {
        super(name, salary);
    }

    @Override
    public String doTheJob() {
        return this.getName() + " tells the vision.";
    }
}
