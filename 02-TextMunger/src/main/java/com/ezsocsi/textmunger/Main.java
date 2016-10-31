package com.ezsocsi.textmunger;


import com.ezsocsi.utils.ArgUtils;
import com.ezsocsi.utils.ConsoleUtils;
import com.ezsocsi.utils.ListUtils;

public class Main {
    public static void main(String... args) {
        ListUtils listUtils = new ListUtils();
        Munger munger = new Munger(listUtils);
        ConsoleUtils consoleUtils = new ConsoleUtils(listUtils);
        ArgUtils argUtils = new ArgUtils();
        ArgParser argParser = new ArgParser(argUtils);
        TextMunger textMunger = new TextMunger(munger, consoleUtils, argParser);

        textMunger.mungeText(args);
    }
}
