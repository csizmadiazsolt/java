package com.ezsocsi.textmunger;


public class ArgParser {
    private static final int NUMBER_OF_ARGS = 1;
    private String inputText;

    public boolean parseArgs(String... args) {
        if (checkNumberOfArgs(NUMBER_OF_ARGS, args)) {
            inputText = getArgument(args);

            return true;
        }
        return false;
    }

    private boolean checkNumberOfArgs(int numberOfExpectedArgs, String... args) {
        if (args.length == numberOfExpectedArgs) {
            return true;
        }
        return false;
    }

    private String getArgument(String... args) {
        return args[0];
    }

    public String getInputText() {
        return inputText;
    }
}
