package com.ezsocsi.projecteuler1;


import com.ezsocsi.utils.ArgUtils;
import com.ezsocsi.utils.ConverterUtils;

import java.util.Optional;

public class ArgParser {
    private final ArgUtils argUtils;
    private final ConverterUtils converterUtils;
    private static final int NUMBER_OF_ARGS = 1;
    private Integer input;

    ArgParser(ArgUtils argUtils, ConverterUtils converterUtils) {
        this.argUtils = argUtils;
        this.converterUtils = converterUtils;
    }

    boolean parseArgs(String... args) {
        if (argUtils.checkNumberOfArgs(NUMBER_OF_ARGS, args)) {
            Optional<String> inputNumberArg = argUtils.getArgument(0, args);

            if (inputNumberArg.isPresent()) {
                Optional<Integer> argMnt = converterUtils.stringToInteger(inputNumberArg.get());

                if (argMnt.isPresent()) {
                    this.input = argMnt.get();
                }
                return true;
            }
        }
        return false;
    }

    Integer getInput() {
        return this.input;
    }
}
