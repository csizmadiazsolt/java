package com.ezsocsi.module;


import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

import java.io.PrintStream;

public class SystemOutputModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(PrintStream.class).annotatedWith(Names.named("stdout")).toInstance(System.out); // NOSONAR squid:S106
    }
}