package com.ezsocsi.textmunger;


import com.ezsocsi.utility.ConsoleUtility;

public class TextMunger {
    private Munger munger;
    private ConsoleUtility consoleUtility;
    private ArgParser argParser;

    public TextMunger(Munger munger, ConsoleUtility consoleUtility, ArgParser argParser) {
        this.munger = munger;
        this.consoleUtility = consoleUtility;
        this.argParser = argParser;
    }

    public void mungeText(String... args) {
        if (argParser.parseArgs(args)) {
            String textToMunge = argParser.getInputText();

            consoleUtility.println(munger.munge(textToMunge));
        } else {
            consoleUtility.printlnError("unable to parse arguments, expected: <string>.");
        }
    }
}
