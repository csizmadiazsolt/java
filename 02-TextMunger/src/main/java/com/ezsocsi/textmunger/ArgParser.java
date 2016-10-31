package com.ezsocsi.textmunger;


import com.ezsocsi.utils.ArgUtils;

import java.util.Optional;

public class ArgParser {
    private final ArgUtils argUtils;
    private static final int NUMBER_OF_ARGS = 1;
    private String inputText;

    ArgParser(ArgUtils argUtils) {
        this.argUtils = argUtils;
    }

    boolean parseArgs(String... args) {
        if (argUtils.checkNumberOfArgs(NUMBER_OF_ARGS, args)) {
            Optional<String> inputTextArg = argUtils.getArgument(0, args);

            if (inputTextArg.isPresent()) {
                this.inputText = inputTextArg.get();

                return true;
            }
        }
        return false;
    }

    String getInputText() {
        return this.inputText;
    }
}
