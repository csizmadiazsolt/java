package com.ezsocsi.utils;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArgUtils {
    private static final Logger LOGGER = Logger.getLogger(ArgUtils.class.getName());

    public boolean checkNumberOfArgs(int numberOfExpectedArgs, String... args) {
        return args.length == numberOfExpectedArgs;
    }

    public Optional<String> getArgument(int argumentNumber, String... args) {
        Optional<String> argument;

        try {
            argument = Optional.of(args[argumentNumber]);
        } catch (ArrayIndexOutOfBoundsException e) {
            LOGGER.log(Level.WARNING, "Exception:" + e);
            argument = Optional.empty();
        }

        return argument;
    }

    public List<String> splitArgToList(String arg, String limiter) {
        return Arrays.asList(arg.split(limiter));
    }
}
