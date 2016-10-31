package com.ezsocsi.fizzbuzz;


import com.ezsocsi.utils.ArgUtils;
import com.ezsocsi.utils.ConsoleUtils;
import com.ezsocsi.utils.ConverterUtils;
import com.ezsocsi.utils.ListUtils;

public class Main {

    private Main() {
    }

    public static void main(String... args) {
        ArgUtils argUtils = new ArgUtils();
        ConverterUtils converterUtils = new ConverterUtils();
        ArgParser argParser = new ArgParser(argUtils, converterUtils);
        FizzBuzzGenerator fizzBuzzGenerator = new FizzBuzzGenerator();
        ListUtils listUtils = new ListUtils();
        ConsoleUtils consoleUtils = new ConsoleUtils(listUtils);
        FizzBuzz fizzBuzz = new FizzBuzz(argParser, fizzBuzzGenerator, consoleUtils);

        fizzBuzz.fizzBuzz(args);
    }
}
