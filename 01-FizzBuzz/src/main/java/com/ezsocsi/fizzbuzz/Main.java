package com.ezsocsi.fizzbuzz;


import com.ezsocsi.utils.ArgUtils;
import com.ezsocsi.utils.ConsoleUtils;
import com.ezsocsi.utils.ConverterUtils;

public class Main {

    public static void main(String... args) {
        ArgUtils argUtils = new ArgUtils();
        ConverterUtils converterUtils = new ConverterUtils();
        ArgParser argParser = new ArgParser(argUtils, converterUtils);
        FizzBuzzGenerator fizzBuzzGenerator = new FizzBuzzGenerator();
        ConsoleUtils consoleUtils = new ConsoleUtils();
        FizzBuzz fizzBuzz = new FizzBuzz(argParser, fizzBuzzGenerator, consoleUtils);

        fizzBuzz.fizzBuzz(args);
    }
}
