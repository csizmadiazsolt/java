package com.ezsocsi.diguice;


import com.ezsocsi.module.ConfigModule;
import com.ezsocsi.module.RuntimeModule;
import com.ezsocsi.module.SystemOutputModule;
import com.google.inject.Injector;

import static com.google.inject.Guice.createInjector;

public class Main { // NOSONAR squid:S1118
    public static void main(String... args) {
        Injector injector = createInjector(
                new ConfigModule(),
                new RuntimeModule(),
                new SystemOutputModule());
        injector.getInstance(TextMunger.class).mungeText(args);
    }
}
