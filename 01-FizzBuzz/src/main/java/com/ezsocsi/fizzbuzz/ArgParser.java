package com.ezsocsi.fizzbuzz;


import com.ezsocsi.utility.ArgUtility;
import com.ezsocsi.utility.ConverterUtility;

import java.util.Optional;

public class ArgParser {
    private ArgUtility argUtility;
    private ConverterUtility converterUtility;

    private static final int NUMBER_OF_ARGS = 2;
    private Optional<Integer> lowerLimit;
    private Optional<Integer> upperLimit;

    public ArgParser(ArgUtility argUtility, ConverterUtility converterUtility) {
        this.argUtility = argUtility;
        this.converterUtility = converterUtility;
    }

    public boolean parseArgs(String... args) {
        if (argUtility.checkNumberOfArgs(NUMBER_OF_ARGS, args)) {
            Optional<String> lowerLimit = argUtility.getArgument(0, args);
            Optional<String> upperLimit = argUtility.getArgument(1, args);

            if (lowerLimit.isPresent() && upperLimit.isPresent()) {
                this.lowerLimit = converterUtility.stringToInteger(lowerLimit.get());
                this.upperLimit = converterUtility.stringToInteger(upperLimit.get());
            }

            if (this.lowerLimit.isPresent() && this.upperLimit.isPresent()) {
                return true;
            }
        }
        return false;
    }

    public Optional<Integer> getLowerLimit() {
        return lowerLimit;
    }

    public Optional<Integer> getUpperLimit() {
        return upperLimit;
    }
}