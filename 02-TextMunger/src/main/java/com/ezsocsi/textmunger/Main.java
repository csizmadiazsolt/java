package com.ezsocsi.textmunger;


public class Main {
    public static void main(String... args) {
        Utils utils = new Utils();
        Munger munger = new Munger(utils);
        Console console = new Console();
        ArgParser argParser = new ArgParser();
        TextMunger textMunger = new TextMunger(munger, console, argParser);

        textMunger.mungeText(args);
    }
}
