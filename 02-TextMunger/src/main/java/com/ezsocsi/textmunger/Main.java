package com.ezsocsi.textmunger;


import com.ezsocsi.utility.ArgUtility;
import com.ezsocsi.utility.ConsoleUtility;
import com.ezsocsi.utility.ListUtility;

public class Main {
    public static void main(String... args) {
        ListUtility listUtility = new ListUtility();
        Munger munger = new Munger(listUtility);
        ConsoleUtility consoleUtility = new ConsoleUtility();
        ArgUtility argUtility = new ArgUtility();
        ArgParser argParser = new ArgParser(argUtility);
        TextMunger textMunger = new TextMunger(munger, consoleUtility, argParser);

        textMunger.mungeText(args);
    }
}
