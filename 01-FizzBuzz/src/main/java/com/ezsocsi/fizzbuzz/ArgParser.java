package com.ezsocsi.fizzbuzz;


import com.ezsocsi.utils.ArgUtils;
import com.ezsocsi.utils.ConverterUtils;

import java.util.Optional;

public class ArgParser {
    private final ArgUtils argUtils;
    private final ConverterUtils converterUtils;

    private static final int NUMBER_OF_ARGS = 2;
    private Integer lowerLimit;
    private Integer upperLimit;

    ArgParser(ArgUtils argUtils, ConverterUtils converterUtils) {
        this.argUtils = argUtils;
        this.converterUtils = converterUtils;
    }

    boolean parseArgs(String... args) {
        if (argUtils.checkNumberOfArgs(NUMBER_OF_ARGS, args)) {
            Optional<String> lowerLimitArg = argUtils.getArgument(0, args);
            Optional<String> upperLimitArg = argUtils.getArgument(1, args);

            if (lowerLimitArg.isPresent() && upperLimitArg.isPresent()) {
                Optional<Integer> convertedLowerLimit = converterUtils.stringToInteger(lowerLimitArg.get());
                Optional<Integer> convertedUpperLimit = converterUtils.stringToInteger(upperLimitArg.get());

                if (convertedLowerLimit.isPresent() && convertedUpperLimit.isPresent()) {
                    this.lowerLimit = convertedLowerLimit.get();
                    this.upperLimit = convertedUpperLimit.get();
                    return true;
                }
            }
        }
        return false;
    }

    Integer getLowerLimit() {
        return this.lowerLimit;
    }

    Integer getUpperLimit() {
        return this.upperLimit;
    }
}