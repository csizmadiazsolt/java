package com.ezsocsi.module;


import com.google.inject.AbstractModule;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class ConfigModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(Config.class).toInstance(ConfigFactory.load());
    }
}