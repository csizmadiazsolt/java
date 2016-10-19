package com.ezsocsi.fizzbuzz;


import com.ezsocsi.utils.ConsoleUtils;

import java.util.List;
import java.util.Optional;

public class FizzBuzz {
    private final ArgParser argParser;
    private final FizzBuzzGenerator fizzBuzzGenerator;
    private final ConsoleUtils consoleUtils;

    public FizzBuzz(ArgParser argParser, FizzBuzzGenerator fizzBuzzGenerator, ConsoleUtils consoleUtils) {
        this.argParser = argParser;
        this.fizzBuzzGenerator = fizzBuzzGenerator;
        this.consoleUtils = consoleUtils;
    }

    public void fizzBuzz(String... args) {
        if (argParser.parseArgs(args)) {
            Optional<Integer> lowerLimit = argParser.getLowerLimit();
            Optional<Integer> upperLimit = argParser.getUpperLimit();

            if(lowerLimit.isPresent() && upperLimit.isPresent()) {
                List<String> fizzBuzzOutput = fizzBuzzGenerator.generate(lowerLimit.get(), upperLimit.get());
                consoleUtils.printlnList(fizzBuzzOutput, ", ");
            }

        } else {
            consoleUtils.printlnError("unable to parse arguments, expected: <int> <int>.");
        }
    }

}
