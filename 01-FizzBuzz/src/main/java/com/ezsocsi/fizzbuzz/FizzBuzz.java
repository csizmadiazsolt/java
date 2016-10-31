package com.ezsocsi.fizzbuzz;


import com.ezsocsi.utils.ConsoleUtils;

import java.util.List;

public class FizzBuzz {
    private final ArgParser argParser;
    private final FizzBuzzGenerator fizzBuzzGenerator;
    private final ConsoleUtils consoleUtils;

    FizzBuzz(ArgParser argParser, FizzBuzzGenerator fizzBuzzGenerator, ConsoleUtils consoleUtils) {
        this.argParser = argParser;
        this.fizzBuzzGenerator = fizzBuzzGenerator;
        this.consoleUtils = consoleUtils;
    }

    void fizzBuzz(String... args) {
        if (argParser.parseArgs(args)) {
            Integer lowerLimit = argParser.getLowerLimit();
            Integer upperLimit = argParser.getUpperLimit();

            List<String> fizzBuzzOutput = fizzBuzzGenerator.generate(lowerLimit, upperLimit);
            consoleUtils.printlnList(fizzBuzzOutput, ", ");
        } else {
            consoleUtils.printlnError("unable to parse arguments, expected: <int> <int>.");
        }
    }

}
