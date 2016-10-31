package com.ezsocsi.textmunger;


import com.ezsocsi.utils.ConsoleUtils;

class TextMunger {
    private final Munger munger;
    private final ConsoleUtils consoleUtils;
    private final ArgParser argParser;

    TextMunger(Munger munger, ConsoleUtils consoleUtils, ArgParser argParser) {
        this.munger = munger;
        this.consoleUtils = consoleUtils;
        this.argParser = argParser;
    }

    void mungeText(String... args) {
        if (argParser.parseArgs(args)) {
            String textToMunge = argParser.getInputText();

            consoleUtils.println(munger.munge(textToMunge));
        } else {
            consoleUtils.printlnError("unable to parse arguments, expected: <string>.");
        }
    }
}
