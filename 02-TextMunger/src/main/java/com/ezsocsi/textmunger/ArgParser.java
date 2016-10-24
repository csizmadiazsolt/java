package com.ezsocsi.textmunger;


import com.ezsocsi.utils.ArgUtils;

import java.util.Optional;

public class ArgParser {
    private final ArgUtils argUtils;
    private static final int NUMBER_OF_ARGS = 1;
    private String inputText;

    public ArgParser(ArgUtils argUtils) {
        this.argUtils = argUtils;
    }

    public boolean parseArgs(String... args) {
        if (argUtils.checkNumberOfArgs(NUMBER_OF_ARGS, args)) {
            Optional<String> inputText = argUtils.getArgument(0, args);

            if (inputText.isPresent()) {
                this.inputText = inputText.get();

                return true;
            }
        }
        return false;
    }

    public String getInputText() {
        return this.inputText;
    }
}
