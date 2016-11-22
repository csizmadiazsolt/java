package com.ezsocsi.inheritance;


class Secretary extends Employee {
    Secretary(String name, Double salary) {
        super(name, salary);
    }

    @Override
    public String doTheJob() {
        return this.getName() + " orders stuff.";
    }
}
