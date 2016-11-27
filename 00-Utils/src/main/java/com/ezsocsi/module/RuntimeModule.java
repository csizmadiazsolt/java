package com.ezsocsi.module;


import com.google.inject.AbstractModule;

public class RuntimeModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(Runtime.class).toInstance(Runtime.getRuntime());
    }
}