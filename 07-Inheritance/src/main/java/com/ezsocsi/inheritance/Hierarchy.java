package com.ezsocsi.inheritance;


import com.ezsocsi.utils.RandomUtils;

import java.util.List;
import java.util.stream.IntStream;

class Hierarchy {
    private RandomUtils randomUtils;
    private Organization organization;

    Hierarchy(Organization organization, RandomUtils randomUtils) {
        this.randomUtils = randomUtils;
        this.organization = organization;
    }

    void build() {
        setManagerSuperiors();
        setSecretariesSuperiors();
        setDeveloperSuperiors();
    }

    private void setManagerSuperiors() {
        organization.getManagers().forEach(m -> m.addSuperior(organization.getCeo()));
    }

    private void setSecretariesSuperiors() {
        organization.getSecretaries()
                .get(randomUtils.generateRandomInRange(0, organization.getSecretaries().size() - 1))
                .addSuperior(organization.getCeo());
        organization.getManagers()
                .forEach(organization.getSecretaries()
                        .get(randomUtils.generateRandomInRange(0, organization.getSecretaries().size() - 1))::addSuperior);
    }

    private void setDeveloperSuperiors() {
        setCEOAsDeveloperSuperior(organization.getJavaDevelopers().get(0));
        setCEOAsDeveloperSuperior(organization.getCppDevelopers().get(0));
        setManagerAsDeveloperSuperior(organization.getJavaDevelopers());
        setManagerAsDeveloperSuperior(organization.getCppDevelopers());
    }

    private void setCEOAsDeveloperSuperior(Employee employee) {
        employee.addSuperior(organization.getCeo());
    }

    private void setManagerAsDeveloperSuperior(List<Employee> employees) {
        IntStream.range(1, employees.size())
                .forEach(j -> employees.get(j)
                        .addSuperior(organization.getManagers()
                                .get(randomUtils.generateRandomInRange(0, organization.getManagers().size() - 1))));
    }
}
