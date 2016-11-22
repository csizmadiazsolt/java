package com.ezsocsi.inheritance;


import com.ezsocsi.utils.ConsoleUtils;

class Occupation {
    private Organization organization;
    private ConsoleUtils consoleUtils;

    Occupation(Organization organization, ConsoleUtils consoleUtils) {
        this.organization = organization;
        this.consoleUtils = consoleUtils;
    }

    void printOccupations() {
        consoleUtils.println(organization.getCeo().doTheJob());
        organization.getManagers().forEach(m -> consoleUtils.println(m.doTheJob()));
        organization.getSecretaries().forEach(s -> consoleUtils.println(s.doTheJob()));
        organization.getJavaDevelopers().forEach(j -> consoleUtils.println(j.doTheJob()));
        organization.getCppDevelopers().forEach(c -> consoleUtils.println(c.doTheJob()));
    }
}
