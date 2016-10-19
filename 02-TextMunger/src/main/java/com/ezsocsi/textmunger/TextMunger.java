package com.ezsocsi.textmunger;


import com.ezsocsi.utils.ConsoleUtils;

public class TextMunger {
    private final Munger munger;
    private final ConsoleUtils consoleUtils;
    private final ArgParser argParser;

    public TextMunger(Munger munger, ConsoleUtils consoleUtils, ArgParser argParser) {
        this.munger = munger;
        this.consoleUtils = consoleUtils;
        this.argParser = argParser;
    }

    public void mungeText(String... args) {
        if (argParser.parseArgs(args)) {
            String textToMunge = argParser.getInputText();

            consoleUtils.println(munger.munge(textToMunge));
        } else {
            consoleUtils.printlnError("unable to parse arguments, expected: <string>.");
        }
    }
}
