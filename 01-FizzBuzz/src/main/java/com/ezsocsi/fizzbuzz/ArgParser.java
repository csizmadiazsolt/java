package com.ezsocsi.fizzbuzz;

import java.util.Optional;

public class ArgParser {
    private static final int NUMBER_OF_ARGS = 2;
    private Optional<Integer> lowerLimit;
    private Optional<Integer> upperLimit;

    public boolean parseArgs(String... args) {
        if (checkNumberOfArgs(NUMBER_OF_ARGS, args)) {
            lowerLimit = getArgument(0, args);
            upperLimit = getArgument(1, args);

            if (lowerLimit.isPresent() && upperLimit.isPresent()) {
                return true;
            }
        }
        return false;
    }

    private boolean checkNumberOfArgs(int numberOfExpectedArgs, String... args) {
        if (args.length == numberOfExpectedArgs) {
            return true;
        }
        return false;
    }

    private Optional<Integer> getArgument(int argumentNumber, String... args) {
        Optional<Integer> argument;

        try {
            argument = Optional.of(Integer.valueOf(args[argumentNumber]));
        } catch (NumberFormatException e) {
            argument = Optional.empty();
        }

        return argument;
    }

    public Optional<Integer> getLowerLimit() {
        return lowerLimit;
    }

    public Optional<Integer> getUpperLimit() {
        return upperLimit;
    }
}