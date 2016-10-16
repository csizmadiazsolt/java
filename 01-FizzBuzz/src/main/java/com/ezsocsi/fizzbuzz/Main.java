package com.ezsocsi.fizzbuzz;


import com.ezsocsi.utility.ArgUtility;
import com.ezsocsi.utility.ConsoleUtility;
import com.ezsocsi.utility.ConverterUtility;

public class Main {

    public static void main(String... args) {
        ArgUtility argUtility = new ArgUtility();
        ConverterUtility converterUtility = new ConverterUtility();
        ArgParser argParser = new ArgParser(argUtility, converterUtility);
        FizzBuzzGenerator fizzBuzzGenerator = new FizzBuzzGenerator();
        ConsoleUtility consoleUtility = new ConsoleUtility();
        FizzBuzz fizzBuzz = new FizzBuzz(argParser, fizzBuzzGenerator, consoleUtility);

        fizzBuzz.fizzBuzz(args);
    }
}
