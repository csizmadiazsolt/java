package com.ezsocsi.fizzbuzz;


import com.ezsocsi.utility.ConsoleUtility;

import java.util.List;
import java.util.Optional;

public class FizzBuzz {
    private ArgParser argParser;
    private FizzBuzzGenerator fizzBuzzGenerator;
    private ConsoleUtility consoleUtility;

    public FizzBuzz(ArgParser argParser, FizzBuzzGenerator fizzBuzzGenerator, ConsoleUtility consoleUtility) {
        this.argParser = argParser;
        this.fizzBuzzGenerator = fizzBuzzGenerator;
        this.consoleUtility = consoleUtility;
    }

    public void fizzBuzz(String... args) {
        if (argParser.parseArgs(args)) {
            Optional<Integer> lowerLimit = argParser.getLowerLimit();
            Optional<Integer> upperLimit = argParser.getUpperLimit();

            if(lowerLimit.isPresent() && upperLimit.isPresent()) {
                List<String> fizzBuzzOutput = fizzBuzzGenerator.generate(lowerLimit.get(), upperLimit.get());
                consoleUtility.printlnList(fizzBuzzOutput, ", ");
            }

        } else {
            consoleUtility.printlnError("unable to parse arguments, expected: <int> <int>.");
        }
    }

}
