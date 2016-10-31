package com.ezsocsi.utils;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ArgUtils {
    public boolean checkNumberOfArgs(int numberOfExpectedArgs, String... args) {
        return args.length == numberOfExpectedArgs;
    }

    public Optional<String> getArgument(int argumentNumber, String... args) {
        Optional<String> argument;

        try {
            argument = Optional.of(args[argumentNumber]);
        } catch (ArrayIndexOutOfBoundsException e) {
            argument = Optional.empty();
        }

        return argument;
    }

    public List<String> splitArgToList(String arg, String limiter) {
        return Arrays.asList(arg.split(limiter));
    }
}
