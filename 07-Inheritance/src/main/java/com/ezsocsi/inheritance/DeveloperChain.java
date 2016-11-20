package com.ezsocsi.inheritance;


import com.ezsocsi.utils.ConsoleUtils;

class DeveloperChain {
    private Organization organization;
    private ConsoleUtils consoleUtils;

    DeveloperChain(Organization organization, ConsoleUtils consoleUtils) {
        this.organization = organization;
        this.consoleUtils = consoleUtils;
    }

    void printDeveloperChain() {
        organization.getJavaDevelopers().forEach(j -> j.getSuperiors()
                .forEach(s -> consoleUtils.println(j.getName() + " <-- " + s.getName())));

        organization.getCppDevelopers().forEach(c -> c.getSuperiors()
                .forEach(s -> consoleUtils.println(c.getName() + " <-- " + s.getName())));
    }
}
