package com.ezsocsi.inheritance;


import com.ezsocsi.utils.RandomUtils;

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
        organization.getJavaDevelopers().get(0).addSuperior(organization.getCeo());
        organization.getCppDevelopers().get(0).addSuperior(organization.getCeo());

        IntStream.range(1, organization.getJavaDevelopers().size())
                .forEach(j -> organization.getJavaDevelopers().get(j)
                        .addSuperior(organization.getManagers()
                                .get(randomUtils.generateRandomInRange(0, organization.getManagers().size() - 1))));
        IntStream.range(1, organization.getCppDevelopers().size())
                .forEach(c -> organization.getCppDevelopers().get(c)
                        .addSuperior(organization.getManagers()
                                .get(randomUtils.generateRandomInRange(0, organization.getManagers().size() - 1))));
    }
}
