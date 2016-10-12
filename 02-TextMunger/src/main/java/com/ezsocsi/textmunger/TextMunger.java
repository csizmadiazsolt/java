package com.ezsocsi.textmunger;


public class TextMunger {
    private Munger munger;
    private Console console;
    private ArgParser argParser;

    public TextMunger(Munger munger, Console console, ArgParser argParser) {
        this.munger = munger;
        this.console = console;
        this.argParser = argParser;
    }

    public void mungeText(String... args) {
        if (argParser.parseArgs(args)) {
            String textToMunge = argParser.getInputText();

            console.println(munger.munge(textToMunge));
        } else {
            console.printlnError("unable to parse arguments, expected: <string>.");
        }
    }
}
