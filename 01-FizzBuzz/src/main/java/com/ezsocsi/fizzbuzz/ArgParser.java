package com.ezsocsi.fizzbuzz;


import com.ezsocsi.utils.ArgUtils;
import com.ezsocsi.utils.ConverterUtils;

import java.util.Optional;

public class ArgParser {
    private final ArgUtils argUtils;
    private final ConverterUtils converterUtils;

    private static final int NUMBER_OF_ARGS = 2;
    private Optional<Integer> lowerLimit;
    private Optional<Integer> upperLimit;

    public ArgParser(ArgUtils argUtils, ConverterUtils converterUtils) {
        this.argUtils = argUtils;
        this.converterUtils = converterUtils;
    }

    public boolean parseArgs(String... args) {
        if (argUtils.checkNumberOfArgs(NUMBER_OF_ARGS, args)) {
            Optional<String> lowerLimit = argUtils.getArgument(0, args);
            Optional<String> upperLimit = argUtils.getArgument(1, args);

            if (lowerLimit.isPresent() && upperLimit.isPresent()) {
                this.lowerLimit = converterUtils.stringToInteger(lowerLimit.get());
                this.upperLimit = converterUtils.stringToInteger(upperLimit.get());
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