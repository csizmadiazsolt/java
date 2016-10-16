package com.ezsocsi.textmunger;


import com.ezsocsi.utility.ArgUtility;

import java.util.Optional;

public class ArgParser {
    private ArgUtility argUtility;
    private static final int NUMBER_OF_ARGS = 1;
    private String inputText;

    public ArgParser(ArgUtility argUtility) {
        this.argUtility = argUtility;

    }

    public boolean parseArgs(String... args) {
        if (argUtility.checkNumberOfArgs(NUMBER_OF_ARGS, args)) {
            Optional<String> inputText = argUtility.getArgument(0, args);

            if (inputText.isPresent()) {
                this.inputText = inputText.get();

                return true;
            }
        }
        return false;
    }

    public String getInputText() {
        return inputText;
    }
}
